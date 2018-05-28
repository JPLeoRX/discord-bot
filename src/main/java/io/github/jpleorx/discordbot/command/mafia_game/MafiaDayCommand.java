package io.github.jpleorx.discordbot.command.mafia_game;

import io.github.jpleorx.discordbot.command.core.formating.Placeholders;
import io.github.jpleorx.discordbot.command.core.command.TextCommand;
import io.github.jpleorx.discordbot.command.core.reply.TextBlockReply;

public class MafiaDayCommand implements TextCommand<TextBlockReply> {
    @Override
    public String getCommand() {
        return "=mafiaDay";
    }

    @Override
    public String getMessageNoArguments() {
        return "День наступает...";
    }

    @Override
    public String getMessageFullArguments() {
        return "День наступает... " + Placeholders.USER_MENTION + " убит...";
    }

    @Override
    public TextBlockReply createReply(String replyText) {
        return new TextBlockReply(replyText);
    }
}