
public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic
	(
		IProblemState problemState
	) 
	{
		TilePuzzleState state = (TilePuzzleState) problemState;

		int[][] grid = state._tilePuzzle;
		double totalCost = 0;

		for (int i=0; i<grid.length; i++){
			for (int j=0; j<grid[0].length; j++){
				if (grid[i][j] != 0)
					totalCost+= getCost(grid.length, grid[i][j], i, j);
			}
		}


		return totalCost;
	}

	private double getCost(int size, int num, int curRow, int curCol) {
		int goalRow = (num-1)/size;
		int goalCol = (num-1)%size;

		int rowDistance = Math.abs(goalRow - curRow);
		int colDistance = Math.abs(goalCol-curCol);

		return (rowDistance+colDistance)*num;

	}

}
