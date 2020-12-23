#!/bin/bash

tar xzf dossier_flac.tar.gz
#rm dossier_flac.tar.gz

echo "Les albums recommandes des Beatles sont:\n"
for f in The_Beatles-*; do
	echo "- $f";
done

echo "\nLes albums dont le titre a une lettre sont:\n"

for f in *-[a-zA-Z]-*;do
	echo "- $f"
done

nbAlbum=0
for f in *; do
	nbAlbum=$(($nbAlbum + 1))
done

echo "Il y a $nbAlbum Album"

echo "Le nombre moyen de caractere par album est:"

moy=0

for f in *; do
	moy=$(($moy + ${#f}))
done
moy=$(($moy/$nbAlbum))
echo $moy

printf '\n'
for annee in {1995..2016}; do
	count=0
	printf "$annee  : " 
	for i in *-$annee.flac; do
		#count=$(($count + 1))
		printf 'x'
	done
	printf '\n'
done

#tar -zcvf dossier_flac.tar.gz *.flac
rm *.flac
