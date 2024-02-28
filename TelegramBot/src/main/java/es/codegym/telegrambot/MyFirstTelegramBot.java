package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;
//import static jdk.internal.foreign.abi.aarch64.AArch64Architecture.Regs.v1;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "micodegymrolas_bot";
    public static final String TOKEN = "7053280068:AAGTGcfgq0f72eO24YwAU7E4FD_m_NBet2A";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);

    }

    @Override
    public void onUpdateEventReceived(Update update) {
        if(getMessageText().equals("/start")){
            addUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera","step_1_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Tomar una salchicha¡ +20,","step_2_btn",
                            "tomar un pesdado +20 de fama","step_2_btn",
                            "tirar una lata de pepinillos¡ +20 de fama","step_2_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Romper al robot aspirador","step_3_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("enviar al robot aspirador a por comidad +30 de fama","step_4_btn",
                            "dar un paseo en el robot aspirador +30 de fama","step_4_btn",
                            "huir del robot aspirador +30 de fama", "step_4_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Ponerme la gopro y ganar +40 de fama","step_5_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            addUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("pescado","step_6_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear contraseña","step_7_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("FELICIDADES IR AL FINAL","step_9_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_9_btn")){
            addUserGlory(0);
            int puntos=getUserGlory();
            sendTextMessageAsync(FINAL_TEXT+"puntaje final = "+ puntos + "puntos FELICIDADES",
                    Map.of("EMPEZAR NUEVAMENTE","step_10_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_10_btn")){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            addUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera","step_1_btn"));
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}