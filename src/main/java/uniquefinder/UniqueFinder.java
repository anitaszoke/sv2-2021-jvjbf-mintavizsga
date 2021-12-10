package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> getUniqueChars(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Text is null.");
        }
        List<Character> characters = new ArrayList<>();
        for (Character c : word.toCharArray()) {
            if (!characters.contains(c)) {
                characters.add(c);
            }
        }
        return characters;
    }
}
