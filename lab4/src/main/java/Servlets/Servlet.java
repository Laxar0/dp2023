package Servlets;

import Crud.CRUDInterface;
import Crud.SqlCRUD;
import Entities.EEntity;
import com.google.gson.Gson;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/entityes/*")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CRUDInterface<EEntity> crud = new SqlCRUD();

    public void init(ServletConfig config) throws ServletException {
        crud = new SqlCRUD();
    }

    public void destroy() {
        try {
            ((SqlCRUD) crud).getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String entityesJson = new Gson().toJson(crud.read());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.print(entityesJson);
        out.flush();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EEntity entity = Helpers.entityParse(request);
        crud.create(entity);
        doGet(request, response);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EEntity entity = Helpers.entityParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.update(id, entity);
        doGet(request, response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.delete(id);
        doGet(request, response);
    }
}

