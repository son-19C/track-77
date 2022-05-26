package treeAlgorithms;

import java.util.Comparator;

public class PairWeightComparator implements Comparator<Pair>
{

	@Override
	public int compare(Pair first, Pair second) 
	{
		if(first.getWeight()-second.getWeight() < 0) return -1;
		else if(first.getWeight()-second.getWeight() == 0) return 0;
		else return 1;
	}

}
