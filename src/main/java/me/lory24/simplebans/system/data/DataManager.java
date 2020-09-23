package me.lory24.simplebans.system.data;

import org.bukkit.command.CommandSender;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager extends Sqlite {
    private final Connection connection;

    public DataManager(Connection connection) {
        this.connection = connection;
    }

    public void createBansTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(CREATE_BANS_TABLE);
            statement.close(); // close the statement
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void insertPlayerToBansTable(String player, CommandSender executor, String reason) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(INSERT_PLAYER_TO_BANS_TABLE(player, executor.getName(), reason));
            statement.close(); // close the statement
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
