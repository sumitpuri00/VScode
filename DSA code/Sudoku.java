import java.util.Arrays;

class Test {
          static int count;
          
          static void print(char board[][]){
                    System.out.println("-------chess------");
                    for(int i=0;i<board.length;i++){
                              for(int j=0; j<board[0].length; j++){
                                        System.out.print(" "+ board[i][j]+ " ");
                              }
                              System.out.println();
                    }
                   
          }
          static boolean nQueen(char board[][],int row){
                    if (row==board.length) {
                            //   print(board);
                              count++;
                              return true;
                    }
                    for(int j=0;j<board[0].length;j++){
                             if(isSafe(board, row, j)) {
                                        board[row][j]='Q';
                                        if(nQueen(board, row+1)){
                                            return true;
                                        }else{
                                            board[row][j]='X';
                                        }
                                        
                             }
                    }
                    
                    return false;
          }

          static boolean isSafe(char board[][], int row, int column){
                    // for upside;
                    for(int i=row-1;i>=0;i--){
                              if (board[i][column]=='Q') {
                                        return false;
                                        
                              }
                    }

                    // for left diagonal;
                    for(int i=row-1, j=column-1; i>=0 && j>=0 ; i-- ,j--){
                              if (board[i][j--]=='Q') {
                                        return false;
                              }

                    }

                    // for right diagonal
                    for(int i=row-1, j=column+1; i>=0 && j<=board[0].length-1; i--,j++){
                              if (board[i][j]=='Q') {
                                        return false;
                              }
                    }


                    return true;
          }
          
          
          public static void main(String[] args) {
                    int n=4;
                    char board[][]=new char[n][n];

                    // filling the values inside the matrix
                    for(int i=0; i<board.length;i++){
                              for(int j=0; j<board[0].length; j++){
                                        board[i][j]='X';
                              }
                    }

                    if(nQueen(board, 0)){
                        print(board);
                    }else{
                        System.out.println("solution is not possible");
                    }
                    System.out.println(count);
                  
                   
                    

          }
}
// Java program for above approach
public class Sudoku {

	// N is the size of the 2D matrix N*N
	static int N = 9;

	/* Takes a partially filled-in grid and attempts
	to assign values to all unassigned locations in
	such a way to meet the requirements for
	Sudoku solution (non-duplication across rows,
	columns, and boxes) */
	static boolean solveSudoku(int grid[][], int row,int col)
	{

		/*if we have reached the 8th
		row and 9th column (0
		indexed matrix) ,
		we are returning true to avoid further
		backtracking	 */
		if (row == N - 1 && col == N)
			return true;

		// Check if column value becomes 9 ,
		// we move to next row
		// and column start from 0
		if (col == N) {
			row++;
			col = 0;
		}

		// Check if the current position
		// of the grid already
		// contains value >0, we iterate
		// for next column
		if (grid[row][col] != 0)
			return solveSudoku(grid, row, col + 1);

		for (int num = 1; num < 10; num++) {

			// Check if it is safe to place
			// the num (1-9) in the
			// given row ,col ->we move to next column
			if (isSafe(grid, row, col, num)) {

				/* assigning the num in the current
				(row,col) position of the grid and
				assuming our assigned num in the position
				is correct */
				grid[row][col] = num;

				// Checking for next
				// possibility with next column
				if (solveSudoku(grid, row, col + 1))
					return true;
			}
			/* removing the assigned num , since our
			assumption was wrong , and we go for next
			assumption with diff num value */
			grid[row][col] = 0;
		}
		return false;
	}

	/* A utility function to print grid */
	static void print(int[][] grid)
	{
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
	}

	// Check whether it will be legal
	// to assign num to the
	// given row, col
	static boolean isSafe(int[][] grid, int row, int col,
						int num)
	{

		// Check if we find the same num
		// in the similar row , we
		// return false
		for (int x = 0; x <= 8; x++)
			if (grid[row][x] == num)
				return false;

		// Check if we find the same num
		// in the similar column ,
		// we return false
		for (int x = 0; x <= 8; x++)
			if (grid[x][col] == num)
				return false;

		// Check if we find the same num
		// in the particular 3*3
		// matrix, we return false
		int startRow = row - row % 3, startCol
									= col - col % 3;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (grid[i + startRow][j + startCol] == num)
					return false;

		return true;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
						{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
						{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
						{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
						{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
						{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
						{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		if (solveSudoku(grid, 0, 0))
			print(grid);
		else
			System.out.println("No Solution exists");
	}
	// This is code is contributed by Pradeep Mondal P
}
