import java.lang.reflect.Array;
import java.util.Arrays;

public class reverseString {
          // public static void main(String[] args) {
          //           String name= "sumit" ,reverse="";
          //           char charr;
                    
          //           for(int i=0;i<name.length();i++){
          //                    System.out.println(i);
          //                    charr=name.charAt(i);
          //                    reverse=charr+reverse;

          //           }
          //           System.out.println(reverse);


          //           // StringBuilder reverseName=new StringBuilder();
          //           // for(int i=name.length()-1; i>=0;i--){
          //           //           reverseName.append(name.charAt(i));
          //           // }
          //           // System.out.println(reverseName);
          //           // String hi[]= {"suit","puir","ior"};
          //           // System.out.println(Arrays.toString(hi));

          //           // System.out.println(reverseName.toString());
          // }         
        
          
          public static void main(String[] args) {
              String name ="rohit" ;
              char charArr[] = new char [name.length()-1];
              int j=0;

              for(int i= name.length()-1;i<=0;i--){
                  System.out.print("charArr");
                    System.out.print(name.charAt(i));
                    charArr[j]=name.charAt(i);
                  j++;
              }
          }  
          
}
