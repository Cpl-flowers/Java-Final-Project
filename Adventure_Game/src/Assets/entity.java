package Assets;

public abstract class entity {
    private static int health = 0;
    private static String name = "";
    private static int attack = 0;
    private static int defense = 0;

    public static void setHealth(int x) {
        health = x;
    }

    public static void setAttack(int x) {
        attack = x;
    }

    public static void setDefense(int x) {
        defense = x;
    }

    public static void setName(String x) {
        name = x;
    }

    public static void attack() {

    }
}
