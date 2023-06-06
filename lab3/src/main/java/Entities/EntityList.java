package Entities;

import java.util.ArrayList;
import java.util.List;

public class EntityList {
    private List<Entity> entityList = new ArrayList<>();

    public EntityList () { //contains necessary data
        this.entityList.add(new Entity(1, "assets/Terrier-LT-79.jpg", "TERRIER LT-79", 1000));
        this.entityList.add(new Entity(2, "assets/HUSKY-TSV.jpg", "HUSKY TSV", 1200));
        this.entityList.add(new Entity(3, "assets/BATT-UMG.jfif", "BATT UMG", 900));
    }

    public List<Entity> getList() {
        return entityList;
    }

    public void setCarList(List<Entity> entityList) {
        this.entityList = entityList;
    }
}
