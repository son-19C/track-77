package treeAlgorithms;

public class Pair 
{
	private int vertex;
	private double weight;
	public Pair(int vertex , double weight) 
	{
		this.vertex = vertex;
		this.weight = weight;
	}
	public int getVertex() {
		return vertex;
	}
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		Pair pair = (Pair)obj;
		return (pair.getVertex() == this.getVertex());
	}
	
	@Override
	public String toString() 
	{
		return "  ("+vertex+","+weight+")  ";
	}
}
