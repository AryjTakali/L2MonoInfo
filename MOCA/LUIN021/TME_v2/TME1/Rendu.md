
# Exercice 1

## Q.2

valeur optimal de la fonction objectif :  ```z = 10.5```

Contrainte serrés : ```c1 et c2```

Variable en base : ```x1, x2 et e3```
```
x1 = 2.5
x2 = 1.5
x3 = 0
e3 = 0.5
```
Variable hors-base : ```x3, e1, e2```

avec e1 variable d'écart de c1

et e2 variable d'écart de c2

## Q.3

```txt
e1 et e2 sont des variables hors base et les coefficients 2 et 0.5 sont leurs coûts réduits
Si on augmente la valeur de droite de c1 ou c2 de 1 unité, le profit augmente respectivement 2 et 0.5
```


1. Si on augmente le terme de droite de la contrainte 2 la valeur optimal de la fonction objectif passe de 10.5 à 11
-> ca augmente z du profit marginal de c2 (0.5)

-   `` x* = (3,1,0,0,0,0) ``
-   `` z* = 11 ``

```
x1 = 2
x2 = 3
x3 = 0
e3 = 0
```

2. Si on augmente le terme de droite de la contrainte 1 la valeur optimal de la fonction objectif passe de 10.5 a 12
-> ca augmente z d'une valeur inférieur au profit marginal de c1 (1.5 < 2) car on a changé de base.

On est passé de B1 = {x1,x2,e3} à B2 {x1, x2, e2}
e2 entre en base et e3 sort de base
les contraintes c1 et c2 sont serrés et c3 n'est pas serré.

 -  ``x* = (2,3,0,0,1,0)``
-   ``z* = 12 ``

```
x1 = 2
x2 = 3
x3 = 0
e2 = 1
```

# Exercice 2

## Q.1

### a)

1. On cherche à maximiser le profit donc pour la fonction objectif on associe le bénéfice de chaque produits laitiers à sa variable de décision. Le bénéfice est calculé avec la formule : 
-   ```bénéfice = gain - frais d'exploitation```

```txt
x1 : kl de Fromage
x2 : kl de Yaourt
x3 : kl de Lait cru
```
On obtient alors :

```  
    max z = 25 x1 +  20 x2 + 30 x3
 ```


2. Pour ce qui est des contraintes : 
-   Limite des frais d'exploitation de 2600e. Soit l'investissement de départ.
-   La limite des 60 kL de lait de départ.
Ce qui donne :

``` 
	c1 : 65 x1 + 70 x2 + 40 x3 <= 2600
    c2 : x1 + x2 + x3 <= 60
```

### b)
La solution optimale obtenue grâce à glpk est : 
-   ```z* = 1800```

avec :
```
  x1 = 0
  x2 = 0
  x3 = 60
```

## Q.2

Pour vérifier ça on ajoute une 2e contrainte afin d'avoir au moins 10kl de produits laitiers (fromage + yaourt).
```
    c2 : x1 + x2 >= 10
```
On observe que solution optimale diminue : 
-   ```z* = 1712.5```
-   ```x* = (10, 0, 48.75)```

Donc il n'est pas rentable d'utiliser 10 kl de produit laitier.

## Q.3

Pour vérifier à partir de combien de bénéfice l'exploitant à intérêt à produire des fromages on augmente son coefficient dans la fonction objectif et on observe à partir de combien x1 entre en base.

A partir d'un bénéfice de 31 €/kL soit un gain de 96€/kL il est rentable de produire des fromages.
Il obtiendra alors :
-   ```z* =  1808,5€```
-   ```x* = (8, 0, 52) ```

## Q.4

En enlevant la contrainte c1 (argent investi) on remarque la solution optimale est identique.
Donc il est inutile d'emprunter de l'argent surtout s'il y a un taux d'interet non nul.

## Q.5

Ce prix est envisageable à partir de 30€/kL car il s'agit du meilleur bénéfice obtenu par l'exploitant par kL.
Il ne serait pas rentable laisser ce voisin exploiter lui même une partie de l'exploitation si il lui propose moins.

## Q.6

1.  S'il veut investir 1600€ il lui reste 1000€ pour les frais d'exploitation.

Avec 1000€ dans l'exploitation :
-   ``` z* = 750€```
-   ``` x* = (0, 0, 25)```

Il lui reste donc ```60 - 25 = 35kL ``` de lait pour que quelqu'un d'autre produise à sa place.
-   ```35 * 20 = 700€```

-   Soit au total un bénéfice de ```700 + 750 = 1450€```

2.  Pour atteindre le même bénéfice que pour l'exploitation du lait il doit obtenir :
-   ```1800 - 1450 = 350€```

S'il veut investir 1600€ dans un nouveau projet il doit au moins obtenir 350€ de bénéfice pour avoir autant que son premier projet.
Soit un gain de 1950€

# Exercice 4