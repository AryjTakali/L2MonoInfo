#!/bin/bash


export champion=""

while read line; do 
	./sentance_longest_w.sh $line 
done 
./longest_param.sh $champion 

