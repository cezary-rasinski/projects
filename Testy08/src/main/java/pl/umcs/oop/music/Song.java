package pl.umcs.oop.music;

import pl.umcs.oop.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public record Song(
        String artist,
        String title,
        int duration) {
    public static class Persistence {

        public static Optional<Song> read(int index) throws SQLException {

            PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(
                    "select * from song where id = ?");
            statement.setInt(1, index);
            statement.execute();

            ResultSet result = statement.getResultSet();
            //we can have mutiple elements as a result, but we only want to return 1

            Optional<Song> song = Optional.empty();
            if(result.next()) {
                String artist = result.getString("artist");
                String title = result.getString("title");
                int duration = result.getInt("length");
                song = Optional.of(new Song(artist, title, duration));
            }

            return song;


        }

    }
}
