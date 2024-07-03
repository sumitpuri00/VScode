import java.util.Arrays;

public class Stringss {
          static void shortestPath(){
                    int x=0;
                    int y=0;
                    String path="NS";
                    for(int i=0;i<path.length();i++){
                              if (path.charAt(i)=='E') {
                                        x++;
                              }else if(path.charAt(i)=='W'){
                                        x--;
                              }else if(path.charAt(i)=='N'){
                                        y++;
                              }else{
                                        y--;
                              }
                    }
                    System.out.println(Math.sqrt((x*x)+(y*y)));


          }
          static void upperCase(){
                    String sentence="i, am sumit goswami ";
                    StringBuilder sb=new StringBuilder("");
                    sb.append(sentence.toUpperCase().charAt(0));
                    for(int i=1;i<sentence.length();i++){
                              sb.append(sentence.charAt(i));
                              if (sentence.charAt(i)==' '&& i<=sentence.length()-2) {
                                        i++;
                                        sb.append(sentence.toUpperCase().charAt(i));
                              }
                    }
                    System.out.println(sb.toString());
          }
          static void stringCompression(){
                    String string ="qqqrrrrffffttyee";
                    StringBuilder sb=new StringBuilder();
                    char character=string.charAt(0);
                    Integer count=0;
                    for(int i=0;i<string.length();i++){
                              if(character==string.charAt(i)){
                                        count++;
                              }
                              if (character!=string.charAt(i)) {
                                        String s=count.toString();
                                        sb.append(character+s);
                                        character=string.charAt(i);
                                        count=1;
                              }
                    }
                    
                    System.out.println(sb.toString()+character+count);
          }
          public static void main(String[] args) {
                    stringCompression();
          }
}
