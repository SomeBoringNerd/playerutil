package xyz.twobtwofr.playerutil;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.twobtwofr.playerutil.Listener.RespawnListener;
import xyz.twobtwofr.playerutil.commands.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Playerutil extends JavaPlugin
{
    public static Connection connection;

    @Override
    public void onEnable() {
        getCommand("playtime").setExecutor(new PlayTime());
        getCommand("help").setExecutor(new help());
        getCommand("dupe").setExecutor(new dupe());
        getCommand("ratio").setExecutor(new kd());
        getCommand("command").setExecutor(new commands());
        getServer().getPluginManager().registerEvents(new RespawnListener(), this);
    }



    public Plugin LSTgetPlugin(){
        return this;
    }
}
