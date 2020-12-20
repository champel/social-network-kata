Feature: Actions/Following friends and wall

    Scenario: Charlie follows Alice and Bob, following relations are stored in the network collection  
         When "Charlie" follows "Alice"
          And "Charlie" follows "Bob"
         Then Following relations in network collection are stored in the network collection
              | user    | followed_user |
              | Charlie | Alice         |
              | Charlie | Bob           |
              
    Scenario: User follow friends and has a wall including their messages  
        Given "Charlie" follows "Alice,Bob" in the network collection
        And   "Alice,Bob,Charlie" posts in the posts collection are
              | user    | message                                     | timestamp            |
              | Alice   | It's a lovely day today                     | 2020-01-01T10:00:03Z |
              | Charlie | I'm in London today. Anyone up for a drink? | 2020-01-01T10:00:02Z |
              | Alice   | Hello, my name is Alice                     | 2020-01-01T10:00:01Z |
              | Bob     | Hi, I'm Bob                                 | 2020-01-01T10:00:00Z |
         When Read "Charlie" wall
         Then Returned posts are
              | user    | message                                     | timestamp            |
              | Alice   | It's a lovely day today                     | 2020-01-01T10:00:03Z |
              | Charlie | I'm in London today. Anyone up for a drink? | 2020-01-01T10:00:02Z |
              | Alice   | Hello, my name is Alice                     | 2020-01-01T10:00:01Z |
              | Bob     | Hi, I'm Bob                                 | 2020-01-01T10:00:00Z |