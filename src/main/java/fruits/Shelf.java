package fruits;

import com.google.common.base.Function;

import java.util.ArrayList;

public interface Shelf {

    void sort(ArrayList<Fruit> fruit, Function<Integer, String> sortByProperty);

}
