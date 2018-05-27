package io.github.jpleorx.discordbot;

import io.github.jpleorx.discordbot.command.HelloWorldCommand;
import io.github.jpleorx.discordbot.command.SuicideCommand;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

public class Main {

    /**
     * The entrance point of our program.
     *
     * @param args The arguments for the program. The first element should be the bot's token.
     */
    public static void main(String[] args) {
        // Enable debugging, if no slf4j logger was found
        FallbackLoggerConfiguration.setDebug(true);

        // The token is the first argument of the program
        String token = "NDUwNDA1NDUzMjk4NTMyMzUy.DeywTA._VGqeNxB8uxHjLGW6ZWIxAKBn_E";

        // We login blocking, just because it is simpler and doesn't matter here
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // Print the invite url of the bot
        System.out.println("You can invite me by using the following url: " + api.createBotInvite());

        // Add listeners
        api.addMessageCreateListener(new HelloWorldCommand());
        api.addMessageCreateListener(new SuicideCommand());

        // Log a message, if the bot joined or left a server
        api.addServerJoinListener(event -> System.out.println("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> System.out.println("Left server " + event.getServer().getName()));
    }

}
