
# Exercice 1

##	Q.1	

Cette commande permet d'avoir toute les lignes commencant par une adresse d'IPV4 :

``grep -E '^[0-255].{3}[0-255]'``

la derniere instruction permet de garder uniquement le champs avec l'IPV4 de localhost
1.  On affiche les adresses fixes en dure contenu dans /etc/hosts
2.  On garde les lignes du localhost
3.  On garde uniquement les lignes commencant par un IPV4
4.  On prend uniquement le 1er champs 

``cat /etc/hosts | grep localhost | grep -E '^[0-255].{3}[0-255]' | cut -f1``



##	Q.2	

Cette commande permet de voir le nom des parametres auquels les options se rapporte 

```bash
lpoptions -l | cut -d ':' -f1
```

Cette commande permet d'obtenir seulement les options actives caracterise par *

1.  On garde uniquement le 2e champs separe par * constitue par l'option active puis d'autres options qui suivent
2.  On garde uniquement le 1er champs il s'agira de l'option active
 
```bash
lpoptions -l | cut -d '*' -f2 | cut -d ' ' -f1
```

##	Q.3

1.  On garde uniquement les interfaces reseaux contenant ethX ou X est un chiffre
2.  On garde uniquement les lignes contenant une adresse IPV4 et on remarque que l'adresse est toujours dans le 3e champs separer par des espaces
3.  pour eviter les repetitions du separateur espaces on remplace tous les espaces multiples par un espaces unique grace a l'option tr -s
4.  on garde le champs avec l'IPV4 , si on ne veut pas afficher le masque  on peut ajouter ` | cut -d '\' -f1 ` a la suite de cette commande

```bash
ip addr | grep -E 'eth[0-9]' | grep -E '[0-255].{3}[0-255]' | tr -s ' ' ' ' | cut -d ' ' -f3
```

##  Q.4

1.  Affiche le fichiers /etc/groupe  
2.  On garde uniquement les groupes ou on est membre 
3.  On affiche uniquement le 1er champ correspondant au nom de groupe

```bash
cat /etc/group | grep -E $(whoami) | cut -d ":" -f1
```

##	Q.5

1.  Affiche statistique 
2.  On enleve la premiere ligne , 
### si cette commande ne fonctionne pas on la remplace par 
```bash
tail -n $(($(df | wc -l) - 1))
```
qui calcule le nombre de lignes -1 et affiche les dernieres lignes sauf la 1ere
3. On supprime les repetitions d'espaces
4. On garde uniquement la colonne de point de montage et celle indiquant le nombre de place
5. On trie en fonction du nombre de place grace a l'option -n
6. On garde le point de montage avec le plus de place et on affiche uniquement celui ci

```bash
df | tail -n -1 |  tr -s ' ' ' ' | cut -d ' ' -f4,6 | sort -n | tail -n 1 | cut -d ' ' -f2 
```
