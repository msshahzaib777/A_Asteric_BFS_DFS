/**
 *
 * @author Shahzaib
 */
import java.util.*;

public class DFS {
    public int s;                                                      //start node
    public int e;                                                      // end node
    private int current;
    final private Stack<Integer> done [];
    final private Stack<Integer> toExplore [];
    public Stack<Integer> path;
    
    public DFS(int s, int e){
        this.s = s-1;
        this.e = e-1;
        done = new Stack[2];
        toExplore = new Stack[2];
        path = new Stack();
        for(int i=0; i<2; i++){
            done[i] = new Stack();
            toExplore[i] = new Stack();
        }
        toExplore[0].add(s-1);
        toExplore[1].add(null);
    }
    
    public void getpath(Graph G){                                       // main for calculating path kind of controller
        boolean complete = false;
        while(!(false)){
            current = toExplore[0].peek();                                                    // set start node to current node
            done[0].push(toExplore[0].pop());
            done[1].push(toExplore[1].pop());
            int [] edges = G.edges[current].stream().mapToInt(i->i).toArray();
            for(int i=edges.length-1; i>=0; i--){
                if(done[0].search(edges[i]) < 0){
                    toExplore[0].push(edges[i]);
                    toExplore[1].push(current);
                }
                if(edges[i] == e ){
                    done[0].push(edges[i]);
                    done[1].push(current);
                    complete = true;
                    break;
                }
            }
            if(complete){
                break;
            }
            
        }
        track();
    }
    
    public void track(){
        int [][] Array = new int[2][done[0].size()];
        int i = 0;
        while(done[1].peek() != null){
            Array[0][i] = done[0].pop();
            Array[1][i] = done[1].pop();
            i++;
        }
        Array[0][i] = done[0].pop();
        Array[1][i] = -1;
        int next = e;
        int index;
        while(next != -1){
            index = findIndex(Array[0], next);
            path.push(Array[0][index]);
            next = Array[1][index];
        }
    }
    
     public void printPath(Graph G){                        // print path that is saved in path(stack) 
        int[] DFS_road = new int[path.size()];              // stack to array
        for(int i=0; i<DFS_road.length; i++){               // pop the stack into Array    
            DFS_road[i] = path.pop();
        }
        int path_cost=0;                                    
        System.out.println("Path using DFS:");              
        for(int i: DFS_road){                               
            System.out.print(G.names[i] + "->");             // instead of numbers print names for array of names in graph 
        }
        for(int i=0; i<DFS_road.length-1; i++){             
            path_cost += G.Graph[DFS_road[i]][DFS_road[i+1]];   // calculate path Cost   
        }
        System.out.print("\b\b");
        System.out.println("\nCost : " + path_cost);
    }
    
     public static int findIndex(int arr[], int t){         // find t in array arr[] return index or otherwise -1;
        if (arr == null){ 
            return -1; 
        }
        int len = arr.length; 
        int i = 0;
        while (i < len){ 
            if (arr[i] == t){ 
                return i; 
            } 
            else{ 
                i = i + 1; 
            } 
        } 
        return -1; 
    } 
}
