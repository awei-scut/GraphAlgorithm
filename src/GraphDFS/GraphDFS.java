package GraphDFS;
import Graph.Graph;
import java.util.ArrayList;

/*
    created by wzw
    图的深度优先遍历

 */
public class GraphDFS {
    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    public GraphDFS(Graph G){
        this.G = G;
        visited = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if(!visited[i])
                dfs(i);
        }
    }
    private void dfs(int v){
         visited[v] = true;
         pre.add(v);
         for(int w : G.adj(v))
             if(!visited[w])
                 dfs(w);
         post.add(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g2.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println("pre: " + graphDFS.pre());
        System.out.println("post: " + graphDFS.post());
    }
}
