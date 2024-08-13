import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;
import javax.swing.plaf.metal.MetalTheme;
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
    void preOrder(Node hNode){
        if (hNode==null) {
            System.out.print("-1"+" ");
            return;
        }

        System.out.print(hNode.data + " ");
        preOrder(hNode.leftNode);
        preOrder(hNode.rightNode);
    }
    void inOrder(Node hNode){
        if (hNode==null) {
            return;
        }
        inOrder(hNode.leftNode);
        System.out.print(hNode.data +" ");
        inOrder(hNode.rightNode);

    }
    void postOrder(Node hNode){
        if (hNode==null) {
            return;
        }
        postOrder(hNode.leftNode);
        postOrder(hNode.rightNode);
        System.out.print(hNode.data+" ");
    }
    void levelOrder(Node hNode){
        Queue<Node>queue =new LinkedList<>();
        
        queue.add(hNode);
        queue.add(null);
    
        
        while (!queue.isEmpty()) {
            Node currNode=queue.remove() ;
            
            if (currNode == null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                System.out.println();
                 
            }else{
                System.out.print(currNode.data+" ");
                if (currNode.leftNode != null) {
                    queue.add(currNode.leftNode);
                }
                if (currNode.rightNode != null) {
                    queue.add(currNode.rightNode);
                }
                
                 
            }

        }
    }
    int heightOfTheTree(Node hNode){
        if (hNode==null) {
            return 0;
        }
        int lh=heightOfTheTree(hNode.leftNode);
        int rh=heightOfTheTree(hNode.rightNode);
        int result=Math.max(lh, rh)+1;
        return result;

    }
    int countNodes(Node hNode){
        if (hNode==null) {
            return 0;
        }
        int lc=countNodes(hNode.leftNode);
        int rc=countNodes(hNode.rightNode);
        int tcount=lc+rc+1;
        return tcount;
    }
    int diameterOfTree(Node hNode){
        if (hNode == null) {
            return 0;
        }
        int lc=diameterOfTree(hNode.leftNode);
        int rc=diameterOfTree(hNode.rightNode);
        int self=heightOfTheTree(hNode.leftNode)+heightOfTheTree(hNode.rightNode)+ 1;
        int result=Math.max(Math.max(lc, rc), self);
        return result;

    }
    boolean isIdentical(Node root,Node subRoot){
        if (root == null && subRoot ==null) {
            return true;
        }
        else if (root.data != subRoot.data || root == null || subRoot == null ) {
            return false;
        }
        if (!isIdentical(root.leftNode, subRoot.leftNode)) {
            return false;
        }
        if (!isIdentical(root.rightNode, subRoot.rightNode)) {
            return false;   
        }

        return true;
    }
    boolean isSubTreeExist(Node root ,Node subRoot){
        if (root == null) {
            return false ;
        }

        if (root.data == subRoot.data) {
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        
        return isSubTreeExist(root.leftNode, subRoot) || isSubTreeExist(root.rightNode, subRoot);
        
    }

    class Info{
        // class to help the function findDiameterTwo
        int diameter;
        int height;
        Info(int diameter,int height){
            this.diameter=diameter;
            this.height=height;
        }
    }

    Info findDiameterTwo(Node root){
        // this way we have optimize the complexity to O(n) or linear time;
        if (root ==  null) {
            return new Info(0,0);
        }
        Info leftInfo=findDiameterTwo(root.leftNode);
        Info rightInfo=findDiameterTwo(root.rightNode);
        
        int diameter=Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height +1);
        int height=Math.max(leftInfo.height, rightInfo.height)+1;

        return new Info(diameter,height);

    }
    class InfoTwo{
        // class to help the function topViewOfTree();
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
        // queue.add(null); // the purpose of null is just to print next line in level order treversal
        
        while (!queue.isEmpty()) {
            InfoTwo curr=queue.remove();
 

            if (!map.containsKey(curr.horizontalD)) {
                map.put(curr.horizontalD, curr.node);
            }
            if (curr.node.leftNode != null) {
                queue.add(new InfoTwo(curr.node.leftNode, curr.horizontalD-1));
                min=Math.min(curr.horizontalD-1, min);
            }
            if (curr.node.rightNode != null) {
                queue.add(new InfoTwo(curr.node.rightNode, curr.horizontalD+1)); 
                max=Math.max(curr.horizontalD+1, max);
            }
            
        }

        for(int i=min;i<=max;i++){
            System.out.print(map.remove(i).data+" ");
        }
         
    }
    class LevelInfo{
        // class to help findKthlevel();
        int level;
        Node node;
        LevelInfo(Node node, int level){
            this.node=node;
            this.level=level;
        }
    }
    void findKthLevel(Node node,int level){
        // iterative way

        Queue<LevelInfo> queue=new LinkedList<>();
        
        queue.add(new LevelInfo(node,1));
        queue.add(null);

        while (!queue.isEmpty()) {
            LevelInfo curr=queue.remove();
           
            if (curr== null) {
                if (queue.isEmpty() ) {
                    break;
                }
                queue.add(null);
               
            }else{
                if (curr.level==level) {
                    System.out.print(curr.node.data+" ");
                }
                if (curr.node.leftNode != null && curr.level+1 <= level) {
                    queue.add(new LevelInfo(curr.node.leftNode,curr.level+1));
                }
                if (curr.node.rightNode != null && curr.level+1 <= level) {
                    queue.add(new LevelInfo(curr.node.rightNode,curr.level+1));
                }
            }
        }

    }
    void findKthLevelUsingRecursion(Node node,int count,int level){

        if (node== null) {
            return;
        }
        if (count==level) {
            System.out.print(node.data+" ");
        }
        findKthLevelUsingRecursion(node.leftNode, count+1, level);
        findKthLevelUsingRecursion(node.rightNode, count+1, level);


    }
    boolean fillList(Node root,int leaf,ArrayList<Node> list){
        if (root==null) {
            return false;
        }
        list.add(root);

        if (root.data==leaf) {
            return true;
        }
        boolean left=fillList(root.leftNode, leaf, list);
        boolean right=fillList(root.rightNode, leaf, list);

        if (right || left) {
            return true;
        }
        list.remove(list.size()-1);
        

        return false;


    }
    void findLowertCommonAncestor(Node root,int n1, int n2){
        ArrayList<Node> list1=new ArrayList<>();
        ArrayList<Node> list2=new ArrayList<>();

        fillList(root,n1,list1);
        fillList(root,n2,list2);

        int i=0;
        for(;i<list1.size() && i<list2.size(); i++){
            if (list1.get(i) != list2.get(i)) {
                break;
            }
        }
        System.out.println(list1.get(i-1).data);
    }
    
    Node lowestCommonAncestor(Node root, int n1,int n2){
        // second approach
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftNext=lowestCommonAncestor(root.leftNode, n1, n2);
        Node rightNext=lowestCommonAncestor(root.rightNode, n1, n2);
        if (leftNext == null) {
            return rightNext;
        }
        if (rightNext == null) {
            return leftNext;
        }

        return  root;

    }
    int minimunDistanceBtTwoNodes(Node root,int leaf1,int leaf2){
        if (root == null) {
            return -1;
        }
        if (root.data == leaf1 && root.data ==leaf2) {
            return -1;
        }
        if (root.data == leaf1 || root.data == leaf2) {
            return 0;
        }
        int ld=minimunDistanceBtTwoNodes(root.leftNode, leaf1, leaf2);
        int rd=minimunDistanceBtTwoNodes(root.rightNode, leaf1, leaf2);
        

        if (ld == -1 && rd == -1) {
            return -1;
        }else if(ld == -1){
            return rd+1;
        }else if(rd == -1){
            return ld+1;
        }


        return ld+rd+1;
    }
    public static void main(String[] args) {

        // first tree
        // int nodes[]=new int[]{1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        // second tree
        int nodes []=new int[]{1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};

        //  third tree
        // int nodes []=new int[]{99,2,3,-1,4,5,-1,6,7,-1,-1,8,9,10,-1,-1,-1,-1,-1,11,-1,12,13,-1,14,15,-1,16,17,-1,-1,-1,18,19,-1,-1,20,21,-1,-1,22,23,-1,-1,-1};
        

        
        Node root =new Trees().new BinaryTree().buildBinaryTree(nodes);

        // int nodesTwo[]=new int[]{6,-1,7,-1,-1};

        // Node subRoot=new Trees().new BinaryTree().buildBinaryTree(nodesTwo);

        // System.out.println(root.rightNode.data);
        Trees treesObj=new Trees();
        // System.out.println(root.data);
        
        // System.out.println("this is preorder");
        // treesObj.preOrder(root);

        // treesObj.inOrder(root);

        // treesObj.postOrder(root);
        // treesObj.levelOrder(root);
        // System.out.println(treesObj.heightOfTheTree(root));
        // System.out.println(treesObj.countNodes(root));
        // System.out.print("diameter of thr tree is ");
        // System.out.println(treesObj.diameterOfTree(root));


        // System.out.println(treesObj.isSubTreeExist(root, subRoot));


        // System.out.println(treesObj.findDiameterTwo(root).diameter);
        // treesObj.topViewOfTree(root);
        // treesObj.findKthLevel(root, 2);
        // treesObj.findKthLevelUsingRecursion(root, 1, 3);
        // treesObj.findLowertCommonAncestor(root, 4,3);
        System.out.println(treesObj.lowestCommonAncestor(root,2,7).data);
    }

          
}
