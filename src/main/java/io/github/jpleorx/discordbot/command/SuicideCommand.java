package io.github.jpleorx.discordbot.command;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import io.github.jpleorx.discordbot.utils.FileUtils;

public class SuicideCommand implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        String command = messageCreateEvent.getMessage().getContent();

        if (command.startsWith("=suicide")) {
            String[] commandParts = command.split(" ");

            if (commandParts.length == 1) {
                EmbedBuilder embed = new EmbedBuilder()
                        .setDescription("Kill yourself <@" + messageCreateEvent.getMessage().getAuthor().getIdAsString() + ">")
                        .setImage(FileUtils.loadFile("gifs/suicide/1.gif"));

                messageCreateEvent.getChannel().sendMessage(embed);
            }

            else if (commandParts.length == 2) {
                String userTarget = commandParts[1];

                EmbedBuilder embed = new EmbedBuilder()
                        .setDescription("Kill yourself " + userTarget)
                        .setImage(FileUtils.loadFile("gifs/suicide/1.gif"));

                messageCreateEvent.getChannel().sendMessage(embed);
            }
        }
    }
}
