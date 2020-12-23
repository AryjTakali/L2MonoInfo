# Exercice 1 

## Question 1

1. Supprime la premiere ligne de mon_fichier.txt

2. Remplacement dans la 4e ligne, substitue la seconde occurence de toto par titi
3. on ne supprime pas les lignes avec toto

4. a la 10e ligne on substitue tous les toto par titi
- de la 5e a la derniere ligne on affiche les lignes contenant tutu

5. option -n = on imprime pas apres l'execution. 
Pour les lignes contenant tutu : 
 -  remplacer le premier toto par tutu -> imprime grace a /p


a comprendre :
- option -n n'imprime pas le buffer a la fin
- option /p imprime le buffer des qu'il est rencontré
- combiner -n et /p  : limite la sortie -> seules les lignes filtré seront affichés
- commande s sans option g substitue seulement une occurence
- option -E use expression reguliere

## Question 2
```
sed '5,$d' mon_fichier.txt
sed '1,4!d' mon_fichier.txt 
```
## Question 3
```
sed '4,$!=d' mon_fichier.txt
sed '1,4d' mon_fichier.txt 
```
## Question 4
```
sed -E -n '/expr/p' mon_fichier.txt
```
## Question 5
```
sed -E 'y/abc/xyz/' mon_fichier.txt
```

# Exercice 2 

## Question 1

Pas possible car tr transforme un charactere par un charactere
hors ici on veut transformer un char par 2

On peut borner avec le caractere que l'on veut! 
utiliser '/' comme separateur n'est pas obligatoire

## Question 2

On souhaite supprimer toute les lignes vides ou avec des espaces seulement
```
sed -E '/^ *$/d' mon_fichier.txt
```

- motif utilisant des expressions regulieres : 
-   '^ ': debut de ligne et espace 
- '*' : cardinalite autant de repetition que l'on veut
-  $ : fin de ligne

## Question 3

Ajout de ligne vide apres chaque ligne non vide -> modification de fichier 
- option -i : modifier le fichier 

```
sed -E -i '/./s/$/\n/' mon_fichier.txt
```

## Question 4

```
sed -E -i '/^ *function/i### FUNCTION ###' mon_fichier.txt
```

- le ^ * : permet de ne pas ecrire ##FUNCTION## a chaque fois que le mot function est ecrit (ex dans un commentaire ou autre)

## Question 5

