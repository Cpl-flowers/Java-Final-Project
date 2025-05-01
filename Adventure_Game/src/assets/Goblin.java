package assets;

public class Goblin extends Entity {
    // attributes health, attack, defense, name

    // methods
    @Override
    public int attack(int entityDamage, int entityHP) {
        int randDamage = new java.util.Random().nextInt(entityDamage);
        entityHP -= randDamage;
        return entityHP;
    }
}