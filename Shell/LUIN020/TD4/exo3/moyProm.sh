#!/bin/bash


sum=0
cpt=0

while read line
do 
	sum=$((line + sum))
	cpt=$((cpt + 1))
done

echo $((sum/cpt))

