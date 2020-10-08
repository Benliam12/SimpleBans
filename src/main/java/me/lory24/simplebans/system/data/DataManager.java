package me.lory24.simplebans.system.data;

import org.bukkit.command.CommandSender;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class DataManager
 * Manages interactions with the SQlite Database
 */
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

    /**
     * Bans a player
     * @param player Player to ban. TODO: Use UUID (user unique id) to store who is getting ban
     * @param executor Command sender. Who's banning the player
     * @param reason Reason of ban
     */
    public void insertPlayerToBansTable(String player, CommandSender executor, String reason) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(INSERT_PLAYER_TO_BANS_TABLE(player, executor.getName(), reason));
            statement.close(); // close the statement
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
