package me.devLuca.UHC.Managers;

import me.devLuca.UHC.Objects.SuperPlayer;
import me.devLuca.UHC.UHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by devLuca on 25-7-2015.
 */
public class SuperPlayerManager implements Listener {

    private UHC instance;

    private ArrayList<SuperPlayer> players = new ArrayList<SuperPlayer>();

    public SuperPlayerManager(UHC instance) {
        this.instance = instance;
        Bukkit.getPluginManager().registerEvents(this, instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        createPlayer(e.getPlayer());
    }

    public void createPlayer(Player p) {
        if (getPlayer(p.getUniqueId()) == null) {
            return;
        }

        //Get the resultset from the MySQL Database
        ResultSet set = instance.sql.getPlayerData(p);

        //Create a new SuperPlayer with the results from MySQL.


        try {
            Date date = null;

            if (!set.getString("BannedUntil").equalsIgnoreCase("noBan")) {

            }

            SuperPlayer sp = new SuperPlayer(set.getString("UUID"), set.getString("Name"), set.getString("Rank"), date, set.getInt("Kills"), set.getInt("Deaths"), set.getInt("Money"));
            players.add(sp);
            checkIfBanned(p);
        } catch (Exception ex) {
            p.kickPlayer(ChatColor.RED + "Something went wrong, please try again!");
        }

    }

    public void checkIfBanned(Player p) {
        checkIfBanned(getPlayer(p.getUniqueId()));
    }

    public void checkIfBanned(SuperPlayer sp) {
        if (sp.getBannedUntil() != null) {
            Bukkit.getPlayer(UUID.fromString(sp.getUUID())).kickPlayer("You have a deathban!");
        }
    }

    public SuperPlayer getPlayer(String name) {
        for (SuperPlayer sp : players) {
            if (sp.getName().equalsIgnoreCase(name))
                return sp;
        }
        return null;
    }

    public SuperPlayer getPlayer(UUID uuid) {
        for (SuperPlayer sp : players) {
            if (sp.getUUID().equalsIgnoreCase(uuid.toString()))
                return sp;
        }
        return null;
    }

}
