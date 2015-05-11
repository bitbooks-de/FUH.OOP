package tests;

import com.ea3.graph.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rudy on 10.05.15.
 */
public class GraphTest {

    protected Graph testgraph;

    @Before
    public void setUp() throws Exception {
        String[] test = new String[] {"a", "b", "c"};
        testgraph = new Graph(test);
    }

//    public Graph initTestGraph() {
//        String[] test = new String[] {"a", "b", "c"};
//        Graph testgraph = new Graph(test);
//        return testgraph;
//    }

//    @After
//    public void tearDown() throws Exception {
//
//    }

    @Test
    public void testGetNode() throws Exception {
       // Graph testgraph = initTestGraph();
        Assert.assertEquals("b", testgraph.getNode(1));
    }

    @Test
    public void testGetNumberOfNodes() throws Exception {
       // Graph testgraph = initTestGraph();
        Assert.assertEquals(3, testgraph.getNumberOfNodes());

    }

    @Test
    public void testSetNodes() throws Exception {
       // Graph testgraph = initTestGraph();
        String[] nodes = new String[] {"d", "e", "f", "gh"};
        testgraph.setNodes(nodes);
        Assert.assertEquals("It should set new nodes", "f", testgraph.getNode(2));
    }

    @Test(expected = Graph.GraphException.class)
    public void testIsAdjacent() throws Exception {
       // Graph testgraph = initTestGraph();
        Assert.assertFalse("Nodes should not be adjacent (false)", testgraph.isAdjacent(2, 1));
        testgraph.isAdjacent(4, 1);
    }

    @Test
    public void testIsAdjacent1() throws Exception {
       // Graph testgraph = initTestGraph();
        String node1 = "a";
        String node2 = "c";
        Assert.assertFalse("Nodes should not be adjacent (false)", testgraph.isAdjacent(node1, node2));
    }

    @Test(expected = Graph.GraphException.class)
    public void testIsAdjacent2() throws Exception {
        // Graph testgraph = initTestGraph();
        String node1 = "a";
        String node2 = "foo";
        Assert.assertFalse("It should throw exception", testgraph.isAdjacent(node1, node2));
    }

    @Test
    public void testAddEdge() throws Exception {
    // Graph testgraph = initTestGraph();
        testgraph.addEdge(2, 1);
        Assert.assertTrue("Edges should be added correctly", testgraph.isAdjacent(2,1));
    }

    @Test(expected = Graph.GraphException.class)
    public void testAddEdge1() throws Exception {
        String node1 = "a";
        String node2 = "foo";
        testgraph.addEdge(node1, node2);
        Assert.fail("It should throw exception");
    }
}