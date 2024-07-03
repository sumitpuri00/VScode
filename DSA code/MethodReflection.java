public class MethodReflection {
          public static void sum(int num){
                    int num2=20;
                    System.out.println(num+num2);
          }

          static int me(){
                    int num=20;
                    int num2=90;
                    return num+num2;
          }

          public static void main(String[] args) {
                    sum(me());
          }
}


