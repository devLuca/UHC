package me.devLuca.UHC;

import me.devLuca.UHC.IO.MySQL;
import me.devLuca.UHC.Managers.SuperPlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by devLuca on 25-7-2015.
 */
public class UHC extends JavaPlugin {

    public MySQL sql;
    public SuperPlayerManager superPlayerManager;
    public DateFormat dateFormat;

    @Override
    public void onEnable() {
        sql = new MySQL("db4free.net", "devluca", "devluca", "uhcdb", this);
        superPlayerManager = new SuperPlayerManager(this);
        dateFormat = new SimpleDateFormat("HH:mm");
    }

}
