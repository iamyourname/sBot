package org.example;

import org.example.keyboards.SendKeyboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    final static Logger logger = LoggerFactory.getLogger(Bot.class);



    @Override
    public String getBotUsername() {
        return "moiseev_vpn_bot";
    }

    @Override
    public String getBotToken() {
        return "8025936217:AAFOqA2ywo4AqpU9sRLxMjJrQILWpzbCLo4";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")) {
                sendInlineKeyboard(chatId);
            }
        } else if (update.hasCallbackQuery()) {
            String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();
            var user = update.getCallbackQuery().getMessage().getFrom();
            var bText = update.getCallbackQuery().getMessage().getText();

            if (call_data.equals("addnew")) {
                // Действие при нажатии на кнопку 1

                executeEditMessageText("Вы нажали кнопку 1", chat_id, message_id);
            } else if (call_data.equals("show")) {
                // Действие при нажатии на кнопку 2
                executeEditMessageText("Вы нажали кнопку 2", chat_id, message_id);
            }
        }

    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    private void executeEditMessageText(String text, long chatId, long messageId) {
        //Редактирование текста сообщения после нажатия на кнопку
        SendMessage message = new SendMessage(); // Create a message object object
                message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try {
            execute(message); // Sending our message by using method execute()
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    private void sendInlineKeyboard(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Добавить торрент");
        button1.setCallbackData("addnew");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Активные загрузки");
        button2.setCallbackData("show");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(button1);
        keyboardButtonsRow1.add(button2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowList);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Выберите действие:");
        message.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



}
