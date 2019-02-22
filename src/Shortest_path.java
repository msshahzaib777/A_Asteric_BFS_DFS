/**
 *
 * @author Shahzaib
 */
import java.util.*;
import java.awt.AWTException;
import java.awt.Robot;

public class Shortest_path {
    int [] check = new int[10];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        String [] file_paths = {"names.txt", "hValue.txt", "Graph.txt",  "adjList.txt"};  
        String [] file_paths2 = {"names1.txt", "hValue1.txt", "Graph1.txt",  "adjList1.txt"};
        String [] file_paths1 = {"names2.txt", "hValue2.txt", "Graph2.txt",  "adjList2.txt"};
        String [] file_paths3 = {"names3.txt", "hValue3.txt", "Graph3.txt",  "adjList3.txt"};
        int graph = -1;
        Scanner x = new Scanner(System.in);
        while(graph != 0){
            System.out.println("0-> Exit");
            System.out.println("1-> Romania");                          //Start node: 1 
                                                                        //End node:   2
            System.out.println("2-> Test case 1");                      //Start node: 1 
                                                                        //End node:   9
            System.out.println("3-> Test case 2");                      //Start node: 1
                                                                        //End node:   7
            System.out.println("4-> Test case 3");                      //Start node: 1
                                                                        //End node:   10
            System.out.print("Graph number:");          
            graph = x.nextInt();
            
            switch(graph){
                case 1:
                    find_paths(file_paths);
                    break;
                case 2:
                    find_paths(file_paths1);
                    break;
                case 3:
                    find_paths(file_paths2);
                    break;
                case 4:
                    find_paths(file_paths3);
                    break;
                case 0:
                    graph = 0;
                    break;
                default:
                    System.out.println("Wrong Selection");
                    
            }
        }
    }
    
    public static void find_paths(String [] names){
        int s, e;
        String y;
        Scanner X = new Scanner(System.in);
        Graph Romania = new Graph(names);
        Romania.read();
        System.out.println("To Know the Start and end node for that Graph read Section 5 of READme.txt");
        System.out.print("Enter Start node:");
        s = X.nextInt();
        System.out.print("Enter End node:");
        e = X.nextInt();
        System.out.print("If want to print intermediate Paths (press Y for Yes/ N for No):");
        y = X.next();
        clearscreen();
        A_estaric_path(Romania, s, e, y);
        BFS_path(Romania, s, e);
        DFS_path(Romania, s, e);
    }
    
    public static void A_estaric_path(Graph G, int s, int e, String Y){
        A_estaric Agraph = new A_estaric(s, e, Y);
        Agraph.getPath(G);
        Agraph.printPath(G);
    }
    
    public static void BFS_path(Graph G, int s, int e){
        BFS BFSgraph = new BFS(s, e);
        BFSgraph.getpath(G);
        BFSgraph.printPath(G);
    }
    
    public static void DFS_path(Graph G, int s, int e){
        DFS DFSgraph = new DFS(s, e);
        DFSgraph.getpath(G);
        DFSgraph.printPath(G);
    }
    
    public static void clearscreen(){
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        }
        catch (AWTException ex) {
            
        }
    }
}
