class BinarySearchTrees{

    static class Node{
        int data;
        Node leftNode;
        Node rightNode;
        Node(int data){
            this.data=data;
            this.leftNode=null;
            this.rightNode=null;
        }
              
    }
    class BST{
              
        Node insert(Node root, int value){
            if (root==null) {
                root=new Node(value);
                return root ;
            }
            
            if (value < root.data) {
                root.leftNode=insert(root.leftNode, value);
                      
            }else {
                root.rightNode=insert(root.rightNode,value);
            }

            return root;
        }
              
    }
    void inorder(Node root){
        if (root == null) {
                  return;
        }

        inorder(root.leftNode);
        System.out.print(root.data+" ");
        inorder(root.rightNode);
    }

    boolean search(Node root, int key){
        if (root==null) {
            return false;
        }
        if (root.data == key) {
            return true;
                  
        }else if (root.data > key) {
            return search(root.leftNode, key);
        }else {
            return search(root.rightNode, key);
                  
        }
              
    }
    Node findInOrder(Node root){
        if (root.leftNode == null) {
            return root;
        }
        Node lm=findInOrder(root.leftNode);
        return lm;
    }
    Node delete(Node root,int key){
        
        if(root.data > key) {
           root.leftNode= delete(root.leftNode, key);
        }else if(root.data<key){

            root.rightNode=delete(root.rightNode, key);

        }else {
            if (root.leftNode == null && root.rightNode == null) {
                return null;
            }
            if (root.leftNode == null) {
                return root.rightNode;
            } else if (root.rightNode == null){
                return root.leftNode;
            }
            if (root.leftNode != null && root.rightNode != null ) {
                Node inOrderSuccessor=findInOrder(root.rightNode);
                root.data=inOrderSuccessor.data;
                root.rightNode=delete(root.rightNode, inOrderSuccessor.data);
            }
        }
        return root;
        
    }
    
    boolean verifyBST(Node root){
        if (root  ==  null) {
            return true;
        }
        if (root.leftNode != null && root.rightNode != null) {
            if (root.data > root.rightNode.data || root.data < root.leftNode.data) {
                return false;
            }
        }else if (root.leftNode != null ) {
            if (root.data < root.leftNode.data ) {
                return false;
                
            }
        } else if (root.rightNode != null){
            if (root.data > root.rightNode.data) {
                return false;
            }
        }
        
        
        return verifyBST(root.leftNode) && verifyBST(root.rightNode);
    }
    Node mirrorBST(Node root){
        if (root == null) {
            return null;
        }
        root.leftNode=mirrorBST(root.rightNode);
        root.rightNode=mirrorBST(root.leftNode);
        return root;
    }
    public static void main(String[] args) {
        BinarySearchTrees obj=new BinarySearchTrees();
        int nodes[]=new int[]{5,1,3,4,8,6,9};
        Node root=null;
        
        
        for (int value : nodes) {
            root=new BinarySearchTrees().new BST().insert(root, value);
                  
        }
        
        obj.inorder(root);
        // System.out.println(obj.search(root,1));
        // obj.delete(root, 5);
        // System.out.println();
        // obj.inorder(root);



        // Node root=new Node(9);

        // root.leftNode=new Node(5);
        // root.rightNode=new Node(10);
        
        // root.leftNode.rightNode=new Node(7);

        
        // root.leftNode.rightNode.leftNode=new Node(2);
        // root.leftNode.rightNode.rightNode=new Node(13);


        // System.out.println("validate BSt");
        // System.out.println(obj.verifyBST(root));
        
        obj.mirrorBST(root);
        System.out.println();
        obj.inorder(root);
    }
    
}
