Question 1 :
You are working as a network engineer responsible for ensuring that all parts of a company's internal computer network are properly connected.

The network consists of several computers (nodes) connected by network cables (edges with weights representing latency). However, due to missing or faulty cables, some computers might be disconnected from others, forming separate components.

You are tasked to:

Apply Prim’s Algorithm starting from any computer in a component.

Continue running Prim's on unvisited components to ensure all parts are checked.

Detect and report all disconnected components in the network.

For each connected component, return:

Its Minimum Spanning Tree (MST)

The total cost (latency)

Input Format:
List of computers (nodes): ["A", "B", "C", "D", "E", "F"]

List of weighted connections: [("A", "B", 3), ("A", "C", 1), ...]

Graph is undirected and weighted

 Output Format:
For each disconnected component:

List of edges in MST with weights

Total cost of that MST

Test Case 1 – Fully Connected Network

Computers: [A, B, C, D]
Connections:
A - B (1)
A - C (2)
B - C (2)
C - D (3)


Expected Output:

Component 1:
MST Edges: A-B(1), A-C(2), C-D(3)
Total Cost: 6


 Test Case 2 – Disconnected Network

Computers: [P, Q, R, S, T, U]
Connections:
P - Q (4)
Q - R (1)
S - T (3)
T - U (2)

Component 1:
MST Edges: Q-R(1), P-Q(4)
Total Cost: 5

Component 2:
MST Edges: T-U(2), S-T(3)
Total Cost: 5

==========================================================================

Question 2 : You are working as a network administrator for a company. The company has several computers (nodes) 
connected via network cables (edges). The connections are bidirectional, and not all computers are directly 
connected to each other.

Sometimes, when a computer sends a broadcast message, it should reach all other computers in the network
in the shortest number of hops (i.e., fewest intermediate computers). You are tasked to simulate this broadcast 
operation using Breadth-First Search (BFS).

Your goal is to write a function that:

Traverses the network from a given source computer

Returns the order in which the computers receive the broadcast message

Assumes each edge takes equal time to traverse	

Test Case 1 – Small Office Network

Computers: [A, B, C, D]

Connections:

A - B
A - C
B - D

Start: A

Expected Output:

Broadcast Order: A, B, C, D

Test Case 2 – Medium Network

Computers: [P, Q, R, S, T, U]

Connections:

P - Q
P - R
Q - S
R - T
T - U

Start: P

Output :

Broadcast Order: P, Q, R, S, T, U
