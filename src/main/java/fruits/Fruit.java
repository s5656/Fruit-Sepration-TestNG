package fruits;

public class Fruit {
    private String name;
    private String color;
    private String taste;
    private  String size;
    public Fruit(String name, String color, String taste, String size) {
        this.name = name;
        this.color = color;
        this.taste = taste;
        this.size = size;
    }
    public String getColor() {
        return color;
    }
    public String getTaste() {
        return taste;
    }
    public String getSize() {
        return size;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return
                "name :" + name ;
    }
}
