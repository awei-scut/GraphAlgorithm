package CC;

import Graph.Graph;

import java.util.ArrayList;

/*
    created by wzw
    求图的联通分量的个数
    输出各个联通分量的顶点
 */
public class CC {

    private Graph G;
    private int count;
    private int[] visited;

    public CC(Graph G){
        this.G = G;
        visited = new int[G.V()];
        for (int i = 0; i < G.V(); i++)
            visited[i] = -1;
        count = 0;
        for (int i = 0; i < G.V(); i++) {
            if(visited[i] == -1){
                dfs(i, count);
                count ++;
            }
        }
    }

    private void dfs(int v,int ccid){
        visited[v] = ccid;
        for(int w : G.adj(v))
            if(visited[w] == -1)
                dfs(w, ccid);
    }

    // 两个顶点是否相连
    public boolean isConnected(int v, int w){
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v] == visited[w];
    }

    public int count(){
//        for (int e : visited){
//            System.out.print(e + " ");
//        }
//        System.out.println();
        return count;
    }

    public ArrayList<Integer>[] components(){
        ArrayList<Integer>[] res = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            res[i] = new ArrayList<>();
        }
        for (int i = 0; i < G.V(); i++) {
            res[visited[i]].add(i);
        }
        return res;
    }


    public static void main(String[] args) {
        Graph g = new Graph("g2.txt");
        CC cc = new CC(g);
        System.out.println(cc.count());
        //测试components
        ArrayList<Integer>[] res = cc.components();
        for (int i = 0; i < res.length; i++) {
            System.out.print("components" + i + " ");
            for (int w : res[i])
                System.out.print(w + " ");
            System.out.println();
        }
    }
}
