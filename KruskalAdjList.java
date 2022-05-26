package treeAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

import entryPoint.Main;

public class KruskalAdjList 
{
	private ArrayList<ArrayList<Pair>> graph;
	
	public void entryPoint()
	{
		Scanner in = new Scanner(System.in);
		int choice,edges,vertices,start,end,root;
		String edge; 
		String[] splittedEdge;
		boolean onGoing = true;
		while(onGoing)
		{
			printMenu();
			choice = in.nextInt();
			System.out.println("========================");
			switch(choice)
			{
				case 1:
						graph = new ArrayList<ArrayList<Pair>>();
						System.out.println("Number of Vertices:");
						vertices = in.nextInt();
						System.out.println("Number of Edges:");
						edges = in.nextInt();
						System.out.println("Weight Range starts from: ");
						start = in.nextInt();
						System.out.println("Weight Range ends at: ");
						end = in.nextInt();
						generateRandomizedGraph(vertices,edges,start,end);
						System.out.println("Enter source vertex #: ");
						root = in.nextInt(); 
						startKruskals(root,vertices);
						break;
				case 2:
						graph = new ArrayList<ArrayList<Pair>>();
						System.out.println("Number of Vertices:");
						vertices = in.nextInt();
						if(vertices<=0)
						{
							System.out.println("Minimum # of vertices is 1");
							break;
						}
						for (int i = 0; i < vertices; i++) graph.add(new ArrayList<Pair>());
						
						System.out.println("Number of Edges:");
						edges = in.nextInt();
						if(edges<vertices-1)
						{
							System.out.println("Minimum # of edges = vertices-1");
							break;
						}
						System.out.println("Enter Edges");
						System.out.println("Edge Format: start vertex,end vertex,weight");
						for(int i = 0 ; i < edges; i++)
						{
							System.out.println("Enter Edge "+(i+1));
							edge = in.next();
							splittedEdge = edge.split(",");
							graph.get(Integer.parseInt(splittedEdge[0]))
									.add(new Pair(Integer.parseInt(splittedEdge[1]),Double.parseDouble(splittedEdge[2])));
							graph.get(Integer.parseInt(splittedEdge[1]))
							.add(new Pair(Integer.parseInt(splittedEdge[0]),Double.parseDouble(splittedEdge[2])));
						}
						formedGraphPrinter();
						System.out.println("Enter source vertex #: ");
						root = in.nextInt(); 
						startKruskals(root,vertices);
						break;
				case 3:
						preMadeTest();
						break;
				default:
						onGoing=false;
						break;
			}
		}
	}
	
