package me.devLuca.UHC.Managers;

import me.devLuca.UHC.Objects.SuperPlayer;
import me.devLuca.UHC.UHC;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by devLuca on 25-7-2015.
 */
public class SuperPlayerManager {

    private UHC instance;

    private ArrayList<SuperPlayer> players = new ArrayList<SuperPlayer>();

    public SuperPlayerManager(UHC instance) {
        this.instance = instance;
    }

    public void createPlayer(Player p) {
        //TODO:
        //Get the resultset from the MySQL Database

        //Create a new SuperPlayer with the results from MySQL.
        SuperPlayer sp = null;

        players.add(sp);
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
