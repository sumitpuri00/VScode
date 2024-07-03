import java.lang.reflect.Array;
import java.util.Arrays;

public class Arra {
          static void subArray(){
                    
                    int arr[]={2,4,6,8,10};
                    for(int i=0;i<arr.length;i++){
                              for(int j=i;j<arr.length;j++){
                                        for(int k=i;k<j+1;k++){
                                                  System.out.print(arr[k]+" ");
                                        }
                                        System.out.println();
                              }
                              System.out.println();
                   }
          }
          static void maxSumSubArray(){
                    int max=0;
                    int arr[]={4,-5,2,-6,33-12};
                    for(int i=0;i<arr.length;i++){
                              for(int j=i;j<arr.length;j++){
                                        int cur=0;
                                        for(int k=i;k<j+1;k++){
                                                  System.out.print(arr[k]+" ");
                                                  cur=cur+arr[k];
                                        }
                                        if (cur>max) {
                                                  max=cur;
                                        }
                                        System.out.print("sum="+cur);
                                        System.out.println();
                              }
                              System.out.println();
                   }
                   System.out.println(max);
                    
                    
          }
          static void prefixSum(){
                     
                    int arr[]={1,2,1};
                    int prefixArr[]=new int[arr.length];
                    int max=Integer.MIN_VALUE;


                    for(int i=0;i<arr.length;i++){
                              if(i==0){
                                        prefixArr[i]=arr[i];
                              }else{
                                        prefixArr[i]=prefixArr[i-1]+arr[i];
                              }

                    }
                    
                    System.out.println(Arrays.toString(prefixArr));
                    for(int i=0;i<arr.length;i++){
                              for(int j=i;j<arr.length;j++){

                                        int cur= i==0? prefixArr[j]:prefixArr[j]-prefixArr[i-1];
                                        
                                        if (cur>max) {
                                                  max=cur;
                                        }
                              }
                             
                   }
                   System.out.println(max);
          }
          static void kadaneAlgo(){
                    int arr[]={-2,-3,4,-1,-2,1,5,-3};
                    int maxSum=Integer.MIN_VALUE;
                    int curr=0;
                    for(int i=0;i<arr.length;i++){
                              curr=curr+arr[i];
                              maxSum=Math.max(curr, maxSum);
                              if (curr<0) {
                                        curr=0;
                              } 
                             
                    }
                    System.out.println("max sum is "+maxSum);
          }
          static void trappingRainWater(){
                    int buildingHeight[]={4,2,0,6,3,2,5};

                    int left[]=new int[buildingHeight.length];
                    int right[]=new int[buildingHeight.length];

                    // auxiliary array left boundary;
                    for(int i=0;i<buildingHeight.length;i++){
                              if (i==0) {
                                        left[i]=buildingHeight[i];
                                        
                              }else{
                                        if (buildingHeight[i]>left[i-1]) {
                                                  left[i]=buildingHeight[i];

                                        }else{
                                                  left[i]=left[i-1];
                                        }
                              }
                              

                    }

                    // auxiliary array for right boundary;
                    for(int j=buildingHeight.length-1;j>=0;j--){
                              if (j==buildingHeight.length-1) {
                                        right[j]=buildingHeight[j];
                              }else{
                                        if (buildingHeight[j]>right[j+1]) {
                                                  right[j]=buildingHeight[j];
                                        }else{
                                                  right[j]=right[j+1];
                                        }
                              }
                    }
                    // calculating the water level;
                    int trapperWater=0;
                    for(int i=0;i<buildingHeight.length;i++){
                              int waterLevel=Math.min(left[i], right[i]);
                              trapperWater+=(waterLevel-buildingHeight[i]);
                    }
               
                    // System.out.print(Arrays.toString(right));
                    System.out.println(trapperWater);
          }
          static void spiralMatrix(){
                    int matrix[][]={
                              {2,4,9,4},
                              {6,5,9,7},
                              {6,1,3,1},
                              {1,2,3,8}
                    };
                    int rowStart=0;
                    int rowEnd=matrix.length-1;
                    int columnStart=0;
                    int columnEnd=matrix[0].length-1;

                    while (rowStart<=rowEnd && columnStart<=columnEnd) {
                              // upper
                              for(int i=columnStart;i<=columnEnd;i++){
                                        System.out.print(matrix[rowStart][i]);
                              }
                              // right
                              for(int j=rowStart+1;j<=rowEnd;j++){
                                        System.out.print(matrix[j][columnEnd]);
                              }
                              // bottom
                              for(int k=columnEnd-1;k>=columnStart;k--){
                                        System.out.print(matrix[rowEnd][k]);
                              }
                              // left
                              for(int l=rowEnd-1;l>=rowStart+1;l--){
                                        System.out.print(matrix[l][columnStart]);
                              }
                              rowStart++;
                              rowEnd--;
                              columnStart++;
                              columnEnd--;
                    }


          }
          static void diagonalSum(){
                    int matrix[][]={
                              {1,2,3,4},
                              {5,6,7,8},
                              {9,10,11,12},
                              {13,14,15,16}
                    };
                    int firstDiagonal=0;
                    int secondDiagonal=0;

                    int j=matrix[0].length-1;
                    for(int i=0;i<matrix.length;i++){
                              firstDiagonal+=matrix[i][i];
                              secondDiagonal+=matrix[i][j];
                              j--;


                    }
                     
                    System.out.println(firstDiagonal+secondDiagonal);
          }
          static boolean staircaseSearch(){
                    int martix[][]={
                              {10,20,30,40},
                              {15,25,35,45},
                              {27,29,37,48},
                              {32,33,39,50}
                    };
                    int key=10;

                    int row=0;
                    int columnEnd=martix[0].length-1;
                    while (row<=martix.length && columnEnd>=0) {
                              if(key==martix[row][columnEnd]){
                                        System.out.println("found key at index "+row+" "+columnEnd);
                                        return true;
                              }
                              else if (key<martix[row][columnEnd]) {
                                        columnEnd--;
                              }else{
                                        row++;
                              }
                              
                    }
                    System.out.println("key is not present");
                    return false;
                    
          }
          public static void main(String[] args) {
                    // staircaseSearch();

          } 
}
