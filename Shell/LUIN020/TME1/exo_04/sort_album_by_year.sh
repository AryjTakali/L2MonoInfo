#!/bin/sh

tar xzf dossier_flac.tar.gz
#rm dossier_flac.tar.gz

if [ -d "./by_year" ]; then
	echo "Le repertoire by_year existe deja !"
else
	mkdir by_year
	echo "Le repertoire by_year vient d'etre cree ."
fi

for annee in {1995..2016}; do
	if [ ! -d "./by_year/$annee" ]; then
		mkdir ./by_year/$annee
	fi
	for f in *-$annee.flac; do
		if [ ! -f "./by_year/$annee/$f" ]; then
			cp $f ./by_year/$annee/
		fi
	done
done

#tar -zcvf dossier_flac.tar.gz *.flac
rm *.flac
