#include <stdio.h>

typedef struct noeud *PNoeud; 
typedef struct noeud {
    char lettre;
    FDM fin_de_mot; 
    PNoeud fils;
    PNoeud frere_suivant;
}   Noeud;

// fin = il existe un mot finissant par cette lettre
// non_fin = il n’existe pas de mot finnissant par cette lettre 
typedef enum _FDM {fin,non_fin} FDM;

typedef struct Lm_mot_ { 
    char *mot;
    struct Lm_mot_ *suiv;
}   Lm_mot;

PNoeud creer_noeud(char lettre){
    PNoeud pn = malloc(sizeof(PNoeud));
    pn->lettre = lettre;
    pn->fin_de_mot = non_fin;
    pn->fils = NULL;
    pn->frere_suivant = NULL;
    return pn;
}

int rechercher_mot(PNoeud dico, char *mot){

    
}