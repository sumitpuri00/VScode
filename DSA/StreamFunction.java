package DSA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFunction {
          public static void main(String[] args) {
                    // note that-> stream() is used to get stream from the list only;
                    List<Integer> listVariable=List.of(3,5,6,3,8,4);
                    listVariable.stream().map(sui ->sui +2).forEach(System.out::print);

                    // note that -> Stream.of() is used to get the stream from an array of Wrapper class only 
                    // which exclude int[] , to get the array of int[] we use these two ways given below;
                    int sumit[]={7,35,5};
                    IntStream.of(sumit).forEach(System.out::print);
                    Arrays.stream(new int[]{6,9,4,2,4}).map(sum -> sum+2).forEach(System.out::println);
                    String names[]={"huis","jig","njod","jid"};
                    Stream.of(names).map(sui->sui.length()).forEach(System.out::println);
                    
                    // for regular wrapper arrays  
                    List.of("sumit","vanya","puri").stream().forEach(System.out::print);

          }
}

// import java.util.List;
// import java.util.stream.Stream;

// public class StreamFunction {
//     public static void main(String[] args) {
//         List<Integer> listVariable = List.of(3, 5, 6, 3, 8, 4);
//         Stream.of(listVariable) // Create a stream directly from the list
//                 .flatMap(List::stream) // FlatMap to convert List<Integer> to Stream<Integer>
//                 .map(sui -> sui + 2)
//                 .forEach(System.out::println);
//     }
// }
 
