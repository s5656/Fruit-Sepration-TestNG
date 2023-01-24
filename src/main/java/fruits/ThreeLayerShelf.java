package fruits;

import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ThreeLayerShelf implements Shelf{
    public void sort(ArrayList<Fruit> fruit, Function<Integer, String> sortByProperty) {
        HashMap<String, List<Fruit>> sorted = new HashMap<>();

        for(int i=0; i<fruit.size();i++){
            String data= sortByProperty.apply(i);

            if(sorted.containsKey(data)){
                List<Fruit>fruitList=new ArrayList<>();

                fruitList.addAll(sorted.get(data));

                fruitList.add(fruit.get(i));
                sorted.put(data,fruitList);
            }
            else {
                sorted.put(data,List.of(fruit.get(i)));
            }
        }
        for (Map.Entry<String,List<Fruit>> map : sorted.entrySet()) {
            System.out.println(map.getKey()+" : "+ map.getValue());
        }
    }
}
