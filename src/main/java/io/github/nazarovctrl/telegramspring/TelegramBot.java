package io.github.nazarovctrl.telegramspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Slf4j
@Component
public class TelegramBot extends TelegramWebhookBot {

    private final BotConfig botConfig;

    public TelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
        initializeBotCommand(botConfig.getCommandList());
    }

    private void initializeBotCommand(List<BotCommand> commandList) {
        try {
            execute(new SetMyCommands(commandList, new BotCommandScopeDefault(), null));
            log.info("Command list successfully initialized");
        } catch (TelegramApiException e) {
            log.warn("Command list initializing failed");
        }
    }

    @Bean(name = "command")
    CommandLineRunner commandLineRunner(SendMessageService sendMessageService) {
        return args -> {
            sendMessageService.setTelegramBot(this);
            log.info("SendMessageService initialized");
        };
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
