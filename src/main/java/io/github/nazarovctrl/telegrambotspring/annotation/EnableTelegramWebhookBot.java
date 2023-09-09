package io.github.nazarovctrl.telegrambotspring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation for enabling telegram bot with webhook
 *
 * @author Azimjon Nazarov
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(EnableTelegramWebhookBot.WebhookConfig.class)
public @interface EnableTelegramWebhookBot {

    /**
     * The class for creating beans for TelegramWebhookBot
     */
    @Configuration
    @ComponentScan(basePackages = {"io.github.nazarovctrl.telegrambotspring.bot",
            "io.github.nazarovctrl.telegrambotspring.webhook"})
    class WebhookConfig {
    }
}