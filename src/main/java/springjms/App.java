package springjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by антон on 02.07.2014.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    //    ApplicationContext consumerContext = new ClassPathXmlApplicationContext("consumerContext.xml");
        ((Bean)context.getBean(Bean.class)).p();
    }
}
