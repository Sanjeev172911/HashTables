import java.util.HashMap;
import java.util.Map;

public class HashTable <K,V> {
    Map<K,V>hashMap;

    HashTable(){
        hashMap=new HashMap<>();
    }

    public void put(K key,V value){
        hashMap.put(key,value);
    }

    public V getValue(K key){
        return hashMap.get(key);
    }

    public boolean containsKey(K key){
        return hashMap.containsKey(key);
    }

    public int size(){
        return hashMap.size();
    }

    public void remove(K key){
        if(hashMap.containsKey(key)){
            hashMap.remove(key);
        }
    }

    public void printHashMap(){
        for(K key:hashMap.keySet()){
            System.out.println(key+" -> "+this.getValue(key));
        }
    }
}
