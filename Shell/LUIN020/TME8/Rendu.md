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

## Question 2

```bash 
#! /bin/bash

if [ !-e $1 ] || [ !-f '/proc/$1/exe' ]; then
    echo "Usage : $0 <PID>"
    exit
fi

for i in {1..60}; do
        ps o pid,ppid,state,command $1
        sleep 1
done
```

# Exercice 2

