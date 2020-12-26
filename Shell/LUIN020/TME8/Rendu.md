# TD 8 

# Exercice 3

## Question 1

```
bash
| ./patriarche.sh 
-------------------
                   | echo "Je suis le patriarche"
                   | ./descendant.sh 3 &
                   |---------------------------|
                   |                           | echo "je suis le descendant 3"
                   |                           | ./descendant.sh 2 &
                   | ./descendant.sh 2 &       |-----------------------|
                   |                           |                       | echo "je suis le descendant 2"
                   | ./descendant.sh 1 &       |                       | ./descendant 1 &
                   |                           |                       |-----------------------|
                   | ./descendant.sh 1 &       |                       |                       | echo "je suis le descendant 1"
                   |                           |                       |                       | ./descendant 0
                   | ./descendant.sh 0 &       |                       |                       |---------|
                   |                           |                       |                       |         | echo "je suis le descendant 1"
                   | echo "fin d'un descendant"|                       |                       |         | echo "fin d'un descendant"
                   |                           | ./descendant.sh 2 &             
                   |                           |
                   |                           |
                   |                           | terminaison
                   |<==========================|
                   | terminaison du père
 <=================                  
| ...
|
|
```


## Question 2 

Non parce que le processus de patriarche continue en parallele des processus fils. Donc si les processus fils ne sont pas finit il se terminera avant eux.
Pour s'assurer qu'il finisse avant les autres il suffit de rajouter un _wait_ apres l'appel ./descendant 3 &

# TME 8 

# Exercice 1

## Question 1

avec la commande : 
```bash 
sleep 30 &
ps o pid,ppid,state --pid $!
```

On obtient :
```
 PID  PPID S
 6298  6280 S
 ```

## Question 2

Avec le script : 

```bash
#! /bin/bash

sleep 60 &
echo "Debut pere $$ je lance $!" 
echo "fin pere"
```

Puis la ligne de commande : 
```bash 
ps o pid,ppid,state,command --pid $!
```

On obtient : 

```
PID  PPID S COMMAND
527  526  S -bash
792    1  S sleep 60
793  527  R ps o pid,ppid,state,command
 ```

-  Le processus pere (script) se termine avant son fils (sleep) ce qui provoque la creation d'un fils zombie.
- Sleep est alors adopté par init (de PID 1).

Ce qui prouve bien l'adoption d'un processus par init.

## Question 3

Afin de répéter la commande chaque seconde on utilise sleep 1

```bash 
#! /bin/bash

if [ !-e $1 ] || [ !-f '/proc/$1/exe' ]; then
    ./myZombie &
fi

i=0
while [ $i -lt 59 ]; then
    ps o pid,ppid,state $1
    sleep 1
    i=$((i+1))
done
```

# Exercice 2

```bash
#! /bin/bash

if [ ! -d dico ]; then
       mkdir dico
fi

touch dico/{A..Z}

while read line; do
  for i in {A..Z};do
        if [ ${line:0:1} == $i ]; then
                echo "$line" >> dico/$i
        fi
  done
done < dico.txt
```


```bash
#! /bin/bash

if [ ! -d dico ]; then
       mkdir dico
fi

touch dico/{A..Z}

while read line; do
  echo "$line"  >> dico/${line:0:1}
done < dico.txt

for f in [A-Z]; do  mv $f $f.txt ;done
```

# Exercice 3

## Question 1

```bash
#! /bin/bash

champion=""
max=0

if [ ! -e $1 ] && [ ! -f $1 ]; then
        echo "Usage : $0 <nom_fichier>"
        exit
fi

while read line ;do 
        if [ $max -lt ${#line} ]; then
                champion=$line
                max=${#line}
        fi
done < $1

echo $champion > $1.tmp
```

## Question 2

``` bash
#! /bin/bash

if [ ! -e $1 ] && [ ! -d $1 ]; then
        echo "Usage : $0 <nom_repertoire>"
        exit
fi

for f in $1/*.txt ; do 
        ./longest.sh $f &
        liste_pid="$! "
done

champion=""
max=0

for y in $liste_pid; do
                wait $y
        done

for f in $(cat $1/*.tmp); do 
    if [ $max -lt ${#f} ];then
        champion=$f
        max=${#f}
    fi
done

echo $champion
```

## Question 3

```
time ./longest.sh dico.txt
```

- real    0m2,110s
- user    0m1,797s
- sys     0m0,308s

```
time ./paraLongest.sh dico
```

- real    0m0,130s
- user    0m0,096s
- sys     0m0,030s

On remarque que le temps mis par le script _paraLongest.sh_ est beaucoup plus rapide que _longest.sh_. 
-   Le temps d'execution a été divisé par 20
-   Le temps d'utilisation du processeur en mode user a été divisé par plus de 100
-   Le temps d'utilisation du processeur en mode systeme a été divisé par plus de 10
Cela prouve que paralelliser les taches optimise grandement le temps de recherche.

## Question 4

```
time ./longest.sh dico.txt
```

- real    0m2,110s
- user + sys =  0m1,797s + 0m0,308s = 0m2,105 

```
time ./paraLongest.sh dico
```

- real    0m0,130s
- user + sys =  0m0,096s + 0m0,030s = 0m0,126s

On remarque que la comme des temps user et sys sont tres proche des temps de real a 0,005s pres