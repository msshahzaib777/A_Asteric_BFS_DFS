Section 1:
Algorithms implemented in the given JAVA project:
1-> A*
3-> Breath First Search
4-> Depth First Search
------------------------------------------------------

Section 2:(INPUT FILES PATH)
------------------------------------------------------
Input (i.e graphs) is taken from file.
To make the project run do as follows:
1->Open the project in any IDE meant for JAVA.
2->Go to Class names as "Graph"
3-> On 10th line, there is String variable path give this variable the path of the folder (Project root)-> src -> Graph
                 "X:\\AI Programming Assignment\\src\\Graphs"

------------------------------------------------------

Section 3:(Structure OF Input Files)
------------------------------------------------------
There are Four files in which input is Separately save
-> name(names.txt)     
-> Adjacency Matrix(Graph.txt)
-> Adjacency list(adjList.txt)
-> heuristic values(hValue.txt)

NAME-> name contains number of nodes in the graph
		     And name of each node of the Graph in separate line.

Adjacency Matrix -> this file contains the matrix representation of the Graph
			  on no egde the value is '-1'
			  else the value is the weight of that edge
Adjacency list-> this file contains the Adjacency list of the graph
			in this file First line represent the nodes connected to first node
			and second represents nodes conneted to second node and so on

Heuristic Values-> it contains heuristic value of each node on separate line


NOTE: first make order of the nodes by you self then keep that order in all file
Example: I numbered the nodes according to there Alphabetic order
-------------------------------------------------------

Section 4:(Test cases)
-------------------------------------------------------
In this project along with the Given graph of Romania  There the 3 more graphs that helped me to test my Correctness of code
Image of the Graphs are in the (Project root)-> src -> Graph folder
---------------------------------------------------------

Section 5: (How to use)
---------------------------------------------------------
Enter the graph that you need to run the Algorithms on.
It will ask the start and end nodes
 for Romania    : 	Start node:1
			End node: 2 
 for Test case 1:	Start node:1
			End node: 7
 for Test case 2:	Start node:1
			End node: 9
 for Test case 3:	Start node:1
			End node: 10
---------------------------------------------------------


Section 6:(Add your graph)
---------------------------------------------------------
1-> First make the files discussed in Section 3
2-> Add these files in project root-> src -> Graph
3-> In main add Array of String Variable with value : {"names.txt", "hValue.txt", "Graph.txt",  "adjList.txt"};
		NOTE: this is to give you the order of the names name will be as you saves you file with.
4-> Add selection option in while loop
5-> Add case according to the selection option in Switch case
6-> In That case: call find_paths() and pass the String array that you created in step 3
---------------------------------------------------------


Section 7:(Code Structure)
---------------------------------------------------------
Classes:
	1-> Graph.java
	2-> A_estaric.java
	3-> DFS.java
	4-> BFS.java
	5-> shortest_path.java
----------------------------------------------------------------
Shortest_path.java is the controlling class where the main() is.
functions:
1)clearscreen()
		clears screan
2)void DFS_path(Graph G, int s, int e)
		create object of DFS
		get path
		prints
3)void BFS_path(Graph G, int s, int e)
		create object of BFS
		get path
		prints
4)void A_estaric_path(Graph G, int s, int e, String Y)
		create object of A_estaric
		get path
		prints
-------------------------------------------------------------------
Graph.java this class reads the graph from file and save it in form
	   of linked list.

1) Graph(String [] files)
	get String array discussed in section 6 part 3
2) void readGraph()
	read Matrix from Adjacency Matrix file and save in 2D array Graph[][]
3) void readhvalue()
	read Hueristic value form Heuristic Values file save in Array hValue[]
4) void readadjList()
	read Adjacency List and save in array of linked list edges[]
5) void readNames()
	read Names of nodes from Names file and save it in names[]
6) void read()
	calls all above read function
7) void printNames()
	print Names of nodes from names[]
8) void printGraph()
	print Adjacency Matrix from Graph[][]
9) void printhvalue()
	print Heuristic Values along with the node names
10)void printedges()
	print Adjacency List saved in LinkedList<Integer>edges[]
11)void print()
	calls all above print function
12)Scanner open(String name)
	open file with name 'name' from the directory mentioned in (section 2)
-------------------------------------------------------------------
A_estaric.java calculates and save A* path and prints too 
1)A_estaric(int a, int b , String y) //Constructor
			a is start node
			b is end node
			y is the path string (discussed in section 6 step 3)
			initailize requried Data Structure
2)void getPath(Graph G)
			main algorithm of A*
3)void functionValue(Graph G, int [] Array)
			calculate f(n) i.e sum of path cost from root and Hueristic value
		
4)int cost(int [][]graph, int i)
			calculaltes path cost from root to node i and returns 
5)void rmvmin()
			remove the node with minimum f(n) value among the leave nodes
6)void trace()
			trace the paths saved in unordered manner
7)int min()
			find the minimum node among the leave nodes	
8)void printPath(Graph G)
			prints the path and path cost 
			sent Graph cause Ajdacency Matrix is needed to calculate path 

----------------------------------------------------------------
BFS.java  calculates and save BFS path and prints too 

1)BFS(int s, int e)
		set start and end node
2)void getpath(Graph G)
		main algorithm of BFS
3)void track()
		trace the paths saved in unordered manner
4)void printPath(Graph G)
		prints the path and path cost
		sent Graph cause Ajdacency Matrix is needed to calculate path
5)int findIndex(int arr[], int t)
		find the int t in array arr and returns index of t in arr[]
		return -1 if not found
-----------------------------------------------------------------

DFS.java  calculates and save DFS path and prints too 

1)DFS(int s, int e)
		set start and end node
2)void getpath(Graph G)
		main algorithm of DFS
3)void track()
		trace the paths saved in unordered manner
4)void printPath(Graph G)
		prints the path and path cost
		sent Graph cause Ajdacency Matrix is needed to calculate path
5)int findIndex(int arr[], int t)
		find the int t in array arr and returns index of t in arr[]
		return -1 if not found

---------------------------------------------------------------
