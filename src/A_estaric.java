/*
 *
 *
 * @author Shahzaib
 */
import java.util.*;

public class A_estaric {
    public String permission;
    public int s;                                           // start node number
    public int e;                                           // end node number
    private int mincost;                                    //  minimum cost among the unexplored nodes 
    private int current;                                    //  Current node in the path
    private int minindex;                                   //  index of minimum node
    private final LinkedList<Integer> open [];                    //  array of linkedlist to save cost, parent and node number
                                                            //  of the unexplored nodes
    public Stack<Integer> path;                          //  nodes selected for the final path(tentative till last iteration 
    public LinkedList<Integer> tracks[];                   //  to keep track in case path in changed (back tracking)
    public LinkedList<Integer> parents;
    
    public A_estaric(int a, int b , String y){
        permission = y;
        s = a-1;                                // in real nodes are from 1-n    start node number 
        e = b-1;                                // -1 to change it to 0-(n-1)    end node number   
        path = new Stack();                    
        open = new LinkedList[3];
        tracks = new LinkedList[2];
        parents = new LinkedList();
        for(int i=0; i<2; i++){                 // initailizing linkedlists (array)
            open[i] = new LinkedList();
            tracks[i] = new LinkedList();
        }
        open[2] = new LinkedList();
       
    }
    
    public void getPath(Graph G){                           // main for calculating path kind of controller
        current = s;                                        // set start node to current node
        path.push(current);                                // parent of start node is null     
        tracks[0].push(current);
        tracks[1].push(-1);
        parents.add(current);
        if("Y".equals(permission)){
            System.out.print("intermediate Path:\n");
        }
        while(path.peek() != e){                         // iterates until end node is at the top of path(stack)
            int [] possible = G.edges[current].stream().mapToInt(i->i).toArray();   // gets the possible edges to go 
                                                                                    // from Ajdcency list of graph
                                                                                    // in an array
            functionValue(G, possible);                     // calculate f(n) = g(n) + h(n) and save it to open
            min();                                          // calculate the minimun of opened list
            rmvmin();
            if("Y".equals(permission)){
                path.forEach((node)->{
                    System.out.print(G.names[node] + "->");
                });
                System.out.println();
            }
        }
    }
    
    public void functionValue(Graph G, int [] Array){           
        for(int i: Array){                                         //for each egde 
            if(!(tracks[0].contains(i))){
                tracks[0].add(i);
                tracks[1].add(current);
                int temp;
                open[0].add(i);                                        // add node number to open[0]
                temp = G.hValue[i]+ cost(G.Graph, i);
                open[1].add(temp);                                     // add f(n) to open[1]     
                open[2].add(current);                                  // add parent of that edge in open[2]
            }
            else{
                if(!(parents.contains(i))){
                    int index = tracks[0].indexOf(i);
                    tracks[1].add(index, current);
                    int temp;
                    open[0].add(i);                                        // add node number to open[0]
                    temp = G.hValue[i]+ cost(G.Graph, i);
                    open[1].add(temp);                                     // add f(n) to open[1]     
                    open[2].add(current);    
                }
                
            }
        }
    }
    
    public int cost(int [][]graph, int i){
        int cost = 0;
        int node1 = i;
        int node2, index;
        while(tracks[0].contains(node1)){
            index = tracks[0].indexOf(node1);
            node2 = tracks[1].get(index);
            if(node2 >= 0){
                int temp = graph[node1][node2];
                cost += temp;
                node1 = node2;
            }
            else{
                break;
            }
        }
        return cost;
    }
    
    public void rmvmin(){
        int check  = open[2].get(minindex);             // parent of the min
        if(path.size()>0){
            if(path.contains(check)){
                while(path.peek() != check){
                    path.pop();
                }
            }
            else{
                trace();
            }
        }
        current = open[0].get(minindex);
        path.push(current);
        open[0].remove(minindex);
        open[1].remove(minindex);
        open[2].remove(minindex);
    }
    
    public void trace(){
        int node2  = open[2].get(minindex);
        LinkedList<Integer> recover = new LinkedList();
        int index;
        int node1 = open[0].get(minindex);
        recover.push(node2);
        while(tracks[0].contains(node2)){
            index = tracks[0].indexOf(node2);
            node1 = tracks[1].get(index);
            if(node1 >= 0){
                recover.push(node1);
                node2 = node1;
            }
            else{
                break;
            }
        }
        while(path.size() > 0){
            path.pop();
        }
        while(recover.size()> 0){
            path.push(recover.pop());
        }
    }
    
    public int min(){                               //find min and save it to the min coes and min index
        int index = 0;
        int min = open[1].getFirst();
        for(Integer Cost: open[1]){
            if(Cost < min){
                min = Cost;
                index = open[1].indexOf(Cost);
            }
        }
        mincost = min;
        minindex = index;
        parents.add(open[0].get(minindex));
        return index;
    }
    
    public void printPath(Graph G){                                 // print path that is saved in path(stack) 
        int[] A_road = path.stream().mapToInt(i->i).toArray();   // stack to array
        int path_cost=0;
        System.out.println("Path using A*:");
        for(int i: A_road){
            System.out.print(G.names[i] + "->");                // instead of numbers print names for array of names in graph
        }
        for(int i=0; i<A_road.length-1; i++){
            path_cost += G.Graph[A_road[i]][A_road[i+1]];       // calculate path Cost
        }
        System.out.print("\b\b");
        System.out.println("\nCost : " + path_cost);
        
        
    }
}
