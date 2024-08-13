import java.lang.reflect.Array;
import java.util.*;
class QueueUsingTwoStacks{
        class StackImplimentation{
                ArrayList<Integer>arrayList=new ArrayList<>();
                boolean isEmpty(){
                        if (arrayList.size() == 0) {
                                return true;
                        }
                        return false;
                }
                void push(int data){
                        arrayList.add(data);
                }
                int pop(){
                        if (isEmpty()) {
                                System.out.println("nothing to pop, arrayList is empty");
                                return -1;
                        }
                        int tempNum=arrayList.get(arrayList.size()-1);
                        arrayList.remove(arrayList.size()-1);
                        return  tempNum;
                }
                int peek(){
                        if (isEmpty()) {
                                System.out.println("nothing to peek, arrayList is empty");
                                return -1;
                        }
                        return arrayList.get(arrayList.size()-1);
                }
        }
        class TwoStackApproach {
                Stack<Integer> s1=new Stack<>();
                Stack<Integer> s2=new Stack<>();
                boolean isEmpty(){
                        return s1.isEmpty();
                }
                void push(int data){
                        
                        if(s1.isEmpty()){
                                s1.push(data);
                                return;
                        } else {
                                while(!s1.isEmpty()){
                                        s2.push(s1.pop());
                                }
                                s1.push(data);
                        }


                        while(!s2.isEmpty() ) {
                                s1.push(s2.pop());
                        }
                }
                int pop(){
                        if (s1.isEmpty()) {

                                System.out.println("queue is empty");
                                return -1;
                        }
                        return s1.pop();
                }
                int peek(){
                        if (s1.isEmpty()) {

                                System.out.println("queue is empty");
                                return -1;
                        }
                        return s1.peek() ;
                }

        }
        public static void main(String[] args) {
                QueueUsingTwoStacks q=new QueueUsingTwoStacks();
                QueueUsingTwoStacks.StackImplimentation stack=q.new StackImplimentation();
                stack.push(2);
                stack.push(5);
                stack.push(4);
                
                while (!stack.isEmpty()) {
                        System.out.println(stack.peek());
                        stack.pop();
                }
                QueueUsingTwoStacks.TwoStackApproach twoStackObj=q.new TwoStackApproach();
                twoStackObj.push(11);
                twoStackObj.push(33);
                twoStackObj.push(55);
                twoStackObj.push(77);
                System.out.println();
                twoStackObj.pop();
                while (!twoStackObj.isEmpty()) {
                        System.out.print(twoStackObj.peek()+" ");
                        twoStackObj.pop();
                }
                
                

                
        }
}
class QueueUsingLinkedList{
        static class Node{
                int data;
                Node Next;
                Node(int data){
                        this.data=data;
                        this.Next=null;
                }
                
        }
        Node head;
        Node tail;
        boolean isEmpty(){
                if (head==null) {
                        return true;
                }
                
                return false;
        }
        void push(int data){
                Node newNode=new Node(data);
                if (head==null && tail==null) {
 
                        head=newNode;
                        tail=newNode;
                }
                tail.Next=newNode;
                tail=newNode;

        }
        
        int pop(){
                if (isEmpty()) {
                        System.out.println("Queue is empty now");
                        return -1;
                }
                Node tempNode=head;
                head=head.Next;
                return tempNode.data ;
        }
        int peek(){
                if (isEmpty()) {
                        System.out.println("Queue is empty nothing to peek");
                        return -1;
                }
                return head.data;
        }
        void printQueue(){
                if (isEmpty()) {
                        System.out.println("Queue is empty nothing to print");
                        return;

                }
                Node temp=head;
                while (temp !=null) {
                        System.out.print(temp.data+" ");
                        temp=temp.Next;
                }
                System.out.println();
                 
        }
        public static void main(String[] args) {
                // this time we are creating queue linked list;
                QueueUsingLinkedList q=new QueueUsingLinkedList();
                q.push(3);
                q.push(8);
                q.push(1);
                q.push(5);
      
                q.printQueue();
                q.pop();
 
                
        }
}
class CircularQueues {
          static class DQueues{
                    static int arr[];
                    static int rear;
                    static int front;
                    static int size; 
                    DQueues(int arrSize){
                              this.arr=new int[arrSize];
                              this.rear=-1;
                              this.front=-1;
                              this.size=arrSize;
                    }
                    boolean isEmpty(){
                              return rear == -1 && rear == -1;
                    }
                    void push(int data){
                              
                              if (((rear+1)%size)==front) {
                                        System.out.println("queue is full element is not added !");
                                        return;
                              }
                              rear=(rear+1)%size;
                              if (front == -1) {
                                        front++;   
                              }
                              arr[rear] =data;
                    }
                    int pop(){
                              if (isEmpty()) {
                                        System.out.println("queue is empty, nothing to pop");
                                        return -1 ;
                              }
                              
                              int popedNum=arr[front];
                              if (rear == front ) {
                                      front=rear=-1;  
                              }else{    
                                        
                                        front=(front+1)% size;
                              }
                              return popedNum;
                              
                    }
                    int peek(){
                              if (isEmpty()) {
                                        System.out.println("queue is empty, nothing to pop");
                                        return -1 ;
                              }
                              return arr[front] ;
                    }
                    void printQueue(){
                              if (isEmpty()) {
                                        System.out.println("queue is empty, nothing to pop");
                                        return ;
                              }
                              while (!isEmpty()) {
                                        System.out.print(peek()+" ");
                                        pop();
                              }
                    }
                     
          }
          public static void main(String[] args) {
                    // creating the object
                    DQueues qq=new DQueues(4);

                    qq.push(41);
                    // qq.push(31);
                    // qq.push(21);
                    // qq.push(91);
                    // q.push(6);

                    qq.printQueue();
                    // System.out.println(1%4);
                   
                    
          }
}

class Queues {
          static class Queue{
                    static int arr[];
                    static int rear;
                    static int size; 
                    Queue(int arrSize){
                              this.arr=new int[arrSize];
                              this.rear=-1;
                              this.size=arrSize;
                    }
                    boolean isEmpty(){
                              return rear == -1;
                    }
                    void push(int data){
                              rear++;
                              if (rear==size) {
                                        System.out.println("queue is full element is not added !");
                                        return;
                              }
                              arr[rear] =data;
                    }
                    int pop(){
                              if (isEmpty()) {
                                        System.out.println("queue is empty, nothing to pop");
                                        return -1 ;
                              }
                              int popedNum=arr[0];
                              for(int i=1; i<size;i++){
                                        arr[i-1]=arr[i];
                              }
                              arr[rear]=0;
                              rear--;
                          
                             
                              
                              
                              return popedNum;
                    }
                    int peek(){
                              if (isEmpty()) {
                                        System.out.println("queue is empty, nothing to pop");
                                        return -1 ;
                              }
                              return arr[0] ;
                    }
                    void printQueue(){
                              if (isEmpty()) {
                                        System.out.println("queue is empty, nothing to pop");
                                        return ;
                              }
                              while (!isEmpty()) {
                                        System.out.print(peek()+" ");
                                        pop();
                              }
                    }
                     
          }
          public static void main(String[] args) {
                    // creating the object
                    Queue q=new Queue(4);

                    q.push(4);
                    q.push(3);
                    q.push(2);
                    // q.push(9);
                    // q.push(6);
                    q.printQueue();
 
                     
                    
          }
}
