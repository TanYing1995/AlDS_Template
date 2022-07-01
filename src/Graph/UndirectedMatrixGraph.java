package Graph;

import Graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedMatrixGraph<V> implements Graph<V> {

    private List<V> vertexList;//保存顶点信息
    private int[][] edgeMatrix;//邻接矩阵
    private int edges;//边的数量
    private int vertices;//顶点数量
    private int size;//规模

    public UndirectedMatrixGraph(int size) {
        this.size = size;
        vertexList = new ArrayList<>();
        edgeMatrix = new int[size][size];
        this.edges = 0;
        this.vertices = 0;
    }

    @Override
    public int edgesSize() {
        return this.edges;
    }

    @Override
    public int verticesSize() {
        return this.vertices;
    }

    @Override
    public void addVertex(V v) {
        this.vertexList.add(v);
        this.vertices++;
    }

    @Override
    public void addEdge(V from, V to) {
        this.addEdge(from,to,1);
    }

    @Override
    public void addEdge(V from, V to, int weight) {
        int i = this.vertexList.indexOf(from);
        int j = this.vertexList.indexOf(to);
        edgeMatrix[i][j] = weight;
        edgeMatrix[j][i] = weight;
        edges++;
    }

    @Override
    public void removeEdge(V from, V to) {
        int i = this.vertexList.indexOf(from);
        int j = this.vertexList.indexOf(to);
        edgeMatrix[i][j] = 0;
        edgeMatrix[j][i] = 0;
        edges--;
    }

    @Override
    public void removeVertex(V v) {
        // 删除一个顶点
        int index = this.vertexList.indexOf(v);

        for(int i = 0; i < this.vertices; i++){
            if(this.edgeMatrix[index][i] != 0)
                this.edges--;
        }

        // index后面的所有行前移一行
        for (int i = index; i < this.vertices - 1; i++) {
            for (int j = 0; j < this.vertices; j++) {
                this.edgeMatrix[i][j] = this.edgeMatrix[i + 1][j];
            }
        }

        // index后面的所有列前移一列
        for (int i = 0; i < this.vertices; i++) {
            for (int j = index; j < this.vertices - 1; j++) {
                this.edgeMatrix[i][j] = this.edgeMatrix[i][j + 1];
            }
        }

        this.vertexList.remove(index);
        this.vertices--;
    }

    @Override
    public void displayGraph() {
        //显示当前图
        System.out.println("这是一个无向图（邻接矩阵） ： ");
        System.out.println("顶点： "+vertexList);
        for (int i = 0; i < this.vertices; i++) {
            for (int j = 0; j < this.vertices; j++) {
                System.out.print(this.edgeMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public int degree(V v) {
        //返回图的顶点的度
        int index = this.vertexList.indexOf(v);
        int cnt = 0;
        for(int i = 0; i < this.vertices; i++){
            if(edgeMatrix[index][i] != 0)
                cnt++;
        }
        return cnt;
    }

    @Override
    public void dfs() {
        //深度优先遍历
        boolean[] vis = new boolean[vertices];
        vis[0] = true;
        System.out.print("深度优先遍历结果为: " );
        System.out.print(vertexList.get(0)+ " ");
        this.dfs(0,1,vis);
        System.out.println();
    }

    private void dfs(int x, int y, boolean[] vis){
        //遍历X的第y个相邻节点
        while(y < vertices){
            if(edgeMatrix[x][y] != 0 && !vis[y]){
                vis[y] = true;
                System.out.print(this.vertexList.get(y) + " ");
                this.dfs(y,0,vis);
            }
            y++;
        }
    }

    @Override
    public void bfs() {

    }
}
