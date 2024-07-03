import java.util.Scanner;
 
class Questions {
          static int factorial(int num){
                    if(num==1 || num==0){
                              return 1;
                    }
                    return num*factorial(num-1);
          }
          static int binomialCofficient(int n,int r){
                    //nCr=n!/r!(n-r)! formula
                    return factorial(n)/(factorial(r)*factorial(n-r));
          }

          static void allPrimeNumber(){
                    
                    var input=new Scanner(System.in);
                    System.out.println("enter initial number;");
                    int initial=input.nextInt();
                    System.out.println("enter final range?");
                    int finall=input.nextInt();
                    input.close();
                    
                    for(int i=initial;i<=finall;i++){
                              for(int j=2;j<=Math.sqrt(i);j++){
                                        if (i%j==0) {
                                                  break;
                                        }else{
                                                  System.out.print(" " +i+" ");
                                                  break;
                                        }
                              }
                              
                    }
          }

          
}
class pattern{
          static void butterflyPattern(){
                    // int height=8;
                    // for(int i=1;i<=height/2;i++){
                    //           for(int j=1;j<=height;j++){
                    //                     if (i==height/2) {
                    //                               System.out.print(" * ");
                    //                     }else{
                    //                               if (j<=i || j>height-i ) {
                    //                                         System.out.print(" * ");
                                                            
                    //                               }
                    //                               else{
                    //                                         System.out.print("   ");
                    //                               }
                    //                     }       
                    //           }
                    //           System.out.println();
                    // }
                    int n=4;

                    for(int i=1;i<=n;i++){
                              for(int j=1;j<=i;j++){
                                        System.out.print(" * ");
                              }
                              for(int j=1;j<=2*(n-i);j++){
                                        System.out.print(" - ");
                              }
                              for(int j=1;j<=i;j++){
                                        System.out.print(" * ");
                              }
                              System.out.println();
                    }
                    for(int i=n;i>=1;i--){
                              for(int j=1;j<=i;j++){
                                        System.out.print(" * ");
                              }
                              for(int j=1;j<=2*(n-i);j++){
                                        System.out.print(" - ");
                              }
                              for(int j=1;j<=i;j++){
                                        System.out.print(" * ");
                              }
                              System.out.println();
                    }
                    
          }
          static void zeroOneTriangle(){
                    var input=new Scanner(System.in);
                    System.out.println("enter the height of pyramid;");
                    int height=input.nextInt();
                    input.close();
                    for(int i=1;i<=height;i++){
                              for(int j=1;j<=i;j++){
                                        if((i+j)%2==0){
                                                  System.out.print(" 1 ");
                                        }else{
                                                  System.out.print(" 0 ");
                                        }
                              }
                              System.out.println();
                    }
          }

