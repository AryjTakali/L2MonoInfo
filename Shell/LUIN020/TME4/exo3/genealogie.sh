#!/bin/bash

#verification du nombre de parametre
if [ $# -lt 1 ]; then
	echo "Usage $0 <param>"
	exit 1
fi

#On verifie si le processe existe bien avant de commencer le script
#sinon on affiche un message d'erreur
if [ -n $1 -a -e /proc/$1 ]; then
       	echo "$1 process exists"

#on stock dans une variable les valeurs du procfs et on la parse afin d'obtenir le current PID 
	line=$( cat /proc/$1/stat  | cut -d ' ' -f4)

#on utilise la meme methode afin d'obtenir le PPID et on reitere jusqua atteindre le PID 1 qui correspond au premier processus
#on ecrit le no; du processus ainsi que son PID de maniere successive
	 while [ $line -ne 1 ] ; do 
		line=$(cat /proc/$line/stat  | cut -d ' ' -f4)
		echo $(cat /proc/$line/stat  | cut -d ' ' -f2) : $line
	done
	echo "$line est le ppid de tous les process"
	echo; pstree -cp | grep famille 
else
	echo "process doesn't exists"
fi

