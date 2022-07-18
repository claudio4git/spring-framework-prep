# About this project

This project will show you how the Spring Framework works.

# Structure of the project

This project is `hello world` using 3 classes.

- `GettingService` Is responsible for show the getting word
- `TimerService` Is responsible for show the date and time
- `OutputService` Is responsible for show the hello world using GettingService and TimerService

You can run the `Application` and show the getting result.

# Java approach

---

The first approach was used just Java to create the hello world using 3 classes as dependencies.

[Here](https://github.com/claudio4git/spring-framework-prep/releases/tag/spring-core-in-java-v1) is the v1 tag on GitHub.

Using this approach you need to create all dependencies classes before you can run the application.

# Spring Framework approach

---

This approach was used Java and Spring Framework (Core and Context) to manage injections.

[Here](https://github.com/claudio4git/spring-framework-prep/releases/tag/spring-core-in-java-v2) is the v2 tag on GitHub.

Using this approach you configure the classes dependencies and delegate the classes dependencies to Spring DI.

And use `context.getBean()` to get an instance.

## Spring Framework core dep

Go to `pom.xml` file and add these dependencies.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>5.2.3.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.2.3.RELEASE</version>
    </dependency>
</dependencies>
```

## Spring configuration

Create a `SpringConfiguration` Java file and configure the Beans.

```java
@Configuration
public class SpringConfiguration {

    @Value("Hello there")
    private String greeting;

    @Autowired
    private GreetingService greetingService;
    @Autowired
    private TimerService timerService;

    @Bean
    public GreetingService gettingService() {
        return new GreetingService(greeting);
    }

    @Bean
    public TimerService timerService() {
        return new TimerService(false);
    }

    @Bean
    public OutputService outputService() {
        return new OutputService(greetingService, timerService);
    }
}
```

## Running with DI

Then, change your `Application` lunch Java file to get instances from Spring DI and don't use `new` operator to get them.

```java
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        OutputService outputService = context.getBean(OutputService.class);
        outputService.generateOutput("Claudio");
    }
}
```