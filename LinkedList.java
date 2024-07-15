public class LinkedList <T>{
          static class Node<T>{
                    T data;
                    Node next;
                    Node(T data){
                              this.data=data;
                              this.next=null;
                    }

          }
          static Node head;
          static Node tail;
          // insert at first 
          void insertL(T data){
                    Node<Integer> newNode=new Node(data);
                    if(head==null){
                              head=newNode;
                              tail=newNode;

                    }else{
                              tail.next=newNode;
                              tail=newNode;
                    }

          }
          void printL(){
                    
                    if (head==null) {
                              System.out.println("linkedlist is empty");
                              return;

                    }else{
                              Node counter=head;
                              while (counter!=null) {
                                        System.out.print(counter.data+" ");
                                        counter=counter.next;
                                        
                              }
                    }
          }
          T sumit;
          public static void main(String[] args) {
                    System.out.println("this is sumit");
                    // var LinkedListObj=new LinkedList();
                    LinkedList<Integer> LinkedListObj=new LinkedList();
                    LinkedListObj.insertL(22);
                    LinkedListObj.insertL(55);
                    LinkedListObj.insertL(44);
                    LinkedListObj.printL();
                    // System.out.println(head.data);
                    // System.out.println(tail.data);
          }
}
