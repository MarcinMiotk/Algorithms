Feature: Tree details

  Scenario: 2 vertices connected with 1 edge
    Given 2 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
    Then Parent node has 1 neighbours.

  Scenario: 3 vertices connected with 2 edges
    Given 3 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 1     | 3   |
    Then Parent node has 2 neighbours.

  Scenario: 4 vertices connected with 3 edges
    Given 4 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 1     | 3   |
      | 1     | 4   |
    Then Parent node has 3 neighbours.

  Scenario: 4 vertices connected with 3 edges but parent has 1 child
    Given 4 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 2     | 3   |
      | 2     | 4   |
    Then Parent node has 1 neighbours.

  Scenario: 4 vertices connected with 3 edges are POST-ORDER traversed
                  1
              2       3
          4
    Given 4 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 1     | 3   |
      | 2     | 4   |
    Then Post-Order traversal is
      | 4 |
      | 2 |
      | 3 |
      | 1 |

  Scenario: 12 vertices connected and are POST-ORDER traversed
    Given 12 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 1     | 3   |
      | 1     | 4   |
      | 2     | 5   |
      | 3     | 6   |
      | 6     | 7   |
      | 6     | 8   |
      | 4     | 9   |
      | 4     | 10  |
      | 10    | 11  |
      | 11    | 12  |
    Then Post-Order traversal is
      | 5 |
      | 2 |
      | 7 |
      | 8 |
      | 6 |
      | 3 |
      | 9 |
      | 12 |
      | 11 |
      | 10 |
      | 4 |
      | 1 |


  Scenario: 4 vertices connected with 3 edges are POST-ORDER traversed. Calculate Weight for each node.
                        1
                    2       3
                4
    Given 4 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 1     | 3   |
      | 2     | 4   |
    Then Weights are
      | Node  | Weight  |
      | 4     |   1     |
      | 2     |   2     |
      | 3     |   1     |
      | 1     |   4     |



  Scenario: 12 vertices connected and are POST-ORDER traversed. Calculate Weight for each node.
    Given 12 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 1     | 3   |
      | 1     | 4   |
      | 2     | 5   |
      | 3     | 6   |
      | 6     | 7   |
      | 6     | 8   |
      | 4     | 9   |
      | 4     | 10  |
      | 10    | 11  |
      | 11    | 12  |
    Then Weights are
      | Node  | Weight  |
      | 5     | 1       |
      | 2     | 2       |
      | 7     | 1       |
      | 8     | 1       |
      | 6     | 3       |
      | 3     | 4       |
      | 9     | 1       |
      | 12    | 1       |
      | 11    | 2       |
      | 10    | 3       |
      | 4     | 5       |
      | 1     | 12      |


  Scenario: 6 vertices connected and are POST-ORDER traversed. Calculate Weight for each node.
                  1
              3       2
            4       5   6
    Given 6 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 1     | 3   |
      | 3     | 4   |
      | 2     | 5   |
      | 2     | 6   |
    Then Weights are
      | Node  | Weight  |
      | 4     | 1       |
      | 3     | 2       |
      | 5     | 1       |
      | 6     | 1       |
      | 2     | 3       |
      | 1     | 6       |



  Scenario: 9 vertices connected and are POST-ORDER traversed. Calculate Weight for each node.
                                  1
                        3       6         2
                      4       8         7   5
                            9   10
    Given 6 vertices
    When Edges are
      | From  | To  |
      | 1     | 3   |
      | 1     | 6   |
      | 1     | 2   |
      | 3     | 4   |
      | 6     | 8   |
      | 8     | 9   |
      | 8     | 10  |
      | 2     | 7   |
      | 2     | 5   |
    Then Weights are
      | Node  | Weight  |
      | 4     | 1       |
      | 3     | 2       |
      | 9     | 1       |
      | 10    | 1       |
      | 8     | 3       |
      | 6     | 4       |
      | 7     | 1       |
      | 5     | 1       |
      | 2     | 3       |
      | 1     | 10      |
