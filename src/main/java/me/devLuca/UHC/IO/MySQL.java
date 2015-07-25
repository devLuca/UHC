package me.devLuca.UHC.IO;

import me.devLuca.UHC.UHC;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by devLuca on 25-7-2015.
 */
public class MySQL {

    private UHC instance;

    private Connection connection;

    public MySQL(String ip, String userName, String password, String db, UHC instance) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + db + "?user=" + userName + "&password=" + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.instance = instance;
    }

    public boolean playerDataContainsPlayer(Player p) {
        try {

            PreparedStatement statement = connection.prepareStatement("select * from data_Players where UUID='" + p.getUniqueId() + "';");
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return true;
            }

        } catch (Exception ex) {
        }
        return false;
    }

}
