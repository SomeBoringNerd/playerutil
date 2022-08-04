package xyz.twobtwofr.playerutil.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.twobtwofr.playerutil.Playerutil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class kd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)
    {
        if(args.length == 0){
            sender.sendMessage("[§52b2fr§r] : please mention a player");
            return false;
        }else
        {
            OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
            try {
                ResultSet set = Playerutil.prepareStatement("SELECT COUNT(UUID) FROM " + (Playerutil.Debug ? "player_data_debug" : "player_data") + " WHERE UUID='" + player.getUniqueId().toString().replace("-", "") + "';").executeQuery();
                set.next();
                if(set.getInt(1) == 0)
                {
                    sender.sendMessage("[§52b2fr§r] : that player never joined the server");
                }else
                {
                    sender.sendMessage("[§52b2fr§r] : player §4" + args[0] +  "§r have §4" + player.getStatistic(Statistic.PLAYER_KILLS) + "§r kills for §4" + player.getStatistic(Statistic.DEATHS) + "§r deaths");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        return true;
    }
}
