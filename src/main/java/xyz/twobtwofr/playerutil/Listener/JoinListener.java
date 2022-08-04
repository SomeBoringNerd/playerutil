package xyz.twobtwofr.playerutil.Listener;

import com.destroystokyo.paper.event.server.ServerTickStartEvent;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.advancement.Advancement;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.twobtwofr.playerutil.Playerutil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinListener implements Listener
{

    Playerutil main;

    public JoinListener(Playerutil util){
        main = util;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {

        event.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.1d);

        try {
            //ResultSet set = Playerutil.prepareStatement("SELECT COUNT(UUID) FROM player_info WHERE UUID = '" + event.getPlayer().getUniqueId().toString() + "';").executeQuery();
            ResultSet set = Playerutil.prepareStatement("SELECT COUNT(UUID) FROM " + (Playerutil.Debug ? "player_data_debug" : "player_data") + " WHERE UUID='" + event.getPlayer().getUniqueId().toString().replace("-", "") + "';").executeQuery();
            set.next();

            if(set.getInt(1) == 0)
            {
                Playerutil.prepareStatement("INSERT INTO " + (Playerutil.Debug ? "player_data_debug" : "player_data") + "(UUID, TickPlayTime, _Kill, Death, LastSeen) VALUES('" + event.getPlayer().getUniqueId().toString().replace("-", "") + "', "+ (int)event.getPlayer().getStatistic(Statistic.TOTAL_WORLD_TIME) + ", " +event.getPlayer().getStatistic(Statistic.PLAYER_KILLS) + ", " + event.getPlayer().getStatistic(Statistic.DEATHS) + ", now());").executeUpdate();

                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    player.sendMessage("[§52b2fr§r] §4" + event.getPlayer().getName() + "§r joined for the first time !");
                }
            }else{
                try {
                    Player player = event.getPlayer();
                    Playerutil.prepareStatement("UPDATE " + (Playerutil.Debug ? "player_data_debug" : "player_data") + " SET TickPlayTime=" + (int)player.getStatistic(Statistic.TOTAL_WORLD_TIME) + ", _Kill=" + player.getStatistic(Statistic.PLAYER_KILLS) + ", Death=" + player.getStatistic(Statistic.DEATHS) + ", LastSeen=now() WHERE UUID='" + player.getPlayer().getUniqueId().toString().replace("-", "") + "';").executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    int tick = 0;
    @EventHandler
    public void onTick(ServerTickStartEvent event)
    {
        if(tick >= 200){
            for(Player player : Bukkit.getOnlinePlayers())
            {
                try {
                    Playerutil.prepareStatement("UPDATE " + (Playerutil.Debug ? "player_data_debug" : "player_data") + " SET TickPlayTime=" + (int)player.getStatistic(Statistic.TOTAL_WORLD_TIME) + ", _Kill=" + player.getStatistic(Statistic.PLAYER_KILLS) + ", Death=" + player.getStatistic(Statistic.DEATHS) + ", LastSeen=now() WHERE UUID='" + player.getPlayer().getUniqueId().toString().replace("-", "") + "';").executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            tick = 0;
        }else{
            tick++;
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();

        try {
            Playerutil.prepareStatement("UPDATE " + (Playerutil.Debug ? "player_data_debug" : "player_data") + " SET TickPlayTime=" + (int)player.getStatistic(Statistic.TOTAL_WORLD_TIME) + ", _Kill=" + player.getStatistic(Statistic.PLAYER_KILLS) + ", Death=" + player.getStatistic(Statistic.DEATHS) + ", LastSeen=now() WHERE UUID='" + player.getPlayer().getUniqueId().toString().replace("-", "") + "';").executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
