#!/bin/bash

#1
echo voici ce que l\'on trouve dans le fichier cv.txt:
cat cv.txt
echo ;echo 
echo voici ce que l\'on trouve dans le fichier \"ma lettre.txt\":
cat "ma lettre.txt"

echo ; echo 
#3
val="un deux"
for x in zero $val trois "et cetera"; do
    echo $x
    done