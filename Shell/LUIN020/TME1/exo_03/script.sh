#!/bin/sh

tar xzf jeu_piste.tar.gz

cat README
echo "\n"
cat etape_1/Livre*/*63
echo "\n"
cd etape_2 && sh etape2.sh && cd ..
echo "\n"
echo "Le cat"
# cat {501..600..3}AD > etape3
cat etape_3/etape3 | awk '{printf("%s", $0)}' 
echo "\n"
cd etape_4 && sh etape4.sh && cd ..

rm -rf etape_{1..4} README
