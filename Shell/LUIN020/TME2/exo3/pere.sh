#!/bin/bash

#affiche le pid du script fils et de son pere 10 fois

echo Je suis $$
for i in {1..10}; do
    bash fils.sh
done

#on remarque que le pi change mais le pid reste le meme