          static void floydTriangle(){
                    var input=new Scanner(System.in);
                    System.out.println("enter the height of pyramid;");
                    int height=input.nextInt();
                    input.close();
                    int count=1;
                    for(int i=1;i<=height;i++){
                              for(int j=1;j<=i;j++){
                                        System.out.print(" "+count+" ");
                                        count++;
                              }
                              System.out.println();
                    }
          }
          static void invertedHalfPyramidWithNum(){
                    var input=new Scanner(System.in);
                    System.out.println("enter the height of pyramid;");
                    int height=input.nextInt();
                    input.close();
                    for(int i=1;i<=height;i++){
                              for(int j=1;j<=height+1-i;j++){
                                        System.out.print(" "+j+" ");
                              }
                              System.out.println();
                    }
          }
          static void hollowRectangle(){
                    
                    var input=new Scanner(System.in);
                    System.out.println("enter number of rows;");
                    int num1=input.nextInt();
                    System.out.println("enter number of column?");
                    int num2=input.nextInt();
                    input.close();
                    for(int i=1;i<=num1;i++){
                              for(int j=1;j<=num2;j++){
                                        if (i==1 || i==num1) {
                                                  System.out.print(" * ");
                                        }else{
                                                  if (i!=1 || i!=num1) {
                                                            if (j==1 || j==num2) {
                                                                      System.out.print(" * ");
                                                            }else{
                                                                      System.out.print("   ");
                                                            }
                                                  }
                                                  
                                        }
                                        
          
                              }
                              System.out.println();
                    }
          }
          static void squarePattern(){
                    System.out.println("enter the rows and column of the matrix to be printed;");
                    var input=new Scanner(System.in);
                    System.out.println("enter how many rows you want ?");
                    int rows=input.nextInt();
                    System.out.println("enter how many column you want?");
                    int columns=input.nextInt();
                    input.close();
                    for(int i=1;i<=rows;i++){
                              for(int j=1;j<=columns;j++){
                                        System.out.print(" * ");
                              }
                              System.out.print("\n");
                    }
          }
          static void leftTriangel(){
                    System.out.println("enter the height of the triangle");
                    var input=new Scanner(System.in);
                    int height=input.nextInt();
                    input.close();
                    for(int i=1;i<=height;i++){
                              for(int j=1;j<=i;j++){
                                        System.out.print(" * ");
                              }
                              System.out.println("");
                    }
          }
          static void rightTriangel(){
                    System.out.println("enter the height of the triangle");
                    var input=new Scanner(System.in);
                    int height=input.nextInt();
                    input.close();
                    for(int i=1;i<=height;i++){
                              for(int j=1;j<=height;j++){
                                        if (height-j>=i) {
                                                  System.out.print("   ");
                                        }else{
                                                  System.out.print(" * ");
                                        }
                              }
                              System.out.println("");
                              
                    }
          }
          static void invertedRightTriangel(){
                    System.out.println("enter the height of the triangle");
                    var input=new Scanner(System.in);
                    int height=input.nextInt();
                    input.close();
                    for(int i=0;i<=height;i++){
                              for(int j=0;j<height-i;j++){
                                        System.out.print(" * ");
                              }
                              System.out.println("");
                              
                    }
          }
          static void halfPyramid(){
                    System.out.println("enter the height of the pyramid");
                    var input=new Scanner(System.in);
                    int height=input.nextInt();
                    input.close();
                    for(int i=1;i<=height;i++){
                              for(int j=1;j<=i;j++){
                                        System.out.print(" "+j+" ");
                              }
                              System.out.println();
                    }
          }
          static void character(){
                    System.out.println("enter the alpabet where you want to start the pattern;");
                    var input=new Scanner(System.in);
                    char alpabet=input.next().charAt(0);
                    System.out.println("enter the height you want");
                    int height=input.nextInt();
                    input.close();

                    alpabet=Character.toUpperCase(alpabet);
                    for(int i=1;i<=height;i++){
                              for(int j=1;j<=i;j++){
                                        System.out.print(" "+alpabet+" ");
                                        alpabet++;

                              }
                              System.out.println();
                    }
          }
}
public class Input {
          static void taxCalculator(){
                    System.out.println("Enter your in-hand salary per month");
                    var input=new Scanner(System.in);
                    int perMonthSalary=input.nextInt();
                    input.close();
                    int annualSalary=12*perMonthSalary;
                    if (annualSalary<500000) {
                              System.out.println("your are under zero tax slap");
                    } else if (annualSalary>500000 && annualSalary<1000000) {
                              System.out.println("you came under 20% tax slap and have to pay Rs"+annualSalary*.20+" as tax"+" of your salary "+annualSalary+";");

                              
                    } else {
                              System.out.println("you are top 1% people ,so you have to pay 30% tax ,which is Rs"+annualSalary*.30+" of your salary "+annualSalary+";");
                              
                    }
                    
          }
          static void largestNumber(){
                    var input=new Scanner(System.in);
                    System.out.println("Enter first number;");
                    int num1=input.nextInt();
                    System.out.println("Enter second number;");
                    int num2=input.nextInt();
                    System.out.println("Enter third number;");
                    int num3=input.nextInt();
                    input.close();
                    if(num1>num2){
                              if (num1>num3) {
                                        System.out.println("number 1 is greater, which is "+num1);
                              }else{
                                        System.out.println("number 3 is greater, which is "+num3);
                              }
                    }else{
                              if (num2>num3) {
                                        System.out.println("number 2 is greater, which is "+num2);
                              }else{
                                        System.out.println("number 3 is greater, which is "+num3);
                              }

                    }

          }
          
          static void calculator(int num1, int num2,char operation){
                    switch (operation) {
                              case '+':{
                                        
                                        int result =num1-num2;
                                        System.out.println("addition result  is "+result);
                                        break;
                              
                              }         
                              case '-':{
                                        int result=num1-num2;
                                        System.out.println("your result is "+result);
                                        break;
                              }
                              case '*':{
                                        int result=num1*num2;
                                        System.out.println("your result is "+result);
                                        break;
                              }
                              case '/':{
                                        int result=num1/num2;
                                        System.out.println("your result is "+result);
                                        break;
                              }
                              default:  
                                        System.out.println("only + , - , * , /  is allowed ;");
                                        break;
                    }
          }
          static void reverseNumber(){
                    System.out.println("enter a number whose reverse you want ;");
                    var input=new Scanner(System.in);
                    int number=input.nextInt();
                    input.close();
                    int reverse=0;
                    while (number>0) {
                              int lastDigit=number%10;
                              number=number/10;
                              reverse=reverse*10+lastDigit;
                    }
                    System.out.println(reverse);

          }
          static void isPrime(int num){
                    for(int i=2;i<=num-1;i++){
                              if (num%i==0) {
                                        System.out.println("not prime");
                                        break;
                              }else{
                                        System.out.println("prime");
                                        break;
                              }
                              
                    }
          }
          public static void main(String[] args) {
                     
                    // for(char i='a';i<='g';i++){
                    //           System.out.print(" "+i+" ");
                    // }
                    pattern.butterflyPattern();
 
          } 

}