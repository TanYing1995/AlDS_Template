package Graph;

public interface Graph<V> {
    int edgesSize();
    int verticesSize();
    void addVertex(V v);
    void addEdge(V fr0m, V to);
    void addEdge(V from, V to,int weight);
    void removeEdge(V from, V to);
    void removeVertex(V v);

    void displayGraph();
    int degree(V v);

    void dfs();
    void bfs();
}
