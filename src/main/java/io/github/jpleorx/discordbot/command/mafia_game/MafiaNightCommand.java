package io.github.jpleorx.discordbot.command.mafia_game;

import io.github.jpleorx.discordbot.command.core.Placeholders;
import io.github.jpleorx.discordbot.command.core.command.TextCommand;
import io.github.jpleorx.discordbot.command.core.reply.TextBlockReply;

public class MafiaNightCommand implements TextCommand<TextBlockReply> {
    @Override
    public String getCommand() {
        return "=mafiaNight";
    }

    @Override
    public String getMessageNoArguments() {
        return "Ночь наступает...";
    }

    @Override
    public String getMessageFullArguments() {
        return "Ночь наступает... " + Placeholders.USER_MENTION + " убит...";
    }

    @Override
    public TextBlockReply createReply(String replyText) {
        return new TextBlockReply(replyText);
    }
}