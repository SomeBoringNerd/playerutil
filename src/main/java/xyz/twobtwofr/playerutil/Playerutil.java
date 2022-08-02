package xyz.twobtwofr.playerutil;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.twobtwofr.playerutil.Listener.JoinListener;
import xyz.twobtwofr.playerutil.commands.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class Playerutil extends JavaPlugin
{
    public static final boolean Debug = true;
    private final String DATA_BASE_IP = "localhost";
    private final String TABLE = "2b2fr";
    private final String USER = "root";
    private final String PASSWORD = "123456789";

    public static Connection connection;

    @Override
    public void onEnable() {
        getCommand("playtime").setExecutor(new PlayTime());
        getCommand("joindate").setExecutor(new JoinDate());
        getCommand("seen").setExecutor(new Seen());
        getCommand("help").setExecutor(new help());
        getCommand("dupe").setExecutor(new dupe());
        getCommand("discord").setExecutor(new discord());

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        try {
            openConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        try {
            if(!connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void openConnection() throws SQLException {
        if (connection != null && !connection.isClosed())
            return;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + DATA_BASE_IP + ":3306/" + TABLE, USER, PASSWORD);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement prepareStatement(String query) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ps;
    }

    public Plugin LSTgetPlugin(){
        return this;
    }
}
