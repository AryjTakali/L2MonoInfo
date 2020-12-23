#include <stdio.h>

typedef struct Nd_mot_ { 
    char *mot;
    struct Nd_mot_ *g;
    struct Nd_mot_ *d;
} Nd_mot;

typedef struct Lm_mot_ { 
    char *mot;
    struct Lm_mot_ *suiv;
}   Lm_mot;

/* taille de la liste donnee en argument */
int taille_Lmot(Lm_mot *lm);

Lm_mot  *part_Lmot(Lm_mot **pl){
    int nbm = taille_Lmot(*pl);
    Lm_mot *p = *pl;    
    Lm_mot *pivot;    

    if (nbm < 3){
        *pl = NULL;
        return p;
    } else {
        for (int i = 0; i < nbm / 2 - 1 ; i++){
            p = p->suiv;
        }
        pivot = p->suiv;
        p->suiv = NULL;
    }
    return pivot;
}

Nd_mot  *Lm2abr(Lm_mot *l){
    Lm_mot *p;    
    Nd_mot *nd;    

    if (l == NULL)
        return NULL;

    p = part_Lmot(&l);

    nd = malloc(sizeof(Nd_mot));

    nd->mot = p->mot;
    nd->g = Lm2abr(l);
    nd->d = Lm2abr(p->suiv);
    free(p);

    return nd;
}

Nd_mot *chercher_Nd_mot(Nd_mot *abr, const char *mot){
    int res;
    if (mot && abr){
        if ((res = strcmp(abr->mot, mot)) == 0)
            return abr;
        else
           res < 0 ? chercher_Nd_mot(abr->g, mot) : chercher_Nd_mot(abr->d, mot); 
    }
    return NULL;
}


void detruire_abr_mot(Nd_mot *abr){
    if (!abr)
        return;
    if (abr->g)
        detruire_abr_mot(abr->g);
    if (abr->d)
        detruire_abr_mot(abr->d);
    free(abr);
}

//comparaison : 1 noeud par mot 
//-> determiner taille d'un mot (3 pointeurs : fils et mot) + chaque mot taille moyenne de str * nbmot
//taille pointeur : 32bit = 4 octet / 64bit = 8octet

//nombre de comparaison recherche d'un mot
// relié a l'equilibre de l'arbre 
// nb de comparaison lié a la hauteur de l'arbre
//lien hauteur / nb noeuds = ajout d'un niveau = *2 nombre de noeuds 
//nouveau niveau  a  2* plus de noeuds que le niveau precedent : fonction exponentielle (log)
//hauteur : fonc log(noeuds de l'arbres)
//complexite dans dico logarithmique