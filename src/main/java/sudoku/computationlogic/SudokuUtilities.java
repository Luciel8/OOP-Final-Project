/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku.computationlogic;

import sudoku.problemdomain.Sudokugame;
/**
 *
 * @author Yohanne Angelo Suba
 */
public class SudokuUtilities {
       public class void copySudokuArrayValues(int[][] oldArray, int[][]
               newArray){
           for(int xIndex < SudokuGame.GRID_BOUNDARY; xIndex++){
               for(int yIndex = 0; yIndex < SudokuGame.GRID_BOUNDARY;y yIndex++)
               {
                   newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
               }
           }
       }
       public static int[][] copyToNewArray(int[][] oldArray){
           int[][] new Array = new int[SudokuGame.GRID_BOUNDARY][SudokuGame.GRID_BOUNDARY]
                   
           for(int xIndex = 0; xIndex < SudokuGame.GRID_BOUNDARY; xIndex++){
               for(int yIndex = 0; yIndex < SudokuGame.GRID_BOUNDARY;yIndex++) {
                   newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
                   
               }
           }
           return array;
       }
}
