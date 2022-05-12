/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku.computationlogic;

import java.util.Random;


import static sudoku.problemdomain.SudokuGame.GRID_BOUNDARY;
/**
 *
 * @author Yohanne Angelo Suba
 */
public class GameGenerator {
    public static int[][] getNewGameGrid() {
        return unsolvedgame(getSolvedGame());
    }
    private static int[][] unsolved(int[][] solvedGame) {
        Random random = new Random(System.currentTimeMillis());
        
        boolean solvable = false;
        int[][] solvableArray =new int[GRID_BOUNDARY][GRID_BOUNDARY];
        
        while (solvable == false){
            SudokuUtilities.copySudokuArrayValues(solvedGame, solvableArray);
            
            int index = 0;
            
            while (index <40) {
                int xCoordinate = random.nextInt(GRID_BOUNDARY);
                int yCoordinate = random.nextInt(GRID_BOUNDARY); 
                
                if(solvableArray[xCoordinate][yCoordinate] != 0{
                    solvableArray[xCoordinate][yCoordiante] = 0;
                    index++;
                }
            }
            
            int[][] toBeSolved = new Int[GRID_BOUNDARY][GRID_BOUNDARY];
            SudokuUtilities.copySudokuArrayValues(solvableArray, toBeSovled);
            
            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);
            
            
        }
                
        return solvableArray;
        
    }    
    public static int[][] getSolvedGame(){
    Random random = new Random(System.currentTimeMillis());
    int[][] newGrid = new Int[GRID_BOUNDARY][GRID_BOUNDARY];
    
    for(int value = 1; value <= GRID_BOUNDARY; value++) {
        int allocations = 0;
        int interrupt = 0;
        
        List<Coordinates>allocTracker = ArrayList<>();
        
        int attempts = 0;
        
        while (allocations < GRID_BOUNDARY) {
            if (interrupt > 200) {
                allocTracker.forEach(coord -> {
                    newGrid[coord.getX()[coord.getY()] = 0;
                });
                
                interrupt = 0;
                allocations =0;
                alloctracker.clear();
                attempts++;
                
                if(attempts > 500) {
                    clearArray(newGrid);
                    attempts = 0;
                    value = 1;
                }
            }
            
            int xCoordinate = random.nextInt(GRID_BOUNDARY);
            int yCoordinate = random.nextInt(GRID_BOUNDARY);
            
            if (newGrid[xCoordinate][yCoordinate] == 0){
                newGrid[xCoordinate][yCoordinate] = value;
                
                if(GameLogic.sudokuIsInvalid(newGrid)) {
                    newGrid[xCoordinate][yCoordinate] = 0;
                    interrupt++;
                     
                } else {
                    allocTracker.add(new Coordinates(xCordinates, yCoordinate));
                    allocations++;
                }
            }
        }
    }
        
    return newGrid;
    
}
    private static void clearArray(int[][] newGrid){
        for(int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++){
            for (int yIndex = 0; yIndex <GRID_BOUNDARY; yIndex++){
                newGrid[xIndex][yIndex] =0;
            }
        }
    }
