#!/bin/bash

mkdir LUIN020
for num in {0{1..9},10,11}; do
    if [ ! -d LUIN020/TP_$num ]; then
        mkdir LUIN020/TP_$num
    fi
done

for num in {0{1..9},10,11}; do
    cd LUIN020/TP_$num
    pwd
    ls
    if [ -f README ]; then
        cat README
    fi
    cd ../..
done

#