package io.github.jpleorx.discordbot.command.core.reply;

import org.javacord.api.entity.channel.TextChannel;

import java.util.Objects;

/**
 * This will be a simplistic text-only reply. This object is immutable.
 *
 * @author Leo Ertuna
 * @since 28.05.2018 20:29
 */
public class TextReply implements Reply {
    /**
     * Text
     */
    private String text;

    /**
     * Constructor
     * @param text text
     */
    public TextReply(String text) {
        this.text = text;
    }

    /**
     * Getter
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * How this reply should be sent to the channel
     * @param textChannel channel
     */
    @Override
    public void send(TextChannel textChannel) {
        textChannel.sendMessage(this.getText());
    }

    /**
     * Equals
     * @param o other object
     * @return true if they are equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextReply textReply = (TextReply) o;
        return Objects.equals(text, textReply.text);
    }

    /**
     * Hash code
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    /**
     * To string
     * @return string representation of this object
     */
    @Override
    public String toString() {
        return "TextReply{" +
                "text='" + text + '\'' +
                '}';
    }

    /**
     * Clone
     * @return copy of this object
     */
    @Override
    public TextReply clone() {
        return new TextReply(text);
    }
}