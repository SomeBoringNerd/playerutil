package xyz.twobtwofr.playerutil.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class help implements CommandExecutor
{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)
    {
        sender.sendMessage("§5SpaceAnarchy TRIVIAL");
        sender.sendMessage("");
        sender.sendMessage(">§6You can find our custom plugins here : (§https://git.someboringnerd.xyz/SpaceAnarchy§r)");
        sender.sendMessage("");
        sender.sendMessage(">§6Server's log are erased on each reboot to ensure extra player safety");
        sender.sendMessage("");
        sender.sendMessage(">§6the server do not log any ip to insure player safety");
        sender.sendMessage("");
        sender.sendMessage("The server's seed is : [§6" + Bukkit.getWorld("Map").getSeed() +"§r]");
        sender.sendMessage("For a list of commands, do /command");
        return true;
    }
}
