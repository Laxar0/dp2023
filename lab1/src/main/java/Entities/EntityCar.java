package Entities;

public class EntityCar {
    private String img;
    private String name;
    private int price;

    public EntityCar(String img, String name, int price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{\"img\": \""+img+"\", \"name\": \""+name+"\", \"price\": "+price+"}";
    }
}

