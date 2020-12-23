#!/bin/bash

moyenne=0

if [ $# -ne 1 ]
then
	echo "usage $0 <filename>"
	exit -1
fi

for i in 5 6 7
do
	moyenne=$(cat $1 | cut -d ' ' -f$i | tail -n +2 | ./moyProm.sh)
	nom=$(cat $1 | cut -d ' ' -f$i | tail -n 1)
	echo "la moyenne de $nom est de $moyenne"
done
