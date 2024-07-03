/**
 * sumit
 */
interface sumit {

          void num();


}
/**
 * puri 
 */
class puri implements sumit {
          public void print(){
                    System.out.println("this is print");
          }

          @Override
          public void num() {
                    // TODO Auto-generated method stub
                    System.out.println("this is interface method");
          }
          
}
public class interfaceEx {

          public static void main(String[] args) {
                    sumit suObj=new puri();
                    // suObj.print(); this gives an error because only method which are 
                    // inside the sumit interface are called ; because we are storing child refrence
                    // inside the parent class; 
                    
          }
}
