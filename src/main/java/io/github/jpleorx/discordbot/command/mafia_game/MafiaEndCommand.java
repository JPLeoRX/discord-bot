package io.github.jpleorx.discordbot.command.mafia_game;

import io.github.jpleorx.discordbot.command.core.command.TextCommand;
import io.github.jpleorx.discordbot.command.core.reply.TextBlockReply;

public class MafiaEndCommand implements TextCommand<TextBlockReply> {
    @Override
    public String getCommand() {
        return "=mafiaEnd";
    }

    @Override
    public String getMessageNoArguments() {
        return "Игра закончена!";
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
