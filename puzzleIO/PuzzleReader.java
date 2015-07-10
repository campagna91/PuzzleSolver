package puzzleIO;

import puzzleObject.Puzzle;
import puzzleObject.PuzzleTile;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class PuzzleReader {

	public PuzzleReader() {

	}	
	public void loadPuzzle(Puzzle puzzle, String file) {
		BufferedReader in = null;
		int cols = 0, rows = 0;

		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String line = null;
			while( (line = in.readLine()) != null) {
				String[] tiles = line.split("\\ ");
				PuzzleTile tile = new PuzzleTile(tiles);
				if(tile.getTop().equals("VUOTO"))
					cols++;
				if(tile.getLeft().equals("VUOTO"))
					rows++;
				puzzle.push(tile);
			}
			puzzle.setNumCols(cols);
			puzzle.setNumRows(rows);
		} 
		catch(IOException e) {
			System.out.println("Errore durante la lettura del file");
			e.printStackTrace();
		}
		finally {
			try {
				if(in != null)
					in.close();
			}
			catch(IOException e) {
				System.out.println("Errore durante la chiusura del file in lettura");
				e.printStackTrace();
			}
		}
		
	}
}