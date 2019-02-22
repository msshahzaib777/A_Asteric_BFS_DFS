/**
 *
 * @author Shahzaib
 *//**
 *
 * @author Shahzaib
 */
import java.util.*;

public class BFS {
    public int s;                                                      //start node
    public int e;                                                      // end node
    private int current;
    final private Stack<Integer> done [];
    final private Queue<Integer> toExplore [];
    public Stack<Integer> path;
    
    public BFS(int s, int e){
        this.s = s-1;
        this.e = e-1;
        done = new Stack[2];
        toExplore = new Queue[2];
        path = new Stack();
        for(int i=0; i<2; i++){
            done[i] = new Stack();
            toExplore[i] = new LinkedList();
        }
        toExplore[0].add(s-1);
        toExplore[1].add(null);
    }
    
    public void getpath(Graph G){                                       // main for calculating path kind of controller
        boolean complete = false;
        while(!(false)){
            current = toExplore[0].peek();                                                    // set start node to current node
            done[0].add(toExplore[0].remove());
            done[1].add(toExplore[1].remove());
            for(Integer i: G.edges[current]){
                if(done[0].search(i) < 0){    
                    toExplore[0].add(i);
                    toExplore[1].add(current);
                }
                if(i == e ){
                    done[0].add(i);
                    done[1].add(current);
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
    
     public void printPath(Graph G){                                 // print path that is saved in path(stack) 
        int[] BFS_road = new int[path.size()];   // stack to array
        for(int i=0; i<BFS_road.length; i++){
            BFS_road[i] = path.pop();
        }
        int path_cost=0;
        System.out.println("Path using BFS:");
        for(int i: BFS_road){
            System.out.print(G.names[i] + "->");
        }
        for(int i=0; i<BFS_road.length-1; i++){
            path_cost += G.Graph[BFS_road[i]][BFS_road[i+1]];
        }
        System.out.print("\b\b");
        System.out.println("\nCost : " + path_cost);
    }
    
     public static int findIndex(int arr[], int t){  // find t in array arr[] return index or otherwise -1;
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
