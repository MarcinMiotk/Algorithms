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
    Given 3 vertices
    When Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 1    |
      | 1      | 2        | 1000 |
      | 2      | 3        | 3    |
      | 1      | 3        | 100    |
    Then Minimal Penalty from 1 to 3 is 3.



  Scenario:
    Given 5 vertices
    When Undirected edges are
      | First  | Second   | Cost |
      | 1      | 2        | 3    |
      | 1      | 3        | 3    |
      | 4      | 5        | 2    |
    Then Minimal Penalty from 3 to 5 is not exist.



  Scenario:
    Given 9 vertices
    When Undirected edges are
      | First  | Second   | Cost |
      | 9      | 8        | 4    |
      | 8      | 2        | 2    |
      | 2      | 1        | 1    |
      | 1      | 3        | 5    |
      | 3      | 4        | 3    |
      | 4      | 5        | 1    |
      | 4      | 6        | 1    |
      | 6      | 7        | 1    |
      | 5      | 7        | 1    |
    Then Minimal Penalty from 4 to 8 is 7.
