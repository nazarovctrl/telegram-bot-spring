package io.github.nazarovctrl.telegrambotspring.annotation;

import io.github.nazarovctrl.telegrambotspring.bot.BotConfig;
import io.github.nazarovctrl.telegrambotspring.bot.BotInitializer;
import io.github.nazarovctrl.telegrambotspring.bot.MessageSender;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation for enabling telegram bot without webhook
 *
 * @author Azimjon Nazarov
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(EnableTelegramLongPollingBot.LongPollingConfig.class)
public @interface EnableTelegramLongPollingBot {

    /**
     * The class for creating beans for TelegramLongPollingBot
     */
    @Configuration
    @ComponentScan(basePackages = "io.github.nazarovctrl.telegrambotspring.bot.longpolling",
            basePackageClasses = {BotInitializer.class, BotConfig.class, MessageSender.class})
    class LongPollingConfig {
    }
}