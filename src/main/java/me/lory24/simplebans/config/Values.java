package me.lory24.simplebans.config;

public class Values extends ConfigTool {
    private final String kickPageMessage;
    private final String kickMessage;
    private final boolean enablePublicKickMessage;
    private final String publicKickMessage;
    private final String noPermissionMessage;
    private final String syntaxIncorrectMessage;
    private final String overridePlayerMessage;
    private final String playerNotFoundMessage;

    public Values() {
        this.kickPageMessage = this.printColors(this.getStringFromConfig("Settings.Messages.KickMessages.KickPageMessage"));
        this.kickMessage = this.printColors(this.getStringFromConfig("Settings.Messages.KickMessages.KickMessage"));
        this.enablePublicKickMessage = this.isBooleanGet("Settings.Messages.KickMessages.EnablePublicKickMessage");
        this.publicKickMessage = this.printColors(this.getStringFromConfig("Settings.Messages.KickMessages.PublicKickMessage"));
        this.noPermissionMessage = this.printColors(this.getStringFromConfig("Settings.Messages.GeneralMessages.NoPermission"));
        this.syntaxIncorrectMessage = this.printColors(this.getStringFromConfig("Settings.Messages.GeneralMessages.SyntaxIncorrect"));
        this.overridePlayerMessage = this.printColors(this.getStringFromConfig("Settings.Messages.GeneralMessages.OverridePlayer"));
        this.playerNotFoundMessage = this.printColors(this.getStringFromConfig("Settings.Messages.GeneralMessages.PlayerNotFound"));
    }

    public String getKickPageMessage(String reason, String moderator, String kicked) {
        return kickPageMessage.replace("{REASON}", reason).replace("{MODERATOR}", moderator).replace("{KICKED}", kicked);
    }

    public String getKickMessage(String reason, String kicked) {
        return kickMessage.replace("{REASON}", reason).replace("{KICKED}", kicked);
    }

    public boolean isEnablePublicKickMessage() {
        return enablePublicKickMessage;
    }

    public String getPublicKickMessage(String reason, String moderator, String kicked) {
        return publicKickMessage.replace("{REASON}", reason).replace("{MODERATOR}", moderator).replace("{KICKED}", kicked);
    }

    public String getNoPermissionMessage(String player, String permission) {
        return noPermissionMessage.replace("{PLAYER}", player).replace("{PERMISSION}", permission);
    }

    public String getSyntaxIncorrectMessage(String usage) {
        return syntaxIncorrectMessage.replace("{USAGE}", usage);
    }

    public String getOverridePlayerMessage(String action, String player) {
        return overridePlayerMessage.replace("{ACTION}", action).replace("{PLAYER}", player);
    }

    public String getPlayerNotFoundMessage(String player) {
        return playerNotFoundMessage.replace("{PLAYER}", player);
    }
}
