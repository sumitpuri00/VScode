import java.util.*;

class Main { 

    static int waterTrapped(ArrayList<Integer>list){
        int maxWater=Integer.MIN_VALUE;
        
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int length=Math.min(list.get(i), list.get(j));
                int breath=j-i;
                int waterStored=length*breath;
                if (waterStored>maxWater) {
                    maxWater=waterStored;
                }

            }
        }
         

        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList();
        list.add(1) ;
        list.add(8) ;
        list.add(6) ;
        list.add(2) ;
        list.add(5) ;
        list.add(4) ;
        list.add(8) ;
        list.add(3) ;
        list.add(7) ;
        
        System.out.println(waterTrapped(list));
        
        

    }
}
