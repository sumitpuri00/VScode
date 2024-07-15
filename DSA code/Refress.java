class sumit{
    // sumit(){

    // }
    sumit(int num){
        System.out.println("this is constructr");
        this.num=num;
    }
    int num;
    static void name(){
        System.out.println(" this is parent name");
    }
}
public class Refress extends sumit{
    Refress(){
        super(7);
         

        System.out.println("this is");
    }
    
    
    
    void anime(){
         
        
        System.out.println();
    }
    public static void main(String[] args) {
        new Refress();
        
    }
}