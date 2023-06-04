package com.hadesdc.lifestealsmp.Players;

import com.hadesdc.lifestealsmp.LifestealSMP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CustomPlayer {

    private LifestealSMP lssmp;

    private UUID uuid;
    private int HP;
    private int KILLS;
    private int DEATHS;
    public CustomPlayer(LifestealSMP lssmp, UUID uuid) {
        this.uuid = uuid;

        try {
            PreparedStatement statement = lssmp.getDatabase().getConnection().prepareStatement("SELECT HP, KILLS, DEATHS FROM players WHERE UUID = ?");
            statement.setString(1, uuid.toString());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                HP = rs.getInt("HP");
                KILLS = rs.getInt("KILLS");
                DEATHS = rs.getInt("DEATHS");

                // Update the player data in the database
                PreparedStatement updateStatement = lssmp.getDatabase().getConnection().prepareStatement("UPDATE players SET HP = ?, KILLS = ?, DEATHS = ? WHERE UUID = ?");
                updateStatement.setInt(1, HP);
                updateStatement.setInt(2, KILLS);
                updateStatement.setInt(3, DEATHS);
                updateStatement.setString(4, uuid.toString());
                updateStatement.executeUpdate();
            } else {
                HP = 20;
                KILLS = 0;
                DEATHS = 0;

                PreparedStatement insertStatement = lssmp.getDatabase().getConnection().prepareStatement("INSERT INTO players (ID, UUID, KILLS, DEATHS, HP) VALUES (?, ?, ?, ?, ?);");
                insertStatement.setString(1, "default");
                insertStatement.setString(2, String.valueOf(uuid));
                insertStatement.setInt(3, KILLS);
                insertStatement.setInt(4, DEATHS);
                insertStatement.setInt(5, HP);
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            // Handle any potential exceptions
            e.printStackTrace();
        }

    }
    public void setHP(int HP) {
        this.HP = HP;
        try{
            PreparedStatement statement = lssmp.getDatabase().getConnection().prepareStatement("UPDATE players SET HP =" + HP + " WHERE UUID = '" + uuid + "'");
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setKILLS(int KILLS) {
        this.KILLS = KILLS;
        try{
            PreparedStatement statement = lssmp.getDatabase().getConnection().prepareStatement("UPDATE players SET KILLS =" + KILLS + " WHERE UUID = '" + uuid + "'");
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setDEATHS(int DEATHS) {
        this.DEATHS = DEATHS;
        try{
            PreparedStatement statement = lssmp.getDatabase().getConnection().prepareStatement("UPDATE players SET DEATHS =" + DEATHS + " WHERE UUID = '" + uuid + "'");
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getHP() {return HP;}
    public int getKILLS() {return KILLS;}
    public int getDEATHS() {return DEATHS;}
}
