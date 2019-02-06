package lv.visitorreg.visitors.DAL;

import lv.visitorreg.visitors.Domain.LoginUser;
import lv.visitorreg.visitors.Domain.ResponsiblePerson;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserChekRepo {


    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    java.sql.Connection conn = null;



    public LoginUser checkLoginUser(String username, String password){
        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        java.sql.Connection conn = null;

        String sql = "Select* from accessUser where UserName = ?";

        try {
            DbConnection dbConnection  = new DbConnection ();
            conn = dbConnection.getDbConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        LoginUser loginUser = new LoginUser();
        try {
if(!resultSet.next()){System.out.println("null");}
            int i = 0;
            while (resultSet.next()) {


                loginUser.setUsername(resultSet.getString(2));
                loginUser.setPassword(resultSet.getString(3));
                loginUser.setAccessPoint(resultSet.getString(4));
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }



        return loginUser;
    }










}
