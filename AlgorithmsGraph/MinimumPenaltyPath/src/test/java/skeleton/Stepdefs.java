package skeleton;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Stepdefs {

    // =======

    public static class Edge {
        private int first;
        private int second;
        private int cost;
    }

    // =======

    protected Solution solution;

    @Given("^(\\d+) vertices$")
    public void vertices(int vertices) throws Throwable {
        this.solution = new Solution(vertices);
    }

    @When("^Undirected edges are$")
    public void undirected_edges_are(List<Edge> edges) throws Throwable {
        for(Edge edge : edges) {
            solution.addEdge(edge.first, edge.second, edge.cost);
        }
    }

    @Then("^Minimal Penalty from (\\d+) to (\\d+) is (\\d+)\\.$")
    public void minimal_Penalty_from_to_is(int source, int destination, int expectedMinimalPenalty) throws Throwable {
        int minimalPenalty = solution.minimumPenaltyPath(source, destination);
        assertEquals(expectedMinimalPenalty, minimalPenalty);
    }


    Solution.Dijkstra dijkstra;
    Solution.DijkstraStructures dijkstraStructures;

    @When("^Vertex (\\d+) is processed$")
    public void vertex_is_processed(int vertexId) throws Throwable {
        Solution.Vertex vertex = solution.getOrCreate(vertexId);

        dijkstra = new Solution.Dijkstra();
        dijkstra.adaptForDijkstraAlgorithm(vertex, Solution.DijkstraStructures::isFirstCostBetterThanSecond);
    }

    @Then("^Vertex (\\d+) has (\\d+) edges$")
    public void vertex_has_edges(int vertexId, int expectedCountOfEdges) throws Throwable {
        Solution.Vertex vertex = solution.getOrCreate(vertexId);
        assertEquals(expectedCountOfEdges, vertex.countEdges());
    }

    public static class EdgeCost {
        private int edge;
        private int cost;
    }

    @Then("^Vertex (\\d+) has edges with costs$")
    public void vertex_has_edges_with_costs(int vertexId, List<EdgeCost> expectedCosts) throws Throwable {
        Solution.Vertex vertex = solution.getOrCreate(vertexId);
        for(EdgeCost expectedCost : expectedCosts) {
            int costTo = vertex.costTo(expectedCost.edge);
            assertEquals(expectedCost.cost, costTo);
        }
    }

    @When("^Dijkstra updates table by visiting vertex (\\d+) in order to reach (\\d+)$")
    public void dijkstra_updates_table_by_visiting_vertex_in_order_to_reach(int source, int destination) throws Throwable {
        Solution.Vertex sourceVertex = solution.getOrCreate(source);
        Solution.Vertex destinationVertex = solution.getOrCreate(destination);
        dijkstra = new Solution.Dijkstra();
        if(dijkstraStructures==null) {
            dijkstraStructures = new Solution.DijkstraStructures();
        }
        dijkstra.process(
                sourceVertex,
                dijkstraStructures::onVisit,
                dijkstraStructures::parentAssign,
                dijkstraStructures::costAssign,
                dijkstraStructures::removeCostForVertex,
                dijkstraStructures::isParentOf,
                Solution.DijkstraStructures::isFirstCostBetterThanSecond,
                Solution::sum);
    }

    @Then("^Dijkstra costs table is$")
    public void dijkstra_costs_table_is(List<VertexCost> expectedCostsTable) throws Throwable {
        assertEquals(expectedCostsTable.size(), dijkstraStructures.getPathCostsSize());
        for(VertexCost expected : expectedCostsTable) {
            assertThat(dijkstraStructures.getPathCostFor(expected.vertex), is(expected.cost));
        }

    }

    @Then("^Parents table is$")
    public void parents_table_is(List<ParentsAssociation> expectedParentsAssociations) throws Throwable {
        for(ParentsAssociation expected : expectedParentsAssociations) {
            assertThat(dijkstraStructures.getParentFor(expected.vertex), is(expected.parent));
        }
    }

    @Then("^Visited Set is$")
    public void visited_Set_is(List<VertexSetEntry> expectedVisitedSet) throws Throwable {
        List<Integer> expected = new ArrayList<>();
        for(VertexSetEntry e : expectedVisitedSet) {
            expected.add(e.vertex);
        }
        List<Integer> visited = dijkstraStructures.getVisited();
        assertThat(visited, is(expected));

    }

    static class ParentsAssociation {
        private int vertex;
        private int parent;
    }

    static class VertexCost {
        private int vertex;
        private int cost;
    }

    static class VertexSetEntry {
        private int vertex;
    }



    @When("^Current Dijkstra costs table is$")
    public void current_Dijkstra_costs_table_is(List<VertexCost> costsToSet) throws Throwable {
        dijkstraStructures = new Solution.DijkstraStructures();
        for(VertexCost cost : costsToSet) {
            dijkstraStructures.setCostByTest(cost.vertex, cost.cost);
        }
    }

    @When("^Current Visited Set is$")
    public void current_Visited_Set_is(List<VertexSetEntry> visitedToSet) throws Throwable {
        for(VertexSetEntry v : visitedToSet) {
            dijkstraStructures.setVisitedByTest(v.vertex);
        }
    }

    @When("^Current Parents table is$")
    public void current_Parents_table_is(List<ParentsAssociation> associationsToSet) throws Throwable {
        for(ParentsAssociation p : associationsToSet) {
            dijkstraStructures.setParentByTest(p.vertex, p.parent);
        }
    }


    @Then("^Dijkstra results NO final result$")
    public void dijkstra_results_NO_final_result() throws Throwable {
        assertTrue(dijkstraStructures.isFinished());
    }




    @Then("^Dijkstra results (\\d+) final result$")
    public void dijkstra_results_final_result(int finalResult) throws Throwable {
        dijkstraStructures.isFinished();
        assertThat(dijkstraStructures.getFinalCost(), is(finalResult));
    }

    @Then("^Dijkstra returns best path$")
    public void dijkstra_returns_best_path(List<VertexSetEntry> expectedBestPath) throws Throwable {
        List<Integer> expected = new ArrayList<>();
        for(VertexSetEntry e : expectedBestPath) {
            expected.add(e.vertex);
        }
        List<Integer> finalPath = dijkstraStructures.getFinalPath();
        assertThat(finalPath, is(expected));
    }

    @When("^Dijkstra is going to reach vertex (\\d+)$")
    public void dijkstra_is_going_to_reach_vertex(int destination) throws Throwable {

        dijkstraStructures.setDestinationToReach(destination);
    }

    @Then("^Dijkstra tells that there is no path to destination\\. Solution does not exist\\.$")
    public void dijkstra_tells_that_there_is_no_path_to_destination_Solution_does_not_exist() throws Throwable {
        assertFalse(dijkstraStructures.doesPathToDestinationCanBeFound());
    }

    @Then("^Dijkstra algoritm can still work\\.$")
    public void dijkstra_algoritm_can_still_work() throws Throwable {
        assertFalse(dijkstraStructures.isFinished());
    }

    @Then("^Dijkstra algoritm can not work\\.$")
    public void dijkstra_algoritm_can_not_work() throws Throwable {
        assertTrue(dijkstraStructures.isFinished());
    }

    @Then("^Best vertex in costs table is (\\d+)$")
    public void best_vertex_in_costs_table_is(int expectedBestVertex) throws Throwable {
        assertThat(dijkstraStructures.getBestVertexInCostsTable(Solution.DijkstraStructures::isFirstCostBetterThanSecond), is(expectedBestVertex));
    }


}
