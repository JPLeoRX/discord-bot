package io.github.jpleorx.discordbot.command.core.command;

import io.github.jpleorx.discordbot.command.core.Placeholders;
import io.github.jpleorx.discordbot.command.core.reply.Reply;
import io.github.jpleorx.discordbot.command.core.reply.TextReply;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.List;

/**
 * Simple command that generates a text only reply while mentioning a user
 *
 * If this is a no-arguments call we will insert the call's author name in the message
 * If this is a call with arguments we will insert the 1st argument in the message
 *
 * @author Leo Ertuna
 * @since 28.05.2018 21:10
 */
public interface TextCommand extends Command {
    /**
     * What's the command of this listener
     * @return command
     */
    @Override
    String getCommand();

    /**
     * What message should be sent if this is a no-arguments call
     * @return message
     */
    String getMessageNoArguments();

    /**
     * What message should be sent if this call contains arguments
     * @return message
     */
    String getMessageFullArguments();

    @Override
    default Reply getReply(MessageCreateEvent event) {
        long authorId = event.getMessage().getAuthor().getId();
        String authorMention = "<@" + authorId + ">";
        String fullReply = this.getMessageNoArguments().replace(Placeholders.USER_MENTION, authorMention);
        return new TextReply(fullReply);
    }

    @Override
    default Reply getReply(MessageCreateEvent event, List<String> args) {
        String userMention = args.get(0);
        String fullReply = this.getMessageFullArguments().replace(Placeholders.USER_MENTION, userMention);
        return new TextReply(fullReply);
    }
}