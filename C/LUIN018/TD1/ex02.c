#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>

int compteMotsChaine(char *chaine){
    int nbMots = 0;

    while (*chaine){
        if (isspace(*chaine)){
            while (*chaine != '\0' && isspace(*chaine))
                chaine++;
        } else {
            nbMots++;
            while (*chaine != '\0' && !isspace(*chaine))
                chaine++;
        }
    }
    return nbMots;
}

int	compte_mots(char **tab){
	int nbMots = 0;

	while (*tab != NULL){
		nbMots++;
		tab++;
	}
	return nbMots;
}

void	detruit_tab_mots(char **ptab_mots){
	int i = 0;

	while (ptab_mots[i] != NULL){
		free(ptab_mots[i]);
		i++;
	}
	free(ptab_mots);
}
int		lenMot(char *str){
	int i = 0;

	while (str[i] && !isspace(str[i])){
		i++;
	}
	return (i);
}

char	**decompose_chaine(char *chaine){
	int nb_mots = compteMotsChaine(chaine);
	char **tabs = malloc(sizeof(char*) * (nb_mots + 1));
	int lenW;
	int i = 0;

	while (i < nb_mots){
		while (*chaine != '\0' && isspace(*chaine))
			chaine++;
		lenW = lenMot(chaine);
		tabs[i] = malloc(sizeof(char) * (lenW + 1));
		tabs[i] = memcpy(tabs[i], chaine, lenW);
		tabs[i][lenW] = '\0';
		chaine += lenW;
		i++;
	}
	tabs[i] = NULL;
	return tabs; 
}

int	main(){
	char *str = "testons trois mots";
	char **tabs = decompose_chaine(str);

	printf("nombre de mot dans \"%s\" = %d\n", str, compteMotsChaine(str));
	while (*tabs != NULL){
		printf("|%s| ", *tabs);
		tabs++;
	}
}
