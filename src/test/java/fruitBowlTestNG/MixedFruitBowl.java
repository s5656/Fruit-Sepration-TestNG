package fruitBowlTestNG;

import java.util.List;

public class MixedFruitBowl {

    private List<Fruit> fruitBowl;

    public MixedFruitBowl(List<Fruit> fruitBowl) {
        this.fruitBowl=fruitBowl;
    }
    public void showAllTheFruits() {
            System.out.println(fruitBowl);
            System.out.println();
    }
}
