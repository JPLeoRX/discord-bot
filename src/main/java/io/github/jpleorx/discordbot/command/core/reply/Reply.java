package io.github.jpleorx.discordbot.command.core.reply;

import org.javacord.api.entity.channel.TextChannel;

import java.io.Serializable;

/**
 * This interface will mark a reply object
 *
 * @author Leo Ertuna
 * @since 28.05.2018 20:20
 */
public interface Reply extends Serializable, Cloneable {
    /**
     * How this reply should be sent to the channel
     * @param textChannel channel
     */
    void send(TextChannel textChannel);
}