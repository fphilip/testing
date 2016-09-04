package houseware.learn.testing.mockito;

import java.util.HashMap;
import java.util.Map;

public class MyDictionary {

    Map<String, String> wordMap;

    public MyDictionary() {
        wordMap = new HashMap<>();
    }

    public String getMeaning(final String word) {
        return wordMap.get(word);
    }
}
