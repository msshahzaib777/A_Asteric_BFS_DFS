/**
 *
 * @author Shahzaib
 */
import java.util.*;
import java.io.*;


public class Graph{
    private final String path = "E:\\Semester 6\\AI\\Assignment 1\\AI Programming Assignment\\src\\Graphs\\"; // path where files are saved
    private Scanner FILE;                   //File Pointer to Read Files
    private final String [] data;                 //Array of File names need to read 
    public int nodes;                       // no. of cities
    public LinkedList<Integer> edges[];     // Adjancey List of the given graph
    public int [][] Graph;                  // Matrix of graph
    public int [] hValue;                   // heuristic values of each node
    public String [] names;                 // names of nodes
    
    public Graph(String [] files){
        data = new String[files.length];    
        int j=0;
        for(String i : files ){             // Coping names from local variable to data
            data[j] = i;
            j++;
        }
        FILE = open(data[0]);               // opened data[0] that is names of cities to get count of cities
        nodes = FILE.nextInt();
        edges = new LinkedList[nodes];      // initializing variables
        Graph = new int[nodes][nodes];
        hValue = new int[nodes];
        names = new String[nodes];
        for(int i = 0; i < nodes ; i++){ 
                edges[i] = new LinkedList<>(); 
            } 
    }
    
    public void read(){                     //calling reading functions
        readGraph();
        readhvalue();
        readadjList();
        readNames();
    }
    
    public void readGraph(){                // reading graph Matrix from graph.txt
        FILE = open(data[2]);
        for(int i=0; i<nodes; i++){
            for(int j=0; j<nodes; j++){
                Graph[i][j] = FILE.nextInt();
            }
        }
        FILE.close();
    }
    
    public void readhvalue(){               //reading heuristic values  from hValue.txt
        FILE = open(data[1]);
        for(int i=0; i<nodes; i++){
            hValue[i] = FILE.nextInt();
        }
        FILE.close();
    }
    
    public void readadjList(){              //reading adjancy List from adjList.txt
        FILE = open(data[3]);
        int next;
        for(int i=0; i<nodes; i++){
            
            while(true){
                String check = FILE.next();
                if("*".equals(check)){
                    break;
                }
                next = Integer.parseInt(check);
                edges[i].add(next);
            }
        }
    }
    
    public void readNames(){                // reading names of nodes saved in names.txt
        FILE = open(data[0]);
        FILE.next();
        FILE.nextLine();
        for(int i=0; i<nodes; i++){
            names[i] = FILE.nextLine();
        }
    }
    
    public void print(){                    //calling print functions
        printNames();
        printhValue();
        printedges();
        printGraph();    
    }
    
    public void printNames(){               //printing names of nodes with their numbers
        System.out.println("Cities:");
        for(int i=0; i<nodes; i++){
            System.out.println( String.format("%3d) %s", i+1, names[i]));
        }
    }
    
    public void printGraph(){               //printing matrixs of graph
        System.out.print("              ");
        for(int i=0; i<nodes; i++){
            System.out.print(String.format("%-4s ", " "+ names[i].charAt(0)));
        }
        System.out.println();
        for(int i=0; i<nodes; i++){
            System.out.print(String.format("%-15s ", names[i]));
            for(int j=0; j<nodes; j++){
                System.out.print(String.format("%-4d ", Graph[i][j]));
            }
            System.out.println();
        }
            
    }
    
    public void printhValue(){              // printing node number names and Heuristic values of nodes
        System.out.println("Cities and there Heuristic Values:");
        for(int i=0; i<nodes; i++){
            System.out.println(String.format("%3d) %-14s %-3d", i+1, names[i], hValue[i]));
        }
    }
    
    public void printedges(){                   // printing Adjacency list of the graph
        System.out.println("adjacency List");
        for(int i=0; i<nodes; i++){
            System.out.print(String.format("%3d) %-14s ", i+1, names[i]));
            for(Integer node: edges[i]){
                System.out.print(String.format("-> %2d(%-15s", node+1, names[node]+")"));
            }
            System.out.println();
        }
    }
    
    /**
     *
     * @param name
     * @return
     */
    
    private Scanner open(String name){          //function to open file and return file pointer
        Scanner X = null;
        try{
            X = new Scanner(new File( path + name));
        }
        catch(FileNotFoundException e){
            System.out.println("File Error " + e);
        }
        return X;
    }
}
