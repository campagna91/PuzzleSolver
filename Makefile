Prima_consegna: PuzzleSolver

PuzzleSolver: PuzzleSolver.class

PuzzleSolver.class: PuzzleUnsolved.class PuzzleSolved.class	Puzzle.class PuzzleReader.class	PuzzleWriter.class
	@echo 'caricamento di PuzzleSolver'
	@javac PuzzleSolver.java
PuzzleUnsolved.class:
	@echo 'caricamento di PuzzleUnsolved'
	@javac puzzleObject/PuzzleUnsolved.java
Puzzle.class:
	@echo 'caricamento di Puzzle'
	@javac puzzleObject/Puzzle.java
PuzzleTile.class:
	@echo 'caricamento di PuzzleTile'
	@javac puzzleObject/PuzzleTile.java
PuzzleSolved.class:
	@echo 'caricamento di PuzzleSolved'
	@javac puzzleObject/PuzzleSolved.java
PuzzleReader.class:
	@echo 'caricamento di PuzzleReader'
	@javac puzzleIO/PuzzleReader.java
PuzzleWriter.class:
	@echo 'caricamento di PuzzlewWriter'
	@javac puzzleIO/PuzzleWriter.java
clean:
	@echo 'Eliminazione file principali'
	@rm -f *.class 
	@echo 'Eliminazione file puzzleObject'
	@rm -f puzzleObject/*.class 
	@echo 'Eliminazione file puzzleIO'
	@rm -f puzzleIO/*.class 
	@echo 'File correttamente eliminati'
						
