import java.util.ArrayList;
import java.util.List;

public abstract class CharacterPrototype implements Character {
    protected String name;
    protected int level;
    protected List<String> skills;

    public CharacterPrototype(String name, int level) {
        this.name = name;
        this.level = level;
        this.skills = new ArrayList<>();
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    @Override
    public Character clone() {
        try {
            CharacterPrototype clone = (CharacterPrototype) super.clone();
            clone.skills = new ArrayList<>(this.skills); // Deep copy danh sách kỹ năng
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name + ", Level: " + level + ", Skills: " + skills);
    }
}
