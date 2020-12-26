# -*- coding: utf-8 -*-
from transition import *
from state import *
import os
import copy
from sp import *
from parser import *
from itertools import product
from automateBase import AutomateBase



class Automate(AutomateBase):
        
    def succElem(self, state, lettre):
        """State x str -> list[State]
        rend la liste des états accessibles à partir d'un état
        state par l'étiquette lettre
        """
        successeurs = []
        # t: Transitions
        for t in self.getListTransitionsFrom(state):
            if t.etiquette == lettre and t.stateDest not in successeurs:
                successeurs.append(t.stateDest)
        return successeurs


    def succ(self, listStates, lettre):
        """list[State] x str -> list[State]
        rend la liste des états accessibles à partir de la liste d'états
        listStates par l'étiquette lettre
        """
        ret = []
        # s: state
        for s in listStates:
            ret += self.succElem(s, lettre)
        return ret




    """ Définition d'une fonction déterminant si un mot est accepté par un automate.
    Exemple :
            a=Automate.creationAutomate("monAutomate.txt")
            if Automate.accepte(a,"abc"):
                print "L'automate accepte le mot abc"
            else:
                print "L'automate n'accepte pas le mot abc"
    """
    @staticmethod
    def accepte(auto,mot) :
        """ Automate x str -> bool
        rend True si auto accepte mot, False sinon
        """
        s=auto.getListInitialStates()
        for i in mot:
            s = auto.succ(s, i)
        fin={x for x in s}
        for sfin in auto.getListFinalStates():
            if sfin in fin :
                return True
        return False


    @staticmethod
    def estComplet(auto,alphabet) :
        """ Automate x str -> bool
         rend True si auto est complet pour alphabet, False sinon
        """
        allS=auto.listStates
        for l in alphabet:
            for s in allS:
                if (auto.succElem(s, l) == []):
                    return False
        return True


        
    @staticmethod
    def estDeterministe(auto) :
        """ Automate  -> bool
        rend True si auto est déterministe, False sinon
        """
        alpha= auto.getAlphabetFromTransitions()
        for l in alpha:
            for s in auto.listStates:
                if len(auto.succElem(s, l)) > 1:
                    return False
        return True
        

       
    @staticmethod
    def completeAutomate(auto,alphabet) :
        """ Automate x str -> Automate
        rend l'automate complété d'auto, par rapport à alphabet
        """
        new = copy.deepcopy(auto)
        if not Automate.estComplet(auto,alphabet):
            allS=new.listStates
            # sp : State
            sp = State(len(allS) + 1, False, False)
            new.addState(sp)
            for l in alphabet:
                for s in allS:
                    if (auto.succElem(s, l) == []):
                        new.addTransition(Transition(s, l, sp))
        return new


    @staticmethod
    def determinisation(auto) :
        """ Automate  -> Automate
        rend l'automate déterminisé d'auto
         """
        if Automate.estDeterministe(auto):
            new = copy.deepcopy(auto)
        else:
            initS = set(auto.getListInitialStates())
            final = set(auto.getListFinalStates())
            alphabet=auto.getAlphabetFromTransitions()
            newAuto= Automate([], [set(auto.getListInitialStates())] + [auto.succ() for ])

        #     # ns : State
        #     ns = State(set(init), True, False)
        #     s = ns
        #     allState = ns
        #     new.addState(ns)
            
        #     while i in allState: 
        #         for l in alphabet:
        #             ns = auto.succ(s, l)
        #             if ns not in allState:
        #                 new.addState(ns)
        #                 allState += ns
        #                 new.addTransition(Transition(s, l, ns))
        # return new
        return

    @staticmethod
    def complementaire(auto,alphabet):
        """ Automate -> Automate
        rend  l'automate acceptant pour langage le complémentaire du langage de a
        """
        complet = Automate.estComplet(auto, alphabet) if copy.deepcopy(auto) else Automate.completeAutomate(auto, alphabet)
        return Automate(auto.listTransitions, [State(s.id, s.init, not s.fin) for s in auto.listStates ])
   
    @staticmethod
    def intersection (auto0, auto1):
        """ Automate x Automate -> Automate
        rend l'automate acceptant pour langage l'intersection des langages des deux automates
        """
        return

    @staticmethod
    def union (auto0, auto1):
        """ Automate x Automate -> Automate
        rend l'automate acceptant pour langage l'union des langages des deux automates
        """
        return
        

   
       

    @staticmethod
    def concatenation (auto1, auto2):
        """ Automate x Automate -> Automate
        rend l'automate acceptant pour langage la concaténation des langages des deux automates
        """
        return
        
       
    @staticmethod
    def etoile (auto):
        """ Automate  -> Automate
        rend l'automate acceptant pour langage l'étoile du langage de a
        """
        return




