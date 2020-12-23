#ifndef LECTURE_H
# define LECTURE_H

#include <stdio.h>
#include <stdlib.h>

typedef struct _ty_etu{ 
    int     id_etu;
    char    nom[200], prenom[200]; int nb_ue;
    char    codes_ue[9][20];
    int     notes[20];
} ty_etu;

#endif