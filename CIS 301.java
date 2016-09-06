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

****************************************************

Class 4: Sept. 1, 2016

Lecture: Propositional Logic

Logic to Establish Valid Reassoning
Logics such as Propositional Logic addresses truth preserving arguments
      Premise(1) + Premise(2) >> Truth-Preserving Inference Step >> Claim(1) + Claim(2) >> Truth-Preserving Inference Step >> Conclusion
      {
            A (valid) argument consists of sentences (claims) chained wither in such a way that the truth of each sentence...
                  Is assumed(i.e., the sentence is a premise) or...
                  Follows from the trut
      }
Keywords (Therefore, ... hence..., Thus, so, consequently, which establishes that, allows us to infer that, it follows that, demonstrates)

Patterns of Inference
      Invalid
      {
            If p then q
            but not p
            so, not q
      }
Validity: We call an inference valid if there is 'transmission of truth': in every situation where all premises P(i) are true,the conclusion Q is also true
      
You can check if a particular sequent is valid using truth tables
      It is only valid when the conclusion is true
      
Aristotelian Logic -- Syllogisms
      {
            All A are B
            All B are C
            Thus all A are C
      }
There are infinitely many possible syllogisms
There are  number of distinct types of syllogisms but only  number of syllogisms are valid

****************************************************

Class 5: Sept. 6, 2016

Homework 1 due Sept. 7 by 11:59 PM CST
      Submit to 301f16-yourName

Lecture: English to Prop Logic

Step 1: Read the passage in English and determine all significant units within the passage.
Step 2: Set a scheme of abbreviation by assigning propositional letters of PL, such as p, q, r,... to sentences of the passage you are translating
Step 3: Using the translation guides, translate the sentence to English

Negation          ~
      Often involves Negative words such as not and morphemes like un-, ir-, etc.
            ex:   (1)
                        a. Clint went to the Chatterbox Cafe
                        b. Clint did NOT go to the Chatterbox Cafe
                        
                        c. IT IS NOT THE CASE that CO2-emissions are being cut
Conjunction       ^
      Both (usually together with and) can also be an indicator of conjunction
      Words like but, moreover, however also join the individual claims
      Sometimes the use of and implies a temporal order of causality, such aspects cannot be captured directly in propositional logic
      Sometimes we do not want to split things joined by and into separate propositions
      Often involves the word and, but, nonetheless, however, nevertheless, moreover, although, whereas...
            ex:
                        a. Xiaojing went to Dillons and Fred went to Best Buy
                        b. ... people that are older than 25, and live in Manhattan
                        c. Both Xiaojing and Fred have credit cards
                        e. KU beat K-State in basketball, but K-State won in football
                        f. I hiked 10 miles with a 60 pound backpack. Moreover, it was raining as I hiked
                        g. Venice is a beautiful city. However, the smell of the canals is a bit distracting.
                        h. Axel Rose's voice went out, and the crowd threw food on the stage
                        i. John discovered the cure for cancer and became famous
                        j. Jane and Bill danced the night away
                        k. June, July, and August make up the summer recess
                        l. Pastor Ingvist is a Lutheran but Father Wilmers is not
Disjunction       v
      Usually involves the word or
            ex:
                        a. You will either pass 301 or fail 301                           exclusive
                        b. 301 is open either in Spring semester or Fall semester         inclusive
                        c. The system chall maintain the room temperature within the target range unless a sensor fails.
Implication       ->
      If... then..., provided... that..., assuming, only if, given...
            ex:
                        a. Wally eats Powdermilk biscuits only if Evelyn makes them
                        b. You can login CIS lab computer if you have a CIS account
                        
Biimplication     <->
      If and only if, just in case...
            ex:  
                        a. You get A if and only if your grade is above 90
                        
                        Florian neither washed the car nore went to the mercantile
                        It's not true that Clint owns both Ford and a Chevy dealership
                        Myrtle doesn't cook
                        I met my ex girlfriend today and either she grew taller or I got shorter
                        You get an A only if you score at least 50% on the midterm or you submit HW
                        State the negation of:
                              "I am a doctor or a lawyer"
                              "I am not a doctor and I am not a lawyer"
                        State the negation of:
                              "She is rich and beautiful"
                              "She is either not rich or not beautiful"
The Principle of Maximum Logical Revelation: 
      Always translate so as to reveal as much logical structure as the language into which you are translating allows for...

Exercise:
      a. The sun is hot but it it not humid
            P: The sun is hot
            Q: It is humid
                  P ^ ~Q
      b. If John doesn't pass then he will lose his scholarship and drop out of school.
            P: John passes his classes
            Q: loses Scholarship
            R: drops out of school
                  ~P -> (Q ^ R)
      c. If it rains and you don't open your umbrella then you will get wet.
            P: It rains
            Q: Open you umbrella
            R: Get wet
                  (P ^ ~Q) -> R
      d. If your car doesn't start or you didn't wake up on time then you will miss your interview and you will not get the new job
            P: Car starts
            Q: Wake up on time
            R: Miss interview
            S: Get the new job
                  (~P v ~Q) -> (R ^ ~S)
      e. If you elect Mary then Mary will make sure that the federal budget will be balanced, partisan wrangling in Washington will cease, and there will be no cuts in social security benefits
            P: You elect Mary
            Q: Federal budget will be balanced
            R: Partisan wrangling in Washington will cease
            S: Social Security benefits will be cut
                  P -> (Q ^ R ^ ~S)
      f. If the cake gets hot then icing melts and if the icing melts then cake cannot be used at the wedding reception
            P: Cake gets hot
            Q: Icing melts
            R: Cake can be used at the wedding reception
                  (P -> Q) ^ (Q -> ~R)
      g. If the New York Yankees win the World Series and the New York Jets win the Super Bowl then New York fans will be overjoyed and dance in the streets
            P: New York Yankees win the World Series
            Q: New York Jets win the Super Bowl
            R: New York fans will be overjoyed
            S: New York fans will dance in the streets
                  (P ^ Q) -> (R ^ S)
                  
      //Note: Do not use different language from the English sentence. Use same words.
