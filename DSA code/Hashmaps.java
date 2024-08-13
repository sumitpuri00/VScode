// import java.util.ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hashmaps {
    static class HashMap<K,V>{
        class Node{
            K key;
            V value;
            Node(K key ,V value){
                this.key=key;
                this.value=value;
            }
        }
        LinkedList<Node> bucket[];
        int bucketSize;
        int totalNodes;
        
        HashMap(){
            this.bucketSize=4;
            this.totalNodes=0;
            this.bucket=new LinkedList[bucketSize];
            for(int i=0; i<bucket.length; i++){
                bucket[i]=new LinkedList<>();
            }
        }
        int hashFunction(K key){
            int inddex=Math.abs(key.hashCode()) % bucketSize;
            return inddex;

        }
        int searchInLL(K key, int bucketIdx){
            LinkedList<Node> bucketLL =bucket[bucketIdx];
            for(int i=0;i<bucketLL.size();i++){
                if (bucketLL.get(i).key==key) {
                    return i;
                } 
            }
            return -1;
        }
        
        void reHashing(){
            bucketSize=bucketSize*2;
            LinkedList<Node> oldBucket []=bucket;
            bucket=new LinkedList[bucketSize];

            for(int i=0;i<bucket.length;i++){
                bucket[i]=new LinkedList<>();
            }

            // adding data from old bucket to bucket
            for(int i=0; i<oldBucket.length;i++){
                for(int j=0;j<oldBucket[i].size();j++){
                    Node oldNodes=oldBucket[i].get(j);
                    put(oldNodes.key,oldNodes.value);
                }
            }

        }
        void put(K key,V value){
            int bucketIdx=hashFunction(key);
            int dataIdx=searchInLL(key,bucketIdx);
            if (dataIdx == -1) {
                bucket[bucketIdx].add(new Node(key, value));
                totalNodes++;
            }else{
                bucket[bucketIdx].get(dataIdx).value=value;
            }

            float lamda= (float) totalNodes / bucketSize;
            if (lamda > 2.0) {
                reHashing();
            }
        }

        boolean containsKey(K key){
            int bucketIdx= hashFunction(key);
            int nodeIdx=searchInLL(key, bucketIdx);
            if (nodeIdx != -1) {
                return true;
            }else{
                return false;
            }
        }

        V get(K key){
            int bucketIdx=hashFunction(key);
            int nodeIdx=searchInLL(key, bucketIdx);
            if (nodeIdx != -1) {
                return bucket[bucketIdx].get(nodeIdx).value;
            }else{
                return null;
            }
        }
        V remove(K key){
            int bucketIdx=hashFunction(key);
            int nodeIdx=searchInLL(key, bucketIdx);
            if (nodeIdx != -1) {
                Node removedNode=bucket[bucketIdx].remove(nodeIdx);
                return removedNode.value;
            }else{
                return null;
            }
        }

        ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0;i<bucket.length;i++){
                LinkedList<Node> ll=bucket[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        boolean isEmpty(){
            if (totalNodes != 0 ) {
                return false;
                
            }else{
                return true;
            }
        }

    }

    
    public static void main(String[] args) {
        Hashmaps.HashMap<String,Integer> obj =new Hashmaps.HashMap<>();
        System.out.println(obj.isEmpty());
        obj.put("india", 200);
        obj.put("us", 4);
        for (String keys : obj.keySet()) {
            System.out.println(keys) ;
        }
        

    }
}
