import java.util.Arrays;
class DoubleLL{
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }

    }
    Node head;
    Node tail;
    void addlast(int data){
        Node newNode=new Node(data);
        if (head==null) {
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        
    }

    void printDll(Node head){
        Node tempHead=head;
        if (head==null) {
            System.out.println("DLL is Empty;");
             
        }else if (head.next==null && head.prev==null ) {
            System.out.print(head.data+" ");
            
        }else if (head.next==null) {
            while (tempHead != null) {
                System.out.print(tempHead.data+" ");
                tempHead=tempHead.prev;
            }           
        }else{
            while (tempHead != null) {
                System.out.print(tempHead.data+" ");
                tempHead=tempHead.next;
            }           
        }

        
        
    }
        
    public static void main(String[] args) {
        DoubleLL dll=new DoubleLL();
        dll.addlast(3);
        dll.addlast(6);
        dll.addlast(5);
        dll.addlast(9);
        
        
        dll.printDll(dll.head);
        System.out.println();
        dll.printDll(dll.tail);

        
    }
}
class SolveError {
	   static class Node{
                    int data;
                    Node next;
                    Node(int data){
                              this.data=data;
                              this.next=null;
                    }
          }
          Node head;
          Node tail;
          int size;
	 void addLast(int data ){
                    Node newNode=new Node(data);

                    if (head==null) {
                              size=1;
                              head=tail=newNode;
                    }else{    
                              size++;
                              tail.next=newNode;
                              tail=newNode;
                             
                               
                    }
          }
           void printLL(Node head){
                    if (head==null) {
                              System.out.println("linked list is empty");
                              return;
                    }
                    Node temp=head;
                    while (temp!= null) {
                              System.out.print(temp.data);
                              System.out.print(" -> ");
                              temp=temp.next;
                    }
                    System.out.println("null");
          }

          Node midOfLinkedListForMergeSort(Node head){
                    // finding the mid of the LL ; using slow +1 and fast +2 ;
                    // slow will increase 1 time and fast will increase 2  times;
                    Node slow=head;
                    Node fast=head.next;
                    while (fast != null && fast.next != null) {
                              slow=slow.next; 
                              fast=fast.next.next;
                    }
                    return slow;

          }
          Node mergeSort(Node head){
                    
                    if (head == null || head.next == null ) {
                              return head;
                              
                    }

                    Node mid=midOfLinkedListForMergeSort(head);

                    Node rightHead=mid.next;
                    mid.next=null;

                    Node left=mergeSort(head);
                    Node right=mergeSort(rightHead);
                    

                    return merge(left,right);
 
          }
           Node merge(Node leftNodeHead, Node rightNodeHead){
                    Node newNode=new Node(-1);
                    Node tempNode=newNode;
                    Node leftPointer=leftNodeHead;
                    Node rightPointer=rightNodeHead;
                    while (leftPointer != null && rightPointer != null) {
                              if (leftPointer.data < rightPointer.data) {

                                        tempNode.next=leftPointer;

                                        leftPointer=leftPointer.next;
                                        tempNode=tempNode.next;
                              }else{
                                        tempNode.next=rightPointer;

                                        rightPointer=rightPointer.next;
                                        tempNode=tempNode.next;
                              }
                    }
                    if (leftPointer != null) {
                              tempNode.next=leftPointer;

                              leftPointer=leftPointer.next;
                              tempNode=tempNode.next;
                              
                    }
                    if (rightPointer != null ) {
                              tempNode.next=rightPointer;

                              rightPointer=rightPointer.next;
                              tempNode=tempNode.next;
                    }

                    return newNode.next;
          }


          void zizZazlinkedList(){
            // finding the mid of the LL 
            Node slow=head;
            Node fast =head.next;
            while (fast != null && fast.next != null) {
                slow=slow.next;
                fast=fast.next.next;
            }

            Node mid=slow;

            // dividing the linked list into two parts 

            Node curr=mid.next;
            mid.next=null;

            // reversing the second half of the linked list
            Node prev=null;
            Node next;
            while ( curr !=null) {
                next=curr.next;
                curr.next=prev;
                
                prev=curr;
                curr=next;
            }
            Node left=head;
            Node right=prev;
 
            // zig zag code 
            Node fCurr=left;
            Node sCurr=right;
            while ( fCurr !=  null && sCurr != null) {
                Node fNext=fCurr.next;
                fCurr.next=sCurr;

                Node sNext=sCurr.next;
                sCurr.next=fNext;

                fCurr=fNext;
                sCurr=sNext;
            }

            
          }
          public static void main(String[] args) {
                    SolveError ll=new SolveError();
                    ll.addLast( 5);
                    ll.addLast( 3);
                    ll.addLast(9);
                    ll.addLast(7);
                    // ll.addLast(1);
                    // ll.addLast(0);
                    
                    ll.printLL(ll.head);
                // Node newNode=ll.mergeSort(ll.head);
                    // ll.printLL(newNode);
                    ll.zizZazlinkedList();
                    ll.printLL(ll.head);

                  
                   
           
                     
                     
                    
              
        
          }
}



class Practice{
    void quickSortAgain(int arr[],int iIdx, int fIdx){
        if (iIdx>=fIdx) {
            return;
        }
        int pivot=partition(iIdx,fIdx,arr);
        
        quickSortAgain(arr,iIdx,pivot-1);
        quickSortAgain(arr,pivot+1,fIdx);
    
    }
    int partition(int iIdx,int fIdx,int arr[]){
        int pointer=iIdx-1;
        int pivot=fIdx;
        for(int i=iIdx; i<fIdx; i++){
            if ( arr[i]<=arr[pivot]) {
                pointer++ ;
                int temp=arr[pointer];
                arr[pointer]=arr[i];
                arr[i]=temp;
            }
        }
        pointer++;
        int temp=arr[pointer];
        arr[pointer]=arr[pivot];
        arr[pivot]=temp;

        return pointer;
    }
    public static void main(String[] args) {
        int arr[]={6,3,9,8,2,5};
        Practice p=new Practice();
        p.quickSortAgain(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}