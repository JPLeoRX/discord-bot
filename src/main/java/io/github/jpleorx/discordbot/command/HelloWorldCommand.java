package io.github.jpleorx.discordbot.command;

import io.github.jpleorx.discordbot.command.core.Placeholders;
import io.github.jpleorx.discordbot.command.core.command.TextCommand;

/**
 * Simple hello world command
 *
 * @author Leo Ertuna
 * @since 28.05.2018 20:46
 */
public class HelloWorldCommand implements TextCommand {
    @Override
    public String getCommand() {
        return "=привет";
    }

    @Override
    public String getMessageNoArguments() {
        return "Ну привет-привет, пидрила, " + Placeholders.USER_MENTION + ".";
    }

    @Override
    public String getMessageFullArguments() {
        return "Здарова " + Placeholders.USER_MENTION + "! Ты пидор, держу в курсе.";
    }
}