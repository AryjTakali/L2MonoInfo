#ifndef ECOSYS_H
# define ECOSYS_H

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <time.h>
#include <assert.h>

#define SIZE_X 20
#define SIZE_Y 5

typedef struct s_animal{
    int x;
    int y;
    float energie;
    int dir[2];
    struct s_animal *suivant;
}   Animal;


#endif