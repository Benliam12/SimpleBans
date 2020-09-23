package me.lory24.simplebans.system.data;

public abstract class Sqlite {

    protected final String CREATE_BANS_TABLE = "CREATE TABLE IF NOT EXISTS bannedPlayers(PlayerNAME varchar," +
                                                                                        "BanExecutor varchar," +
                                                                                        "BanReason varchar);";

    protected final String INSERT_PLAYER_TO_BANS_TABLE(String player, String executor, String reason) {
        return  "INSERT INTO bannedPlayers ('PlayerNAME', 'BanExecutor', 'BanReason')" +
                "VALUES ('" + player + "', '" + executor + "', '" + reason + "')";
    }
}
