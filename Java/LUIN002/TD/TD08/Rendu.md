# Exercice 56

## Question 1

@startuml

interface VehiculeAMoteur{
+ demarrer()
+ sarreter()
}

interface Roulant{
+ rouler()
}

interface Volant{
+ voler()
}

interface Flottant{
+ naviguer()
}

class Voiture{
+ demarrer()
+ sarreter()
+ rouler()
}
class Hydravion{
+ demarrer()
+ sarreter()
+ voler()
+ naviguer()
}

VehiculeAMoteur <|.. Roulant
VehiculeAMoteur <|.. Volant
VehiculeAMoteur <|.. Flottant

Roulant <|.. Voiture
Volant <|.. Hydravion
Flottant <|.. Hydravion
@enduml

## Question 2

```java
public class Voiture extends VehiculeAMoteur implements Roulant{
    public void demarrer(){}
    public void sarreter(){}
    public void rouler(){}
}
```

## Question 3
```java
public class Hydravion extends VehiculeAMoteur implements Roulant{
    public void demarrer(){}
    public void sarreter(){}
    public void voler(){}
    public void naviguer(){}
}
```
