package treeAlgorithms;


//with union by rank and path compression
public class DisjointSets  
{
	int[][] disjointForest;
	public DisjointSets(int vertices) 
	{
		// parent , rank
		disjointForest = new int[vertices][2];
		for (int i = 0; i < disjointForest[0].length; i++) 
		{
			disjointForest[i][0] = -1;
			disjointForest[i][1] = -1;
		}
	}
	
	public void makeSet(int vertex)
	{
		disjointForest[vertex][0] = vertex; // parent
		disjointForest[vertex][1] = 0; // rank
	}
	
	public int findSet(int vertex)
	{
		// path compression
		if(disjointForest[vertex][0]!=vertex)	disjointForest[vertex][0] = findSet(disjointForest[vertex][0]);
		return disjointForest[vertex][0];
	}
	
	public void union(int vertex1 , int vertex2)
	{
		vertex1 = findSet(vertex1);
		vertex2 = findSet(vertex2);
		
		if(disjointForest[vertex1][1] > disjointForest[vertex2][1])	
		{
			disjointForest[vertex2][0] = disjointForest[vertex1][0];
		}
		else
		{
			disjointForest[vertex1][0] = disjointForest[vertex2][0];
			if(disjointForest[vertex1][1] == disjointForest[vertex2][1]) disjointForest[vertex2][1] += 1;
		}
	}
}
