import java.util.LinkedList;
import java.util.Scanner;

public class SentenceOperation {
    static HashTable<String,Integer> frequency;
    static HashTable<String, LinkedList<Integer>>indexOfWord;

    public static String [] wordBreaker(String sentence){
        String cleanedSentence = sentence.replaceAll("[\\.]", " "); // regex to replace space and .
        return cleanedSentence.split("\\s+"); // split it into words based on the space.
    }

    public static void storeFrequency(String []words){
        for(String word:words){
            if(frequency.containsKey(word)){
                frequency.put(word, frequency.getValue(word)+1);
            }else{
                frequency.put(word,1);
            }
        }
    }

    public static String[] takeInput(){
        Scanner input=new Scanner(System.in);
        String sentence=input.nextLine();
        String []words=wordBreaker(sentence);
        return words;
    }

    public static void useCase1(){
        String []words=takeInput();
        storeFrequency(words);
        frequency.printHashMap();
    }

    public static void useCase2(Boolean identifier){
        String []words=takeInput();

        int index=0;
        for(String word:words){
            if(indexOfWord.containsKey(word)){
                LinkedList<Integer>list=indexOfWord.getValue(word);
                list.add(index);
            }else{
                LinkedList<Integer>list=new LinkedList<>();
                list.add(index);
                indexOfWord.put(word,list);
            }

            index++;
        }

        if(identifier) return;

        for(String word:indexOfWord.hashMap.keySet()){
            LinkedList<Integer>list=indexOfWord.getValue(word);
            System.out.print(word+" : ");
            System.out.println(list);
        }
    }

    public static void useCase3(){
        useCase2(true);
        System.out.println("Before Removal \n");
        for(String word:indexOfWord.hashMap.keySet()){
            LinkedList<Integer>list=indexOfWord.getValue(word);
            System.out.print(word+" : ");
            System.out.println(list);
        }

        indexOfWord.remove("avoidable");

        System.out.println("After Removal \n");

        for(String word:indexOfWord.hashMap.keySet()){
            LinkedList<Integer>list=indexOfWord.getValue(word);
            System.out.print(word+" : ");
            System.out.println(list);
        }

    }


    public static void main(String[] args) {
        frequency =new HashTable<>();
        indexOfWord=new HashTable<>();
        useCase1();
        useCase2(false);
        useCase3();
    }
}
