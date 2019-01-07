package lv.visitorreg.visitors.DAL;

import lv.visitorreg.visitors.Domain.Visitors;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {


    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    java.sql.Connection conn = null;
    DbConnection dbConnection  = new DbConnection ();

    public List<Visitors> selectVisitors(String date){

        String sql = "Select* from Visitors where InTime > ? ORDER BY Visitors.InTime";


        java.sql.Timestamp timestamp1 = Timestamp.valueOf(date + " 00:00:00");
        List<Visitors> visitorsList = new ArrayList<>();
        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setTimestamp(1, timestamp1);
            resultSet = preparedStatement.executeQuery();


            int i = 0;
            while (resultSet.next()) {

                Visitors visitors = new Visitors();
                visitors.setVisitorId(resultSet.getString(1));
                visitors.setLastName(resultSet.getString(2));
                visitors.setFirstName(resultSet.getString(3));
                visitors.setCompany(resultSet.getString(4));
                visitors.setAddress(resultSet.getString(5));
                visitors.setInTime(resultSet.getTimestamp(6));
                visitorsList.add(i, visitors);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return visitorsList;
    }

    public void addVisitors(){


    }
}
