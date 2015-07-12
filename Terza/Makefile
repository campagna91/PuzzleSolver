Terza: exec

exec: server common client

server: serverPuzzleSolver serverPuzzleSolved

common: commonPuzzle commonPuzzleTile commonSolvable

client: clientPuzzleSolver clientPuzzleReader clientPuzzleWriter clientPuzzleUnsolved

# Server dependencies

serverPuzzleSolver:
	@echo 'Caricamento Server-PuzzleSolver'
	@javac server/PuzzleSolver.java
serverPuzzleSolved:
	@echo 'Caricamento Server-PuzzleSolved'
	@javac server/puzzleObject/PuzzleSolved.java

# Common dependecies

commonPuzzle:
	@echo 'Caricamento Common-Puzzle'
	@javac common/Puzzle.java
commonPuzzleTile:
	@echo 'Caricamento Common-PuzzleTile'
	@javac common/PuzzleTile.java
commonSolvable:
	@echo 'Caricamento Common-Solvable'
	@javac common/Solvable.java

# Client dependencies

clientPuzzleSolver:
	@echo 'Caricamento Client-PuzzleSolver'
	@javac client/PuzzleSolver.java
clientPuzzleReader:
	@echo 'Caricamento Client-PuzzleReader'
	@javac client/puzzleIO/PuzzleReader.java
clientPuzzleWriter:
	@echo 'Caricamento Client-PuzzleWriter'
	@javac client/puzzleIO/PuzzleWriter.java
clientPuzzleUnsolved:
	@echo 'Caricamento Client-PuzzleUnsolved'
	@javac client/puzzleObject/PuzzleUnsolved.java

# Clean
clean:
	rm -f *.class
	rm -f client/*.class
	rm -f client/puzzleIO/*.class
	rm -f client/puzzleObject/*.class
	rm -f server/*.class
	rm -f server/puzzleObject/*class
