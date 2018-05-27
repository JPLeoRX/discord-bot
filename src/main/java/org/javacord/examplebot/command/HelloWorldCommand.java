package org.javacord.examplebot.command;

import org.javacord.entity.message.embed.EmbedBuilder;
import org.javacord.event.message.MessageCreateEvent;
import org.javacord.listener.message.MessageCreateListener;

public class HelloWorldCommand implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessage().getContent().equalsIgnoreCase("!sayHi")) {
            messageCreateEvent.getChannel().sendMessage("Hello " + messageCreateEvent.getMessage().getAuthor().getDisplayName() + "!");
        }
    }
}
