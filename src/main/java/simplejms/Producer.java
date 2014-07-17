package simplejms;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by антон on 02.07.2014.
 */
public class Producer implements Runnable{
    Logger log = LoggerFactory.getLogger(Producer.class);

    @Override
    public void run() {

        try {
            ConnectionFactory connectionFactory = App.getConnectionFactory();
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("myqueue");
            MessageProducer messageProducer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            log.info("Sending");
            message.setText("Hello from " + Thread.currentThread().getName());
            messageProducer.send(message);
            session.close();
            connection.stop();
            connection.close();

            log.info("Sent");

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
