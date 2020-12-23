#!/bin/bash

for num in {1..100}; do
    if  ./monProg $num ; then
        echo -n "$num "
    fi
done
echo
