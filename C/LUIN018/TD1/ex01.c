#include <stdio.h>
#include <ctype.h>
#include <time.h>
#include <stdlib.h>
#define SIZE 5

static int	fMin(int n1, int n2){
	return n1 < n2 ? n1 : n2;
}

static int	fMax(int n1, int n2){
	return n1 > n2 ? n1 : n2;
}

int     rec_min(int *tab, int size, int min){
	if (size > 0)
		return (rec_min(tab, size - 1, fMin(tab[size], min)));
	else
		return fMin(tab[size], min);
}

int     rec_max(int *tab, int size, int max){
	if (size > 0)
		return (rec_max(tab, size - 1, fMax(tab[size], max)));
	else
		return fMax(tab[size], max);
}

double	sum(int *tab, int size, int somme){
	if (size > 0)
		return sum(tab, size - 1, somme + tab[size]);
	else
		return (double)somme;
}

void    rec_min_max_moy(int *tab, int size, int *min, int *max, double *moy){
	*min = *tab;
	*max = *tab;
	*moy = 0;
	*max = rec_max(tab, size - 1, *max);
	*min = rec_min(tab, size - 1, *min);
	*moy = sum(tab, size - 1, *moy) / size;
}

void    min_max_moy(int *tab, int size, int *min, int *max, double *moy){
	int i = 0;
	*min = *tab;
	*max = *tab;
	*moy = (double)*tab;

	while (i < size){
		if (tab[i] < *min)
			*min = tab[i];
		else if (tab[i] > *max)
			*max = tab[i];
		*moy += (double)tab[i];
		i++;
	}
	*moy = *moy/(double)size;
}

void	afficheTab(int *tab, int size){

	printf("le tableau : ");
	for (int i = 0; i < size; i++){
		printf("%d ", tab[i]);
	}
}

void	testeurRand(){
	int size = rand() % 100 + 1;
	int min,max;
	double moy;
	int *tab = malloc(sizeof(int) * size + 1);

	for (int i = 0; i < size; i++){
		tab[i] = i;
	}
	afficheTab(tab, size);
	min_max_moy(tab, size, &min, &max, &moy); 
	printf("\nminimum : %d\t-\tmaximum : %d\t-\tmoyenne : %.1f\n", min, max, moy);

}

void	fullTest(){
	int min,max;
	double moy;

	for (int size = 1; size <= 101; size++){
		int *tab = malloc(sizeof(int) * size + 1);

		for (int i = 0; i < size; i++){
			tab[i] = i;
		}
		afficheTab(tab, size);
		min_max_moy(tab, size, &min, &max, &moy); 
		printf("\nminimum : %d\t-\tmaximum : %d\t-\tmoyenne : %.1f\n", min, max, moy);
	}
}



int main(){
	srand( time( NULL ) );
	int tab[SIZE] = {-10,1,2,3,4};
	int min = 0, max = 0;
	double moy = 0;

	afficheTab(tab, SIZE);
	printf("\n\nFacon recursive :");
	rec_min_max_moy(tab, SIZE, &min, &max, &moy); 
	printf("\nminimum : %d\t-\tmaximum : %d\t-\tmoyenne : %.1f\n", min, max, moy);

	printf("\n\nFacon iterative :");
	min_max_moy(tab, SIZE, &min, &max, &moy); 
	printf("\nminimum : %d\t-\tmaximum : %d\t-\tmoyenne : %.1f\n", min, max, moy);

	testeurRand();
//	decommenter ligne 120 pour avoir tous les test de 1 a 100
//	fullTest();
	return (0);
}
