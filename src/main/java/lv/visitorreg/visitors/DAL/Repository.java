package lv.visitorreg.visitors.DAL;

import lv.visitorreg.visitors.Domain.Visitors;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Repository {


    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    java.sql.Connection conn = null;



    public List<Visitors> selectVisitors(String date){
        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;
        DbConnection dbConnection  = new DbConnection ();

        String sql = "Select* from Visitors where DATEPART(yy, inTime)=? and DATEPART(mm, inTime)=? and DATEPART(dd, inTime)=? ORDER BY Visitors.InTime";

        List<String> dates = new ArrayList(Arrays.asList(date.split("\\D"))) ;

        List<Visitors> visitorsList = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, dates.get(0));
            preparedStatement.setString(2, dates.get(1));
            preparedStatement.setString(3, dates.get(2));

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
                visitors.setOutTime(resultSet.getTimestamp(7));
                visitors.setCardNumber(resultSet.getString(8));
                visitorsList.add(i, visitors);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return visitorsList;
    }

    public List<Visitors> selectVisitorsById(String id){
        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;
        DbConnection dbConnection  = new DbConnection ();

        String sql = "Select* from Visitors where VisitorId = ?";



        List<Visitors> visitorsListById = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);

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
                visitors.setOutTime(resultSet.getTimestamp(7));
                visitors.setCardNumber(resultSet.getString(8));
                visitorsListById.add(i, visitors);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return visitorsListById;
    }

    public void addVisitors(Visitors visitor){

        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;

        String sql = "insert into Visitors (LastName, FirstName, Company, Adress, CardNumber, OrderNumber)" +
                "values (?, ?, ?, ?, ?, '1')";

               List<Visitors> visitorsList = new ArrayList<>();
        try {
            DbConnection dbConnection  = new DbConnection ();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, visitor.getLastName());
            preparedStatement.setString(2, visitor.getFirstName());
            preparedStatement.setString(3, visitor.getCompany());
            preparedStatement.setString(4, visitor.getAddress());
            preparedStatement.setString(5, visitor.getCardNumber());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addVisitorsOutTime(LocalDateTime localDateTime, String id){

        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;

        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        String sql = "UPDATE Visitors SET OutTime = ? WHERE VisitorID = ?";

        List<Visitors> visitorsList = new ArrayList<>();
        try {
            DbConnection dbConnection  = new DbConnection ();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setInt(2, Integer.valueOf(id));


            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
