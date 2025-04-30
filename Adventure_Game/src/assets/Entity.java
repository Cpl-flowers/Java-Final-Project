package assets;

public abstract class Entity {
    int health;
    String name;
    int attack;
    int defense;

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
    public int attack(){
        return 0;
    }
}