import database.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("smh");

        DatabaseConnection databaseConnection = new DatabaseConnection();

        databaseConnection.connect("database.sqlite");

        PreparedStatement statement = databaseConnection.getConnection()
                        .prepareStatement("insert into auth_account (name, password) values ('test2', 'test2')");
        //in statement, we put our SQL code; it's not done yet, just prepared

        statement.execute(); //executes the prepared statement

        databaseConnection.disconnect();

    }
}
