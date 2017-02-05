Feature: Minimum Penalty Path from https://www.hackerrank.com/challenges/beautiful-path

  Scenario:
    Given 2 vertices
    When Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 3    |
    Then Minimal Penalty from 1 to 2 is 3.


  Scenario:
    Given 2 vertices
    When Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 2    |
    Then Minimal Penalty from 1 to 2 is 2.


  Scenario:
    Given 2 vertices
    When Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 2    |
    Then Minimal Penalty from 1 to 2 is 2.




  Scenario:
    Given 2 vertices
    When Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 1    |
      | 1      | 2        | 1000 |
      | 2      | 3        | 3    |
      | 1      | 3        | 100    |
    Then Minimal Penalty from 1 to 3 is 3.
