import java.util.ArrayList;
import java.util.Arrays;

public class Heaps {
    static class Heap{
        ArrayList<Integer> arrayList=new ArrayList<>();

        void insert(int data){

            // adding the data at the end of the arrayList;
            arrayList.add(data);
            int childIdx=arrayList.size()-1;
            int parentIdx=(childIdx-1)/2;
            while (arrayList.get(childIdx) < arrayList.get(parentIdx)) {
                
                int curr=arrayList.get(parentIdx);
                arrayList.set(parentIdx, arrayList.get(childIdx));
                arrayList.set(childIdx,  curr);
                childIdx=parentIdx;
                parentIdx=(parentIdx-1)/2;
                
            }

        }

        void  heapify(int rootIdx){
            
            int leftIdx= 2*rootIdx+1;
            int rightIdx = 2*rootIdx+2;
            int minIdx=rootIdx;
            if(leftIdx<arrayList.size() && arrayList.get(minIdx)> arrayList.get(leftIdx)){
                minIdx=leftIdx;
            }
            if (rightIdx < arrayList.size() && arrayList.get(minIdx) > arrayList.get(rightIdx)) {
                minIdx=rightIdx;
            }
            if (rootIdx != minIdx) {
                int minData=arrayList.get(minIdx);
                arrayList.set(minIdx, arrayList.get(rootIdx));
                arrayList.set(rootIdx, minData);

                heapify(minIdx);
            }
            
        }
        int delete(){
            int last=arrayList.get(arrayList.size()-1);
            arrayList.set(arrayList.size()-1, arrayList.get(0));
            arrayList.set(0, last);
            
            int deletedData=arrayList.remove(arrayList.size()-1);
            heapify(0);

            return deletedData;
        }

        void print(){
            System.out.println(arrayList);
        }
    }
    public static void main(String[] args) {
        System.out.println("this is heap");
        Heaps.Heap heapobj=new Heaps.Heap();

        heapobj.insert(2);
        heapobj.insert(3);
        heapobj.insert(4);
        heapobj.insert(5);
        heapobj.insert(10);
        heapobj.insert(1);
        heapobj.print();
        heapobj.delete();
        heapobj.print();
    }
}

