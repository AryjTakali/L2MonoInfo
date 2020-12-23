#!/bin/bash

for i in {1..26}; do
	echo -n "decalage de $i : " >> best_decalage
	 ./a.out $i < fenetre_sur_coquillage/part1 >>best_decalage
done


for f in ./fenetre_sur_coquillage/part*; do
	 ./a.out 16 < $f >> news.txt
done
