#!/bin/bash

#1
echo Hello World

#2
echo Hello World
echo Hello World

#3 considere le echo comme part du texte a afficher
echo Hello World echo Hello World

#4 erreur car considere une nouvelle ligne "Hello World" 
#et ne connais pas la commande Hello
#echo Hello World; Hello World

#5 considere 2 ligne de commande du au separateur ;
echo Hello World; echo Hello World

#6
echo Hello World; 
echo Hello World;