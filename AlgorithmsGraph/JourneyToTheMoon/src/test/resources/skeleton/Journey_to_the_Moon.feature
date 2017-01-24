Feature: Journey to the Moon

  - So I have to create undirected edge from each vertex to each other vertex
  - then remove the edges from input
  - then compute how many vertexes left



  Scenario: Two pairs
    Given 4 astronauts
    And Astronauts 0 and 1 from the same country
    And Astronauts 2 and 3 from the same country
    When compute in how many ways they can pick a pair of astronauts belonging to different countries
    Then Found 4 ways

