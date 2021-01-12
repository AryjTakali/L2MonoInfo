#!/bin/bash

if [ $# -ne 1 ] && [ $1 -lt 0 ] ; then
	echo "Usage : $0 <number>"
	exit
fi

nb=$1
for i in {1..$nb}; do
	printf "Ola :%-$(($nb-$i))s0\n" " " 
done

