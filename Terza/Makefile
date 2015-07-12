Terza: exec

exec: server common client

server: serverPuzzleSolver serverSolver

common: commonPuzzle commonPuzzleTile commonSolvable commonPuzzleSolved commonPuzzleUnsolved

client: clientPuzzleSolver clientPuzzleReader clientPuzzleWriter

# Server dependencies

serverPuzzleSolver:
	@echo 'Caricamento Server-PuzzleSolver'
	@javac server/PuzzleSolver.java
serverPuzzleSolved:
	@echo 'Caricamento Server-PuzzleSolved'
	@javac server/puzzleObject/PuzzleSolved.java
serverSolver:
	@echo 'Caricamento Server-Solver'
	@javac server/puzzleObject/Solver.java
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
commonPuzzleSolved:
	@echo 'Caricamento Common-PuzzleSolved'
	@javac common/PuzzleSolved.java
commonPuzzleUnsolved:
	@echo 'Caricamento Common-PuzzleUnsolved'
	@javac common/PuzzleUnsolved.java

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

# Clean
clean:
	rm -f *.class
	rm -f client/*.class
	rm -f client/puzzleIO/*.class
	rm -f client/puzzleObject/*.class
	rm -f server/*.class
	rm -f server/puzzleObject/*class
	rm -f common/*.class
