package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();

        System.out.println(
                user.getUserName() + "(" + user.getId() + "): " + msg.getText()
        );
        logger.info(user.getUserName() + "(" + user.getId() + "): " + msg.getText());
        sendText(id,msg.getText());

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



}
