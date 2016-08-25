****************************************************

Robby
Office: DUE 2181
Hours: T 2:00-3:30

TAs:  Joshua Donnoe
      DUE 1119 U 3:00-4:30
      
      Joydeep Mitra
      DUE 2206D T 2:00-3:30
      
email: help-301@santoslab.org

****************************************************

Class 2: Aug. 25, 2016

Lecture: Circuits and Truth Tables

Basic Truth Tables 
  Formulas as Trees
  {
    Tree structure captures the precedence and order of evaluation without the need of parantheses
    Should look similar to circuit objects
  }
  You can also place variables for the circuit products to create a code like syntax
  ~(p ^ q) -->  a = p ^ q
                out = ~a //Out may be marked by *

Tautology
  A formula that always results in true on every truth-assignment
Contradictory
  A formula that always results in false on every truth-assignment
Contingent
  A formula that may result in a combination of true and false for truth-assignments
Satisfiable (sat)
  If there exists a truth-assignment that makes the formula true
    Note that is a formula is not contradictory, it is satisfiable
    Any tautology or contingent formula is satisfiable
    
Format:
    * //Star is placed above the highest moderator
-------------
p | ~(p v ~p)
-------------
T | F   T F
F | F   T T
-------------
Contradictory (unsat)

