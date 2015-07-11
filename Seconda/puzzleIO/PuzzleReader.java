package puzzleIO;

import puzzleObject.Puzzle;
import puzzleObject.PuzzleTile;

import java.util.Arrays;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;

public class PuzzleReader {
	
	public void read(Puzzle puzzle, String inputFile) {
		BufferedReader in = null;
		int cols = 0, rows = 0;

		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile),"UTF-8"));
			String line = null;
			while( (line = in.readLine()) != null) {
				String[] tiles = line.split("\\ ");

				try {					
					String[] tokens = line.split("\\	");
					PuzzleTile tile = new PuzzleTile(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
					if(tile.top().equals("VUOTO"))
						cols++;
					if(tile.left().equals("VUOTO"))
						rows++;
					puzzle.addTile(tile);
				}
				catch(ArrayIndexOutOfBoundsException o) {
					System.out.println("Il puzzle di ingresso non è correttamente formattato");
					System.exit(1);
				}
			}
			puzzle.setColumns(cols);
			puzzle.setRows(rows);
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