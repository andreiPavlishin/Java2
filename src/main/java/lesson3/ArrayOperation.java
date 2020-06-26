package lesson3;


import java.util.*;

public class ArrayOperation {
    public static void main(String[] args) {
        String[] words = {"word", "Камчатка", "Голова идёт кругом", "Кот",
                "Автомобиль", "Гранит науки","Кот","Море", "Озеро","Автомобиль","Тепло",
                "letter", "sun", "color","Кот","sun","Автомобиль","Новы год"};
        System.out.println(Arrays.toString(words));

        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        for (String x : words){
            hmap.put(x, hmap.getOrDefault(x,0) + 1);
        }System.out.println(hmap);

    }
//public static void main(String[] args) {
//    String[] words = {"word", "Камчатка", "Голова идёт кругом", "Кот",
//            "Автомобиль", "Гранит науки","Кот","Море", "Озеро","Автомобиль","Тепло",
//            "letter", "sun", "color","Кот","sun","Автомобиль","Новы год"};
//    System.out.println(Arrays.toString(words));
//
//    List<String> wordsList = Arrays.asList(words);
//    Map<String, Integer> result = new HashMap<>();
//
//    for (String word : wordsList) {
//        result.put(word, Collections.frequency(wordsList, word));
//    }
//
//
//    result = new HashMap<>();
//    for (String word : wordsList) {
//        if (result.containsKey(word)) {
//            result.put(word, result.get(word) + 1);
//            continue;
//        }
//        result.put(word, 1);
//    }
//
//    System.out.println(result);
//}
}