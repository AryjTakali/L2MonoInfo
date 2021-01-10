#!/bin/bash

liste_sig=$(kill -l | tr -s ' \t' '\n' | grep SIG )

#while read line; do
while IFS= read -r line
do
	trap '' $line
done <<< $liste_sig 

echo "il ne doit en rester qu'un"
sleep 5
./$0
