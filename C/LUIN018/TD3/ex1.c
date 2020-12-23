#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#define DIM1 5
#define DIM2 6

void    show(char **tab){
    while (tab){
        printf("%s\n", *tab);
        tab++;
    }
}

void    InitTab(char **tab){
    int i = 0;
    int j = 0;
    
    tab[DIM1 - 1] = NULL;
    while (tab){
        tab[i][DIM2 - 1] = '\0';
        j = 0;
        while (tab[i][j] != '\0'){
            tab[i][j] = '0';
            j++;
        }
        i++;
    }
}

int main(void){
    char **tab2D = malloc(sizeof(char*) * DIM1);
    assert(tab2D);
    for (int i = 0; i < DIM1; i++)
        assert(tab2D[i] = malloc(sizeof(char)*DIM2));

    InitTab(tab2D);

   // show(tab);
    return 0;
}