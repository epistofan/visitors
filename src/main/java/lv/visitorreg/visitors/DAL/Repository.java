package lv.visitorreg.visitors.DAL;

import lv.visitorreg.visitors.Domain.ResponsiblePerson;
import lv.visitorreg.visitors.Domain.Visitor;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Repository {


    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    java.sql.Connection conn = null;
    String test;


    public List<Visitor> selectVisitors(String date){
        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;
        DbConnection dbConnection  = new DbConnection ();

        String sql = "Select* from visitorOfK1 where DATEPART(yy, inDate)=? and DATEPART(mm, inDate)=? and DATEPART(dd, inDate)=? ORDER BY visitorOfK1.InTime";

        List<String> dates = new ArrayList(Arrays.asList(date.split("\\D"))) ;

        List<Visitor> visitorList = new ArrayList<>();

        try {
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, dates.get(0));
            preparedStatement.setString(2, dates.get(1));
            preparedStatement.setString(3, dates.get(2));

            resultSet = preparedStatement.executeQuery();


            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH:mm");

            int i = 0;
            while (resultSet.next()) {

                Visitor visitor = new Visitor();
                visitor.setOrderNumber(resultSet.getInt(2));
                //visitor.setInDate(resultSet.getTimestamp(3));
               visitor.setInDateString(resultSet.getTimestamp(3).toLocalDateTime().toLocalDate().format(dateTimeFormatter));
                //visitor.setInTime(resultSet.getTimestamp(4));
                visitor.setInTimeString(resultSet.getTimestamp(4).toLocalDateTime().toLocalTime().format(dateTimeFormatter1));
try {
    //visitor.setOutDate(resultSet.getTimestamp(5));
    visitor.setOutDateString(resultSet.getTimestamp(5).toLocalDateTime().toLocalDate().format(dateTimeFormatter));

    //visitor.setOutTime(resultSet.getTimestamp(6));
    visitor.setOutTimeString(resultSet.getTimestamp(6).toLocalDateTime().toLocalTime().format(dateTimeFormatter1));
}catch (NullPointerException npe){

}
                visitor.setFirstName(resultSet.getString(7));
                visitor.setLastName(resultSet.getString(8));
                visitor.setCardNumber(resultSet.getString(9));
                visitor.setCompany(resultSet.getString(10));
                visitor.setResponsiblePerson(resultSet.getString(11));

                visitor.setRoomName(resultSet.getString(12));
                visitor.setResponsiblePersonIdentity(resultSet.getString(13));
                visitorList.add(i, visitor);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return visitorList;
    }


    public void addVisitors(Visitor visitor){

        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;

        String sql = "insert into visitorOfK1 (OrderNumber, FirstName, LastName,  CardNumber, Company, roomNumber, ResponsiblePerson )" +
                "values (?, ?, ?, ?, ?, ?, ?)";

               List<Visitor> visitorList = new ArrayList<>();
        try {
            DbConnection dbConnection  = new DbConnection ();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, visitor.getOrderNumber());
            preparedStatement.setString(2, visitor.getFirstName());
            preparedStatement.setString(3, visitor.getLastName());
            preparedStatement.setString(4, visitor.getCardNumber());
            preparedStatement.setString(5, visitor.getCompany());
            preparedStatement.setString(6, visitor.getRoomName());

            preparedStatement.setString(7, visitor.getResponsiblePerson());


            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public List<ResponsiblePerson> selectResponsiblePerson(String password){
        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;

        String sql = "Select* from responsiblePerson where Password = ?";

        try {
            DbConnection dbConnection  = new DbConnection ();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, password);

            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<ResponsiblePerson> responsiblePersonList = new ArrayList<>();

        try {

            int i = 0;
            while (resultSet.next()) {

                ResponsiblePerson responsiblePerson = new ResponsiblePerson();
                responsiblePerson.setPersonId(resultSet.getInt(1));
                responsiblePerson.setResponsiblePerson(resultSet.getString(2));
                responsiblePerson.setPassword(resultSet.getString(3));
                responsiblePersonList.add(i, responsiblePerson);
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return responsiblePersonList;
    }


    public void addVisitorsOutTime(LocalDateTime localDateTime, String orderNumber, String responsiblePerson1){

        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;

        Timestamp timestamp = Timestamp.valueOf(localDateTime);


        String sql = "UPDATE visitorOfK1 SET OutTime = ?, OutDate=?, ResponsiblePersonIdentity = ? WHERE OrderNumber = ?";

        List<Visitor> visitorList = new ArrayList<>();
        try {
            DbConnection dbConnection  = new DbConnection ();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.setString(3, responsiblePerson1);
            preparedStatement.setInt(4, Integer.valueOf(orderNumber));


            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
