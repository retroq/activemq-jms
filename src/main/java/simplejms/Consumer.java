package simplejms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * Created by антон on 02.07.2014.
 */
public class Consumer implements Runnable{
    Logger log = LoggerFactory.getLogger(Consumer.class);

    @Override
    public void run() {

        try {
            ConnectionFactory connectionFactory = App.getConnectionFactory();
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("myqueue");
            MessageConsumer messageConsumer = session.createConsumer(destination);
            TextMessage message;// = session.createTextMessage();
            //message.setText("Hello from " + Thread.currentThread().getName());
            message = (TextMessage)messageConsumer.receive(1000);
            if (message == null) {
                log.info("Message was not received");
                return;
            }
            log.info("Message received");
            System.out.println(message.getText());
            session.close();
            connection.stop();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
