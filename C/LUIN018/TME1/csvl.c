#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "csvl.h"

int compte_mots_chaine(char *chaine) {
	int i=0, cpt=0;

	while (chaine[i] != '\0') {
		if (chaine[i] == ' '){
			while (chaine[i] && chaine[i] == ' ')
				i++;
		} else{
			cpt++;
			while (chaine[i] && chaine[i] != ' ')
				i++;
		}
	}
	return cpt;
}

char **decompose_chaine(char *chaine)
{

	/* Fonction vue en TD, exercice 2, question 7 */

	char *pc= chaine;
	int nb_mots=0;
	char **ptab;
	char *psrc_mot;
	int ind_mot=0;

	//comptages des mots
	nb_mots=compte_mots_chaine(chaine);

	if (nb_mots == 0)
		return NULL;
	// allocation du tableau

	ptab = malloc((nb_mots + 1) * sizeof(char *));
	ptab[nb_mots] = NULL;

	// copie des mots

	pc=chaine;
	while (*pc)
	{
		if(*pc == ' ')
		{
			pc++;
			continue;
		}

		psrc_mot = pc;

		while((*pc != ' ') && (*pc)) pc++;

		//allocation du mot
		ptab[ind_mot] = malloc((pc - psrc_mot + 1)* sizeof(char));
		//copie du mot
		memcpy(ptab[ind_mot], psrc_mot, pc - psrc_mot);
		//insertion du marqueur de fin de chaine
		*(ptab[ind_mot] + (pc - psrc_mot)) = '\0';

		ind_mot++;
	}
	return ptab;
}

int compte_mots(char **ptab_mots)
{
	/* a completer exercice 3, question 2 */
	int nbMots = 0;

	while (*ptab_mots != NULL){
		ptab_mots++;
		nbMots++;
	}
	return nbMots;
}

int	nbChar(char **ptab_mots){
	int size = compte_mots(ptab_mots);
	
	while (*ptab_mots != NULL){
		size += strlen(*ptab_mots);
		ptab_mots++;
	}
	return size;
}

void detruit_tab_mots(char **ptab_mots)
{

	/* Fonction vue en TD, exercice 2, question 5 */

	int i=0;

	if (ptab_mots)
		while(ptab_mots[i])
			free(ptab_mots[i++]);

	free(ptab_mots);
}

char *compose_chaine(char **ptab_mots)
{
	/* a completer exercice 3, question 4 */
	char *chaine = malloc(sizeof(char) * nbChar(ptab_mots));
	int i = 0, lenMot;
	
	while (*ptab_mots != NULL){
		lenMot = strlen(*ptab_mots);
		memcpy(&chaine[i], *ptab_mots, lenMot);
		i+= lenMot;
		if (*(ptab_mots + 1)){
			strcpy(&chaine[i], " ");
			i++;
		}
		ptab_mots++;
	}
	chaine[i] = '\0';
	return chaine;
}


void affiche_tab_mots(char **ptab_mots)
{
	/* a completer exercice 3, question 3 */
	while (*ptab_mots != NULL){
		printf("|%s| %p \n", *ptab_mots, *ptab_mots);
		ptab_mots++;
	}
}

char **reduit_tab_mots(char **ptab_mots)
{
	/* a completer exercice 4, question 1 */
	int i = 0, j = 1;

	while (ptab_mots[i] != NULL){
		j = 1;
		while (ptab_mots[i + j]!= NULL){
			if (strcmp(ptab_mots[i], ptab_mots[i + j]) == 0){
				free(ptab_mots[i + j]);
				ptab_mots[i + j] = ptab_mots[i];
			}
			j++;
		}
		i++;
	}
	return ptab_mots;
}

int main() {

	char *tab="mot1 et mot2 et mot3";
	int nbMot1 = compte_mots_chaine(tab);
	char **tabDouble = decompose_chaine(tab);
	int nbMot2 = compte_mots(tabDouble);

	printf("chaine d'origine : %s\nContient %d mots", tab, nbMot1);
	printf("\nChaine modifie : \n");
	affiche_tab_mots(tabDouble);
	printf("\nContient : %d mots\n", nbMot2);
	printf("chaine de fin : |%s|\n", compose_chaine(tabDouble));
	printf("nombre de char : %d - %d\n", nbChar(tabDouble), (int)strlen(tab));
	affiche_tab_mots(reduit_tab_mots(tabDouble));
//	detruit_tab_mots(tabDouble);
	return 1;
}