	private void preMadeTest() 
	{
		System.out.println("================================");
		System.out.println("Graph 1:");
		int vertices = 5;
		int edges = 7;
		graph = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < vertices; i++) graph.add(new ArrayList<Pair>());
		graph.get(0).add(new Pair(1,2));
		graph.get(1).add(new Pair(0,2));
		graph.get(0).add(new Pair(3,5));
		graph.get(3).add(new Pair(0,5));
		graph.get(1).add(new Pair(2,14));
		graph.get(2).add(new Pair(1,14));
		graph.get(1).add(new Pair(3,5));
		graph.get(3).add(new Pair(1,5));
		graph.get(1).add(new Pair(4,4));
		graph.get(4).add(new Pair(1,4));
		graph.get(2).add(new Pair(4,34));
		graph.get(4).add(new Pair(2,34));
		graph.get(3).add(new Pair(4,58));
		graph.get(4).add(new Pair(3,58));
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startKruskals(0,vertices);
		System.out.println("================================");
		System.out.println("Graph 2:");
		vertices = 3;
		edges = 3;
		graph = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < vertices; i++) graph.add(new ArrayList<Pair>());
		graph.get(0).add(new Pair(1,10));
		graph.get(1).add(new Pair(0,10));
		graph.get(0).add(new Pair(2,20));
		graph.get(2).add(new Pair(0,20));
		graph.get(1).add(new Pair(2,30));
		graph.get(2).add(new Pair(1,30));
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startKruskals(0,vertices);
		System.out.println("================================");
		System.out.println("Graph 3:");
		vertices = 6;
		edges = 10;
		graph = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < vertices; i++) graph.add(new ArrayList<Pair>());
		graph.get(0).add(new Pair(1,20));
		graph.get(1).add(new Pair(0,20));
		graph.get(0).add(new Pair(2,70));
		graph.get(2).add(new Pair(0,70));
		graph.get(0).add(new Pair(5,10));
		graph.get(5).add(new Pair(0,10));
		graph.get(1).add(new Pair(2,60));
		graph.get(2).add(new Pair(1,60));
		graph.get(1).add(new Pair(3,30));
		graph.get(3).add(new Pair(1,30));
		graph.get(2).add(new Pair(3,50));
		graph.get(3).add(new Pair(2,50));
		graph.get(2).add(new Pair(4,80));
		graph.get(4).add(new Pair(2,80));
		graph.get(3).add(new Pair(4,40));
		graph.get(4).add(new Pair(3,40));
		graph.get(3).add(new Pair(5,90));
		graph.get(5).add(new Pair(3,90));
		graph.get(4).add(new Pair(5,100));
		graph.get(5).add(new Pair(4,100));
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startKruskals(0,vertices);
		System.out.println("================================");
		System.out.println("Graph 4:");
		vertices = 8;
		edges = 13;
		graph = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < vertices; i++) graph.add(new ArrayList<Pair>());
		graph.get(0).add(new Pair(1,1));
		graph.get(1).add(new Pair(0,1));
		graph.get(0).add(new Pair(2,12));
		graph.get(2).add(new Pair(0,12));
		graph.get(0).add(new Pair(7,15));
		graph.get(7).add(new Pair(0,15));
		graph.get(1).add(new Pair(2,10));
		graph.get(2).add(new Pair(1,10));
		graph.get(1).add(new Pair(4,11));
		graph.get(4).add(new Pair(1,11));
		graph.get(2).add(new Pair(3,8));
		graph.get(3).add(new Pair(2,8));
		graph.get(2).add(new Pair(4,9));
		graph.get(4).add(new Pair(2,9));
		graph.get(3).add(new Pair(4,7));
		graph.get(4).add(new Pair(3,7));
		graph.get(3).add(new Pair(5,14));
		graph.get(5).add(new Pair(3,14));
		graph.get(4).add(new Pair(6,16));
		graph.get(6).add(new Pair(4,16));
		graph.get(5).add(new Pair(6,5));
		graph.get(6).add(new Pair(5,5));
		graph.get(6).add(new Pair(7,3));
		graph.get(7).add(new Pair(6,3));
		graph.get(7).add(new Pair(5,4));
		graph.get(5).add(new Pair(7,4));
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startKruskals(0,vertices);
		System.out.println("================================");
		System.out.println("Graph 5:");
		vertices = 9;
		edges = 14;
		graph = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < vertices; i++) graph.add(new ArrayList<Pair>());
		graph.get(0).add(new Pair(1,4));
		graph.get(1).add(new Pair(0,4));
		graph.get(0).add(new Pair(7,8));
		graph.get(7).add(new Pair(0,8));
		graph.get(1).add(new Pair(2,8));
		graph.get(2).add(new Pair(1,8));
		graph.get(1).add(new Pair(7,11));
		graph.get(7).add(new Pair(1,11));
		graph.get(2).add(new Pair(3,7));
		graph.get(3).add(new Pair(2,7));
		graph.get(2).add(new Pair(8,2));
		graph.get(8).add(new Pair(2,2));
		graph.get(2).add(new Pair(5,4));
		graph.get(5).add(new Pair(2,4));
		graph.get(3).add(new Pair(4,9));
		graph.get(4).add(new Pair(3,9));
		graph.get(3).add(new Pair(5,14));
		graph.get(5).add(new Pair(3,14));
		graph.get(4).add(new Pair(5,10));
		graph.get(5).add(new Pair(4,10));
		graph.get(5).add(new Pair(6,2));
		graph.get(6).add(new Pair(5,2));
		graph.get(6).add(new Pair(7,1));
		graph.get(7).add(new Pair(6,1));
		graph.get(7).add(new Pair(8,7));
		graph.get(8).add(new Pair(7,7));
		graph.get(8).add(new Pair(6,6));
		graph.get(6).add(new Pair(8,6));
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startKruskals(0,vertices);
		System.out.println("================================");
		System.out.println("Graph 6:");
		vertices = 2;
		edges = 1;
		graph = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < vertices; i++) graph.add(new ArrayList<Pair>());
		graph.get(0).add(new Pair(1,10));
		graph.get(1).add(new Pair(0,10));
		formedGraphPrinter();
		System.out.println("Source Vertex: 0");
		startKruskals(0,vertices);
		System.out.println("================================");
	}

	private void startKruskals(int root,int vertices) 
	{
		long startTime = System.currentTimeMillis();
		if(root>=vertices || root<0) 
		{
			System.out.println("Invalid root, root = 0 will be used instead.");
			root = 0;
		}
		
		// the empty set
		ArrayList<ArrayList<Pair>> result = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < vertices; i++) result.add(new ArrayList<Pair>());
		
		//make sets of vertices
		DisjointSets sets = new DisjointSets(vertices);
		int numberOfOperations = 0;
		for(int i = 0 ; i < vertices ; i++)
		{
			sets.makeSet(i);
			numberOfOperations++;
		}
		
		// sorting ascendinglly
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(vertices,new EdgeComparator());
		for (int i = 0; i < vertices; i++) 
		{
			for (int j = 0; j < graph.get(i).size(); j++) 
			{
				priorityQueue.add(new Edge(i,graph.get(i).get(j).getVertex(),graph.get(i).get(j).getWeight()));
				numberOfOperations++;
			}
		}
		double minimumCost=0;
		while(!priorityQueue.isEmpty())
		{
			Edge edge = priorityQueue.poll();
			numberOfOperations++;
			if(sets.findSet(edge.getStartVertex()) != sets.findSet(edge.getEndVertex()))
			{
				result.get(edge.getStartVertex()).add(new Pair(edge.getEndVertex(),edge.getWeight()));
				result.get(edge.getEndVertex()).add(new Pair(edge.getStartVertex(),edge.getWeight()));
				sets.union(edge.getStartVertex(), edge.getEndVertex());
				minimumCost+=edge.getWeight();
				numberOfOperations++;
			}
		}
		
		
		
		System.out.println("----");
		System.out.println("MST:");
		System.out.println("----");
		for (int i = 0; i < vertices; i++) 
		{
			System.out.print(i+" : ");
			for (int j = 0; j < result.get(i).size(); j++) 
			{
				System.out.print(result.get(i).get(j).toString());
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
		System.out.println("Minimum Cost = "+minimumCost);
		System.out.println("------------------------------------");
		System.out.println("Number Of Operations = "+numberOfOperations);
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("Time Required = "+(System.currentTimeMillis() - startTime));
		System.out.println("------------------------------------");
		
		
	}

	private void generateRandomizedGraph(int vertices, int edges, int start,int end) 
	{
		if(vertices<=0)
		{
			System.out.println("# of vertices is below allowed minimum.");
			System.out.println("Minimum No.of verices 1 will be used");
			vertices = 1;
		}
		if(edges<vertices-1)
		{
			System.out.println("# of edges is below allowed minimum.");
			System.out.println("Minimum No.of edges"+(vertices-1) + " will be used");
			edges = vertices-1;
		}
		if(start>end)
		{
			System.out.println("Start weight is less than end weight.");
			System.out.println("Swappig will be done.");
			int temp = start;
			start = end;
			end = temp;
			System.out.println("Start = "+start+" End = "+end);
		}
		
		for(int i = 0 ; i < vertices ; i++)	graph.add(new ArrayList<Pair>());
		boolean[][] edgesCheck = new boolean[vertices][vertices];
		int randomStartVertex,randomEndVertex,randomWeight;
		for (int i = 0; i < edges; i++) 
		{
			//each vertex has at least 1 edge
			if(i<vertices)	randomStartVertex = i;
			else randomStartVertex = Main.randomGenerator.nextInt(vertices);
			
			randomEndVertex = Main.randomGenerator.nextInt(vertices);
			//remove self loops and repeated edges
			while( (vertices!=1) 
					&& (randomEndVertex==randomStartVertex || edgesCheck[randomStartVertex][randomEndVertex])) 
			{
				randomEndVertex = Main.randomGenerator.nextInt(vertices);
			}
			randomWeight = start+Main.randomGenerator.nextInt(end-start)+1;
			edgesCheck[randomStartVertex][randomEndVertex]=true;
			graph.get(randomStartVertex).add(new Pair(randomEndVertex,randomWeight));
			graph.get(randomEndVertex).add(new Pair(randomStartVertex,randomWeight));
		}
		formedGraphPrinter();
	}
	
	private void formedGraphPrinter()
	{
		System.out.println("-------------");
		System.out.println("Formed Graph:");
		System.out.println("-------------");
		for (int i = 0; i < graph.size(); i++) 
		{
			System.out.print(i+" : ");
			for (int j = 0; j < graph.get(i).size(); j++) 
			{
				System.out.print(graph.get(i).get(j).toString());
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
	}

	private void printMenu() 
	{
		System.out.println("=====KruskalAdjList=====");
		System.out.println("1) Randomized input Test");
		System.out.println("2) Manual input Test");
		System.out.println("3) Pre-made Test");
		System.out.println("*) Back");
		System.out.println("========================");
		System.out.print("Your Choice: ");
	}

}
