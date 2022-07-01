package Graph.Test;


import Graph.*;

public class GraphTest{

    public static void main(String[] args) {
        //Graph<Character> graph = new UndirectedListGraph<Character>(10);
        Graph<Character> graph = new UndirectedMatrixGraph<Character>(10);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        graph.addEdge('A', 'B');
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'D');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'F');
        graph.addEdge('E', 'F');

        //
        //graph.removeVertex('B');
        graph.displayGraph();
        graph.dfs();
    }
}
