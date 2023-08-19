package io.github.nazarovctrl.telegramspring.bot.longpolling;

import io.github.nazarovctrl.telegramspring.bot.AbstractBotConfig;
import io.github.nazarovctrl.telegramspring.controller.UpdateController;
import io.github.nazarovctrl.telegramspring.function.Initialize;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class TelegramLongPollingBot extends org.telegram.telegrambots.bots.TelegramLongPollingBot implements Initialize {

    private final AbstractBotConfig botConfig;
    private final UpdateController updateController;

    public TelegramLongPollingBot(AbstractBotConfig botConfig, UpdateController updateController) {
        this.botConfig = botConfig;
        this.updateController = updateController;
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

    @Override
    public void onUpdateReceived(Update update) {
        updateController.handle(update);
    }
}
