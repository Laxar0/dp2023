package Servlets;

import Entities.EntityWorker;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Staff")
public class ServletWorker extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityWorker worker = new EntityWorker("assets/man-1.jfif", "Andrew Mapper", "Administrator");
        String workerJson = new Gson().toJson(worker);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.print(workerJson);
        out.flush();
       // out.println("["+worker+"]");
    }
}
