package Assets;

public class goblin extends entity {

    // attributes health, attack, defense, name

    // methods


    public static void attack(int x, int y) {
        int monsterDamage = new java.util.Random().nextInt(x);
        int playerHP = y;
        playerHP -= monsterDamage;
    }

}