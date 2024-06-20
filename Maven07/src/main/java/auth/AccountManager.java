package auth;

import database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    static DatabaseConnection databaseConnection;
    public void register(Account user) {
        try {
            databaseConnection.connect("database.sqlite");
            PreparedStatement statement = databaseConnection.getConnection()
                    .prepareStatement("insert into auth_account (name, password) values (?, ?)");
            //those parameters we start indexing from 1!!!
            statement.setString(1, user.name());
            statement.setString(2, user.password());
            statement.execute();

            databaseConnection.disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean authenticate(String name, String password) {
        Account account = getUser(name);
        if (account == null) {
            return password.equals(account.password());
        }
        return false;
    }
    public Account getUser(String name) {
        try {
            databaseConnection.connect("database.sqlite");
            PreparedStatement statement = databaseConnection.getConnection()
                    .prepareStatement("select password from auth_account where name = ?)");
            //those parameters we start indexing from 1!!!
            statement.setString(1, name);
            statement.execute();

            //after statement.execute() executes
            //the data or effect appear in getResultSet()
            ResultSet result = statement.getResultSet(); //result is a collection
            List<Account> accounts = new ArrayList<>();
            while (result.next()) {
                String password = result.getString("password");
                Account account = new Account(name, password);
                accounts.add(account);
            }
            databaseConnection.disconnect();
            return accounts.get(0);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
