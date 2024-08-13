import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

class RandomGraph {
    public static void main(String[] args) {
        // Define the vertices
        int[] vertices = {3, 5, 2, 8, 4};

        // Create a map to represent the adjacency list of the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize the adjacency list
        for (int vertex : vertices) {
            graph.put(vertex, new ArrayList<>());
        }

        // Randomly connect the vertices
        Random random = new Random();
        for (int i = 0; i < vertices.length; i++) {
            int v1 = vertices[random.nextInt(vertices.length)];
            int v2 = vertices[random.nextInt(vertices.length)];
            
            // Avoid self-loops and duplicate edges
            if (v1 != v2 && !graph.get(v1).contains(v2)) {
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
             
        }

        // Print the adjacency list
        for (int vertex : graph.keySet()) {
            System.out.println(vertex + " -> " + graph.get(vertex));
        }
        
        

    }
}

class puri{
    static Integer sumit(){
        return null;
    }
    public static void main(String[] args) {
        LinkedList<Integer> ss=new LinkedList<>();
        ss.add(3);
        System.out.println(ss.get(0));
        System.out.println(sumit());
        System.out.println(7%4);

        float arr[]=new float[2];
        System.out.println(Arrays.toString(arr));
    }
}
class Fun{
    static int num=9;

    void m2(){
        System.out.println("i am outside fun");
    }
    static class moreFun{
        
        void m1(){
            m2();
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        new Fun().new moreFun().m1();
    }
}
class TreeTwo{
    public static void main(String[] args) {
        System.out.println("there is nothing to work on ;");
    }
}
class Trees {
    class Node{
        int data;
        Node leftNode;
        Node rightNode;
        Node(int data){
            this.data=data;
            this.leftNode=null;
            this.rightNode=null;
        }
    }
    class BinaryTree{
        int arrIdx=-1;
        Node buildBinaryTree(int nodes[]){
            arrIdx++;
            if (arrIdx >=nodes.length || nodes[arrIdx] == -1) {
                return null;
            }
            Node newNode=new Node(nodes[arrIdx]);

            newNode.leftNode=buildBinaryTree(nodes);
            newNode.rightNode=buildBinaryTree(nodes);

            return newNode;
            
            
        }
    }
    
    class InfoTwo{
        Node node;
        int horizontalD;
        InfoTwo(Node node, int horizontalD){
            this.node=node;
            this.horizontalD=horizontalD;
        }
    }
    void topViewOfTree(Node root){
        Queue<InfoTwo> queue=new LinkedList<>();
        HashMap<Integer,Node>map=new HashMap<>();
        int min=0;
        int max=0;
        queue.add(new InfoTwo(root, 0));
        queue.add(null);
        while (!queue.isEmpty()) {
            InfoTwo curr=queue.remove();

            if (curr==null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            }else{

                if (!map.containsKey(curr.horizontalD)) {
                    map.put(curr.horizontalD, curr.node);
                }

                if (curr.node.leftNode != null) {
                    queue.add(new InfoTwo(curr.node.leftNode, curr.horizontalD-1));
                    min=Math.min(curr.horizontalD, min);
                }
                if (curr.node.rightNode != null) {
                    queue.add(new InfoTwo(curr.node.rightNode, curr.horizontalD+1)); 
                    max=Math.max(curr.horizontalD, max);
                }
            }
        }

        for(int i=min;i<=max;i++){
            System.out.print(map.remove(i).data+" ");
        }
         
    }

