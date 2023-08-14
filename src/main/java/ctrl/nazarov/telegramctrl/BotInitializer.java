package ctrl.nazarov.telegramctrl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
@RequiredArgsConstructor
public class BotInitializer {
    private final TelegramBot bot;

    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        SetWebhook setWebhook = SetWebhook.builder()
                .url(bot.getBotUri())
                .build();

        bot.setWebhook(setWebhook);
        log.info("Telegram bot initialized");
    }
}
