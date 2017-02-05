Feature: Minimum Penalty Path from https://www.hackerrank.com/challenges/beautiful-path

  Scenario: Updating Dijkstra structures
    Given 6 vertices
    And Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 20   |
      | 1      | 3        | 4    |
      | 1      | 4        | 1    |
      | 4      | 6        | 7    |
      | 4      | 3        | 4    |
      | 3      | 6        | 1    |
      | 6      | 2        | 2    |
      | 3      | 5        | 3    |
      | 2      | 5        | 4    |
      | 6      | 5        | 20   |
    When Current Dijkstra costs table is
      | Vertex  | Cost  |
      | 2       | 21    |
      | 3       | 4     |
      | 6       | 7     |
    And Current Dijkstra lastKnownCosts table is
      | Vertex  | Cost  |
      | 1       | 1     |
      | 2       | 21    |
      | 3       | 4     |
      | 4       | 0     |
      | 6       | 7     |
    And Current Parents table is
      | Vertex  | Parent  |
      | 1       | 4       |
      | 3       | 4       |
      | 6       | 4       |
      | 2       | 1       |
    And Current Visited Set is
      | Vertex  |
      | 4       |
      | 1       |
    And Dijkstra updates table by visiting vertex 3 in order to reach 2
    Then Dijkstra costs table is
      | Vertex  | Cost  |
      | 2       | 21    |
      | 5       | 7     |
      | 6       | 5     |
    And Parents table is
      | Vertex  | Parent  |
      | 1       | 4       |
      | 3       | 4       |
      | 6       | 3       |
      | 2       | 1       |
      | 5       | 3       |
    And Visited Set is
      | Vertex  |
      | 4       |
      | 1       |
      | 3       |
