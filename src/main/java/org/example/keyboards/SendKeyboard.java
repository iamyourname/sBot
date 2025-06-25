package org.example.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class SendKeyboard {


    /*


public static SendMessage hermitageInlineKeyboardAb (long chat_id) {

// создаем объект сообщения
        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText(«Чтобы увидеть картины, нажми на фамилию художника или перейди в полную коллекцию на сайте музея»);

// создаем объект встроенной клавиатуры
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

// создаем список списков кнопок, который впоследствии объединит ряды кнопок
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

// создаем список с кнопками для первого ряда
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

// создаем первую кнопку для в ряду
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();

// устанавливаем параметр текста на кнопке
        inlineKeyboardButton1.setText(«Аврезе»);

// устанавливаем параметр callback_data
        inlineKeyboardButton1.setCallbackData(«АВРЕЗЕ»);

// создаем по аналогии вторую кнопку в ряду
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText(«Аликс»);
        inlineKeyboardButton2.setCallbackData(«АЛИКС»);

// добавляем кнопки в первый ряд в том порядке,
// какой нам необходим. В рассматриваемом случае ряд будет содержать 2 кнопки,
// размер которых будет одинаково пропорционально растянут по ширине сообщения,
// под которым клавиатура располагается
        rowInline1.add(inlineKeyboardButton1);
        rowInline1.add(inlineKeyboardButton2);

// если необходимо в кнопку запрограммировать переход на адрес
// Интернет страницы, такой параметр устанавливается через setUrl(String s).
// При этом в приведенном примере ряд кнопок будет состоять всего из одной кнопки
        InlineKeyboardButton inlineKeyboardButton21 = new InlineKeyboardButton();
        inlineKeyboardButton21.setText(«Переход на внешний сайт»);
        inlineKeyboardButton21.setUrl(«https://collections.hermitagemuseum.org»);

// устанавливаем url, указывая строковый параметр с адресом страницы
        inlineKeyboardButton21.setCallbackData(«ПЕРЕХОД НА ВНЕШНИЙ САЙТ»);

        rowInline11.add(inlineKeyboardButton21);

// настраиваем разметку всей клавиатуры
        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
…
        rowsInline.add(rowInline11);

// добавляем встроенную клавиатуру в сообщение
        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

     */
    public static SendMessage hermitageInlineKeyboardAb (long chat_id) {

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chat_id));
        message.setText("Чтобы увидеть картины, нажми на фамилию художника или перейди в полную коллекцию на сайте музея");

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Аврезе");
        inlineKeyboardButton1.setCallbackData("АВРЕЗЕ");
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Аликс Ив");
        inlineKeyboardButton2.setCallbackData("АЛИКС");
        rowInline1.add(inlineKeyboardButton1);
        rowInline1.add(inlineKeyboardButton2);

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText("Амелин");
        inlineKeyboardButton3.setCallbackData("АМЕЛИН");
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton4.setText("Арстер");
        inlineKeyboardButton4.setCallbackData("АРСТЕР");
        rowInline2.add(inlineKeyboardButton3);
        rowInline2.add(inlineKeyboardButton4);

        // иные необходимые ряды кнопок по вышеуказанной аналогии

        List<InlineKeyboardButton> rowInline11 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton21 = new InlineKeyboardButton();
        inlineKeyboardButton21.setText("Переход на внешний сайт");
        inlineKeyboardButton21.setUrl("https://collections.hermitagemuseum.org");
        inlineKeyboardButton21.setCallbackData("ПЕРЕХОД НА ВНЕШНИЙ САЙТ");
        rowInline11.add(inlineKeyboardButton21);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline11);

        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        return message;

    }



}