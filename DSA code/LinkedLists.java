import java.util.*;

class FindZigZaglinkedList {
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
                 FindZigZaglinkedList ll=new FindZigZaglinkedList();
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

class LinkedLists {
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

          // second way to addFirst ;
          // void addFirst(int data){
          //           if (tail==null) {
          //                    tail=head=new Node(data);
                              
          //           }else{
                              
          //                     Node temp=head;
          //                     head=new Node(data);
          //                     head.next=temp;
          //           }
          // }


          void addFirst(int data){
                    Node newNode=new Node(data);

                    if (head==null) {
                              size=1;
                             head=tail= newNode;
                              
                    }else{    size++;
                              newNode.next=head;
                              head=newNode;
                    }
          }


          // second way to addLast ;
          // void addLast(int data ){
          //           if (head==null) {
          //                     head=tail=new Node(data);
          //           }else{    
          //                     Node temp=tail;
          //                     tail=new Node(data);
          //                     temp.next=tail;
                               
          //           }
          // }
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
          void addInMiddle(int data ,int index){
                    Node temp=head;
                    int count=1;
                    while (count != index-1) {
                              count++;
                              temp=temp.next ;
                              
                    }
                    Node newNode=new Node(data);
                    Node temp2=temp.next ;
                    temp.next=newNode;
                    newNode.next=temp2;

          }
          int size(){
                    Node temp=head;
                    int count=1;
                    while (temp.next != null) {
                              count++;
                              temp=temp.next;
                    }
                    return count;

          }
           
          void removeLast(){
                    
                    if (size==0) {
                              System.out.println("Linked List is already empty ;");
                              return;
                    }else if (size == 1) {
                              head=tail=null;
                              return ;
                    
                    }
                    Node temp=head;
                    int count=1;
                    while (count !=size-1 ) {
                              temp=temp.next;
                              count++ ;
                    }
                    temp.next=null;
                    tail=temp;


          }
          void search(int data){
                    
                    Node temp=head;
                    int count=0;
                    while (temp != null) {
                              if (temp.data == data ) {
                                        System.out.println("position is "+count);
                                        return;
                              }
                              temp=temp.next;
                              count++;
                    }
                    System.out.println("-1 , Data is not present inside the linked List");

          }
          int recursiveSearch(int data, Node head){
                    if (head.data == data) {
                              return 0;
                    }
                    if (head.next == null) {
                              return -1;
                    }

                    int value=recursiveSearch(data, head.next);
                              
                    if (value != -1) {
                              value=value+1;
                    }


                    return value;
          }
          void SearchWithRecursion(int data){
                    int result=recursiveSearch(data ,head );
                    if (result == -1) {
                              System.out.println("-1 , Data is not present inside the linked list");
                    }else{
                              System.out.println("position is "+result);
                    }
          }

          void reverseAlinkedList(){
                    Node curr=tail=head;
                    Node prev=null;
                    Node next;
                    while (curr != null) {
                              next=curr.next;
                              curr.next=prev;
                              prev=curr;
                              curr=next;
                    }
                    head=prev;
                    
                     
                    

                    
          }
          Node reverseAlinkedListUsingRecursion(Node head){
                    if (head.next==null) {
                              tail=Problems.head;
                              Problems.head=head;
                              return head;
                    }
                    Node newHead=reverseAlinkedListUsingRecursion(head.next);

                    head.next.next=head;
                    head.next=null;

                    return newHead;

          }
          Node midOfLinkedList(){
                    // finding the mid of the LL ; using slow +1 and fast +2 ;
                    // slow will increase 1 time and fast will increase 2  times;
                    Node slow=head;
                    Node fast=head;
                    while (fast != null && fast.next != null) {
                              slow=slow.next; 
                              fast=fast.next.next;
                    }
                    return slow;

          }
          boolean checkPalindrome(){
                    if (head==null || head.next == null) {
                              return false;
                              
                    }
                    // middle pointer;
                    Node mid=midOfLinkedList();
                    
                    // revercing the LL of the right  half;
                    Node curr=mid;
                    Node next;
                    Node prev=null;
                    while (curr != null) {
                              next=curr.next;
                              curr.next=prev;
                              prev=curr;
                              curr=next;

                    }

                    // right pointer
                    Node Rpointer=prev;
                    // left pointer
                    Node Lpointer=head;


                    // checking the right half from the end point to the 
                    // left half from the start point ;
                    while (Rpointer.next != null ) {
                              if (Rpointer.data != Lpointer.data ) {
                                        return false;
                              }
                              Rpointer=Rpointer.next;
                              Lpointer=Lpointer.next ;

                    }

                    return true;
          }


          Node getMid(Node head){
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
          Node sortList(Node head){
                    if (head == null || head.next == null) {
                              return head;
                          }
                   
                          Node mid =getMid(head);
                          Node rightHead=mid.next;
                          // Split the linked list into two halves
                          mid.next=null;
                  
                          Node left = sortList(head);
                          Node right = sortList(rightHead);
                            
                    return merge(left,right);
 
          }
          Node merge(Node leftNodeHead, Node rightNodeHead){
                    Node newNode=new Node(-1);
                    Node tempNode=newNode;
                    
                    while (leftNodeHead != null && rightNodeHead != null) {
                              if (leftNodeHead.data <= rightNodeHead.data) {

                                        tempNode.next=leftNodeHead;

                                        leftNodeHead=leftNodeHead.next;
                                        tempNode=tempNode.next;
                              }else{
                                        tempNode.next=rightNodeHead;

                                        rightNodeHead=rightNodeHead.next;
                                        tempNode=tempNode.next;
                              }
                    }
                    while(leftNodeHead != null) {
                              tempNode.next=leftNodeHead;

                              leftNodeHead=leftNodeHead.next;
                              tempNode=tempNode.next;
                              
                    }
                    while(rightNodeHead != null ) {
                              tempNode.next=rightNodeHead;

                              rightNodeHead=rightNodeHead.next;
                              tempNode=tempNode.next;
                    }

                    return newNode.next;
          }

          public static void main(String[] args) {
                    LinkedLists ll=new LinkedLists();
                    ll.addLast( 5);
                    ll.addLast( 1);
                    ll.addLast(2);
                    // ll.addLast(7);
                    // ll.addLast(9);
                    // ll.addLast(3);
                    
                    ll.printLL(ll.head);

                    Node newHead=ll.sortList(ll.head);
                    ll.printLL(newHead);
                  
                   
           
                     
                     
                    
              
        
          }
}


