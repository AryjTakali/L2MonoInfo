#! /bin/bash

if [ ! -f $1 ]; then
    echo "Usage : $0 <velib-dispo.json>"
    exit
fi

dispo=0

for i in $(cat $1 | tr -s '[]{}' '\n\n\n\n' | sed -En 's/(.*"numbikesavailable":) ([0-9]*)(,.*)/\2/p' ) ; do
    dispo=$((dispo + i))
done

echo "En tout, il a $dispo velibs disponibles sur l'ensemble du reseau"