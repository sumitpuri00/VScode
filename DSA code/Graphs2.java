import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
class EdgesNode{
    int source;
    int destination;
    int weight;

    EdgesNode(int source,int destination,int weight){
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }
    
}

public class Graphs2{
    static void DFS( Map<Integer, ArrayList<EdgesNode>> graph, Set<Integer> set, int vertex){
        System.out.print(vertex +" ");
        set.add(vertex);
        for(EdgesNode v: graph.get(vertex)){

            if (!set.contains(v.destination)) {
                
                DFS(graph, set, v.destination);

            }
            
        }
    }
     
    public static void main(String[] args) {
        Map<Integer, ArrayList<EdgesNode>> graph =new HashMap<>();
        int vertices[]=new int[]{5,9,7,8,4};
        for(int i=0; i<vertices.length; i++){
            graph.put(vertices[i],new ArrayList<>());

        }

        graph.get(5).add(new EdgesNode(5, 9, 5));

        graph.get(9).add(new EdgesNode(9, 5, 5));
        graph.get(9).add(new EdgesNode(9, 7, 1));
        graph.get(9).add(new EdgesNode(9, 8, 3));
       
        graph.get(7).add(new EdgesNode(7, 4, 3));
        graph.get(7).add(new EdgesNode(7, 8, 1));
        graph.get(7).add(new EdgesNode(7, 9, 1));
        
        
        graph.get(8).add(new EdgesNode(8, 7, 1));
        graph.get(8).add(new EdgesNode(8, 9, 3));
       

        graph.get(4).add(new EdgesNode(4, 7, 2));



        Set<Integer> set=new HashSet<>();
        
        Queue<Integer> queue=new LinkedList<>();
        queue.add(8);
        

        while (!queue.isEmpty()) {
            int vertex=queue.remove();
            
            if (!set.contains(vertex)) {
                System.out.print(vertex+" ");
                set.add(vertex);
                for(EdgesNode v: graph.get(vertex) ){
                    queue.add(v.destination);
        
                }
            }
           
            
            
        }
       
        set.clear();
        System.out.println("this is DFS");
        DFS(graph, set, 9);
        


    }


    
}

class Graphs {
    public static void main(String[] args) {
        //  creating a adjacency list manually
        /*      
                   graph picture
                   
                        (5)
                    0 ----- 1
        *                  /  \
        *            (1)  /    \ (3)
                         /      \
                        2 ------ 3
                        |   (1)
                    (2) | 
                        |
                        4

        */

        // total vertices
        int vertices=5;
        ArrayList<EdgesNode> graph[] =new ArrayList[vertices];

        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new EdgesNode(0,1,5));

        graph[1].add(new EdgesNode( 1,0,5));
        graph[1].add(new EdgesNode(  1,2,1));
        graph[1].add(new EdgesNode(1,3,3));

        graph[2].add(new EdgesNode(3,1,3));
        graph[2].add(new EdgesNode(2,3,1));
        graph[2].add(new EdgesNode(2,4,2));

        graph[3].add(new EdgesNode(3,1,3));
        graph[3].add(new EdgesNode(3,2,1));

        graph[4].add(new EdgesNode(4,2,2)) ;
        
        for(int i=0; i<graph[2].size(); i++){
            EdgesNode node=graph[2].get(i);
            System.out.print(node.destination+ " ");
        }



        // System.out.println(Arrays.toString(graph));
    }
}
