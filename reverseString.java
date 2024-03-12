
import java.util.Arrays;
import java.util.stream.Stream;


class SecoundMethod{
  
  String namee="sumit";
  char reverseName[]=new char[namee.length()];
  void printReverse(){
    Stream.of(reverseName).forEach(System.out::print);
  }
  public void runnReverse(){

    for(int i=0;i<=namee.length()-1;i++){
      reverseName[i]=namee.charAt(namee.length()-1-i);
    }
    printReverse();

  }

}

public class reverseString {
          public static void main(String[] args) {
                  String name= "sumit" ,reverse="";
                  char charr;
                    
                    for(int i=0;i<name.length();i++){
                             System.out.println(i);
                             charr=name.charAt(i);
                             reverse=charr+reverse;

                    }
                    System.out.println(reverse);


                    StringBuilder reverseName=new StringBuilder();
                    for(int i=name.length()-1; i>=0;i--){
                              reverseName.append(name.charAt(i));
                    }
                    System.out.println(reverseName);
                    String hi[]= {"suit","puir","ior"};
                    System.out.println(Arrays.toString(hi));

                    System.out.println(reverseName.toString());


                  // method from SecoundMethod class;
                  System.out.println("this is reverse string  using secound method");

                  new SecoundMethod().runnReverse();
                
                    
          }         
        
          
         
          
}
