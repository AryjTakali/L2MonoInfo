#include "lecture.h"

ty_etu    lecture_ascii_etu(){
    int nb_etu;
    ty_etu *BD;
    FILE *f;

    assert(f = fopen("notes.txt", "r"));
    fscanf(f, "%d", &nb_etu);
    assert(BD = malloc(sizeof(ty_etu) * (nb_etu)));

    // for (int i = 0; i < nb_etu; i++){
        fscanf(f, "%d", BD[0].id_etu);
        
    // }
    printf("%d - %d", nb_etu, BD[0].id_etu);
    return (BD);
}

int main(){
    lecture_ascii_etu();
    return (0);
}