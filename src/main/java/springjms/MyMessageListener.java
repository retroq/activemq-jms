package springjms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Date;

/**
 * Created by антон on 02.07.2014.
 */
public class MyMessageListener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            if (message instanceof TextMessage)
                System.out.println(Thread.currentThread().getName()
                        + " " +new Date().toString()
                        + " " + ((TextMessage) message).getText());
            Thread.sleep(1000);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
