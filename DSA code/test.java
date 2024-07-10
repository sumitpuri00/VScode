class Test {
          static int count = 0;
      
          // Function to print the board
          static void printBoard(char[][] board) {
              System.out.println("------- Chess Board -------");
              for (int i = 0; i < board.length; i++) {
                  for (int j = 0; j < board[0].length; j++) {
                      System.out.print(" " + board[i][j] + " ");
                  }
                  System.out.println();
              }
              System.out.println();
          }
      
          // Function to solve N-Queens problem
          static void solveNQueens(char[][] board, int row) {
              // If all queens are placed, print the board and increment count
              if (row == board.length) {
                  printBoard(board);
                  count++;
                  return;
              }
      
              // Try placing a queen in each column of the current row
              for (int j = 0; j < board[0].length; j++) {
                  if (isSafe(board, row, j)) {
                      board[row][j] = 'Q'; // Place queen
                      solveNQueens(board, row + 1); // Recur to place rest of the queens
                      board[row][j] = 'X'; // Backtrack and remove queen
                  }
              }
          }
      
          // Function to check if it's safe to place a queen at board[row][column]
          static boolean isSafe(char[][] board, int row, int column) {
              // Check for queens in the same column
              for (int i = row - 1; i >= 0; i--) {
                  if (board[i][column] == 'Q') {
                      return false;
                  }
              }
      
              // Check for queens in the left diagonal
              for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
                  if (board[i][j] == 'Q') {
                      return false;
                  }
              }
      
              // Check for queens in the right diagonal
              for (int i = row - 1, j = column + 1; i >= 0 && j < board[0].length; i--, j++) {
                  if (board[i][j] == 'Q') {
                      return false;
                  }
              }
      
              return true; // Safe to place a queen
          }
      
          public static void main(String[] args) {
              int n = 5; // Size of the board (NxN)
              char[][] board = new char[n][n];
      
              // Initialize the board with 'X'
              for (int i = 0; i < board.length; i++) {
                  for (int j = 0; j < board[0].length; j++) {
                      board[i][j] = 'X';
                  }
              }
      
              // Solve the N-Queens problem
              solveNQueens(board, 0);
              System.out.println("Total solutions: " + count);
          }
      }
      