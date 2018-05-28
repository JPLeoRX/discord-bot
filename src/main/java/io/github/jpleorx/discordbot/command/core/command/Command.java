package io.github.jpleorx.discordbot.command.core.command;

import io.github.jpleorx.discordbot.command.core.MessageListener;
import io.github.jpleorx.discordbot.command.core.reply.Reply;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Arrays;
import java.util.List;

/**
 * This will be a core logic of any command
 *
 * @author Leo Ertuna
 * @since 28.05.2018 20:34
 */
public interface Command extends MessageListener {
    /**
     * What's the command of this listener
     * @return command
     */
    String getCommand();

    /**
     * Build a reply object from no-argument command
     * @return reply
     */
    Reply getReply();

    /**
     * Build a reply object from command with arguments
     * @param args list of arguments
     * @return reply
     */
    Reply getReply(List<String> args);

    /**
     * What to do when a new message is created
     * @param event event
     */
    @Override
    default void onMessageCreate(MessageCreateEvent event) {
        // Get request string
        String message = event.getMessage().getContent();

        // If this is the command
        if (message.startsWith(this.getCommand())) {
            // Get all words of this request
            List<String> requestWords = Arrays.asList(message.split(" "));

            // Get command arguments
            List<String> requestArguments = requestWords.subList(1, requestWords.size());

            // If there are no arguments
            if (requestArguments.isEmpty()) {
                // Get the reply
                Reply reply = this.getReply();

                // Send the reply
                reply.send(event.getChannel());
            }

            // But if there are many arguments
            else {
                // Get the reply
                Reply reply = this.getReply(requestArguments);

                // Send the reply
                reply.send(event.getChannel());
            }
        }
    }
}