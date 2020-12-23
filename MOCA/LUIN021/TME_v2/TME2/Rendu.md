# Exercice 1

##  Q.1

La solution optimale est :
```txt
    z* = 10.5
    x* = (2.5, 1.5, 0, 0, 0 , 0.5)
```

-   Les contraintes serrés sont : ``` c1 et c2 ```
-   Les variables en bases sont : ``` x1, x2 et e3```
avec  e3 la variable d'écart de c3
-   Les variables en hors-bases sont : ``` x3, e1 et e2```
avec  e1 et e2 la variable d'écart de c1 et c2

##  Q.2

La solution optimale du duale associée est : 
```txt
    z* = 10.5
    y* = (2, 0.5, 0, 0, 0 , 1.5)
    Avec y1* = 2    et      y2* = 0.5
```

##  Q.3

La base optimale est identique. Mais la valeur de la fonction objectif à augmenté.
-   B1 = {x1, x2, e3} avec ``` z* = 10.5```
-   B2 = {x1, x2, e3} avec ``` z* = 11```

Où x1 = 3 et x2 = 1. 
- ```x* = (3, 1, 0, 0, 0, 0)```

Toutes les contraintes sont serrés.

On pouvait deduire cela du cout reduit de c2 qui = 0.5. Donc augmenter de 1 le terme de droite de la contrainte 2 augmente de 0.5 la solution optimale. 

Comme la solution optimale du primal et du dual sont identique on pouvait le deduire des valeurs optimales du duale mais pas son augmentation.

##  Q.4

La base optimale à changé. On est passé de B1 à B2.
-   B2 = {x1, x2, e3} avec ``` z* = 11```
-   B2 = {x1, x2, e2} avec ``` z* = 12```

Où ```x1* = 2``` et ```x2* = 3 ``` et ```e2 = 2```. 
- ```x* = (2, 3, 0, 0, 2, 0)```

Les contraintes  c1 et c3 sont serrés.

On pouvait deduire cela du cout reduit de c1 qui = 1. Donc augmenter de 1 le terme de droite de la contrainte 1 augmente de 1 la solution optimale.

Comme la solution optimale du primal et du dual sont identique on pouvait le deduire des valeurs optimales du duale mais pas son augmentation.

##  Q.5

Minimize
    4 y1 + 5 y2 + 7 y3
Subject To
    c1  : y1 + 2 y2 + 2 y3 >= 3
    c2  : y1 +  y3 >= 2
    c3  : 2 y1 + 3 y2 + 3 y3 >= 4

##  Q.6

Non car la solution optimale du Primal et du Dual sont identiques.

# Exercice 2

Exercice fait en : 51.4min

##  Q.1

1.  On cherche à maximiser le profit de TV++ donc la fonction objecif est : 
```txt
    max z = 900 x1 + 1000 x2 + 800 x3
```
Soit le temps de publicité par client multiplié par le prix proposé par seconde. Donc les variables de décisions sont:
-   x1 : temps (/seconde) du client 1
-   x2 : temps (/seconde) du client 2
-   x3 : temps (/seconde) du client 3


2.  Ensuite les contraintes sont L

-   Le temps de publicité total = 400s. Soit la somme des temps de publicité de chaque client.
```
    c1 : x1 + x2 + x3 = 400
```
-   TV++ veut offrir au moins 30s à chaque client donc pour iE{1, 2, 3}: 
```
    c : xi >= 30
```
-   La législation impose de ne pas avoir plus de 3min de publicité sur les aliments gras. Soit ```3 * 60 = 180s```. Seuls les clients 1 et 2  sont des publicités pour les aliments gras donc :
```
    c5 : x1 + x2 <= 180
```
-   Enfin on doit avoir un minimum de 120s de musique. Comme 75% de la pub du client 1 et 30%  de la pub du client 3 contiennent de la musique leur somme doit etre superieur a 120s.
```
    c6 : 0.75 x1 + 0.3 x3 >= 120
```

##  Q.2

A l'aide de GLPK on obtient comme solution optimale: 

```txt
    z* = 348 800
    x1* = 72s
    x2* = 108s
    x3* = 220s
```

Donc le gain obtenu est bien de : 348 800 euros.

##  Q.3

1.  Il est interessant d'utiliser du temps supplementaire.

Pour verifier ca on modifie la fonction objectif : 
```
    z' = 900 x1 + 1000 x2 + 800 x3 - 820 x4
```
x4 correspond au temps supplementaire, soit une perte de 820e/s. Et on change la contrainte de temps de publicité: 
```
    c1 : x1 + x2 + x3 - x4 = 400
```
Ou x4 permet d'augmenter le temps de publicité accordé.

On pouvait le déduire facilement car si c'est le client 1 ou 2 qui prend la seconde le benefice sera d'au moins 100e.

