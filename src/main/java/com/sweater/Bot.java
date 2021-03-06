package com.sweater;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    //метод для настройки сообщения и его отправки
    public void SendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    //метод приема сообщений
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()){
            switch(message.getText()){
                case "/start":
                    SendMsg(message, "Hello and welcome to Idea - the app that will not let your ideas be forgotten!");
                    break;

                case "/test":
                    SendMsg(message, "I am working just fine!");
                    break;
            }
        }
    }

    @Override
    //возвращает имя бота, указанный при регистрации
    public String getBotUsername() {
        return "IdeaAppBot";
    }

    @Override
    //токен, который получили от отца ботов
    public String getBotToken() {
        return "855690852:AAH2ycxPpw7IsDmSsCdYtf080_CAL49BYYQ";
    }
}
