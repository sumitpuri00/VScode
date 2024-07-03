class sumit{
    // sumit(){

    // }
    sumit(int num){
        System.out.println("this is constructr");
        this.num=num;
    }
    int num;
    void name(){
        System.out.println(" this is parent name");
    }
}
public class Refress extends sumit{
    Refress(){
        super(7);
         

        System.out.println("this is");
    }
    
    void anime(){
        super.name();
        System.out.println();
    }
    public static void main(String[] args) {
        new Refress();
        
    }
}