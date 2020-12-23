#!/bin/bash 

#PART 1

#1
ls *.pdf

#2
ls ?

#3
ls td[1-3]

#4
ls td[13]

#5 ne reconnait pas le nombre 13
ls td[1-13]

#6 affiche tous les fichier commencant par lettre minuscule
ls [a-z]*

#PART 3

a=*
echo x$a
b=[a-z]
echo x$b