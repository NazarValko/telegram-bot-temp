package org.example.bot;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.List;

import static java.util.regex.Pattern.matches;


@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    @Override
    public synchronized void onUpdateReceived(Update update) {
        // Example: Echo bot
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            if (messageText.equals("/start")) {
                SendMessage message = new SendMessage()
                        .setChatId(chatId)
                        .setText("Виберіть категорію музики...");
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

                List<KeyboardRow> keyboard = new ArrayList<>();

                KeyboardRow row = new KeyboardRow();
                row.add("Поп-музика");
                row.add("Класична");
                row.add("Рок");
                keyboard.add(row);

                row = new KeyboardRow();

                row.add("Хіп-хоп");
                row.add("Електроніка");
                row.add("Country");
                keyboard.add(row);

                keyboardMarkup.setKeyboard(keyboard);
                message.setReplyMarkup(keyboardMarkup);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (messageText.equals("Поп-музика")) {
                SendMessage msg = new SendMessage();
                msg.setText("Що хочете послухати?");
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (messageText.equals("Класична")) {
                SendMessage msg = new SendMessage()
                        .setChatId(chatId)
                        .setText("https://www.jamendo.com/community/classical/tracks");
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (messageText.equals("Рок")) {
                SendMessage msg = new SendMessage()
                        .setChatId(chatId)
                        .setText("https://www.jamendo.com/start?genre=%D0%A0%D0%BE%D0%BA-%D0%BC%D1%83%D0%B7%D1%8B%D0%BA%D0%B0");
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (messageText.equals("Хіп-хоп")) {
                SendMessage msg = new SendMessage()
                        .setChatId(chatId)
                        .setText("https://www.jamendo.com/start?genre=hiphop");
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (messageText.equals("Електроніка")) {
                SendMessage msg = new SendMessage()
                        .setChatId(chatId)
                        .setText("https://www.jamendo.com/start?genre=electronic");
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (messageText.equals("Country")) {
                SendMessage msg = new SendMessage()
                        .setChatId(chatId)
                        .setText("https://www.jamendo.com/start?genre=country");
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (messageText.equals("/hide")) {
                SendMessage msg = new SendMessage()
                        .setChatId(chatId)
                        .setText("Goodbye");
                ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();
                msg.setReplyMarkup(keyboardMarkup);

                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        }
    }




    public String getBotUsername() {
        return "ITClusterDemoBot";
    }

    public String getBotToken() {
        return "1355633692:AAHM2TKSG1FZCH_XazAtSlnJCXZoP1BzkLs";
    }
}
