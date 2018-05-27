package org.javacord.examplebot;

import org.javacord.examplebot.command.CopyAvatarCommand;
import org.javacord.examplebot.command.HelloWorldCommand;
import org.javacord.examplebot.command.SuicideCommand;
import org.javacord.examplebot.command.UserInfoCommand;
import org.javacord.DiscordApi;
import org.javacord.DiscordApiBuilder;
import org.javacord.util.logging.LoggerUtil;

public class Main {

    /**
     * The entrance point of our program.
     *
     * @param args The arguments for the program. The first element should be the bot's token.
     */
    public static void main(String[] args) {
        // Enable debugging, if no slf4j logger was found
        LoggerUtil.setDebug(true);

        // The token is the first argument of the program
        String token = "NDUwNDA1NDUzMjk4NTMyMzUy.DeywTA._VGqeNxB8uxHjLGW6ZWIxAKBn_E";

        // We login blocking, just because it is simpler and doesn't matter here
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // Print the invite url of the bot
        System.out.println("You can invite me by using the following url: " + api.createBotInvite());

        // Add listeners
        api.addMessageCreateListener(new CopyAvatarCommand());
        api.addMessageCreateListener(new UserInfoCommand());
        api.addMessageCreateListener(new HelloWorldCommand());
        api.addMessageCreateListener(new SuicideCommand());

        // Log a message, if the bot joined or left a server
        api.addServerJoinListener(event -> System.out.println("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> System.out.println("Left server " + event.getServer().getName()));
    }

}
