package Content4_Graph.DemSoThanhPhanLienThong;

import java.util.*;

public class Main {
    static ArrayList<Integer>edge[] = new ArrayList[1005];
    static boolean check[] = new boolean[1005];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        while(test-->0){
            int v = in.nextInt(), e = in.nextInt();
            for(int i = 0; i <= v; i++){
                check[i] = true;
                edge[i] = new ArrayList<>();
            }
            for(int i = 0; i < e; i++){
                int a = in.nextInt(), b = in.nextInt();
                edge[a].add(b);
                edge[b].add(a);
            }
            int dem = 0;
            for(int i = 1; i <= v; i++){
                if(check[i]){
                    BFS(i);
                    dem++;
                }
            }
            System.out.println(dem);
        }
    }

    private static void BFS(int u) {
        check[u] = false;
        Queue<Integer>q = new LinkedList<>();
        q.add(u);
        while(!q.isEmpty()){
            int v = q.poll();
            for(Integer x:edge[v]){
                if(check[x]){
                    q.add(x);
                    check[x] = false;
                }
            }
        }
    }
}
