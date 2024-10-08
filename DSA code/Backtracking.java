import java.util.Arrays;

public class Backtracking {
          static int count;
          static void arrBacktrack(int arr[],int i){
                    if (i==arr.length) {
                              System.out.println(Arrays.toString(arr));
                              return;
                    }
                    arr[i]=i+1;
                    arrBacktrack(arr, i+1);

                    arr[i]=arr[i]-2;
          }

          static void subsetBacktrack(String str,String sb,int i){
                    if (i==str.length()) {
                              System.out.println(sb);
                              return;
                    }
                    subsetBacktrack(str, sb+str.charAt(i), i+1);
                    subsetBacktrack(str, sb, i+1);
          }
          static void permutation(String str,String ans){
                    if (str.length() == 0) {
                              System.out.println(ans);
                              return;
                    }
                    for(int i=0;i<str.length();i++){
                              char curr=str.charAt(i);
                              String newStr=str.replace(Character.toString(str.charAt(i)), "");
                              permutation(newStr, ans+curr);
                    }



          }
          
          static void print(char board[][]){
                    System.out.println("-------chess------");
                    for(int i=0;i<board.length;i++){
                              for(int j=0; j<board[0].length; j++){
                                        System.out.print(" "+ board[i][j]+ " ");
                              }
                              System.out.println();
                    }
                   
          }
          static void nQueen(char board[][],int row){
                    if (row==board.length) {
                              print(board);
                              count++;
                              return;
                    }
                    for(int j=0;j<board[0].length;j++){
                             if(isSafe(board, row, j)) {
                                        board[row][j]='Q';
                                        nQueen(board, row+1);
                                        board[row][j]='X';
                             }
                    }
                    
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
                              if (board[i][j]=='Q') {
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
          
          static int grifWays(int i,int j,int row,int coloum){
                    if (i==row-1 && j==coloum-1) {
                              return 1 ;
                    }else if(i==row || j==coloum){
                              return 0;
                    }

                    int down=grifWays(i+1,j, row, coloum);
                    int right=grifWays(i,j+1, row, coloum);
                    int result=down+right;

                    return result ;
          }
          static void sudokuSolver(int sudoku[][], int row ,int column){
                    
                    int newRow=row;
                    int newColumn=column+1;
                    if (newColumn==9) {
                              newRow=row+1;
                              newColumn=0;
                    }
                    // work
                    for(int digit=1; digit<=9; digit++){
                              
                              if (isSafeForSudoku(sudoku,row,column,digit)) {
                                        sudoku[row][column]=digit;
                                        sudokuSolver(sudoku, newRow, newColumn);
                                        sudoku[row][column]=0;
                              }
                    }
          }
           
          
          public static void main(String[] args) {
                    int[][] b = 
                                        {{ 7, 0, 0, 0, 0, 0, 2, 0, 0 },   
                                        { 4, 0, 2, 0, 0, 0, 0, 0, 3 },   
                                        { 0, 0, 0, 2, 0, 1, 0, 0, 0 },   
                                        { 3, 0, 0, 1, 8, 0, 0, 9, 7 },   
                                        { 0, 0, 9, 0, 7, 0, 6, 0, 0 },   
                                        { 6, 5, 0, 0, 3, 2, 0, 0, 1 },   
                                        { 0, 0, 0, 4, 0, 9, 0, 0, 0 },   
                                        { 5, 0, 0, 0, 0, 0, 1, 0, 6 },   
                                        { 0, 0, 6, 0, 0, 0, 0, 0, 8 }
                              } ; 

                    
                              System.out.println(Arrays.deepToString(b));
                    // System.out.println(grifWays(0, 0, 3, 3));

                    // permutation("abc",  "");
                    int n=4;
                    char board[][]=new char[n][n];

                    // filling the values inside the matrix
                    for(int i=0; i<board.length;i++){
                              for(int j=0; j<board[0].length; j++){
                                        board[i][j]='X';
                              }
                    }

                    // nQueen(board, 0);
                    // System.out.println(count);

  
                   
                    

          }
}
 