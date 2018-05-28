package io.github.jpleorx.discordbot.command;

import io.github.jpleorx.discordbot.command.core.command.Command;
import io.github.jpleorx.discordbot.command.core.reply.Reply;
import io.github.jpleorx.discordbot.command.core.reply.TextReply;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.List;

/**
 * Simple hello world command
 *
 * @author Leo Ertuna
 * @since 28.05.2018 20:46
 */
public class HelloWorldCommand implements Command {
    private static final String command = "=привет";
    private static final String replyMessage = "Привет пидор";

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public Reply getReply(MessageCreateEvent event) {
        long authorId = event.getMessage().getAuthor().getId();
        String authorMention = "<@" + authorId + ">";
        String fullReply = replyMessage + " " + authorMention + "!";
        return new TextReply(fullReply);
    }

    @Override
    public Reply getReply(MessageCreateEvent event, List<String> args) {
        String userMention = args.get(0);
        String fullReply = replyMessage + " " + userMention + "!";
        return new TextReply(fullReply);
    }
}