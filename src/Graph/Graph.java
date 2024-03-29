package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
/*
    created by wzw
    图的邻接表表示
    及部分方法封装
 */
public class Graph {
    private int V;
    private int E;

    private TreeSet<Integer>[] adj;

    public Graph(String filename){
        File file = new File(filename);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            V = scanner.nextInt();
            if(V < 0 ) throw new IllegalArgumentException("V must be positive");
            adj = new TreeSet[V];
            for (int i = 0; i < V; i++)
                adj[i] = new TreeSet<>();
            E = scanner.nextInt();
            if(E < 0) throw new IllegalArgumentException("V must be positive");
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                if(a == b) throw new IllegalArgumentException("self Loop is Detected");
                if(adj[a].contains(b)) throw new IllegalArgumentException("Parallel Edges are detected");
                adj[a].add(b);
                adj[b].add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 检验顶点
    public void validateVertex(int v){
        if(v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + "is valid");
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    public boolean hasEdge(int a, int b){
        validateVertex(a);
        validateVertex(b);
        return adj[a].contains(b);
    }

    public TreeSet<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for(int v = 0; v < V; v ++){
            sb.append(String.format("%d : ", v));
            for(int w : adj[v])
                sb.append(String.format("%d ", w));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g.txt");
        System.out.println(graph);
    }
}
