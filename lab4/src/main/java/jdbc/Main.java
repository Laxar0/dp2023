package jdbc;

import Crud.CRUDInterface;
import Crud.SqlCRUD;
import Entities.EEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // CRUDInterface crud = new SqlCRUD();
        Connection connection = new Connect().getCon();

        List<EEntity> list = new ArrayList<>();

    //JDBC connection
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM lab4schema.entityes;");) {
            while (rs.next()) {
                list.add(new EEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("---JDBC---");
        for (EEntity entity : list) {
            System.out.println(entity);
        }
    }
}
