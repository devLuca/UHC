package me.devLuca.UHC.Objects;

import java.util.Date;

/**
 * Created by devLuca on 25-7-2015.
 */
public class SuperPlayer {

    private String UUID;
    private String name;
    private String Rank;
    private Date BannedUntil;
    private int Kills;
    private int Deaths;
    private int Money;

    public SuperPlayer(String UUID, String name, String rank, Date bannedUntil, int kills, int deaths, int money) {
        this.UUID = UUID;
        this.name = name;
        Rank = rank;
        BannedUntil = bannedUntil;
        Kills = kills;
        Deaths = deaths;
        Money = money;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public Date getBannedUntil() {
        return BannedUntil;
    }

    public void setBannedUntil(Date bannedUntil) {
        BannedUntil = bannedUntil;
    }

    public int getKills() {
        return Kills;
    }

    public void setKills(int kills) {
        Kills = kills;
    }

    public int getDeaths() {
        return Deaths;
    }

    public void setDeaths(int deaths) {
        Deaths = deaths;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }
}
