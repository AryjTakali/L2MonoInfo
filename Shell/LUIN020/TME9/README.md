# Exercice 1

## Question 1

1. Pour que le script ignore SIGINT il faut ajouter un trap
2. On affiche "il ne doit en rester qu'un" 
3. On attend 1sec avant le prochain appel de highlander 

./highlander.sh
```bash
#!/bin/bash

trap '' SIGINT

echo "il ne doit en rester qu'un"
sleep 1
./$0
```

## Question 2

Pour l'arreter on peut faire un SIGKILL dans un autre terminal 
Il faut alors recuperer le pid du highlander actuel et lancer la commande 
Comme 1sec est trop court pour faire tout ca j'ai fait un script killhigh qui permet de tuer le dernier highlander afin que les appels recursifs s'arretent

1. la variable current recuppere le pid du dernier highlander
Si le nom du script est different il faut modifier le grep dans la commande
2. puis on envoie un signal SIGKILL au pid obtenu

./killHighlander.sh
```bash
#!/bin/bash

current=$(ps | grep 'highlander' | tail -n 1 | cut -d ' ' -f2)

echo $current
kill -s SIGKILL $current
```

## Question 3

```bash
sig -s SIGKILL $PID_HIGHLANDER
```

