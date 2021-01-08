# -*- coding: utf-8 -*-
from transition import *
from state import *
import os
import copy
from sp import *
from parser import *
from itertools import product
from automateBase import AutomateBase
import itertools


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
                if (auto.succElem(s, l) == []): #Si un etat n'a pas d'etat successeur pour une lettre return False
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
                if len(auto.succElem(s, l)) > 1: #Si un etat a plus de 1 etat successeur return False
                    return False
        return True
        

       
    @staticmethod
    def completeAutomate(auto,alphabet) :
        """ Automate x str -> Automate
        rend l'automate complété d'auto, par rapport à alphabet
        """
        new = copy.deepcopy(auto) # cree copie de automate de depart
        if not Automate.estComplet(auto,alphabet):
            allS=new.listStates
            sp = State(len(allS) + 1, False, False) #cree un etat puie
            new.addState(sp)
            for l in alphabet: # pour chaque lettre de lalphabet
                for s in allS: # pour chaque etat de l'automate
                    if (auto.succElem(s, l) == []): #cree une transition avec etat puie si il n'y a pas d'etat successeur 
                        new.addTransition(Transition(s, l, sp))
        return new

    @staticmethod
    def isFinal(list, final):
        '''list[int] x list[State] -> Bool
        rend True si au moins un des etat de list est final, False sinon
        '''
        for s in list : 
            if s in final :
                return True
        return False

    @staticmethod
    def labelExist(label, listStates):
        ''' Set[int] x list[State] -> Bool
        rend True si il exite un  etat qui avec pour label le label rentré en parametre, False sinon
        '''
        for s in listStates:
            if str(label) == s.label :
                return True
        return False

    @staticmethod
    def getState(label, listStates):
        ''' Set[int] x list[State] -> State
        rend l'etat qui a pour label le label rentré en parametre
        '''
        for s in listStates:
            if str(label) == s.label :
                return s
        return None

    @staticmethod
    def stateLabeled(s): 
        ''' State -> State
        modifie tous les label de l'automate en retirant '(init)' et '(fin)' de leur str
        '''
        # return ''.join((''.join(list.split('(init)')).split('(fin)')))
        return State(s.id, s.init, s.fin, ''.join((''.join(s.label.split('(init)')).split('(fin)')))) 

    @staticmethod
    def labeled(auto): 
        ''' Automate -> Automate
        modifie tous les label de l'automate en retirant '(init)' et '(fin)' de leur str
        '''
        # return Automate(auto.listTransitions, [State(s.id, s.init, s.fin, ''.join((''.join(s.label.split('(init)')).split('(fin)')))) for s in auto.listStates])
        return Automate(auto.listTransitions, [Automate.stateLabeled(s) for s in auto.listStates])
        
    @staticmethod
    def determinisation(auto) :
        """ Automate  -> Automate
        rend l'automate déterminisé d'auto
         """
        if Automate.estDeterministe(auto):
            new = copy.deepcopy(auto)
        else: #si auto n'est pas deterministe
            wait = [auto.getListInitialStates()] #liste de liste d'etats qui n'ont pas encore eu leur transition (en commencant par etat initial)
            final = auto.getListFinalStates() #liste etats finaux
            alpha=auto.getAlphabetFromTransitions() #alphabet de l'automate
            new= Automate([]) #nouvel automate
            id = 0 #compeur d'etat (donne les id aux nouveaux etat)
            while len(wait) > 0 : #tant que tous les etats n'ont pas ete relie
                if wait[0] == auto.getListInitialStates():
                    new.addState(State(id, True, Automate.isFinal(wait[0], final), str(set(wait[0])))) #cas particulier pour l'etat initial
                    id += 1
                for lettre in alpha :
                    ns = auto.succ(wait[0], lettre) #etats en transition avec l'etat actuel
                    if [ns] not in wait and not Automate.labelExist(str(set(ns)), new.listStates): #s'il ne s'agit pas d'un etat deja en attente ou deja cree
                        wait += [ns] #ajout a la liste d'attente
                        new.addState(State(id, False, Automate.isFinal(ns, final), (str(set(ns))))) #ajout a l'automate
                        id +=1
                    new.addTransition(Transition(Automate.getState(set(wait[0]), new.listStates), lettre, Automate.getState(set(ns), new.listStates))) #ajout transition avec l'etat actuel
                wait.pop(0) #une fois que le premier etat de la liste est traite on le retire de la liste d'attente
            new = Automate.labeled(new) #change tous les label afin de ne pas avoir les mention (init), (fin)
        return new

    @staticmethod
    def complementaire(auto,alphabet):
        """ Automate -> Automate
        rend  l'automate acceptant pour langage le complémentaire du langage de a
        """
        complet = Automate.estComplet(auto, alphabet) if copy.deepcopy(auto) else Automate.completeAutomate(auto, alphabet) #complete l'automate
        return Automate(complet.listTransitions, [State(s.id, s.init, not s.fin) for s in complet.listStates])
        #cree un automate en passant inversant etat final et non final a partir de l'automate complet
   
    @staticmethod
    def intersection (auto0, auto1):
        """ Automate x Automate -> Automate
        rend l'automate acceptant pour langage l'intersection des langages des deux automates
        """
        init0 = auto0.getListInitialStates()
        init1 = auto1.getListInitialStates()
        wait = list(itertools.product(init0, init1))
        final = list(itertools.product(auto0.getListFinalStates(), auto1.getListFinalStates()))  
        alpha= auto0.getAlphabetFromTransitions() + auto1.getAlphabetFromTransitions()  
        new= Automate([])
        id = 0 

        while len(wait) > 0 : 
            if wait[0] in list(itertools.product(init0, init1)):#pour les etats initiaux
                new.addState(State(id, True, wait[0] in final, str(wait[0])))
                id += 1
            for lettre in alpha : #pour chaque lettre
                ns0 = auto0.succElem(wait[0][0], lettre) #etats successeur du 1er element du tuple = etat auto1
                ns1 = auto1.succElem(wait[0][1], lettre)
                for s in list(itertools.product(ns0, ns1)): #pour chaque etat contenu dans le produit cartesien des listes d'etat successeurs
                    if (ns0,ns1) not in wait and not Automate.labelExist(str(s), new.listStates): #si etat n'existe pas encore et n'est pas en attente
                        wait += [s]
                        new.addState(State(id, False, s in final, str(s))) 
                        id +=1
                    new.addTransition(Transition(Automate.getState(str(wait[0]), new.listStates), lettre, Automate.getState(str(s), new.listStates))) #ajout de transition
            wait.pop(0) 
        new = Automate.labeled(new) #on retire tous les "(init)" et "fin" des label
        return new

    # @staticmethod
    # def union2 (auto0, auto1): #ne fonctionne pas probleme au niveau des etats finaux
    #     """ Automate x Automate -> Automate
    #     rend l'automate acceptant pour langage l'union des langages des deux automates
    #     """
    #     #on utilise la meme logique que pour intersection, il suffit de completer les automates avant
    #     #et ajouter des etats finaux
    #     compAuto0= Automate.completeAutomate(auto0, auto0.getAlphabetFromTransitions())
    #     compAuto1= Automate.completeAutomate(auto1, auto1.getAlphabetFromTransitions())
    #     new = Automate.intersection(compAuto0, compAuto1)
    #     final0 = compAuto0.getListFinalStates()
    #     final1 = compAuto1.getListFinalStates()
    #   l'erreur est au niveau de la detection des etats finaux, comme dans intersection on modifie les label il devient plus complexe de parser les etats finaux
    #     final = [(Automate.stateLabeled(s[0]),Automate.stateLabeled(s[1])) for s in list(itertools.product(compAuto0.listStates, compAuto1.listStates)) if (s[0] in final0) or (s[1] in final1)] 
    #     print(final)
    #     # print(new.listStates)
    #     return Automate(new.listTransitions, [State(s.id, s.init,s in final, s.label) for s in new.listStates])

    @staticmethod
    def union (auto00, auto01):
        """ Automate x Automate -> Automate
        rend l'automate acceptant pour langage l'union des langages des deux automates
        """
        #on utilise la meme logique que pour intersection, il suffit de completer les automates avant
        #et ajouter des etats finaux (soit final pour auto1 ou auto2)
        auto0= Automate.completeAutomate(auto00, auto00.getAlphabetFromTransitions())#complete auto
        auto1= Automate.completeAutomate(auto01, auto01.getAlphabetFromTransitions())#complete auto
        init0 = auto0.getListInitialStates()
        init1 = auto1.getListInitialStates()
        wait = list(itertools.product(init0, init1))
        final0 = auto0.getListFinalStates()
        final1 = auto1.getListFinalStates()
        final = [s for s in list(itertools.product(auto0.listStates, auto1.listStates)) if (s[0] in final0) or (s[1] in final1)] #fait partie de l'etat final si l'etat est auto1 ou auto2 est acceptant 
        alpha= auto0.getAlphabetFromTransitions() + auto1.getAlphabetFromTransitions()  
        new= Automate([])
        id = 0 

        while len(wait) > 0 : 
            if wait[0] in list(itertools.product(init0, init1)):
                new.addState(State(id, True, wait[0] in final, str(wait[0])))
                id += 1
            for lettre in alpha :
                ns0 = auto0.succElem(wait[0][0], lettre)
                ns1 = auto1.succElem(wait[0][1], lettre)
                for s in list(itertools.product(ns0, ns1)):
                    if (ns0,ns1) not in wait and not Automate.labelExist(str(s), new.listStates): 
                        wait += [s]
                        new.addState(State(id, False, s in final, str(s))) 
                        id +=1
                    new.addTransition(Transition(Automate.getState(str(wait[0]), new.listStates), lettre, Automate.getState(str(s), new.listStates))) 
            wait.pop(0) 
        new = Automate.labeled(new) 
        return new


    @staticmethod
    def concatenation (auto1, auto2):
        """ Automate x Automate -> Automate
        rend l'automate acceptant pour langage la concaténation des langages des deux automates
        """
        a1=copy.deepcopy(auto1)
        a2=copy.deepcopy(auto2)
        f1=a1.getListFinalStates()
        init2=a2.getListInitialStates()
        id=len(a1.listStates)
        alpha=a1.getAlphabetFromTransitions()

        # si auto1 n'accepte pas le mot vide les etats initiaux de auto2 ne sont plus initiaux 
        if (not Automate.accepte(a1, "")):
            for s in init2:
                s.init = False
        # si auto2 n'accepte pas le mot vide les etats finaux de auto1 ne sont plus finaux
        if (not Automate.accepte(a2, "")):
            for s in f1:
                s.fin = False

        #On change les id de l'automate 2 afin de ne pas avoir les meme id que l'auto1
        # et on les ajoute avec les transitions a la suite du nouvel automate 1
        for s in a2.listStates:
            s.id=id
            s.label=id 
            a1.addState(s)
            id += 1 
        for t in a2.listTransitions: 
            a1.addTransition(t)
        
        
        for s in a1.listStates: #pour tous les etats dans le nouvel automate
            for l in alpha: #pour chaque lettre de l'alphabet de auto1
                if Automate.isFinal(a1.succElem(s,l), f1): #si l'un des etats successeur est un etat final de auto1
                    for s2 in init2: #on ajoute une transition de l'etat vers les etats initiaux de auto2
                        a1.addTransition(Transition(s, l, s2)) 
        return a1
       
        
       
    @staticmethod
    def etoile (auto):
        """ Automate  -> Automate
        rend l'automate acceptant pour langage l'étoile du langage de a
        """
        new=copy.deepcopy(auto)
        final=new.getListFinalStates()
        init=new.getListInitialStates()
        alpha=new.getAlphabetFromTransitions()
        
        for s in new.listStates: #pour tous les etats dans le nouvel automate
            for l in alpha: #pour chaque lettre de l'alphabet de auto
                if Automate.isFinal(new.succElem(s,l), final): #si l'un des etats successeur est un etat final de auto1
                    for s2 in init: #on ajoute une transition de l'etat vers les etats initiaux de auto
                        new.addTransition(Transition(s, l, s2)) 
        return new