package me.lory24.simplebans.system.data;

import me.lory24.simplebans.SimpleBans;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PluginDatabase {
    public static File database;
    public static Connection connection;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public PluginDatabase() {
        if (!SimpleBans.instance.getDataFolder().exists()) SimpleBans.instance.getDataFolder().mkdir();
        database = new File(SimpleBans.instance.getDataFolder() + File.separator + "data.sqlite");

        Connection connection = getConnection();

        if(connection == null)
            return;

        DataManager dataManager = new DataManager(connection);
        dataManager.createBansTable();
    }

    public void initConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + database.getAbsolutePath());
            SimpleBans.instance.getLogger().info("Database loaded!");
        } catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
    }

    public static Connection getConnection() {
        try {
            if (connection == null)
                return null;
            if (!connection.isClosed()) return connection;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + database.getAbsolutePath());
            return connection;
        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

        return connection;
    }
}
