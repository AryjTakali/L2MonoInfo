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
Pour s'assurer qu'il finisse avant les autres il suffit de rajouter un _wait_ apres l'appel ./descendant 3 