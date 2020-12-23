#!/bin/bash

max=0

for mot in $@; do 
	if [ ${#mot} -gt $max ]; then
		max=${#mot}
		champ=$mot
	fi
done
return "$champion "
