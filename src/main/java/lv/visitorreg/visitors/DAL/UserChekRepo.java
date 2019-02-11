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


    public LoginUser checkLoginUser(String username, String password){

        LoginUser loginUser1 = null;
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


            int i = 0;
            while (resultSet.next()) {

                LoginUser loginUser = new LoginUser();
                loginUser.setUserId(resultSet.getInt(1));
                loginUser.setUsername(resultSet.getString(2));
                loginUser.setPassword(resultSet.getString(3));
                loginUser.setAccessPoint(resultSet.getString(4));
                i++;
                loginUser1 = loginUser;
            }


    } catch (SQLException e) {
        e.printStackTrace();
    }

        if(loginUser1 == null)
            {
                return null;
            }else {

                return loginUser1;
            }
    }










}
