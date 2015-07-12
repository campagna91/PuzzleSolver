package server.puzzleObject;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.io.Serializable;
import common.Puzzle;
import common.Solvable;
import common.PuzzleTile;

public class PuzzleSolved extends Puzzle implements Solvable {
	private ArrayList<PuzzleTile> tilesOrdered = new ArrayList<PuzzleTile>();

	public PuzzleSolved() throws RemoteException {
	}
	public class PuzzleThread extends Thread {
		public int row;

		public PuzzleThread(int row) {
			this.row = row;
		}
		public void run() {
			for(int c = 0; c < columns(); ++c) {
				boolean notFound = true;
				for(int tile = 0; tile < tiles.size() && notFound; ++tile) {
					if(tiles.get(tile).left().equals(tilesOrdered.get(row * columns() + c))) {
						tilesOrdered.add(row * columns() + c, tiles.get(tile));
						notFound = false;
					}
				}
			}	
		}
	}
	public void solve(Puzzle puzzle)  throws RemoteException {
		// System.out.println(puzzle);
		// setColumns(puzzle.columns());
		// setRows(puzzle.rows());	
		// tiles.addAll(puzzle.tiles());
		// tilesOrdered.addAll(puzzle.tiles());

		// solveFirstColumn();
		// solveRemaining();

	}
	public void solveFirstColumn() {
		String top = "VUOTO";
		for(int r = 0; r < rows(); ++r) {
			boolean notFound = true;
			for(int tile = 0; tile < tiles.size() && notFound; ++tile) {
				if(tiles.get(tile).left().equals("VUOTO")) {
					if(tiles.get(tile).top().equals(top)) {
						tilesOrdered.set(r * columns(), tiles.get(tile));
						top = tiles.get(tile).id();
						notFound = false;
					}
				}
			}
		}
	}
	public void solveRemaining() {
		for(int i = 0; i < rows(); ++i)
			new PuzzleThread(i).start();
	}
	public PuzzleTile tile(int row, int column) {
		return tilesOrdered.get(row * columns() + column);
	}
	public String toString() {
		StringBuilder aux = new StringBuilder();
		for(int r = 0; r < rows(); r++) {
		  aux.append(System.getProperty("line.separator"));
		  for(int c = 0; c < columns(); c++) {
			  aux.append(tile(r, c).character());
			  aux.append(" ");
		  }
	  }
	  aux.append(System.getProperty("line.separator") + System.getProperty("line.separator"));
	  aux.append(rows());
	  aux.append(" ");
	  aux.append(columns());
	  return aux.toString();
	}
}