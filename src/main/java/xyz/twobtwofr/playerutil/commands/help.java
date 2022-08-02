package xyz.twobtwofr.playerutil.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class help implements CommandExecutor
{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        sender.sendMessage("§52B2FR COMMANDS : ");
        sender.sendMessage("/dupe : tutorial on how to dupe");
        sender.sendMessage("/playtime <player> : display a player's playtime");
        sender.sendMessage("/joindate <player> : show a player's join date");
        sender.sendMessage("/seen : show the last time a player was online");
        sender.sendMessage("/discord : join our discord :D");
        sender.sendMessage("");
        sender.sendMessage("§52B2FR TRIVIAL");
        sender.sendMessage("");
        sender.sendMessage(">§6the server run NoChatReport (§5https://github.com/SomeBoringNerd/NoChatReport§r)");
        sender.sendMessage("§6to ensure your freedom of speech isn't compromised by Microsoft ;)");
        sender.sendMessage("");
        sender.sendMessage(">§6The server run custom plugins that are available and open source on the server's discord");
        sender.sendMessage("");
        sender.sendMessage(">§6Server's log are erased on each reboot to ensure extra player safety");
        sender.sendMessage("");
        sender.sendMessage(">§6the server do not log any ip to insure player safety");
        sender.sendMessage("");
        sender.sendMessage("The server's seed is : [§6" + Bukkit.getWorld("Map").getSeed() +"§r]");
        return true;
    }
}
