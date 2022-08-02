package xyz.twobtwofr.playerutil.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class PlayTime implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)
    {
        if(args.length == 0){
            sender.sendMessage("[§52b2fr§r] : Please mention a player");
            return false;
        }else{
            OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);

            int tick_time = player.getStatistic(Statistic.TOTAL_WORLD_TIME);

            if(tick_time == 0) {
                sender.sendMessage("[§52b2fr§r] : That player never played on the server");
            }
            else{
                    float hour = (float)tick_time / 20 / 60 / 60;
                    int _hour = (int)hour;
                    float minute = ((hour - (float)_hour) * 60);

                    sender.sendMessage("[§52b2fr§r] : Player §4" + player.getName() + "§r have played for " + (_hour != 0 ? _hour + "h" + (int)(minute) : "less than one hour") + " || " + tick_time + " ticks");
            }
        }
        return true;
    }
}
