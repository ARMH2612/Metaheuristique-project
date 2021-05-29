import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
    private int nbNode; // number of nodes.
    private Map<Integer,LinkedList> adjacencyList; // representaion of the graph as an adjacency list.

    public Graph(){
        this.nbNode = nbNode;
        this.adjacencyList = new HashMap();

    }

    void addNode(int i){
        this.adjacencyList.put(i, new LinkedList<>());
    }

    void addArc(int origin, int destination){
        // adding an arc between the origin and destination " adding destination to origin's list"
        adjacencyList.get(origin).add(destination);
    }

void printGraph(){
    for (Map.Entry m :adjacencyList.entrySet()){
        System.out.println(m.getKey()+" : "+m.getValue());
    }
}
}
