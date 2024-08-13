import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
class IndianCoin{
    
    public static void main(String[] args) {
        int target=220;
        Integer arr[]=new Integer[]{1,2,5,10,20,50,100,500,1000};
        ArrayList<Integer> result=new ArrayList<>();
        Arrays.sort(arr, Comparator.reverseOrder()); 
        for(int i=0;i<arr.length;i++){
            
           
        }
        
         
        System.out.println(result);
    }
    
}         


class ChainOfPair{
          class Solution {
                    public int findLongestChain(int[][] pairs) {
                        Arrays.sort(pairs, Comparator.comparingDouble(o-> o[1]));
                        System.out.println(Arrays.deepToString(pairs));
                        int count=1;
                        int b=pairs[0][1];
                              
                        for(int i=1; i<pairs.length;i++){
                              if (b<pairs[i][0]) {
                                        b=pairs[i][1];
                                        count++;
                              }
                        }
                        return count;
                    }
                     
          }
          public static void main(String[] args) {
                    // int arr[][]=new int[][]{{5,24},{39,60},{5,28},{27,40},{50,90}};
                    // int arr[][]=new int[][]{{1,2},{7,8},{4,5}};
                    // int arr[][]=new int[][]{{1,2},{2,3},{3,4}};
                    int[][] arr = {
                              {-6, 9},
                              {1, 6},
                              {8, 10},
                              {-1, 4},
                              {-6, -2},
                              {-9, 8},
                              {-5, 3},
                              {0, 3}
                          };

                    ChainOfPair chainObj=new ChainOfPair();
                    ChainOfPair.Solution solObj=chainObj.new Solution();
                    System.out.println(solObj.findLongestChain(arr));
 
          }
}

class ActivitySelection{
          public static void main(String[] args) {
                    int startArr[]={1,3,0,5,8,5};
                    int endArr[]={2,4,6,7,9,9};
                    int totalActivity=1;
                    int tempEndtime=0;
                    for(int i=1;i<endArr.length;i++){
                              if (tempEndtime<=startArr[i]) {
                                        totalActivity++ ;
                                        tempEndtime=endArr[i] ;
                              }
                    }
                    System.out.println(totalActivity);
          }
}
class GreedyAproach {
          public static void main(String[] args) {
                    System.out.println("Question related to greedy approach ;");
                    int arr[][]={{2,4},{5,7},{3,5}};
                    System.out.println(arr[0].length);
                    int arr[]={3,5,2,43,5};
                    Arrays.sort(arr);
                    System.out.println();

          }
}
