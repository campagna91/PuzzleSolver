package puzzleIO;

import puzzleObject.Puzzle;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PuzzleWriter {
	BufferedWriter writer = null;

	public void write(Puzzle puzzle, String outputFile, boolean append) {

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile, append), "utf-8"));
		 	writer.write(puzzle.toString());
		} 
		catch (IOException ex) {	
	  	ex.printStackTrace();
		}
		finally {
			try {
				if( writer != null)
					writer.close();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void close() {
		
	}
}