    public static void main(String[] args) {

        
        int nodes []=new int[]{1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};

        

        
        Node root =new Trees().new BinaryTree().buildBinaryTree(nodes);

       
        Trees treesObj=new Trees();
        
        
        treesObj.topViewOfTree(root);
    }

          
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BinaryTreeFromPreorder {
    int index = 0;

    public TreeNode buildTree(int[] nodes) {
        if (index >= nodes.length || nodes[index] == -1) {
            index++;
            return null;
        }
        
        TreeNode node = new TreeNode(nodes[index++]);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{1,2,3,-1,4,5,-1,6,7,-1,-1,8,9,10,-1,-1,-1,-1,-1,11,-1,12,13,-1,14,15,-1,16,17,-1,-1,-1,18,19,-1,-1,20,21,-1,-1,22,23,-1,-1,-1};
        
        BinaryTreeFromPreorder treeBuilder = new BinaryTreeFromPreorder();
        TreeNode root = treeBuilder.buildTree(nodes);
        
        System.out.println("Preorder traversal of the constructed binary tree:");
        treeBuilder.printTree(root);
    }
}

class Solution {
    static public int[] twoSum(int[] nums, int target) {
        int p1=0;
        int p2=nums.length-1;
        while(p1 <= p2){
            if((nums[p1]+nums[p2])== target){
                return  new int[]{p1,p2};
            }else if((nums[p1]+nums[p2]) < target){
                p1++;
               
            } else {
                p2--;
             
            }
         
            
        }
        return null;
    }
    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[]{1,2,4,6,9}, 3)));
    }
}





// class DublicateParenthsis{
//     void findDublicate(Stack<Character> obj, String str){
//         for(int i=0; i<str.length();i++){

//             char ch=str.charAt(i);
//             System.out.println(ch);

//             if (ch=='[' || ch=='{' || ch=='(') {
//                 obj.push(ch);
//                 System.out.println(0);
                
//             } else if (ch !=']' && ch !='}' && ch !=')') {
//                 obj.push(ch);
//                 System.out.println(1);
     
//             } else{
//                 System.out.println("3");
//                 if (obj.empty()) {
//                     System.out.println("wrong string of parenthesis 1");
//                 }
//                 boolean is=false;
//                 char charr=obj.peek();
//                 while(charr != ')' && charr !='}' && charr !=']') {
//                     is=true;
//                     obj.pop();
        
//                 }
                
//                 if ((obj.peek()=='[' && ch==']') ||
//                  (obj.peek()=='{' && ch=='}') || 
//                  (obj.peek()=='(' && ch==')') ) {
//                     if (is) {
//                         obj.pop();
//                     }else{
//                         obj.pop();
//                         System.out.println("dublicate parenthesis string 2");
//                     }
//                 }

//             }
    
//         }
//         if (obj.empty()) {
//             System.out.println("string of parenthsis is correct 3");;
//         }else{
//             System.out.println("wrong string of parenthesis 4");;
//         }
//     }
//     public static void main(String[] args) {
//         String str="(a)";
//         Stack<Character> stack=new Stack<>();
//         DublicateParenthsis dp=new DublicateParenthsis();
//         dp.findDublicate(stack,str);
 
//     }
// }









// class Practice{
//     void quickSortAgain(int arr[],int iIdx, int fIdx){
//         if (iIdx>=fIdx) {
//             return;
//         }
//         int pivot=partition(iIdx,fIdx,arr);
        
//         quickSortAgain(arr,iIdx,pivot-1);
//         quickSortAgain(arr,pivot+1,fIdx);
    
//     }
//     int partition(int iIdx,int fIdx,int arr[]){
//         int pointer=iIdx-1;
//         int pivot=fIdx;
//         for(int i=iIdx; i<fIdx; i++){
//             if ( arr[i]<=arr[pivot]) {
//                 pointer++ ;
//                 int temp=arr[pointer];
//                 arr[pointer]=arr[i];
//                 arr[i]=temp;
//             }
//         }
//         pointer++;
//         int temp=arr[pointer];
//         arr[pointer]=arr[pivot];
//         arr[pivot]=temp;

//         return pointer;
//     }
//     public static void main(String[] args) {
//         int arr[]={6,3,9,8,2,5};
//         Practice p=new Practice();
//         p.quickSortAgain(arr,0, arr.length-1);
//         System.out.println(Arrays.toString(arr));

//     }
// }