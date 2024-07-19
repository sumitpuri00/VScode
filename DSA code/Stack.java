import java.util.*;
 
class StockSpan{

    void findSpan(int arr[]){
        int span[]=new int[arr.length];
        int count=0;
        for(int i=0;i<arr.length;i++){
            int j=i;
            while (j>=0) {
                if (arr[i]>=arr[j]) {
                    count++;
                }
                j--;
            }
            span[i]=count;
            count=0;
        }
        System.out.println(Arrays.toString(span));
    }
    public static void main(String[] args) {
        // this is also brute force approach; have to write the code for O(n);
        int arr[]={100,80,60,70,60,85,100};
        StockSpan sp=new StockSpan();
        sp.findSpan(arr);

    }

}

class GreatestElement{
    void findGreatestELement(int arr[]){
        // using brute force approach;
        int element[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if (arr[i]<arr[j]) {
                    element[i]=arr[j];
                    break;
                }
                if (j==arr.length-1) {
                    element[i]=-1;
                }
                 
            }
            if (i==arr.length-1) {
                element[i]=-1;
            }
        }
        System.out.println(Arrays.toString(element));
        
    }

    // recurtion 
    int check(Stack<Integer> obj,int checker){
        if (obj.empty()) {
            return -1;
        }
        int num=obj.peek();
        if (num > checker) {
            return num;
        }
        int num1=obj.pop();
        int result=check(obj, checker);
        obj.push(num1);
        
        return result;
    }

    void findGreatestElementUsingStack(Stack<Integer> obj,ArrayList<Integer> greatestElementsList){
        
        int tempNum=obj.pop();
        if (obj.empty()) {
            greatestElementsList.add(-1);
            return;
        }

        if (obj.peek()>tempNum) {
            greatestElementsList.add(obj.peek());

            
        }else{
             
            int num=check(obj, tempNum);
            greatestElementsList.add(num);
            
        }
        
        findGreatestElementUsingStack(obj,greatestElementsList);
    


    }

    public static void main(String[] args) {
        
        // object of GeatestElement
        GreatestElement gl=new GreatestElement();

        // calling the  brute force  function to find the greatestELement;
        // int arr[]={6,8,0,1,3};
        // gl.findGreatestELement(arr);

        // call the function for resursion
        Stack<Integer> stack=new Stack<>();
        ArrayList <Integer>greatestElements=new ArrayList<>();
        stack.add(3);
        stack.add(1);
        stack.add(0);
        stack.add(8);
        stack.add(6);
        
        
        gl.findGreatestElementUsingStack(stack, greatestElements);

        System.out.println(greatestElements);
        
         
        
         
    }
}


class Parenthesis{
    boolean validParenthesis(Stack<Character> obj,String str){
        for(int i=0; i<str.length();i++){

            char ch=str.charAt(i);

            if (ch=='[' || ch=='{' || ch=='(') {
                obj.push(ch);
            }else{
                if (obj.empty()) {
                    return false;
                }
                if ((obj.peek()=='[' && ch==']') ||
                 (obj.peek()=='{' && ch=='}') || 
                 (obj.peek()=='(' && ch==')') ) {
                    obj.pop();
                }else{
                    return false;
                }
            }
        }
        if (obj.empty()) {
            return true;
        }else{
            return false;
        }
        
    }
    public static void main(String[] args) {
        // this is a simple question, but do the hard question of it . which is dublicate parenthesis;
        String str="(a)";
        Stack<Character> stack=new Stack<>();
        Parenthesis vp=new Parenthesis();
        System.out.println(vp.validParenthesis(stack, str));
    }
}

