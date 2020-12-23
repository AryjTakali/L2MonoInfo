#!/bin/bash

#####################    Q.2    #####################

function usage(){
		echo "Usage : $0 <files-readable>"
		exit 1
}


if [ $# -lt 1 ] || [ ! -f $1 ]; then
	usage
fi

#####################    Q.3    #####################
#on affiche tout le fichier en entree en enlevant les 2 dernieres lignes qui ne sont pas des entrees puis on compte le nombre de lignes

echo
echo "Il y a $(cat $1 | head -n -2 | wc -l) entrees"


#####################    Q.4    #####################
#I choose to create a variable with le name of the last personne logged in so i could use it again
#because $(!!) didn't have it
#on qffiche tout le fichier en gardant uniquement la premiere ligne qui correspond a la derniere connexion
#puis on garde uniquement le premier champ (en utilisant le separateur espace) qui correspond a l'identifiant
#enfin on test si cela correspond a notre login et affiche le message en consequence

last_co=$(cat $1 | head -n 1 | cut -d ' ' -f1)
[ $last_co = $(whoami) ] && echo "I am the last person who logged in" || echo "I am not the last person who logged in, it's $last_co"


#####################    Q.5    #####################
#on affiche tout en gardant uniquement la premiere colonne qui correspond aux login 
#on garde uniquement ceux qui correspondent a notre login puis on compte le nombre de lignes

echo
nb_co=$(cat $1 | cut -d ' ' -f1 | grep $(whoami) | wc -l)
echo "Je me suis connecte $nb_co fois"

#####################    Q.6    #####################
#on affiche tout en gardant uniquement la premiere colonne qui correspond aux login 
#on les trie puis on elimigne les logins consecutifs identiques puis on compte le nombre de lignes

echo
nb_user=$(cat $1 | head -n -2 | cut -d ' ' -f1 | sort | uniq  | wc -l)
echo "$nb_user utilisateurs se sont deja connectes a cette machine"


#####################    Q.7    #####################
#on affiche tout, reverse puis gardons le 1er champ (qui est en realite le dernier) et reverse a nouveau pour avoir a l'endroit
#on trie puis on supprime les repetition et les connexions en local avant de compter le nombre de lignes

echo
nb_machine=$(cat $1 | rev | cut -d ' ' -f1 | rev | sort | uniq | grep -v '0.0.0.0' | grep -v 'localhost' | wc -l)

echo "Il y a $nb_machine machines"

#####################    Q.8    #####################
#par soucis de lisibilite j'ai affiche les machines sur lesquels les utilisateurs se sont connecte sans repetitionss

echo;echo
list_user=$(cat $1 | head -n -2 | cut -d ' ' -f1 | sort | uniq)

for user in $list_user; do
	list_machin=$user
	for machin in $(cat $1 | grep $user | rev |cut -d ' ' -f1 | rev | sort | uniq); do
		if [ $machin != '0.0.0.0' ] && [ $machin != 'localhost' ]; then
			list_machin="$list_machin     -     $machin"
		fi
	done

#il faut commenter ces lignes pour ne pas afficher les machines sur lesquels les utilisateurs se sont connecte a distance 
#affiche seulement les utilisateurs se sont connecte au moins une fois a distance 
	[ $machin != '0.0.0.0' ] && [ $machin != 'localhost' ]  && echo $list_machin

done

#####################    Q.9   #####################

#On ne voit que des adresses de la ppti car il s'agit des connexions non locales 
#le nom est enregistre grace a l'option -d 

#####################    Q.10   #####################

#cat finger.log
#j'ai mis dans le fichier finger.log la sortie de la commande finger 
#elle permet d'avoir les indentifiant ainsi que le nom des personnes etant connecte a la ppti


