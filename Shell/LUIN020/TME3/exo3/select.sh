#!/bin/bash

error="Usage : ./select.sh <source_directory> <target_directory>"

if [ $# -lt 2 ] ; then
    [ ! $1 ]  && echo "Two parameters are missing" || echo "one parameter is missing" 
    echo $error
    exit
fi

if [ ! -d $1 ] || [ ! -d $2 ]; then
    [ ! -d $1 ]  && echo "The first directory doesn't exist" || echo "The second directory doesn't exist"
    echo $error
    exit
fi

for i in {1..4}; do
    champion=$( ./biggest.sh $1)
    champion=$(echo $champion | cut -d"\"" -f2)
    mv "./$1/$champion" "./$2"
done

ls $2
