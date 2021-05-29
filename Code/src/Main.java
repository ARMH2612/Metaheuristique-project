
public class Main {
    public static  void main(String args[]){
        Graph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);

        graph.addArc(0,1);
        graph.addArc(0,2);
        graph.addArc(1,2);
        graph.addArc(2,0);
        graph.addArc(2,3);
        graph.addArc(3,4);
        System.out.println("Printing the graph : ");
        graph.printGraph();
        System.out.println("\n---------------------------------------------\n");

        BFS bfs = new BFS(0,graph);

        System.out.println("Eg 1 : Search of the value 2 : ");
        bfs.implementation(2);
        System.out.println("\n---------------------------------------------\n");




        System.out.println("\n---------------------------------------------\n");

        DFS dfs = new DFS(0,graph);

        System.out.println("Eg DFS 1 : Search of the value 2 : ");
        dfs.implementation(6);
        System.out.println("\n---------------------------------------------\n");
    }
}
