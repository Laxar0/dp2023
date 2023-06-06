package Servlets;

import Entities.EEntity;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Helpers {
    public static JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    public static EEntity entityParse(HttpServletRequest request) {
        EEntity entity = new EEntity();
        JsonElement jsonElement = bodyParse(request);
        entity.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        entity.setImg(jsonElement.getAsJsonObject().get("img").getAsString());
        entity.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        entity.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        return entity;
    }

    public static int getNextId(List<EEntity> list) {
        int maxId = 0;

        Iterator<EEntity> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public static int getIndexById(int id, List<EEntity> list) {
        int listId = id;

        Iterator<EEntity> iterator = list.iterator();
        while (iterator.hasNext()) {
            EEntity temp = iterator.next();
            if (temp.getId() == listId) {
                listId = list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
}
