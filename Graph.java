import java.util.*;
public class Graph {
    static class Edge{
        int destination;
        int source;
        Edge(int source, int destination){
            this.destination=destination;
            this.source=source;
        }
    }

    static void buildGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 5));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));


    }
    static void BFS(ArrayList<Edge>[] graph, boolean[] visited, int start){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int current=queue.remove();
            if(visited[current]) continue;
            System.out.print(current+ " ");
            visited[current]=true;

            for(Edge e: graph[current]){
                queue.add(e.destination);
            }
        }
    }
    static void DFS(ArrayList<Edge>[] graph, boolean[] visited, int start){
        System.out.print(start+ " ");
        visited[start]=true;
        for(Edge e: graph[start]){
            if(!visited[e.destination]) {
                DFS(graph,visited,e.destination);
            }
        }
    }
    static void allPaths(ArrayList<Edge>[] graph, boolean[] visited, int current, int destination,String path){
        if(current==destination) {
            System.out.println(path);
            return;
        }
        for(Edge e: graph[current]){
            if(!visited[current]) {
                visited[current] = true;
                allPaths(graph, visited, e.destination, destination, path + e.destination);
                visited[current] = false;
            }
        }
    }
    public static void main(String[] args) {
        ArrayList[] graph=new ArrayList[7];
        buildGraph(graph);
        boolean[] visited=new boolean[graph.length];
//        for(int i=0;i<visited.length;i++){
//            if(!visited[i]) DFS(graph,visited,i);
//        }
        allPaths(graph,visited,0,5,"0" );


    }

}
