import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Salon on 27/07/2018.
 */
public class CatBot  extends TelegramLongPollingBot {

    public static final String CAT_PHOTO_URL = "https://www.catster.com/wp-content/uploads/2017/08/A-fluffy-cat-looking-funny-surprised-or-concerned.jpg";
    public static final String CAT_PHOTO_URL2 = "https://static.boredpanda.com/blog/wp-content/uploads/2018/04/5acb63d83493f__700-png.jpg";
    public static final String CAT_PHOTO_URL3 = "https://ichef.bbci.co.uk/images/ic/720x405/p0517py6.jpg";
    public static final String CAT_PHOTO_URL4 = "https://i.ytimg.com/vi/YCaGYUIfdy4/maxresdefault.jpg";
    private List<String> cats = new ArrayList<String>(Arrays.asList(CAT_PHOTO_URL,CAT_PHOTO_URL2,CAT_PHOTO_URL3,CAT_PHOTO_URL4));
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().) {
                SendMessage OpeningMessage = new SendMessage(update.getMessage().getChatId(), "hi there... wanna c somthing cool??");
                try {
                    execute(OpeningMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            SendMessage message = new SendMessage(update.getMessage().getChatId(), "here is a cat" );
            SendPhoto photo = new SendPhoto();
            photo.setChatId(update.getMessage().getChatId());
            photo.setPhoto(cats.get(getRandomIndex()));

            try {
                execute(message);
                execute(photo);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private int getRandomIndex() {
        return (int)(Math.round(Math.random() * 3));
    }


    public String getBotUsername() {
        return "Cat032Bot";
    }

    public String getBotToken() {
        return "TOKEN";
    }
}
