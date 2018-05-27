package io.github.jpleorx.discordbot.command;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class HelloWorldCommand implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessage().getContent().equalsIgnoreCase("!sayHi")) {
            messageCreateEvent.getChannel().sendMessage("Hello " + messageCreateEvent.getMessage().getAuthor().getDisplayName() + "!");
        }
    }
}
