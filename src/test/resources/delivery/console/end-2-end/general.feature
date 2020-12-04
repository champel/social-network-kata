Feature: General scenario

    Scenario: Scenarion with all functionalities
        Given in:  > "Bob -> Hi, I'm Bob\n"
          And in:  > "Alice -> Hello, my name is Alice\n" 
          And in:  > "Charlie -> I'm in London today. Anyone up for a drink?\n" 
          And in:  > "Alice -> It's a lovely day today\n" 
          And in:  > "Charlie follows Alice\n"
          And in:  > "Charlie follows Bob\n"
         When in:  > "Alice\n"
         Then out: "Alice - It's a lovely day today\n"
          And out: "Alice - Hello, my name is Alice\n" 
         When in:  > "Charlie wall\n"
         Then out: "Alice - It's a lovely day today\n"
          And out: "Charlie - I'm in London today. Anyone up for a drink?\n"
          And out: "Alice - Hello, my name is Alice\n"
          And out: "Bob - Hi, I'm Bob\n"
          And in:  > "exit\n"
          And out: "bye\n"  
