import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Character> prototypes = new HashMap<>();

    public void addPrototype(String type, Character prototype) {
        prototypes.put(type, prototype);
    }

    public Character createCharacter(String type) {
        Character prototype = prototypes.get(type);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new IllegalArgumentException("Character type not found: " + type);
    }
}
