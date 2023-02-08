package fruitBowlTestNG.exception;
public class ExceptionHandler {
    public void checkColorException(int size) throws MoreThanThreeColorsException {
        if (size > 3) {
            throw new MoreThanThreeColorsException("You have given more than 3 colors of fruit");
        }
    }
}
