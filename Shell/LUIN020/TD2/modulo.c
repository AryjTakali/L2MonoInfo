#include <stdio.h>
#include <stdlib.h>

int main(int ac, char **av){
    if (ac < 2){
        printf("il faut un argument\n");
        exit(-1);
    }
    return atoi(av[1]) % 2;
}