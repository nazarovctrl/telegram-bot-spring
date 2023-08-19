package io.github.nazarovctrl.telegramspring.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

@PropertySource("application.properties")
public abstract class AbstractBotConfig {
    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String token;

    @Value("${bot.uri}")
    private String uri;

    private final List<BotCommand> commandList;

    public AbstractBotConfig() {
        commandList = addBotCommands();
    }

    public abstract List<BotCommand> addBotCommands();

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public String getUri() {
        return uri;
    }

    public List<BotCommand> getCommandList() {
        return commandList;
    }
}
