package assets;
import java.util.*;

public class Goblin extends Entity {
    // attributes health, attack, defense, name

    // methods
    @Override
    public int attack() {
        Random randomNum = new Random();
        int monsterdamage = randomNum.nextInt(super.attack);
        return monsterdamage;
    }
}