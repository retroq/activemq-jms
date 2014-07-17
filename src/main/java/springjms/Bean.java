package springjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by антон on 02.07.2014.
 */
@Component
public class Bean {
    @Autowired
    JmsTemplate jmsTemplate;

    public void p(){
        System.out.println("Hello!");
        for (int i = 0; i < 10; i++) {

            jmsTemplate.send(new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    TextMessage textMessage = session.createTextMessage();
                    textMessage.setText("Hello from jdbc template " + Thread.currentThread().getName());
                    return textMessage;
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
