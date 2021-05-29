
public class Main {
    public static  void main(String args[]){
        Graph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        graph.addArc(0,1);
        graph.addArc(0,2);
        graph.addArc(1,2);
        graph.addArc(2,0);
        graph.addArc(2,3);
        graph.addArc(3,4);
        graph.printGraph();

        BFS bfs = new BFS(0,graph);
        bfs.implementation(9);
    }
}
