#! /bin/bash

if [ ! -d dico ]; then
	mkdir dico
fi

touch dico/{A..Z}

while read line; do
  for i in {A..Z};do
	if [ ${line:0:1} == $i ]; then
		echo "$line" >> dico/$i
	fi
  done
done < dico.txt
    
