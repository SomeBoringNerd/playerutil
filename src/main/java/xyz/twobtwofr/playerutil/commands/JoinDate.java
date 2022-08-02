package xyz.twobtwofr.playerutil.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.twobtwofr.playerutil.Playerutil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinDate implements CommandExecutor {
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
                    ResultSet set2 = Playerutil.prepareStatement("SELECT JoinDate FROM " + (Playerutil.Debug ? "player_data_debug" : "player_data") + " WHERE UUID='" + player.getUniqueId().toString().replace("-", "") + "';").executeQuery();
                    set2.next();
                    sender.sendMessage("[§52b2fr§r] : here's the date §4" + args[0] +  "§r was seen for the first time : §4" + set2.getDate("JoinDate").toString());
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        return true;
    }
}
