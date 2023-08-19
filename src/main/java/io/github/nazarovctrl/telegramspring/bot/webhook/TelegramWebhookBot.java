package io.github.nazarovctrl.telegramspring.bot.webhook;

import io.github.nazarovctrl.telegramspring.bot.AbstractBotConfig;
import io.github.nazarovctrl.telegramspring.function.Initialize;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class TelegramWebhookBot extends org.telegram.telegrambots.bots.TelegramWebhookBot implements Initialize {

    private final AbstractBotConfig botConfig;

    public TelegramWebhookBot(AbstractBotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @PostConstruct
    public void initialize() {
        initializeBotCommand();
    }

    public void initializeBotCommand() {
        try {
            execute(new SetMyCommands(botConfig.getCommandList(), new BotCommandScopeDefault(), null));
            log.info("Command list successfully initialized");
        } catch (TelegramApiException e) {
            log.warn("Command list initializing failed");
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    public String getBotUri() {
        return botConfig.getUri();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    @Override
    public String getBotPath() {
        return "/update";
    }
}
