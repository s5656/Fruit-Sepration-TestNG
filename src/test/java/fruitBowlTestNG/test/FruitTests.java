package fruitBowlTestNG.test;
import com.google.common.base.Function;
import fruitBowlTestNG.Fruit;
import fruitBowlTestNG.FruitSegregator;
import fruitBowlTestNG.MixedFruitBowl;
import fruitBowlTestNG.exception.ExceptionHandler;
import fruitBowlTestNG.exception.MoreThanThreeColorsException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.*;

public class FruitTests {
    private List<Fruit> fruitBowl;
    private FruitSegregator fruitSegregator;
    @BeforeClass
    public void shouldAddFruitsInBowl(){

        fruitBowl = new ArrayList();

        fruitBowl.add(new Fruit("Apple", "Red", "Sweet", "Medium"));
        fruitBowl.add(new Fruit("Grape", "Purple", "Salty", "Small"));
        fruitBowl.add(new Fruit("Mango", "Yellow", "Sweet", "Medium"));
        fruitBowl.add(new Fruit("Pineapple", "Yellow", "Sweet", "Large"));
        fruitBowl.add(new Fruit("Watermelon", "Green", "Sweet", "Large"));
        fruitBowl.add(new Fruit("Orange", "Orange", "Sour", "Medium"));
        fruitBowl.add(new Fruit("Lemon", "Yellow", "Sour", "Small"));
        fruitBowl.add(new Fruit("Cherry", "Red", "Sweet", "Small"));
        fruitBowl.add(new Fruit("Kiwi", "Green", "Salty", "Small"));
        fruitBowl.add(new Fruit("Papaya", "Green", "Sour", "Large"));

        MixedFruitBowl mixedFruitBowl =new MixedFruitBowl(fruitBowl);
        mixedFruitBowl.showAllTheFruits();
        fruitSegregator = new FruitSegregator();
    }
    @Test (priority = 0)
    public void segregateFruitsBySize(){
        //Arrange
        Function<Integer, String> sortBySize = (index) -> fruitBowl.get(index).getSize();
        //Act
        fruitSegregator.sortFruits(fruitBowl,sortBySize);
        //Assert
            Assert.assertEquals(fruitSegregator.getSortedFruits().values().size(),3); // Compare assertion with help of size which is present after the excicution
            Assert.assertTrue(fruitSegregator.getSortedFruits().containsKey("Medium"));
            Assert.assertTrue(fruitSegregator.getSortedFruits().containsKey("Large"));
    }
    @Test (priority = 1)
    public void segregateFruitsByTaste(){
        //Arrange
        Function<Integer, String> sortByTaste = (index) -> fruitBowl.get(index).getTaste();
        //Act
        fruitSegregator.sortFruits(fruitBowl,sortByTaste);
        //Assert
        Assert.assertTrue(fruitSegregator.getSortedFruits().keySet().contains("Salty"));
        Assert.assertTrue(fruitSegregator.getSortedFruits().keySet().contains("Sweet"));
        Assert.assertTrue(fruitSegregator.getSortedFruits().keySet().contains("Sour"));
    }
    @Test (priority = 2)
    public void segregateFruitsByColor() throws MoreThanThreeColorsException {

        Function<Integer, String> sortByColor = (index) -> fruitBowl.get(index).getColor();
        fruitSegregator.sortFruits(fruitBowl,sortByColor);

        ExceptionHandler exceptionHandler=new ExceptionHandler();
        exceptionHandler.checkColorException(fruitSegregator.getSortedFruits().size());

        Assert.assertTrue(fruitSegregator.getSortedFruits().keySet().contains("Red"));
        Assert.assertTrue(fruitSegregator.getSortedFruits().keySet().contains("Yellow"));
        Assert.assertTrue(fruitSegregator.getSortedFruits().keySet().contains("Green"));

    }
}
