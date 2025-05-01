package assets;

public abstract class Entity {
    public int health;
    public String name;
    public int attack;
    public int defense;
    public static int entityID;

    // methods

    public void setHealth(int x) {
        health = x;
    }
    public void setName(String x) {
        name = x;
    }
    public void setAttack(int x) {
        attack = x;
    }
    public void setDefense(int x) {
        defense = x;
    }
    public int attack(int x, int y){
        return 0;
    }
}