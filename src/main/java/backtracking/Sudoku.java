package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {
    int [][] firstArea = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    int [][] secondArea = {{0,3},{0,4},{0,5},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5}};
    int [][] thirdArea = {{0,6},{0,7},{0,8},{1,6},{1,7},{1,8},{2,6},{2,7},{2,8}};
    int [][] fourthArea = {{3,0},{3,1},{3,2},{4,0},{4,1},{4,2},{5,0},{5,1},{5,2}};
    int [][] fifthArea = {{4,4},{4,5},{4,6},{4,0},{4,1},{4,2},{5,0},{5,1},{5,2}};
    public void solveSudoku(char[][] board) {

        func(board, 0, 0);
    }

    private void func(char[][] board, int row, int col) {

        List<Character> availRows = getRowValues(board, row);
        List<Character> availCol = getColValues(board, col);
        List<Character> availArea = getAreaValues(board, row, col);

    }

    private List<Character> getAreaValues(char[][] board, int row, int col) {
        List<Character> res = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> avail = new ArrayList<>(res);

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != '.')
                avail.remove((Character) board[i][col]);
        }
        return avail;
    }

    private List<Character> getColValues(char[][] board, int col) {
        List<Character> res = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> avail = new ArrayList<>(res);

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != '.')
                avail.remove((Character) board[i][col]);
        }
        return avail;
    }

    private List<Character> getRowValues(char[][] board, int row) {
        List<Character> res = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> avail = new ArrayList<>(res);

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != '.')
                avail.remove((Character) board[row][i]);
        }
        return avail;
    }
}

class R__unner {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Sudoku sudoku = new Sudoku();
        sudoku.solveSudoku(board);

        char[][] exp = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};

        System.out.println(verify(board, exp));
    }

    private static List<String> verify(char[][] actual, char[][] exp) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < actual.length; i++) {
            if (Arrays.equals(actual[i], exp[i]) == false)
                res.add("\n" + "Actual: " + Arrays.toString(actual[i]) + ". Expc: " + Arrays.toString(exp[i]));
        }
        return res;
    }
}
