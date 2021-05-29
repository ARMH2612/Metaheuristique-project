import java.util.*;

public class BFS {
    private int start; // starting node of the graph;
    private Graph graph;
    private Queue<Integer> queue;
    public BFS(int start, Graph graph){
        this.start = start;
        queue = new LinkedList<>();
        queue.add(this.start);
        this.graph = graph;
    }

    void implementation(int node){
        while (queue.size() > 0){
            int head = queue.peek();
            LinkedList children = graph.get(head);
            try{
                for (int i = 0; i<children.size();i++){
                    queue.add((Integer) children.get(i));
                    if((Integer) children.get(i) == node){
                        System.out.println(node+" is found as a children of : "+head);
                        return;
                    }
                }
            }catch(Exception e){
                System.out.println("Search complete Queue is empty \nNo Node with value : "+node);
                return;
            }

            queue.remove(head);
        }
        System.out.println("Search complete : Queue is empty ");
    }
}
