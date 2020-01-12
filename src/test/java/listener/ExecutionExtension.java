package listener;

import org.junit.jupiter.api.extension.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

public class ExecutionExtension implements BeforeTestExecutionCallback, BeforeEachCallback, AfterEachCallback, AfterTestExecutionCallback {

    private static final Logger logger = Logger.getLogger(ExecutionExtension.class.getName());
    private static final String START_TIME = "start time";

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        Method testMethod = extensionContext.getRequiredTestMethod();
        logger.info(() ->
                String.format("Finished - [%s]", testMethod.getName()));
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        Instant startTime = getStore(context).remove(START_TIME, Instant.class);
        Instant iFinal = Instant.now();
        Duration duration = Duration.between(startTime, iFinal);
        logger.info(() ->
                String.format("Method [%s] took %s ms.", testMethod.getName(), duration));
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        Instant iInicial = Instant.now();
        getStore(context).put(START_TIME, iInicial);
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        logger.info(() ->
                String.format("Starting - [%s]", testMethod.getName()));
    }

    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getRequiredTestMethod()));
    }
}