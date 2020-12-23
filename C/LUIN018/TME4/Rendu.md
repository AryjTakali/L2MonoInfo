Je tiens a m'excuser pour ce retard de rendu. L'exercice 6 m'a pris un certain temps a debugger

# Exercice 5

On economise de la place avec l'arbre lexicographique.

- Dans le 1er arbre : on compare chaque mot avec le mot recherché
- Dans le 2e : on compare uniquement les lettres(moins de comparaison) donc ca devrait etre plus rapide en plus d'economiser de la place

En pratique l'arbre lexicographique prend plus de temps a parcourir, surement car on doit parcourir la liste des noeuds frere pour trouver un mot.


# Exercice 6

## Question 3

- Le nombre de comparaison diminue de facon significative, En effet on compare uniquement lettre par lettre dans le mot recherche. Ainsi on verifie recursivement  si le fils[lettre] est null et si c'est le cas le mot n'appartient pas au dictionnaire 

- Neanmoins l'espace memoire  utilisé est beaucoup plus important car chaque mot possede au moins une structure (compose de 26 pointeurs) qui correspond a la lettre finale. Et ce en plus des lettres qui le compose 



# Rapidité de recherche 

En cherchant le mot 'chat' dans chaque dictionnaire avec un nombre d'iteration different nous allons comparer l'efficacité de chaque dictionnaire .
On compare leur efficacité en executant le cmd : 
```bash
time <executable> <nb_iteration> <mot_cherché>
```

<nb_iteration> : <time>

1. main_abr (mot stocké dans l'arbre)

- 1 : 0,07s 
- 10 : 0,07s 
- 100 : 0,08s 
- 1000 : 0,08s 
- 10000 : 0,08s 
- 100000 : 0,09s 
- 1000000 : 0,23s  
- 10000000 : 1.63s

Dans cette methode la recherche est assez rapide mais le dictionnaire necessite beaucoup d'espace comme chaque mot est stocké dans un element de la liste.

2. main_arbre (dictionnaire lexicographique)

- 1 : 0,08s 
- 10 : 0,09s 
- 100 : 0,08s 
- 1000 : 0,08s 
- 10000 : 0,08s 
- 100000 : 0,10s 
- 1000000 : 0,18s  
- 10000000 : 1.07s 

Dans cette methode la recherche est un peu plus rapide que dans la premiere methode (gain de 0.5s pour 10^7 recherches) et necessite moins de stockage et de comparaison comme seule les lettres sont necessaires

3. main_arbre_tab (dictionnaire lexicographique tableau)

- 1 : 0,09s 
- 10 : 0,10s 
- 100 : 0,10s 
- 1000 : 0,09s 
- 10000 : 0,09s 
- 100000 : 0,09s 
- 1000000 : 0,10s  
- 10000000 : 0,17s 

- 100000000 : 0,87s 

Dans cette derniere methode la recherche est bien plus rapide, (gain de 1s pour 10^7 recherches).


chaque constructions a des avantages differents. Et dependent de ce que l'on recherche : gain d'espace ou efficacité.
