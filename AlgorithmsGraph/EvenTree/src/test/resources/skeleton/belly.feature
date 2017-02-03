Feature: Belly

  -- Number of vertices should be even like 2, 4, 6....
  -- TODO: Policzyc wage kazdego vertex, idac od liscia w gore
  -- TODO: wybrac vetex ktory ma tylko 1 edge. Od niego isc

  Scenario: 2 vertices connected with 1 edge
                      1
                        2
    Given 2 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
    Then Can remove 0 edges from the tree to get a forest such that each connected component of the forest contains an even number of vertices.


  Scenario: 4 vertices connected with 3 edges 1->2->3->4
                      1
                        2
                          3
                            4
    Given 4 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 2     | 3   |
      | 3     | 4   |
    Then Can remove 1 edges from the tree to get a forest such that each connected component of the forest contains an even number of vertices.


  Scenario: 4 vertices connected with 3 edges
                      1
                  2       3
                            4
    Given 4 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 1     | 3   |
      | 3     | 4   |
    Then Can remove 1 edges from the tree to get a forest such that each connected component of the forest contains an even number of vertices.





  Scenario: 6 vertices connected with 5 edges
                    1
                      2
                        3
                          4
                            5
                              6
    Given 6 vertices
    When Edges are
      | From  | To  |
      | 1     | 2   |
      | 2     | 3   |
      | 3     | 4   |
      | 4     | 5   |
      | 5     | 6   |
    Then Can remove 2 edges from the tree to get a forest such that each connected component of the forest contains an even number of vertices.


  Scenario: 6 vertices connected with 5 edges
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
    Then Can remove 1 edges from the tree to get a forest such that each connected component of the forest contains an even number of vertices.
