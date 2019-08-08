package GraphBFS;

import Graph.Graph;
import GraphDFS.GraphDFS;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    created by wzw
    图的广度优先遍历
 */
public class GraphBFS {

    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> res = new ArrayList<>();

    public GraphBFS(Graph G){
        this.G = G;
        visited = new boolean[G.V()];

        for (int i = 0; i < G.V(); i++) {
            if(!visited[i])
                bfs(i);
        }
    }

    private void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()){
            int w = queue.remove();
            res.add(w);
            visited[w] = true;
            for(int i : G.adj(w)){
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public Iterable<Integer> res(){
        return res;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        GraphBFS graphBFS = new GraphBFS(g);
        System.out.println("BFS: " + graphBFS.res());
    }
}
