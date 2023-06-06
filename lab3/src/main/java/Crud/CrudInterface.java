package Crud;

import Entities.Entity;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CrudInterface {
    Entity readEntity();
    void updateEntity(Entity car);

    Entity carParse(HttpServletRequest request);
    int getIndexByCarId(int id, List<Entity> list);
    int getNextId(List<Entity> list);
}
