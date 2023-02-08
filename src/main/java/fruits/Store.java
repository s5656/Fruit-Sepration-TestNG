package fruits;

import com.google.common.base.Function;

import java.util.ArrayList;
;

public class Store {
    public static void main(String[] args) {

        ArrayList<Fruit> bowl = new ArrayList();

        bowl.add(new Fruit("Apple", "Red", "Sweet", "Medium"));
        bowl.add(new Fruit("Grape", "Purple", "Salty", "Small"));
        bowl.add(new Fruit("Mango", "Yellow", "Sweet", "Medium"));
        bowl.add(new Fruit("Pineapple", "Yellow", "Sweet", "Large"));
        bowl.add(new Fruit("Watermelon", "Green", "Sweet", "Large"));
        bowl.add(new Fruit("Orange", "Orange", "Sour", "Medium"));
        bowl.add(new Fruit("Lemon", "Yellow", "Sour", "Small"));
        bowl.add(new Fruit("Cherry", "Red", "Sweet", "Small"));
        bowl.add(new Fruit("Kiwi", "green", "Salty", "Small"));
        bowl.add(new Fruit("Papaya", "Green", "Sour", "Large"));

        ThreeLayerShelf threeLayerShelf = new ThreeLayerShelf();

        System.out.println("According to Size");
        Function<Integer, String> sortBySize = (index) -> bowl.get(index).getSize();
        threeLayerShelf.sort(bowl, sortBySize);

        System.out.println("-----------------------------------------------------------");

        System.out.println("According to Taste");
        Function<Integer, String> sortByTaste = (index) -> bowl.get(index).getTaste();
        threeLayerShelf.sort(bowl, sortByTaste);
    }
}

