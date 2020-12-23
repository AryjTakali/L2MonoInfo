#include <stdio.h>
#include <stdlib.h>

int main(int ac, char **av){
    if (ac != 3){
        printf("il faut de arguments\n");
        exit(-1);
    }
    printf("Le resultat est : %d\n", atoi(av[1])  + atoi(av[2]));
    return (0);
}
/*
1 ) affiche pour 22 et 34 :
Le resultat est : 56

2)le test sur ac est fait par rapport a 3 car 
l'executable est aussi comptabilise dans ac et av

3) code source  = *.c
executable = a.out 
(ou le nom donne si on compile avec l'option -o <nom excecutable>)
processus = execution du programme en cours
*/