# -*- coding: utf-8 -*-
"""
Code modifiable.
"""

from automate import Automate
from state import State
from transition import Transition
from parser import *
from priseEnMain import *

#creationTransition()
#creationFile()
#removeTransitionState()

 # s0 : State
s0 = State(0, True, False)
# s1 : State
s1 = State(1, False, False)
# s2 : State
s2 = State(2, False, True)
# t1 : Transition
t1 = Transition(s0, "a", s0)
# t2 : Transition
t2 = Transition(s0, "b", s1)
# t3 : Transition
t3 = Transition(s1, "a", s2)
# t4 : Transition
t4 = Transition(s1, "b", s2)
# t5 : Transition
t5 = Transition(s2, "a", s0)
# t6 : Transition
t6 = Transition(s2, "b", s1)
#t : Transition
t = Transition(s0, "a", s1)

# autoAcc = Automate.creationAutomate("testFiles/testAcc.txt")
# autoCompl = Automate.creationAutomate("testFiles/testCompl.txt")
# autoDeter = Automate.creationAutomate("testFiles/testDeter.txt")
# autoEtoile = Automate.creationAutomate("testFiles/testEtoile.txt")
# autoInter1 = Automate.creationAutomate("testFiles/testInter1.txt")
# autoInter2 = Automate.creationAutomate("testFiles/testInter2.txt")
# autoMulti = Automate.creationAutomate("testFiles/testMulti.txt")

auto = Automate([t1, t2, t3, t4, t5, t6], [s0, s1, s2])
#   succ
#liste = auto.succ([s0], "a")

def testAccepte(auto,mot):
    if Automate.accepte(auto,mot):
        print("L'automate accepte le mot " + mot)
    else:
        print("L'automate n'accepte pas le mot " + mot)
testAccepte(auto,"bbb")

def  testEstComplet():
    alphabet="ab"
    if Automate.estComplet(auto,alphabet):
        print("L'automate est complet")
    else:
        print("L'automate n'est pas complet")

# pour completer l'automate enlever la lettre c de alphabet
#testEstComplet()

def  testEstDeterministe():
    if Automate.estDeterministe(auto):
        print("L'automate est deterministe")
    else:
        print("L'automate n'est pas deterministe")

#Automate.completeAutomate(auto,"abc").show("test")
# pour determiniser l'automate enlever la transition t
#testEstDeterministe()


#Pour voir le complementaire d'un automate 
#print(Automate.complementaire(auto,"ab"))

#Pour determiniser un automate 
# Automate.determinisation(auto).show("Deterministe")
# auto.addTransition(t)
# Automate.determinisation(auto).show("nonDeterministe")
# auto.removeTransition(t)# Automate.intersection(auto,auto).show("Deter")


#Pour avoir l'intersection de 2 automate 
# Automate.intersection(auto,auto).show("Deter")
# auto.addTransition(t)
# Automate.intersection(auto,auto).show("Deter")
# auto.removeTransition(t)

#Pour avoir l'union de 2 automate 
# Automate.union(auto,auto).show("Deter")
# print(Automate.union(auto,auto))

# s4 = State(4, False, False)
# s5 = State(4, False, True)


#Pour avoir la concatenation de 2 automate 
# Automate.concatenation(auto,auto).show("concatenation")
# print(Automate.concatenation(auto,auto))


# s0 = State(0, True, False)
# s1 = State(1, False, False)
# s2 = State(2, False, True)
# t1 = Transition(s0, "b", s0)
# t2 = Transition(s0, "a", s1)
# t3 = Transition(s1, "b", s1)
# t4 = Transition(s1, "a", s2)
# t5 = Transition(s2, "b", s2)

# #Pour avoir l'etoile auto1
# auto1 = Automate([t1, t2, t3, t4, t5], [s0, s1, s2])
# auto1.show("test")
# Automate.etoile(auto1).show("etoile")
