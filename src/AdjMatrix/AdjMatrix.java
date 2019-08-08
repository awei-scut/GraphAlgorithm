package AdjMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    created by wzw
    图的邻接矩阵表示法
 */
public class AdjMatrix{
    private int V;
    private int E;

    private int[][] adj;

    public AdjMatrix(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        V = scanner.nextInt();
        E = scanner.nextInt();
        adj = new int[V][V];

        for(int i = 0; i < E; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
    }
    @Override
    public String toString() {
        StringBuffer sb  = new StringBuffer();
        sb.append(String.format("V = %d, E = %d\n",V, E));
        for(int i = 0; i < V; i++){
            for(int j = 0; j< V; j++){
                sb.append(String.format("%d ", adj[i][j]));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filepath = "g.txt";
        AdjMatrix am = new AdjMatrix(filepath);
        System.out.println(am);
    }
}