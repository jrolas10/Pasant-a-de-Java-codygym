package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "micodegymrolas_bot";
    public static final String TOKEN = "7053280068:AAGTGcfgq0f72eO24YwAU7E4FD_m_NBet2A";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);

    }

    @Override
    public void onUpdateEventReceived(Update update) {
        if(getMessageText().equals("/start"))
            sendTextMessageAsync("hola _soy EL CHATBOT_ DE *ROLAS*");

        if(getMessageText().contains("hola"))
            sendTextMessageAsync("Hola, cual es es tu nombre?");

        if(getMessageText().contains("mi nombre es"))
            sendTextMessageAsync("Es un placer, yo soy *GATO*");
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}