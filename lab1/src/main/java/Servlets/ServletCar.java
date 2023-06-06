package Servlets;

import Entities.EntityCar;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Car")
public class ServletCar extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityCar car = new EntityCar("assets/Terrier-LT-79.jpg", "TERRIER LT-79", 1000);
        String carJson = new Gson().toJson(car);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.print(carJson);
        out.flush();
       // out.println("["+car+"]");
    }
}

