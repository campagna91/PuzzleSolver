package server.puzzleObject;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import common.Solvable;
import common.Puzzle;
import common.PuzzleSolved;
import common.PuzzleTile;
import common.PuzzleUnsolved;

public class Solver extends UnicastRemoteObject implements Solvable {
	private ArrayList<PuzzleTile> tilesOrdered = new ArrayList<PuzzleTile>();
	private ArrayList<PuzzleTile> tiles = new ArrayList<PuzzleTile>();
	private int rows = 0, columns = 0;
	public Solver() throws RemoteException {

	}
	public class PuzzleThread extends Thread {
		public int row;

		public PuzzleThread(int row) {
			this.row = row;
		}
		public void run() {		
			for(int c = 0; c < columns; ++c) {
				boolean notFound = true;
				for(int tile = 0; tile < tiles.size() && notFound; ++tile) {
					if(tiles.get(tile).left().equals(tilesOrdered.get(row * columns + c))) {
						tilesOrdered.add(row * columns + c, tiles.get(tile));
						notFound = false;
					}
				}
			}	
		}
	}
	public PuzzleSolved solve(PuzzleUnsolved puzzle)  {
		rows = puzzle.rows();
		columns = puzzle.columns();
		tiles.addAll(puzzle.tiles());
		tilesOrdered.addAll(puzzle.tiles());

		solveFirstColumn();
		solveRemaining();

		PuzzleSolved aux = new PuzzleSolved();
		aux.tiles().addAll(tiles);
		aux.setRows(rows);
		aux.setColumns(columns);
		return aux;
	}
	public void solveFirstColumn() {
		String top = "VUOTO";
		for(int r = 0; r < rows; ++r) {
			boolean notFound = true;
			for(int tile = 0; tile < tiles.size() && notFound; ++tile) {
				if(tiles.get(tile).left().equals("VUOTO")) {
					if(tiles.get(tile).top().equals(top)) {
						tilesOrdered.set(r * columns, tiles.get(tile));
						top = tiles.get(tile).id();
						notFound = false;
					}
				}
			}
		}
	}
	public void solveRemaining() {
		for(int i = 0; i < rows; ++i)
			new PuzzleThread(i).start();
	}
	
}