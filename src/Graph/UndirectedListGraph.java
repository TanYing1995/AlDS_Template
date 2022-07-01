package Graph;

import java.util.LinkedList;

public class UndirectedListGraph<V> implements Graph<V> {

    Vertex[] vertexList;
    private int edges;
    private int vertices;

    public UndirectedListGraph(int size) {
        vertexList = new Vertex[size];
        this.vertices = 0;
        this.edges = 0;
    }

    class Vertex<V>{
        V data;//顶点值
        LinkedList<Integer> adj;

        public Vertex(V data) {
            this.data = data;
            this.adj = new LinkedList<>();
        }
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
        //增加一个顶点
        this.vertexList[this.vertices++] = new Vertex<>(v);
    }

    @Override
    public void addEdge(V from, V to) {
        int i = this.getPosition(from);
        int j = this.getPosition(to);

        this.vertexList[i].adj.add(j);
        this.vertexList[j].adj.add(i);
        this.edges++;
    }

    private int getPosition(V v){
        for (int i = 0; i < this.vertices; i++){
            if(this.vertexList[i].data.equals(v))
                return i;
        }
        return -1;
    }

    @Override
    public void addEdge(Object form, Object to, int weight) {
        //TODO
    }

    @Override
    public void removeEdge(V from, V to) {
        //删除一条边
        int i = this.getPosition(from);
        int j = this.getPosition(to);
        this.vertexList[i].adj.remove(new Integer(j));
        this.vertexList[j].adj.remove(new Integer(i));
        this.edges--;
    }

    @Override
    public void removeVertex(V v) {
        //删除一个顶点
        int index = this.getPosition(v);
        this.edges = this.edges - this.degree(v);
        for(int i = 0; i < this.vertices; i++){
            this.vertexList[i].adj.remove(new Integer(index));
        }
        for(int i = index; i < this.vertices-1; i++)
            this.vertexList[i] = this.vertexList[i+1];

        this.vertices--;
        for(int i = 0; i < this.vertices; i++){
            LinkedList list = vertexList[i].adj;
            for(int j = 0; j < list.size(); j++){
                if((int)list.get(j) > index){
                    list.set(j,(int)list.get(j)-1);
                }
            }
        }
    }

    @Override
    public void displayGraph() {
        System.out.println("这是一个用邻接表存储的图");
        for(int i = 0; i < this.vertices; i++){
            System.out.print("顶点: " + this.vertexList[i].data);
            System.out.println(",邻接表" + this.vertexList[i].adj);
        }
    }

    @Override
    public int degree(V v) {
        return this.vertexList[getPosition(v)].adj.size();
    }

    @Override
    public void dfs() {
        //邻接表的深度优先遍历
        boolean[] vis = new boolean[this.vertices];
        //保存节点的遍历状态，默认为false
        vis[0] = true;
        System.out.print("深度优先遍历结果: ");
        System.out.print(this.vertexList[0].data + " ");
        //System.out.print(0 + " ");
        this.dfs(0,vis);
        System.out.println();
    }

    private void dfs(int i, boolean[] vis){
        //从第i个节点开始深度优先遍历
        for(int j = 0; j < this.vertexList[i].adj.size(); j++){
            int idx = (int)this.vertexList[i].adj.get(j);
            if(!vis[idx]){
                vis[idx] = true;
                System.out.print(this.vertexList[idx].data + " ");
                //System.out.print(idx + " ");
                this.dfs(idx,vis);
            }
        }
    }

    @Override
    public void bfs() {

    }
}