class If{
    static void findArea(int arr[]){
        int breath[]=new int[arr.length];
       int result=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int j=i+1;
            int count=1;
            while (j<arr.length) {
                if (arr[i]<=arr[j]) {
                    count++;
                    j++;
                    
                }else{
                    break;
                }
            }
            int k=i-1 ;
            while ( k > -1) {
                if (arr[i]<=arr[k]) {
                    count++;
                    k-- ;
                    
                }else{
                    break;
                }
            }
            breath[i]=count;
            int sum= arr[i] * breath[i];
            if (result<sum) {
                result=sum;
            }

        }
        System.out.println(result);

    }
    public static void main(String[] args) {
        //  this is to find the greatest rectangle formed in a histogram;
        // but this is a brute force maybe and has a time compexity of O(n2), so i have to write this for
        // O(n) liner TC ,but using the logic of nearest greater approach.
        int arr[]={2,1,5,6,2,3};
        findArea(arr);


    }
}
class NextGreatest{
    static void findGreatestELementInRight(int arr[],Stack<Integer> stack){
        int greatestElements[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while (!stack.empty()) {
                if ( arr[i] >= stack.peek()) {
                    stack.pop();
                    
                }else{
                    break;
                }
                
            }
            if (stack.isEmpty()) {
                greatestElements[i]=-1;
            }else{
                greatestElements[i]=stack.peek();
            }
            stack.push(arr[i]);
            
        }
        System.out.println(Arrays.toString(greatestElements));
    }
    public static void main(String[] args) {
        // finding the next greater on the right side ; for O(n) or linear time complexity;
        int arr[]={6,8,0,1,3};
        Stack<Integer> stack=new Stack<>();
        findGreatestELementInRight(arr, stack);

    }
}
class GreatestElement<T>{
    void findGreatestELement(int arr[]){
        int element[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if ( arr[i] < arr[j] ) {
                    element[i]=arr[j];
                    break;
                }
                if (j==arr.length-1) {
                    element[i]=-1;
                }
                 
            }
            if (i==arr.length-1) {
                element[i]=-1;
            }
        }
        System.out.println(Arrays.toString(element));
        
    }

    T check(Stack<Integer> obj,int checker){
        if (obj.empty()) {
            return -1;
        }
        int num=obj.peek();
        if (num > checker) {
            return num;
        }
        int num1=obj.pop();
        int result=check(obj, checker);
        obj.push(num1);
        
        return result;
    }

     void findGreatestElementUsingStack(Stack<Integer> obj,ArrayList<Integer> greatestElementsList){
        
        int tempNum=obj.pop();
        if (obj.empty()) {
            greatestElementsList.add(-1);
            return;
        }

        if (obj.peek()>tempNum) {
            greatestElementsList.add(obj.peek());

            
        }else{
             
            int num=check(obj, tempNum);
            greatestElementsList.add(num);
            
        }
        
        findGreatestElementUsingStack(obj,greatestElementsList);
    


    }

    public static void main(String[] args) {
        // this is for finding the gratest element using nested loop;
        // int arr[]={6,8,0,1,3};
        // findGreatestELement(arr);
        
        // for finding the Greatest element using resursion and stack;
        Stack<Integer> stack=new Stack<>();
        stack.add(3);
        stack.add(1);
        stack.add(0);
        stack.add(8);
        stack.add(6);
        findGreatestElementUsingStack(stack, greatestElements);
        System.out.println(greatestElements);
        
         
        
         
    }
}

class Stack<T> {
    class StackUsingList<T> {
        ArrayList<T> arrayList = new ArrayList<>();

        Boolean isEmpty() {
            return arrayList.size() == 0;
        }

        void push(T data) {
            arrayList.add(data);
        }

        T pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return null;
            }
            T num = arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            return num;
        }

        T peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return null;
            }
            return arrayList.get(arrayList.size() - 1);
        }
    }

    void printStack(StackUsingList<T> obj) {
        while (!obj.isEmpty()) {
            System.out.println(obj.pop());
        }
    }

    void pushAtBottom(StackUsingList<T> obj, T data) {
        if (obj.isEmpty()) {
            obj.push(data);
            return;
        }

        T remove = obj.pop();
        pushAtBottom(obj, data);
        obj.push(remove);
    }
    void reverseAstack(StackUsingList<T> obj){
          if (obj.isEmpty()) {
                    return;
          }
          T remove=obj.pop();
          reverseAstack(obj);
          pushAtBottom(obj, remove);
    }

    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        Stack<Character>.StackUsingList<Character> stack = s.new StackUsingList<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');
        s.reverseAstack(stack);
        s.printStack(stack);
    }
}
