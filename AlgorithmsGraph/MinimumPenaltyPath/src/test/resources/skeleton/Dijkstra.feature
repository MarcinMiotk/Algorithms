Feature: Minimum Penalty Path from https://www.hackerrank.com/challenges/beautiful-path

  Scenario: Loops are ignored
    Given 1 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 1        | 2    |
      | 1      | 1        | 3    |
      | 1      | 1        | 4    |
    When Vertex 1 is processed
    Then Vertex 1 has 0 edges

  Scenario: Loops are ignored
    Given 2 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 1        | 2    |
      | 1      | 1        | 3    |
      | 1      | 2        | 4    |
    When Vertex 1 is processed
    Then Vertex 1 has 1 edges

  Scenario: Loops are ignored
    Given 4 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 2    |
      | 1      | 3        | 3    |
      | 1      | 4        | 4    |
    When Vertex 1 is processed
    Then Vertex 1 has 3 edges

  Scenario: Multiple edges are removed
    Given 2 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 2    |
      | 1      | 2        | 4    |
      | 1      | 2        | 2    |
    When Vertex 1 is processed
    Then Vertex 1 has 1 edges


  Scenario: Multiple edges are removed
    Given 3 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 4    |
      | 1      | 2        | 1    |
      | 1      | 3        | 2    |
    When Vertex 1 is processed
    Then Vertex 1 has 2 edges


  Scenario: Multiple edges are merged into most profitable edge
    Given 3 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 4    |
      | 1      | 2        | 1    |
      | 1      | 3        | 2    |
    When Vertex 1 is processed
    Then Vertex 1 has edges with costs
      | Edge  | Cost  |
      | 2     | 1     |
      | 3     | 2     |


  Scenario: Updating Dijkstra structures
    Given 5 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 4    |
      | 1      | 3        | 1    |
      | 1      | 4        | 2    |
      | 2      | 5        | 3    |
      | 3      | 5        | 5    |
      | 4      | 5        | 1    |
    When Dijkstra updates table by visiting vertex 1 in order to reach 5
    Then Dijkstra costs table is
        | Vertex  | Cost  |
        | 2       | 4     |
        | 3       | 1     |
        | 4       | 2     |
    And Parents table is
        | Vertex  | Parent  |
        | 2       | 1       |
        | 3       | 1       |
        | 4       | 1       |
    And Visited Set is
        | Vertex  |
        | 1       |



  Scenario: Updating Dijkstra structures
    Given 5 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 1    |
      | 1      | 3        | 2    |
      | 1      | 4        | 3    |
      | 2      | 5        | 4    |
      | 3      | 5        | 5    |
      | 4      | 5        | 6    |
    When Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 2       | 1     |
      | 3       | 2     |
      | 4       | 3     |
    And Current Visited Set is
      | Vertex  |
      | 1       |
    And Current Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
    And Dijkstra updates table by visiting vertex 2 in order to reach 5
    Then Dijkstra costs table is
      | Vertex  | Cost  |
      | 3       | 2     |
      | 4       | 3     |
      | 5       | 5     |
    And Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
      | 5       | 2       |
    And Visited Set is
      | Vertex  |
      | 1       |
      | 2       |



  Scenario: Updating Dijkstra structures
    Given 5 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 1    |
      | 1      | 3        | 2    |
      | 1      | 4        | 3    |
      | 2      | 5        | 4    |
      | 3      | 5        | 5    |
      | 4      | 5        | 6    |
    When Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 3       | 2     |
      | 4       | 3     |
      | 5       | 5     |
    And Current Visited Set is
      | Vertex  |
      | 1       |
      | 2       |
    And Current Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
      | 5       | 2       |
    And Dijkstra updates table by visiting vertex 3 in order to reach 5
    Then Dijkstra costs table is
      | Vertex  | Cost  |
      | 4       | 3     |
      | 5       | 5     |
    And Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
      | 5       | 2       |
    And Visited Set is
      | Vertex  |
      | 1       |
      | 2       |
      | 3       |


  Scenario: Updating Dijkstra structures
    Given 5 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 1    |
      | 1      | 3        | 2    |
      | 1      | 4        | 3    |
      | 2      | 5        | 4    |
      | 3      | 5        | 5    |
      | 4      | 5        | 6    |
    When Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 4       | 3     |
      | 5       | 5     |
    And Current Visited Set is
      | Vertex  |
      | 1       |
      | 2       |
      | 3       |
    And Current Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
      | 5       | 2       |
    And Dijkstra updates table by visiting vertex 4 in order to reach 5
    Then Dijkstra costs table is
      | Vertex  | Cost  |
      | 5       | 5     |
    And Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
      | 5       | 2       |
    And Visited Set is
      | Vertex  |
      | 1       |
      | 2       |
      | 3       |
      | 4       |






  Scenario: Updating Dijkstra structures
    Given 4 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 1    |
      | 1      | 3        | 2    |
      | 1      | 4        | 6    |
      | 2      | 4        | 3    |
      | 3      | 4        | 4    |
    When Current Dijkstra costs table is
      | Vertex  | Cost  |
    And Current Visited Set is
      | Vertex  |
    And Current Parents table is
      | Vertex  | Parent  |
    And Dijkstra updates table by visiting vertex 1 in order to reach 4
    Then Dijkstra costs table is
      | Vertex  | Cost  |
      | 2       | 1     |
      | 3       | 2     |
      | 4       | 6     |
    And Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
    And Visited Set is
      | Vertex  |
      | 1       |




  Scenario: Updating Dijkstra structures
    Given 4 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 1    |
      | 1      | 3        | 2    |
      | 1      | 4        | 6    |
      | 2      | 4        | 3    |
      | 3      | 4        | 4    |
    When Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 2       | 1     |
      | 3       | 2     |
      | 4       | 6     |
    And Current Visited Set is
      | Vertex  |
      | 1       |
    And Current Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
    And Dijkstra updates table by visiting vertex 2 in order to reach 4
    Then Dijkstra costs table is
      | Vertex  | Cost  |
      | 3       | 2     |
      | 4       | 4     |
    And Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 2       |
    And Visited Set is
      | Vertex  |
      | 1       |
      | 2       |




  Scenario: Updating Dijkstra structures
    Given 4 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 1    |
      | 1      | 3        | 2    |
      | 1      | 4        | 6    |
      | 2      | 4        | 3    |
      | 3      | 4        | 4    |
    When Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 3       | 2     |
      | 4       | 4     |
    And Current Visited Set is
      | Vertex  |
      | 1       |
      | 2       |
    And Current Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 2       |
    And Dijkstra updates table by visiting vertex 3 in order to reach 4
    Then Dijkstra costs table is
      | Vertex  | Cost  |
      | 4       | 4     |
    And Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 2       |
    And Visited Set is
      | Vertex  |
      | 1       |
      | 2       |
      | 3       |



  Scenario: Updating Dijkstra structures
    Given Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 4       | 3     |
      | 5       | 5     |
    And Current Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
      | 5       | 2       |
    When Dijkstra is going to reach vertex 6
    Then Dijkstra algoritm can still work.



  Scenario: Updating Dijkstra structures
    Given Current Dijkstra costs table is
      | Vertex  | Cost  |
    And Current Parents table is
      | Vertex  | Parent  |
    When Dijkstra is going to reach vertex 6
    Then Dijkstra results NO final result


  Scenario: Updating Dijkstra structures
    Given Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 5       | 5     |
    And Current Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
      | 5       | 2       |
    When Dijkstra is going to reach vertex 5
    Then Dijkstra results 5 final result



  Scenario: Updating Dijkstra structures
    Given Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 5       | 5     |
    And Current Parents table is
      | Vertex  | Parent  |
      | 2       | 1       |
      | 3       | 1       |
      | 4       | 1       |
      | 5       | 2       |
    When Dijkstra is going to reach vertex 5
    Then Dijkstra results 5 final result
    And Dijkstra returns best path
      | Vertex  |
      | 5       |
      | 2       |
      | 1       |








  Scenario: Updating Dijkstra structures
    Given 4 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 3    |
      | 1      | 3        | 4    |
      | 4      | 5        | 2    |
    When Current Dijkstra costs table is
      | Vertex  | Cost  |
    And Current Visited Set is
      | Vertex  |
    And Current Parents table is
      | Vertex  | Parent  |
    And Dijkstra updates table by visiting vertex 3 in order to reach 4
    Then Dijkstra costs table is
      | Vertex  | Cost  |
      | 1       | 4     |
    And Parents table is
      | Vertex  | Parent  |
      | 1       | 3       |
    And Visited Set is
      | Vertex  |
      | 3       |

  Scenario: Updating Dijkstra structures
    Given 4 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 3    |
      | 1      | 3        | 4    |
      | 4      | 5        | 2    |
    When Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 1       | 4     |
    And Current Parents table is
      | Vertex  | Parent  |
      | 1       | 3       |
    And Current Visited Set is
      | Vertex  |
      | 3       |
    And Dijkstra updates table by visiting vertex 1 in order to reach 4
    Then Dijkstra costs table is
      | Vertex  | Cost  |
      | 2       | 7     |
    And Parents table is
      | Vertex  | Parent  |
      | 1       | 3       |
      | 2       | 1       |
    And Visited Set is
      | Vertex  |
      | 3       |
      | 1       |


  Scenario: Updating Dijkstra structures
    Given 4 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 3    |
      | 1      | 3        | 4    |
      | 4      | 5        | 2    |
    When Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 2       | 7     |
    And Current Parents table is
      | Vertex  | Parent  |
      | 1       | 3       |
      | 2       | 1       |
    And Current Visited Set is
      | Vertex  |
      | 3       |
      | 1       |
    And Dijkstra updates table by visiting vertex 2 in order to reach 4
    Then Dijkstra costs table is
      | Vertex  | Cost  |
    And Parents table is
      | Vertex  | Parent  |
      | 1       | 3       |
      | 2       | 1       |
    And Visited Set is
      | Vertex  |
      | 3       |
      | 1       |
      | 2       |
    And Dijkstra algoritm can not work.
    And Dijkstra tells that there is no path to destination. Solution does not exist.






  Scenario: Choosing best vertex in costs table
    Given Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 2       | 5     |
      | 3       | 1     |
      | 4       | 3     |
    Then Best vertex in costs table is 3
