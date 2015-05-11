package com.ea3.graph;

/**
 * Created by rudy on 10.05.15.
 */

public class Graph {
    protected boolean[][] adjacencyMatrix;
    protected String[] nodes;

    protected int indexOf(String node) throws GraphException {
        for (int i = 0; i < nodes.length; i++) {
            if (node.equals(nodes[i])) {
                return i;
            }
        }
        throw new GraphException();
    }

    public Graph(int nodeNumber) {
        nodes = new String[nodeNumber];
        adjacencyMatrix = new boolean[nodeNumber][nodeNumber];
    }

    public Graph(String[] nodes) {
        this(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            this.nodes[i] = nodes[i];
        }
    }

    /**
     * ...liefert den Namen des Knotens an der
     * durch den Wert des Parameters bezeichneten Position,
     * wenn diese einen Knoten bezeichnet; sonst eine GraphException.
     */
    public String getNode(int index) throws GraphException {
        if (index < this.nodes.length) {
            return this.nodes[index];
        }
        throw new GraphException();

    }

    public int getNumberOfNodes() {
        // ...liefert die Anzahl der Knoten zurueck.
        return this.nodes.length;
    }

    public void setNodes(String[] nodes) {
        // ...weist den ersten k Elementen des Attributs nodes die
        // entsprechenden Werte des Parameters nodes zu. k ist dabei das
        // Minimum aus der Laenge des Attributs und des Parameters.
        int k = nodes.length;
        if (k > this.nodes.length) {
            k = this.nodes.length;
        }
        for (int i = 0; i < k; i++) {
            this.nodes[i] = nodes[i];
        }

    }

    public boolean isAdjacent(int index1, int index2) throws GraphException {
        // ...liefert "wahr", wenn die Knoten mit Index
        // index1 und index2 benachbart sind, sonst "falsch".
        if ((index1 < this.nodes.length) && (index2 < this.nodes.length)) {
            return this.adjacencyMatrix[index1][index2];
        }
        throw new GraphException();
    }

    public boolean isAdjacent(String node1, String node2) throws GraphException {
        // ...liefert "wahr", wenn die Laender mit Namen
        // node1 und node2 benachbart sind, sonst "falsch".
        int index1 = this.indexOf(node1);
        int index2 = this.indexOf(node2);
        return this.isAdjacent(index1, index2);
    }

    public void addEdge(int index1, int index2) throws GraphException {
        // ...fuegt Kante zwischen den Knoten mit
        // Index index1 und index2 ein, wenn diese
        // Indizes von Laendern sind; sonst eine GraphException.
        if ((index1 < this.nodes.length) && (index2 < this.nodes.length)) {
            this.adjacencyMatrix[index1][index2] = true;
        }
        else {
            throw new GraphException();
        }
    }

    public void addEdge(String node1, String node2) throws GraphException {
        // ...fuegt Kante zwischen den Knoten mit
        // Laendernamen node1 und node2 ein, wenn diese
        // Knoten des Graphen bezeichnen; sonst eine GraphException.
        int index1 = this.indexOf(node1);
        int index2 = this.indexOf(node2);
        this.addEdge(index1, index2);
    }

    public class GraphException extends Exception {
    }
}