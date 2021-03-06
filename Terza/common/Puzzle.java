package common;

import java.util.ArrayList;
import java.io.Serializable;
import common.Solvable;
import common.PuzzleTile;

public abstract class Puzzle implements Serializable {

	private int rows = 0, columns = 0;
	protected ArrayList<PuzzleTile> tiles = new ArrayList<PuzzleTile>();

	public Puzzle() {
	}
	public int rows(){
		return rows;
	}
	public int columns(){
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void addTile(PuzzleTile t) {
		tiles.add(t);
	}
	protected PuzzleTile tile(int row, int column) {
		return tiles.get(row * columns + column);
	}
	public ArrayList<PuzzleTile> tiles() {
		return tiles;
	}
	public abstract String toString();	
}