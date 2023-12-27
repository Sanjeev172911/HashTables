import java.util.Scanner;

public class FindFrequency {
    public static String [] wordBreaker(String sentence){
        String cleanedSentence = sentence.replaceAll("[\\.]", " "); // regex to replace space and .
        return cleanedSentence.split("\\s+"); // split it into words based on the space.
    }
    public static void main(String[] args) {
        HashTable<String,Integer>hashMap=new HashTable<>();
        Scanner input=new Scanner(System.in);

        String sentence=input.nextLine();
        String []words=wordBreaker(sentence);
        System.out.println(words.length);
        for(String word:words){
            if(hashMap.containsKey(word)){
                hashMap.put(word,hashMap.getValue(word)+1);
            }else{
                hashMap.put(word,1);
            }
        }

        hashMap.printHashMap();

    }
}
