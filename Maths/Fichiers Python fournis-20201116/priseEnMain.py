from automate import Automate
from state import State
from transition import Transition
from parser import *


def creationTransitionState():
    #s = State(id(int), init(bool), fin(bool), nomID (str))
    #t = Transition(etatStart, transition(str) ,etatNext)
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

    # auto : Automate
    auto = Automate([t, t1, t2, t3, t4, t5, t6], [s0, s1, s2])
    # auto1 : Automate
    auto1 = Automate([t1, t2, t3, t4, t5, t6])
    print(auto)
    auto.removeTransition(t)
    print(auto1)
    auto.show("A_ListeTrans")
    auto1.show("A_ListeTrans_State")
    return

def creationFile():
    # auto2 : Automate
    auto2=Automate.creationAutomate("auto.txt")
    print(auto2)
    auto2.show("A_FromFile")
    return



def removeTransitionState():
    #s = State(id(int), init(bool), fin(bool), nomID (str))
    #t = Transition(etatStart, transition(str) ,etatNext)
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

    # auto : Automate
    auto = Automate([t, t1, t2, t3, t4, t5, t6], [s0, s1, s2])
    # print(auto)
    # auto.show("Auto_beforeRemoveT")
    auto.removeTransition(t)
    auto.removeTransition(t1)
    # print(auto)
    # auto.show("Auto_AfterRemoveT")
    auto.addTransition(t1)
    # print(auto)
    # auto.show("Auto_AfterAddT")
    auto.removeState(s1)
    # print(auto)
    # auto.show("Auto_AfterRemoveS")
    auto.addState(s1)
    # print(auto)
    # auto.show("Auto_AfterAddS")
    s2 = State(0, True, False)
    auto.addState(s2)
    # auto.show("Auto_AfterAddS2")

    auto1 = Automate([t1, t2, t3, t4, t5, t6])
    print(auto1.getListTransitionsFrom(s1))

    

    return