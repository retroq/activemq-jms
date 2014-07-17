package simplejms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.ConnectionFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by антон on 02.07.2014.
 */
public class App {
    public static ConnectionFactory getConnectionFactory() {
        String host = "localhost";
        String port = "61616";
        String password = "password";
        String login = "admin";
        return new ActiveMQConnectionFactory(login, password, "tcp://localhost:61616");
    }
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
      //  executor.execute(new Producer());
        executor.execute(new Consumer());
    }

    public static void run(Runnable runnable){

    }
}
