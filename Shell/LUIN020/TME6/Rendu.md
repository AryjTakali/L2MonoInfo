# Exercice 1

## Question 1

- Il suffit de garder les lignes commencant par une adresse ip et finissant par localhost
```bash
sed -En '/^[0-255].{3}[0-255].*localhost$/p' /etc/hosts
```

## Question 2

1. Dans un premier temps on supprime tout ce qui se situe avant '*' dans chaque ligne 
2. On supprime (en substituant par rien) les caracteres qui se situent apres un espace (donc toutes les options non actives)
3. On affiche les seules options restantes (options actives)

```bash
lpoptions -l | sed -En "s/.*\*//; s/ .*//; /^[^ ]*$/p"
```

## Question 3

1. On garde les lignes avec des interfaces ethX ou X est un chiffre
2. On supprime tout ce qui vient apres le masque sous reseaux de l'adresse IPv4
3. On garde uniquement l'adresse ip en supprimant ce qui vient avant 

```bash
ip addr | sed -En "/eth[0-9]/s/[/][0-9]+.*//; s/^(.*inet )([^ ]*)$/\2/p"'
```

## Question 4

```bash
sed -En '/$(whoami)/!d; s/^([^:]*):.*/\1/p' /etc/group 
```

## Question 5

1. Pour simplifier le parsing on remplace tous les espaces et tab par un espace unique grace a tr -s
2. on garde uniquement le champs avec l'espace disponible et le point de montage associé
3. On trie dans l'ordre numerique puis on garde uniquement la derniere ligne et dernier colone qui correspond bien au point de montage ayant le plus de place disponible 

```bash
df | tr -s ' \t' '  '| sed -En 's/(.*) (.*) (.*%) ([/].*)$/\2 \4/p' | sort -n | sed -En 's/.* ([/].*)$/\1/; $p'
```

## Question 6

1. On garde uniquement les lignes comptenant un numero de port entre 0 et 999 et un commentaire non nul
2. on departage les champs afin d'obtenir uniquement le nom de service et le commentaire afin de creer le dictionnaire de tous les services commentes ayant un numero de port inferieur a 1000

```bash 
  cat /etc/services | sed -En '/ [0-9]{3}[/].*[#][ ]*[^ ]+/!d; s/([^ ]*)([ ]+.*)#(.*)$/\1:\3/p' 
 ```

- Si on veut aussi afficher les ports associé afin de les trier dans l'ordre croissant (le sort -n est inutile car dans le fichier /etc/services sont deja triés dans l'ordre)
```bash
cat /etc/services | sed -En '/ [0-9]{3}[/].*[#][ ]*[^ ]+/!d; s/([^ ]*)([ ]+)([0-9]{3})([/].*)#(.*)$/\3\t\1:\5/p' | sort -n
```


# Exercice 2


## Question 1

1. On verifie qu'un fichier est bien entré en parametre
2. afin de separer les champs entre differents id on remplace les '{}' par des retours a la ligne
3. on cut ensuite a l'aide du sed afin de garder uniquement le nombre de velib disponible (on separe en 3 expression : avant la mention "numbikesavailable" / le nombres de velibs disponible/ apres)
4. on parcourt tout le fichier et on fait la somme 

```bash
#! /bin/bash

if [ ! -f $1 ]; then
    echo "Usage : $0 <velib-dispo.json>"
    exit
fi

dispo=0

for i in $(cat $1 | tr -s '[]{}' '\n\n\n\n' | sed -En 's/(.*"numbikesavailable":) ([0-9]*)(,.*)/\2/p' ) ; do
    dispo=$((dispo + i))
done

echo "En tout, il a $dispo velibs disponibles sur l'ensemble du reseau"
```


## Question 2

1. Au lieu de s'embeter a faire une expression reguliere avec chaque ';' On peut directement garder le champ mentionnant l'arrondissement de l'arbre
2. On trie dans l'ordre croissant puis grace a l'option ```uniq -c``` On obtient le nombre d'arbre par arrondissement 
3. On garde l'arrondissement avec le plus d'arbres
```bash
res=$(sed -En 's/(.*PARIS) ([0-9]+)(E.*)/\2/p' arbres-remarquables-paris.csv | sort -n | uniq -c | sort -n | sed -En '$p')
```