package io.github.jpleorx.discordbot.command.mafia_game;

import io.github.jpleorx.discordbot.command.core.command.NoArgumentsCommand;
import io.github.jpleorx.discordbot.command.core.command.TextCommand;
import io.github.jpleorx.discordbot.command.core.reply.TextBlockReply;

public class MafiaStartCommand implements TextCommand<TextBlockReply> {
    @Override
    public String getCommand() {
        return "=mafiaStart";
    }

    @Override
    public String getMessageNoArguments() {
        return "Игра начинается!";
    }

    @Override
    public String getMessageFullArguments() {
        return this.getMessageNoArguments();
    }

    @Override
    public TextBlockReply createReply(String replyText) {
        return new TextBlockReply(replyText);
    }
}