import java.util.HashMap;

public class TreeFactory { 
    private static HashMap<String, TreeType> treeTypes = new HashMap<>();
    public static TreeType getTreeType(String name, String color, String texture) {
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, texture);
            treeTypes.put(name, result);
        }
        return result;
    }
}
