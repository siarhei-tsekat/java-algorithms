package graph;

public class TMp {
    public static void main(String[] args) {
        System.out.println(new S_olution().exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "cdba"));
    }
}

class S_olution {
    boolean visited[][];

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {

                    if (f(board, i, j, word, 0)) return true;
                    visited = new boolean[board.length][board[0].length];
                }
            }
        }
        return false;
    }

    public boolean f(char[][] board, int row, int col, String word, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || index >= word.length())
            return false;
        if(visited[row][col]) return false;
        visited[row][col] = true;
        if (board[row][col] != word.charAt(index)) return false;
        if (index == word.length() - 1 && board[row][col] == word.charAt(index))
            return true;


        if (f(board, row + 1, col, word, index + 1)) return true;
        visited[row][col] = false;
        if (f(board, row - 1, col, word, index + 1)) return true;
        visited[row][col] = false;
        if (f(board, row, col + 1, word, index + 1)) return true;
        visited[row][col] = false;
        if (f(board, row, col - 1, word, index + 1)) return true;
        visited[row][col] = false;
        return false;
    }
}
