Feature: Actions/Posting and read messages

    Scenario: "Alice and Bob post messages, those are created stored in the post collection" 
         When "Bob" posts "Hi, I'm Bob" on "2020-01-01T10:00:00.00Z"
          And "Alice" posts "Hello, my name is Alice" on "2020-01-01T10:00:10Z"
          And "Alice" posts "It's a lovely day today" on "2020-01-01T10:00:20Z"
         Then Stored posts in the post collection are
              | user  | message                  | timestamp            |
              | Bob   | Hi, I'm Bob              | 2020-01-01T10:00:00Z |
              | Alice | Hello, my name is Alice  | 2020-01-01T10:00:10Z |							
              | Alice | It's a lovely day today  | 2020-01-01T10:00:20Z |
							
    Scenario: "Read Alice posts, the stored posts are returned" 
        Given "Alice" posts in the posts collection are
              | user  | message                  | timestamp            |
              | Alice | It's a lovely day today  | 2020-01-01T10:00:20Z |
              | Alice | Hello, my name is Alice  | 2020-01-01T10:00:10Z |							
         When Read "Alice" posts
         Then Returned posts are
              | user  | message                  | timestamp            |
              | Alice | It's a lovely day today  | 2020-01-01T10:00:20Z |							
              | Alice | Hello, my name is Alice  | 2020-01-01T10:00:10Z |							