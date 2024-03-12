import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class sumit{

}


public class dragon {
          static List<luffy> getMyList(){
                    return Arrays.asList(
                              new luffy("hi",99844),
                              new luffy("hi2",894844)
                    );
          }

          public static void main(String[] args) {
                    List<luffy> n=getMyList();
                    for(luffy i:n){
                              System.out.print(i.getName()+" ");
                              System.out.println(i.getBounty());
                    }
                    // System.out.println(n.get(0).getName());

                    // luffy luffyobj=new luffy();

                    Integer num[]={2,5,3,4,3};
                    List<Integer>num1=Arrays.asList(2,4,46,6);
                    String num3[]={"er","et","rte"};
                    System.out.println(Arrays.asList(num1));
                    System.out.println(num1);
                    System.out.println(Arrays.asList(num3));
                    
                    System.out.println("this is stream");
                    Stream<String> streamobj=Stream.of(num3);
                    Stream<Integer> streamobj2=Stream.of(num);
                    System.out.println("this is an int arr"+Arrays.toString(num));
                    streamobj2.forEach(o -> System.out.print(o+" "));

                    int intArr[]={2,5,3,4,3};

                    IntStream ar=Arrays.stream(intArr);

                    

                    
          }
        

}
