#   Gestion d'un hotel
fini en 41min

#   Q.1

1.  Les variables de decisions correspondent au nombres de chambre de chaque type 
-   x1 : chambre simple
-   x2 : chambre double
-   x3 : chambre double avec vue
-   x4 : suite

2.  On cherche a maximiser le profit donc la fonction objectif correspond au tarif de chaque chambre fois le nombre de chambre de chaque type : 

```
    120 x1 + 170 x2 + 180 x3 + 240 x4
```

3.  Pour ce qui est des contraintes:
-   On a au moins 10 chambres de chaque : ``x1, x2, x3, x4 >=10``
-   On a au plus 20 chambres simple :  ``x1 <= 20``
-   La somme des des superficies de chaque chambres doit etre inferieur a la surface disponible pour l'amenagement des chambres : 
    ``` 15 x1 + 20 x2 + 22 x3 + 30 x4 <= 1500```
-   La main-d'oeuvre totale utilisé pour faire ces chambre doit etre inferieur a 2000h : `` 30 x1 + 40 x2 + 50 x3 + 60 x4 <= 2000``
-   Le nombre de personnes que l'on peut accueillir dans la salle du restaurant a chaque service limite la capacité de l'hotel a 100 personnes :    `` x1 + 2 x2 + 2 x3 + 3 x4 <= 100``

#   Q.2

-   Le profit obtenu est de ``z* = 7950e``
-   avec comme solution optimale ``x* = (10, 15, 10, 10) ``
```
    x1* = 10
    x2* = 15
    x3* = 10
    x4* = 10
```

#   Q.3

On soustrait le prix de cette main d'oeuvre a la valeur objectif et on ajoute ce temps de mains d'oeuvre a la contrainte 7.

```
    max z* = 120 x1 + 170 x2 + 180 x3 + 240 x4 - 4 x5
    c7 : 30 x1 + 40 x2 + 50 x3 + 60 x4 - x5 <= 2000
```

C'est intéressant d'utiliser cette main-d'oeuvre car on augmente le profit de 50e : 
-   ``z* = 8000``
-   `` x* = (10, 20, 10, 10, 200)``

On ajoute alors 200h de main-d'oeuvre

#   Q.4

-   On crée une nouvelle variable de decision qui represente la surface de la salle de conference : x5

-   On change la fonction objective afin de maximiser la surface de cette salle de séminaire

```
    max z' = x5 
```
-   On modifie la contrainte sur la surface : 
```
    c6 : 15 x1 + 20 x2 + 22 x3 + 30 x4 + x5 <= 1500
```

-   On ajoute une contrainte pour que le profit genere par la location de diminue pas :
```
    c9 : 120 x1 + 170 x2 + 180 x3 + 240 x4 >= 7950
```

C'est possible : 
-   ``z'* = 530m2`` C'est la surface maximal de la salle de conference
```
    x1'* = 10
    x2'* = 15
    x3'* = 10
    x4'* = 10
    x5'* = 530
```

#   Q.5

Il n'y a pas de solution qui respecte toutes ces contraintes.


#   Q.6

Si on augmente de 5% le prix de la suite : le plan d'aménagement n'est pas modifié mais le profit augmente de 120e.
-   Le profit obtenu est de ``z* = 8070e``
