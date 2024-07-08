import java.util.Arrays; 
public class Resursion {
          static int print(int num){
                    if (num==1) {
                              return 1;
                    }
                    System.out.println(num);
                    return  print(num-1);
          }
          static int factorial(int num){
                    if (num==1) {
                              return 1;
                    }
                    return num*factorial(num-1);
          }
          static int fibonacchi(int num){
                    
                    if (num <= 0) {
                              return 0;
                          
                    } else if (num == 1) {
                              return 1;
                          
                    }
                    return fibonacchi(num - 1) + fibonacchi(num - 2);
          }
          static boolean isArrSorted(int i,int arr[]){
                   
                    if (i==arr.length-1) {
                              return true;
                    }
                    if (arr[i]>arr[i+1]) {
                              return  false;
                    }
                    
                    return isArrSorted(i+1,arr);
          }
          static int arrIndex(int i,int arr[],int key){
                    if (i==arr.length) {
                              System.out.println("no key was there");
                              return -1;
                    }
                    if (arr[i]==key) {
                              return i;
                    }
                    return arrIndex(i+1, arr, key);
          }
          static int lastArrIndex(int i,int arr[],int key){
                    if (i==arr.length){
                              return -1;
                    }
                    int ntiveOne=lastArrIndex(i+1, arr, key);
                    
                    if (arr[i]==key && ntiveOne==-1) {
                              return i;
                    }
                    return  ntiveOne;
          }
          
          static int power(int x,int power){
                    if (power==1) {
                              return x;
                              
                    }
                    return x*power(x,power-1);
          }
          static void removeDublicateChar(String string,StringBuilder sb,boolean mapArr[],int index){
                    if (index==string.length()) {
                              System.out.println(sb);
                              return;
                    }
                    if (mapArr[string.charAt(index)-'a']==false) {
                              mapArr[string.charAt(index)-'a']=true;
                              removeDublicateChar(string, sb.append(string.charAt(index)),mapArr, index+1);
                              
                    }else{
                              removeDublicateChar(string, sb, mapArr, index+1);
                    }

          }
          static void mergSort(int si,int ei,int arr[]){
                    if(si>=ei){
                              return;
                    }
                    int mid=si+(ei-si)/2;
                    mergSort(si, mid, arr);
                    mergSort(mid+1, ei, arr);

                    merg(si, ei, mid, arr);


          }
          static void merg(int si,int ei,int mid,int arr[]){
                    int tmpArr[]=new int[ei-si+1];
                    int i=si;
                    int j=mid+1;
                    int k=0;
                    while (i<=mid && j<=ei) {
                              if (arr[i]<arr[j]) {
                                        tmpArr[k]=arr[i];
                                        k++;i++;
                              }else{
                                        tmpArr[k]=arr[j];
                                        k++;j++;
                              }

                    }
                    while (i<=mid) {
                              tmpArr[k++]=arr[i++];
                    }
                    while (j<=ei) {
                              tmpArr[k++]=arr[j++];
                    }

                    for(k=0 ,i=si;k<tmpArr.length;k++,i++){
                              arr[i]=tmpArr[k];
                    }
          }
          static void  quickSort(int si,int ei,int arr[]){
                    if (si>=ei) {
                              return;
                    }
                    int pivot=findPivot(si,ei,arr);
                    quickSort(si, pivot-1, arr);
                    quickSort(pivot+1, ei, arr);

          }
          static int findPivot(int si,int ei,int arr[]){
                    // int pivot=arr[ei];
                    int i=si-1;
                    for(int j=si;j<ei;j++){
                              if (arr[j]<=arr[ei]) {
                                        i++;
                                        int temp=arr[j];
                                        arr[j]=arr[i];
                                        arr[i]=temp;
                              }
                    }
                    i++;
                    int temp=arr[ei];
                    arr[ei]=arr[i];
                    arr[i]=temp;

                    return i;
          }

          public static void main(String[] args) {
                    int arr[]={3,2,9,8,6,5};
                    quickSort(0, arr.length-1, arr);
                    System.out.println(Arrays.toString(arr));

          }
}






