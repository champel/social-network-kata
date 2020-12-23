Feature: Console/Posts and reads messages

    Scenario: Alice posts two messages using arrow syntax. Alice messages are retrieved by name. 
        Given in:  > "Alice -> Hello, my name is Alice\n"
          And in:  > "Alice -> It's a lovely day today\n" 
         When in:  > "Alice\n"
         Then out: "Alice - It's a lovely day today\n"
          And out: "Alice - Hello, my name is Alice\n"
          And in:  > "exit\n"
          And out: "bye\n"  
