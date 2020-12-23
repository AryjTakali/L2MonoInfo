#! /bin/bash

#cette ligne permet de telecharger le document uniquement s'il n'existe pas deja
if [ ! -f "./arbres-remarquables-paris.csv" ];then
    wget --output-document arbres-remarquables-paris.csv https://opendata.paris.fr/explore/dataset/arbresremarquablesparis/download/?format=csv
fi

#methode1 cut directement le resultat avec le sed
#nbArbres=$(sed -En 's/(.*PARIS) ([0-9]+)(E.*)/\2/p' arbres-remarquables-paris.csv | sort -n | uniq -c | sort -n | sed -En 's/[ ]*(.*) (.*)/\1/; $p')
#methode2 garder l'arrondissement et le nombres d'arbres
res=$(sed -En 's/(.*PARIS) ([0-9]+)(E.*)/\2/p' arbres-remarquables-paris.csv | sort -n | uniq -c | sort -n | sed -En '$p')

#J'ai choisi d'utiliser le cut pour que ce soit plus lisible 
commune=$(echo $res | cut -d ' ' -f2)
nbArbres=$(echo $res | cut -d ' ' -f1)

echo "La commune avec le plus d'arbres remarquable est le $commune eme arrondissement avec $nbArbres arbres"
echo $arbres