#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <assert.h>
#include "arbre_lexicographique_tab.h"


PNoeudTab creer_noeud(char lettre) {
    PNoeudTab pnt = malloc(sizeof(NoeudTab));
  if (pnt == NULL) {
    printf("Impossible d'allouer un noeud\n");
    return NULL;
  }

  pnt->lettre=lettre;
  pnt->fin_de_mot=non_fin;
  for (int i = 0; i < 26; i++)
    pnt->fils[i]=NULL;
  return pnt;
}

PNoeudTab ajouter_mot(PNoeudTab racine, char *mot) {
    PNoeudTab n = racine;
  if (strlen(mot)==0)
    return NULL;

  if (racine == NULL){
    racine = creer_noeud('.');
    n = racine;
  }

  if (n->fils[(int)(*mot - 'a')] == NULL)
    n->fils[(int)(*mot - 'a')] = creer_noeud(*mot);

  if (strlen(mot) == 1)
    n->fils[*mot-'a']->fin_de_mot=fin;
  else 
    n->fils[(int)(*mot - 'a')]=ajouter_mot(n->fils[(int)(*mot - 'a')], mot + 1);
  return racine;
}

void afficher_mots(PNoeudTab n, char mot_en_cours[LONGUEUR_MAX_MOT], int index) {
  if (n == NULL)
    return;
  
  mot_en_cours[index] = n->lettre;
  if (n->fin_de_mot == fin){
    mot_en_cours[index + 1] = '\0';
    printf("%s\n", mot_en_cours+1);
  }else{
    for (int i = 0; i < 26; i++)
      afficher_mots(n->fils[i], mot_en_cours, index + 1);
  }
}

void afficher_dico(PNoeudTab racine) {
  char mot_en_cours[LONGUEUR_MAX_MOT];
  afficher_mots(racine, mot_en_cours, 0);
}

void detruire_dico(PNoeudTab dico) {
  for (int i = 0; i < 26; i++){
    if (dico->fils[i])
      detruire_dico(dico->fils[i]);
  }
  free(dico);
}

int rechercher_mot(PNoeudTab dico, char *mot) {
  PNoeudTab n=dico->fils[(int)(*mot - 'a')];
  if (n == NULL) {
    return 0;
  }
  if (strlen(mot)==1) {
    return n->fin_de_mot == fin;
  }
  return rechercher_mot(n->fils[(int)(*mot - 'a')], mot + 1);
}

PNoeudTab lire_dico(const char *nom_fichier) {
  /* a completer. Exercice 6, question 2 */
  FILE* f = fopen(nom_fichier,"r");
  if(f==NULL){
    fprintf(stderr,"Impossible d'ouvrir le fichier: %s\n",nom_fichier);
    return NULL;
  }
  char mot[LONGUEUR_MAX_MOT];
  PNoeudTab dico = NULL;
    while(fgets(mot,LONGUEUR_MAX_MOT,f)){
      mot[strlen(mot)-1] = '\0';
      dico = ajouter_mot(dico,mot);
    }
    fclose(f);
    return dico;
}


