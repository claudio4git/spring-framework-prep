import com.jccf.config.SpringConfiguration;
import com.jccf.service.GreetingService;
import com.jccf.service.OutputService;
import com.jccf.service.TimerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        OutputService outputService = context.getBean(OutputService.class);

        outputService.generateOutput("Claudio");
    }
}
