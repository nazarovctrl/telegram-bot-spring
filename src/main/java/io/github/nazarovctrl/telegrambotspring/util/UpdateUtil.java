package io.github.nazarovctrl.telegrambotspring.util;

import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateUtil {
    public static User getUserFromUpdate(Update update) {
        User user = null;

        if (update.hasMessage()) {
            user = update.getMessage().getFrom();
        } else if (update.hasInlineQuery()) {
            user = update.getInlineQuery().getFrom();
        } else if (update.hasChosenInlineQuery()) {
            user = update.getChosenInlineQuery().getFrom();
        } else if (update.hasCallbackQuery()) {
            user = update.getCallbackQuery().getFrom();
        } else if (update.hasEditedMessage()) {
            user = update.getEditedMessage().getFrom();
        } else if (update.hasChannelPost()) {
            user = update.getChannelPost().getFrom();
        } else if (update.hasEditedChannelPost()) {
            user = update.getEditedChannelPost().getFrom();
        } else if (update.hasShippingQuery()) {
            user = update.getShippingQuery().getFrom();
        } else if (update.hasPreCheckoutQuery()) {
            user = update.getPreCheckoutQuery().getFrom();
        } else if (update.hasPollAnswer()) {
            user = update.getPollAnswer().getUser();
        } else if (update.hasMyChatMember()) {
            user = update.getMyChatMember().getFrom();
        } else if (update.hasChatMember()) {
            user = update.getChatMember().getFrom();
        } else if (update.hasChatJoinRequest()) {
            user = update.getChatJoinRequest().getUser();
        }
        return user;
    }
}
