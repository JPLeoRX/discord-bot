package io.github.jpleorx.discordbot.command.core.reply;

/**
 * This will be a simplistic text wrap around in a block reply. This object is immutable.
 *
 * @author Leo Ertuna
 * @since 28.05.2018 20:44
 */
public class TextBlockReply extends TextReply {
    /**
     * Constructor
     * @param text text
     */
    public TextBlockReply(String text) {
        super(text);
    }

    /**
     * Getter
     * @return text that'll be represented as a block
     */
    @Override
    public String getText() {
        return "```" + super.getText() + "```";
    }
}