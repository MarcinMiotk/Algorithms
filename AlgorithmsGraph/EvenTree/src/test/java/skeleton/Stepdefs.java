package skeleton;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class Stepdefs {

    private Solution solution;

    @Given("^(\\d+) vertices$")
    public void vertices(int vertices) throws Throwable {
        this.solution = new Solution(vertices);
    }

    @When("^Edges are$")
    public void edges_are(List<Edge> edges) throws Throwable {
        for(Edge edge : edges) {
            solution.addEdge(edge.from, edge.to);
        }
    }

    public static class Edge {
        private int from;
        private int to;
    }

    @Then("^Can remove (\\d+) edges from the tree to get a forest such that each connected component of the forest contains an even number of vertices\\.$")
    public void can_remove_edges_from_the_tree_to_get_a_forest_such_that_each_connected_component_of_the_forest_contains_an_even_number_of_vertices(int edgesToRemove) throws Throwable {
        assertEquals(edgesToRemove, solution.maximumNumberOfEdgesToRemoveToHaveForestWithEvenNumberOfVertices());
    }

    @Then("^Parent node has (\\d+) neighbours\\.$")
    public void parent_node_has_children(int neighbours) throws Throwable {
        assertEquals(neighbours, solution.getParent().countNeighbours());
    }


    @Then("^Post-Order traversal is$")
    public void post_Order_traversal_is(List<Integer> expectedPostOrder) throws Throwable {
        Iterator<Solution.Vertex> postorder = solution.traverse();
        for(Integer expected : expectedPostOrder) {
            assertEquals(expected, postorder.next().getId());
        }
    }

    static class Weights {
        private int node;
        private int weight;
    }


    @Then("^Weights are$")
    public void weights_are(List<Weights> expectedWeights) throws Throwable {
        Iterator<Solution.Vertex> postorder = solution.traverse();
        Solution.WeightsComputations weights = new Solution.WeightsComputations(postorder);
        for(Weights expectedWeight : expectedWeights) {
            assertEquals(expectedWeight.weight, weights.getWeightForNode(expectedWeight.node));
        }
    }

}
