#!/bin/bash

#PART 1
#1
echo fichier_{a,b,c,d}

#2 ne factorise pas car un seul element -> affiche les brackets
echo fichier_{abcd}

#3 
echo fichier_{un, deux, trois}

#4 n'est pas traite car pas de separateur ","
echo fichier_{un deux trois}

#5 traite chaque factorisation a la fois
echo fichier_{a,b} repertoire_{c,d}

#6 considere les factorisation une a une
echo fichier_{a,b} {c,d}

#7 sans espace il s'agit d'un produit de factorisation
echo fichier_{a,b}{c,d}

#8 fait produit avec la factorisation dans la 1ere factorisation
echo fichier_{a,b,c{1,2}}

#9
echo fichier_{a,b,{c,d}}

#PART 2
echo 

#1
echo libreoffice-{en-US,fr}

#2
echo python{,-scipy,-matplotlib}

#3
echo vim-{runtime,spell-{fr,en}}


#PART 3
echo 

#1
echo rm {list,tab}.{h,o,c}

#PART 4
echo 

#1
echo fichier_{0,1,2,3,4,5,6,7,8,9}

#################################check why not working
#2
echo fichier_{1..9..2}

#3
echo fichier_{0..3,5..12..2}