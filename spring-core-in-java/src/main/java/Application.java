import com.jccf.service.GettingService;
import com.jccf.service.OutputService;
import com.jccf.service.TimerService;

public class Application {

    public static void main(String[] args) {
        GettingService gettingService = new GettingService("Hello");
        TimerService timerService = new TimerService(false);
        OutputService outputService = new OutputService(gettingService, timerService);

        outputService.generateOutput("Claudio");
    }
}
