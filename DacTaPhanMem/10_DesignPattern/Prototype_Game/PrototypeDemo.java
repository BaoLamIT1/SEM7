public class PrototypeDemo {
    public static void main(String[] args) {
        // Tạo các prototype ban đầu
        Warrior warrior = new Warrior("Basic Warrior", 1);
        warrior.addSkill("Slash");
        warrior.addSkill("Block");

        Mage mage = new Mage("Basic Mage", 1);
        mage.addSkill("Fireball");
        mage.addSkill("Teleport");

        Archer archer = new Archer("Basic Archer", 1);
        archer.addSkill("Arrow Shot");
        archer.addSkill("Evasion");

        // Thêm prototype vào hệ thống
        Game game = new Game();
        game.addPrototype("Warrior", warrior);
        game.addPrototype("Mage", mage);
        game.addPrototype("Archer", archer);

        // Tạo nhân vật từ prototype
        Character player1Warrior = game.createCharacter("Warrior");
        player1Warrior.displayInfo();

        Character player2Mage = game.createCharacter("Mage");
        player2Mage.displayInfo();

        // Tùy chỉnh thêm sau khi sao chép
        Character player3Archer = game.createCharacter("Archer");
        ((CharacterPrototype) player3Archer).addSkill("Special Shot");
        player3Archer.displayInfo();
    }
}
