import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

    private Stack stack;
    private int start;
    private Graph graph;

    public DFS(int start, Graph graph){
        this.start = start;
        stack = new Stack();
        stack.push(this.start);
        this.graph = graph;

    }

    void util(int node,int v, boolean visited[]){
        if (visited.length>v){
            if(node == v){
                System.out.println(node+" was found");
                return;
            }else{
                visited[v] = true;

                Iterator<Integer> it = graph.get(v).listIterator();
                while (it.hasNext()){
                    int n = it.next();
                    if(!visited[n]){
                        util(node,n,visited);
                    }
                }
            }

        }else{
            System.out.println("There's no index for "+ v);
            return;
        }

    }

    void implementation(int node){
        boolean visited[] = new boolean[graph.size()];
        util(node,start,visited);
    }
}
