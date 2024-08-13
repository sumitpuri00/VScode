class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    TrieNode() {
        this.children = new TrieNode[26];
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }
    }
}

public class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Method to insert a word into the trie
    void insert(String word) {
        TrieNode node = root;
      
        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.endOfWord = true;
       
    }

    // Method to print all words in the trie
    void printTrie(TrieNode node, String word) {
        if (node.endOfWord) {
            System.out.println(word);
        }
        
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char ch = (char) (i + 'a');
                printTrie(node.children[i], word + ch);
            }
        }
    }

    // Wrapper method to start printing from the root
    void printTrie() {
        printTrie(root, "");
    }
    boolean isEmpty(){
        for (TrieNode i : root.children) {
            if (i  !=  null) {
                return false;
            }
        }
        return true;
    }
    boolean search( String word){
        if (isEmpty()) {
            System.out.println("trie is empty");
            
        }
        TrieNode node =root;
        for(int i=0; i<word.length();i++){
            int index=word.charAt(i)-'a';
            if (node.children[index] != null) {
                node=node.children[index];
            }else{
                return false;
            }
        }

        return node.endOfWord;

    }

    void searchW(String word){
        System.out.println(search(word));
    }


    boolean wordBreak(String key){
        if (key.length() == 0) {
            return true;
        }
        for(int i=1; i<=key.length(); i++){
            String key1stHalf=key.substring(0,i);
            String key2ndHalf=key.substring(i);
            if (search(key1stHalf) && wordBreak(key2ndHalf)) { 
                return true;
            }
             
        }

        return false;
    }
    void wordBreakW(String key){
        System.out.println(wordBreak(key));
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        
        trie.insert("car");
        trie.insert("dog");
        trie.insert("do");
        trie.insert("cat");

        System.out.println("Words in the trie:");
        // trie.printTrie();  // This will print all words stored in the trie

        trie.wordBreakW("catdodog");
        String s="puri";
        System.out.println(s.length());
        
        
    }
}
