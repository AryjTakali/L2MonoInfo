#!/bin/bash

error="Usage : ./pere.sh <nb_files>"
#affiche le pid du script fils et de son pere 10 fois
if [ $1 ]; then
	echo Je suis $$
    i=0
    while [ $i -lt $1 ]; do
        echo -n "Fils $i : "
        ./fils.sh
        i=$(($i + 1))
    done
else
    echo Il manque un parametre
    echo $error 
    exit
fi
#on remarque que le pi change mais le pid reste le meme
