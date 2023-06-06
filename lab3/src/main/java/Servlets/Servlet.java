package Servlets;

import Crud.CrudInterface;
import Entities.EntityList;
import Entities.Entity;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/entityes/*")
public class Servlet extends HttpServlet {
    private List<Entity> entity = new EntityList().getList();
    ServletConfigInterface servletConfig; //fills crud
    CrudInterface crud;

    public Servlet() {
        super();
        this.servletConfig = new ServletConfig();
        this.crud = servletConfig.getCrud();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String entityJson = new Gson().toJson(entity);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.print(entityJson);
        out.flush();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Entity car = crud.carParse(request);
        car.setId(crud.getNextId(entity));
        entity.add(car);
        doGet(request, response);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        /*  String img = request.getParameter("img");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price")); //converting string data from request into integer value
        crud.updateEntity(new EntityCar(img, name, price)); */

        Entity car = crud.carParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = crud.getIndexByCarId(id, entity); //list index to store entity
        entity.set(index, car);
        doGet(request, response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = crud.getIndexByCarId(id, entity); //list index to store entity
        entity.remove(index);
        doGet(request, response);
    }
}

