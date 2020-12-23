#!/bin/bash

max=0

if [ $1 ] && [ -d $1 ]; then 
		cd $1
		for f in * ; do
			if [ $(wc -m < $f) -gt $max ]; then
				max=$(wc -m < $f)
				champion=$f
			fi
		done
		echo " Le plus gros fichier est : \"$champion\" avec $max characteres"
else
	[ ! -d $1 ] && echo "the directory $1 doesn't exist" || echo  "there is no parameters " 
	echo "usage $0 <directory-name>"
	exit
fi
