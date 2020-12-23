Exercice fait en : 51.4min
version Markdown

# Exercice 2

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