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
            sender.sendMessage("[§5SpaceAnarchy§r] : " + args[0] + " have " + player.getStatistic(Statistic.DEATHS) + " deaths for " + player.getStatistic(Statistic.PLAYER_KILLS) + " kills.");
        }
        return true;
    }
}