2.  Pour avoir un gain maximal on doit ajouter 105s supplémentaire. On obtient alors :
-   ```z'* = 350 900e```
-   ```x1'* = 30s```
-   ```x2'* = 150s```
-   ```x3'* = 325s```
-   ```x4'* = 105s```


##  Q.4

On ajoute 2 conditions : 
```
    c7 : x1 - x2 >= 10
    c8 : x4 = 1
```
Et on change ajoute 1fois 5000e dans la fonction objectif : 
```
    z' = 900 x1 + 1000 x2 + 800 x3 + 5000 x4
```

On obtient alors : 
-   ```z'* = 351 500e``` > ```z'* = 348 800e```  
-   ```x1'* = 95s```
-   ```x2'* = 85s```
-   ```x3'* = 220s``` 
-   ```x4'* = 1 ```   

Oui c'est rentable avec un bénéfice de 2 700 euros.

##  Q.5

Le cout marginal de l'obligation de la règle des 120 secondes de musique minimum est de -133.33.
Ca veut dire que si on augmente le membre de droite de cette contrainte le gain maximum va diminuer d'au moins 133.33e par unité. 
Il est alors plus rentable de diminuer cette contrainte afin d'augmenter le profit.

##  Q.6

1.  Si ``x2 = 0`` : 

Si on limite la coupure au client 1 et 3 ce n'est pas rentable. On obtiendra alors 
-   ```z* = 338 000e``` < ```z* = 348 000e``` 

On a une perte de 10kE.

2.  ``Si x1 = 0`` ou ``x3 = 0`` : 

Neanmoins si on limite la coupure au client 1 et 2 ou 2 et 3 il n'y a pas de solution optimale. C'est impossible de satisfaire toutes les contraintes.

# Exercice 3


##  Q.1

Pour maximiser son profit on doit avoir chaque semaine: 
-   x1* = 80 L de produit standard
-   x2* = 160 L de produit de luxe

On obtiendra alors un profit de : ```z* = 30 400 euros```


##  Q.2

Je ne comprends pas la question.

##  Q.3

1.  
-   On fixe la vente de produit de standard et de luxe x1 et x2 à 100 et 180. Soit l'écoulement habituel sans promotion.
       -   avec leur coefficient respectif qui represente le prix de vente au litre.

Pour obtenir le bénéfice de la promotion: 
-   On ajoute les litres vendu grace à la promotion et on y soustrait le prix d'investissement. x3 et x4 sont alors les investissements respectifs pour le produit standard et de luxe.
-  ```(augmentation de vente) * (prix de vente) x3 - 10e x3 ```=>```((augmentation de vente) * (prix de vente) - 10) x3  ```
    -   Bénéfice de la promotion du produit standard : 15 * 80 - 10 = 1190
    -   Bénéfice de la promotion du produit de luxe : 10 * 150 - 10 = 1490

Ce qui nous donne une nouvelle fonction objectif :
```
    max z = 80 x1 + 150 x2 +  1190 x3  + 1490 x4
```

Il faut aussi ajouter la contrainte d'investissement pour la publicité :
-   ``` c3 : 10 x3 + 10 x4 = 1000``` = ``` c3 : x3 + x4 = 100```

-   ```z* = 184 000euros``` de gains
-   ```x1* = 100L``` produit standard
-   ```x2* = 180L``` produit de luxe
-   ```x3* = 0e``` de promotion dans le produit standard
-   ```x4* = 100e``` de promotion dans le produit de luxe


##  Q.4

1.  La variable duale associée à la contrainte de temps de travail a le coefficient le moins important dans la fonction objectif à minimiser du duale. 160 < 320 < 400

2. Avec cette modification on a : 
-   ``z'* = 30 440e`` > ``z* = 30 400e``
-   ``x1'* = 88L`` produit standard 
-   ``x2'* = 156L`` produit de luxe

Soit une augmentation de la valeur optimale de 40e. On observe qu'il s'agit du cout réduit de c2.

3.  Avec ce nouveau PL : 
```
Maximize
    80 x1 + 150 x2 - 45 x3 - 15 x4
Subject To
    c1 : x1 + 2 x2 - x4 <= 400
    c2 : 0.5 x1 + 0.75 x2 - x3 <= 160
    c3 : 0.8 x1 + 1.5 x2 <= 320
```

On obtient :
-   ``z'* = 31 600e`` > ``z* = 30 400e``
-   ``x1'* = 0L`` produit standard 
-   ``x2'* = 213.333L`` produit de luxe
-   ``x3* = 0h`` heure de travail supplementaire 
-   ``x4* = 26.6667L`` matiere premiere 

##  Q.5

-   Pour une augmentation de 5% (157.5e/L) : on ne change rien.
    -   ```z'* = 31 600e```
-   Pour une augmentation de 10% (165e/L): on produira uniquement du produit de luxe.``` x'* = (0, 200)```
    -   ```z'* = 33 000e```
-   A partir d'une diminution supérieur à 20% (<120e/L): on produira uniquement du produit standard.
    -   ```z'* = 25 600e```