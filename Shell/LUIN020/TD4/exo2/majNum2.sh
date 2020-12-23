#!/bin/bash

cpt=0

if [ $# -ne 1 ] || [ ! -f $1]; then
		echo "$0 usage <filename>"
		exit 1
fi

./majuscule.sh | ./numerotation.sh < $1


#tres lourd et prendre de la place pour rien
