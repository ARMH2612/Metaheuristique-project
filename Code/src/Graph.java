import java.util.LinkedList;

public class Graph {
    private int nbNode; // number of nodes.
    private LinkedList<Integer> adjacencyList[]; // representaion of the graph as an adjacency list.

    public Graph(int nbNode){
        this.nbNode = nbNode;
        this.adjacencyList = new LinkedList[nbNode];
        for (int i = 0; i < nbNode; i++) {
            this.adjacencyList[i] = new LinkedList();
        }
    }

    void addArc(int origin, int destination){
        // adding an arc between the origin and destination " adding destination to origin's list"
        adjacencyList[origin].add(destination);
    }

void printGraph(){
    for (int i = 0; i < this.nbNode; i++) {
        System.out.print(this.adjacencyList[i]+" : ");
        for (int j = 0; j < this.adjacencyList[i].size(); j++) {
            System.out.print(this.adjacencyList[i].get(j));
        }
        System.out.println();
    }
}
}
