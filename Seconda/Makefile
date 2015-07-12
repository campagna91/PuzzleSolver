Prima_consegna: PuzzleSolver
	
PuzzleSolver: PuzzleSolver.class

PuzzleSolver.class: PuzzleSolved.class	Puzzle.class PuzzleReader.class	PuzzleWriter.class
	@echo 'Caricamento di PuzzleSolver'
	@javac PuzzleSolver.java
Puzzle.class:
	@echo 'Caricamento di Puzzle'
	@javac puzzleObject/Puzzle.java
PuzzleTile.class:
	@echo 'Caricamento di PuzzleTile'
	@javac puzzleObject/PuzzleTile.java
PuzzleSolved.class:
	@echo 'Caricamento di PuzzleSolved'
	@javac puzzleObject/PuzzleSolved.java
PuzzleReader.class:
	@echo 'Caricamento di PuzzleReader'
	@javac puzzleIO/PuzzleReader.java
PuzzleWriter.class:
	@echo 'Caricamento di PuzzlewWriter'
	@javac puzzleIO/PuzzleWriter.java
clean:
	@echo 'Eliminazione file principali'
	@rm -f *.class 
	@echo 'Eliminazione file puzzleObject'
	@rm -f puzzleObject/*.class 
	@echo 'Eliminazione file puzzleIO'
	@rm -f puzzleIO/*.class 
	@echo 'File correttamente eliminati'
						
