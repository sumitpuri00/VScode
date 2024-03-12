import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test  {
          public static List<Integer> returnList(){
                    List<Integer> myList=new ArrayList<>();
                    myList.add(9);
                    myList.add(5);
                    return myList;
          }
          public static void main(String[] args) {
                    // int n=2;
                    // int m=4;
                    // int arr[][]=new int[n][m];
                    // System.out.println(arr.length);
                    // System.out.println(arr[0].length);

                    List<Integer> mylistis=returnList();
                    System.out.println(mylistis);
                    int sumitArr[]={3,5,3,5,2,4};
                    String puri[]={"sumit","puri"};
                    // List<int[]> sumitList=Arrays.asList(sumitArr);

                    System.out.println("this is asList"+ Arrays.asList(puri));
                    System.out.println("this is toString"+ Arrays.toString(puri));

                    System.out.println("this is toString"+ Arrays.toString(sumitArr));
 
          }
}
