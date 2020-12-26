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


auto = Automate([t, t1, t2, t3, t4, t5, t6], [s0, s1, s2])

#   succ
liste = auto.succ([s0], "a")
print(liste)

def testAccepte():
    mot = "bba"
    if Automate.accepte(auto,mot):
        print("L'automate accepte le mot ab")
    else:
        print("L'automate n'accepte pas le mot ab")

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


# init = auto.getListInitialStates()
# final = set(auto.getListFinalStates())
# alphabet=auto.getAlphabetFromTransitions()

# ns = State(set(init), True, False)
# s = ns
# allState = ns
# new = Automate([],[ns])
# for l in alphabet:
#     ns = auto.succ(s, l)
#     if ns not in set(allState):
#         new.addState(ns)
#         # allState += ns
#         # new.addTransition(Transition(s, l, ns))
# # print(new)


#Pour voir le complementaire d'un automate 
#print(Automate.complementaire(auto,"ab"))
