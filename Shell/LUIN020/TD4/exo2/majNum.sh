#!/bin/bash

cpt=0

if [ $# -ne 1 ] || [ ! -f $1]; then
		echo "$0 usage <filename>"
		exit 1
fi

./majuscule.sh < $1 > $1.temp
./numerotation.sh < $1.temp
rm $1.temp


#tres lourd et prendre de la place pour rien
