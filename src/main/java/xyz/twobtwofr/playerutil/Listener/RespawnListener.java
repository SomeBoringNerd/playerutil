package xyz.twobtwofr.playerutil.Listener;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Random;

public class RespawnListener implements Listener
{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
        if(event.getPlayer().getBedSpawnLocation() == null) {
            long randomX = new Random().nextInt(500);
            long randomZ = new Random().nextInt(500);
            long randomY = 319;

            for (int i = 319; i > 0; i--) {
                // if the first two blocks are air but the last one isnt, it's safe to respawn here.
                if (Bukkit.getWorld("Map").getBlockAt(new Location(Bukkit.getWorld("Map"), randomX, i, randomZ)).isEmpty()) {
                    if (Bukkit.getWorld("Map").getBlockAt(new Location(Bukkit.getWorld("Map"), randomX, i - 1, randomZ)).isEmpty()) {
                        if (!Bukkit.getWorld("Map").getBlockAt(new Location(Bukkit.getWorld("Map"), randomX, i - 2, randomZ)).isEmpty()) {
                            if (Bukkit.getWorld("Map").getBlockAt(new Location(Bukkit.getWorld("Map"), randomX, i - 2, randomZ)).getType() != Material.LAVA) {
                                randomY = (long) i;
                            }
                        }
                    }
                }
            }

            event.setRespawnLocation(new Location(Bukkit.getWorld("Map"), randomX, randomY, randomZ));
        }
    }
}
