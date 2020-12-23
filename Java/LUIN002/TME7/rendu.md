

# Exercice 47

- ligne 6: pas de probleme un Chien est un mammifere (heredite)
- ligne 7: pas de probleme car la variable m1 a une instance Chien
- ligne 9: normal

/!\ ligne 8 : probleme de compilation un mammifere n'est pas un chien le cast implicite impossible
/!\ ligne 10 : probleme d'execution (le compilateur nous fait confiance ) mais on ne peut pas cast un mammifere en chien 



# Exercice 48

1. herite des methodes toString et du besoin de definir surface.

2. Il n'y a pas de methode surface, qui est demandé par sa class mere abstract Shape. Le contrat n'est pas respecté


- On ne peut jamais instancier une class abstract donc les constructeurs dans Shape n'ont pas de sens.
- Il n'est pas possible d'avoir un constructeur dans une class abstract ou de fonction comme to String.



# Exercice 52
## 1.
1. Utilisation attribut final 
-   valeur qui ne sera pas modifié ex. identifiant

2. Methode final
-   interdiction de redefinir dans les classes fille

3. Class final
-   interdire l'heritage

4. En general : 
-   interdit des modifications/modifs/changement
- Utile pour les element centraux qui risque d'avoir des erreurs en creants des elements contradictoire avec le but de depart 
- ex: les type de base : int, double etc.. ou String

## 2 .

1. Il serait interessant de mettre x et y en final. Alors lorsque l'on bougera un Point sera toujours fixe.

Ou alors id afin d'avoir un id unique par instance 

2. Si on met x et y en final il sera necessaire de modifier la methode move qui modifie les valeurs des attribut. Il sera alors necessaire de creer une nouvelle instance Point.

3. La fonction toString ne peut pas etre final car ce n'est pas une methode de Point c'est une methode de Object qu'on redefinit.

4. Plus rien ne peut etre redefinit -> un Point est un Point et pas un PointNommee ou autre qui herite de Point. 

5. On peut definir un PointNomme qui contient un point.
- C'est de la delegation.


# Exercie 51

Cet execice est en cours de production. J'ai bien le diagramme de classe en tete mais il me manque encore quelque chose pour le finir.