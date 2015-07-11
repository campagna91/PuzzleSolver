package puzzleObject;

import java.util.ArrayList;
import puzzleObject.Puzzle;
import puzzleIO.*;

public class PuzzleSolved extends Puzzle implements Solvable{
	private ArrayList<PuzzleTile> tiles = new ArrayList<PuzzleTile>();

	public class PuzzleThread extends Thread {
		public int row;
		public Puzzle puzzle;

		public PuzzleThread(Puzzle puzzle, int row) {
			this.puzzle = puzzle;
			this.row = row;
		}
		public void run() {
			System.out.println("run per il " + row + "° thread");
			ArrayList<PuzzleTile> local = puzzle.tiles();
			for(int c = 0; c < puzzle.columns(); ++c) {
				boolean notFound = true;
				for(int tile = 0; tile < local.size() && notFound; ++tile) {
					if(local.get(tile).left().equals(tiles.get(row * puzzle.columns() + c))) {						
						tiles.add(row * puzzle.columns() + c, local.get(tile));
						notFound = false;
					}
				}
			}	
		}
	}
	public PuzzleSolved(Puzzle puzzle) {
		super();
		super.setColumns(puzzle.columns());
		super.setRows(puzzle.rows());	
		for(int i = 0; i < puzzle.tiles().size(); ++i)
			tiles.add(puzzle.tiles().get(i));
		this.solve(puzzle);
	}
	public void solve(Puzzle puzzle) {
		solveFirstColumn(puzzle);
		solveRemaining(puzzle);
	}
	public void solveFirstColumn(Puzzle puzzle) {
		ArrayList<PuzzleTile> local = puzzle.tiles();
		String top = "VUOTO";
		for(int r = 0; r < puzzle.rows(); ++r) {
			boolean notFound = true;
			for(int tile = 0; tile < local.size() && notFound; ++tile) {
				if(local.get(tile).left().equals("VUOTO")) {
					if(local.get(tile).top().equals(top)) {
						tiles.set(r * puzzle.columns(), local.get(tile));
						top = local.get(tile).id();
						notFound = false;
					}
				}
			}
		}
	}
	public void solveRemaining(Puzzle puzzle) {
		for(int i = 0; i < puzzle.rows(); ++i)
			new PuzzleThread(puzzle, i).start();
	}
	public PuzzleTile tile(int row, int column) {
		return tiles.get(row * this.columns() + column);
	}
	public String toString() {
		StringBuilder aux = new StringBuilder();
		for(int r = 0; r < super.rows(); r++) {
		  aux.append(System.getProperty("line.separator"));
		  for(int c = 0; c < this.columns(); c++) {
			  aux.append(this.tile(r, c).character());
			  aux.append(" ");
		  }
	  }
	  aux.append(System.getProperty("line.separator") + System.getProperty("line.separator"));
	  aux.append(this.rows());
	  aux.append(" ");
	  aux.append(this.columns());
	  return aux.toString();
	}
}