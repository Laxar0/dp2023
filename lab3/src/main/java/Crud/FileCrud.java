package Crud;

import Entities.Entity;
import FileIO.FileIO;
import FileIO.FileIOInterface;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FileCrud implements CrudInterface {

    FileIOInterface fio;

    public FileCrud() {
        this.fio = new FileIO();
    }

    @Override
    public Entity readEntity() {
        return (Entity) fio.loadFromFile();
    }

    @Override
    public void updateEntity(Entity car) {
        fio.saveToFile(car);
    }

    public JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    @Override
    public Entity carParse(HttpServletRequest request) {
        Entity car = new Entity();
        JsonElement jsonElement = bodyParse(request);
        car.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        car.setImg(jsonElement.getAsJsonObject().get("img").getAsString());
        car.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        car.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        return car;
    }

    public int getIndexByCarId(int id, List<Entity> list) {
        int listId = id;

        Iterator<Entity> iterator = list.iterator();
        while(iterator.hasNext()) {
            Entity temp = iterator.next();
            if(temp.getId() == listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }

    public int getNextId(List<Entity> list) {
        int maxId = 0;

        Iterator<Entity> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }
}
