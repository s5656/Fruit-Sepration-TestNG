package fruitBowlTestNG;
import com.google.common.base.Function;
import java.util.*;
public class FruitSegregator {
   private HashMap<String, List<Fruit>> sortedFruits;
    public void sortFruits(List<Fruit> fruit, Function<Integer, String> sortByProperty) { //sort it by using streams
        sortedFruits = new HashMap<>();

        for (int i = 0; i < fruit.size(); i++) {
            String data = sortByProperty.apply(i);

            if (sortedFruits.containsKey(data)) {
                List<Fruit> fruitList = new ArrayList<>();

                fruitList.addAll(sortedFruits.get(data));

                fruitList.add(fruit.get(i));
                sortedFruits.put(data, fruitList);
            } else {
                sortedFruits.put(data, List.of(fruit.get(i)));
            }
        }
        for (Map.Entry<String, List<Fruit>> map : sortedFruits.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }
        System.out.println();
    }
    public HashMap<String, List<Fruit>> getSortedFruits() {
        return sortedFruits;
    }
}