#!/bin/bash

#lit sur STDIN le choix de langue
read -p "choose between VF and VO : " sub

#interprete l'entree de l'utilisateur et quitte en erreur s'il ne s'agit pas d'un choix valide
if [ $sub = "VO" ] || [ $sub = "VF" ]; then
	[ $sub = "VO" ] && cowsay "It's in $sub" && lang=3 
	[ $sub = "VF" ] && cowsay "C'est en $sub" && lang=2
else
	cowsay "You needed to choose between VO and VF"
	exit 1
fi

#teste si le fichier blabla.csv est bien present
[ ! -f blabla.csv ] && echo "Le fichier blabla.csv n'a pas ete trouve veuillez le mettre dans ce directory" && exit 1

#parcours le fichier blabla.csc ligne par ligne et execute cowsay avec comme parametre 
#l'animal donne dans la premiere colone de blabla.csv 
#et en deuxieme l'affichage dans la bulle avec la langue choisis

#############   V.1 #################
#cat blabla.csv |  while read word ;do
#		cowsay -f $(echo $word | cut -d ',' -f1) $(echo $word | cut -d ',' -f$lang)
#done

IFS=,

while read animal fr eng ; do
	[ $lang -eq 2 ] && cowsay -f $animal $fr || cowsay -f $animal $eng
done < blabla.csv
