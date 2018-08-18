package ch.generali.camundacon18.async;

import ch.generali.camundacon18.async.impl.*;
import org.camunda.bpm.engine.impl.jobexecutor.JobExecutor;
import org.camunda.bpm.spring.boot.starter.configuration.impl.DefaultJobConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;

import java.util.logging.Logger;

import static org.camunda.bpm.spring.boot.starter.configuration.impl.DefaultJobConfiguration.JobConfiguration.CAMUNDA_TASK_EXECUTOR_QUALIFIER;

@SpringBootApplication
public class AsyncCamundaBpmProcessApplication {

    @Value("${job.executor.maxWaitInMillis}")
    private long maxWait;

    @Value("${job.executor.waitTimeInMillis}")
    private int waitTime;

    private static final Logger LOG = Logger.getLogger(AsyncCamundaBpmProcessApplication.class.getName());

    public static void main(final String[] args) {
        SpringApplication.run(AsyncCamundaBpmProcessApplication.class, args);
    }

    @Bean
    @ConditionalOnProperty(name = "camunda.bpm.job-execution.deployment-aware", havingValue = "true")
    public JobExecutor getJobExecutor(@Qualifier(CAMUNDA_TASK_EXECUTOR_QUALIFIER) final TaskExecutor taskExecutor) {
        final JobExecutor jobExecutor = DefaultJobConfiguration.JobConfiguration.jobExecutor(taskExecutor);
        jobExecutor.setWaitTimeInMillis(waitTime);
        jobExecutor.setMaxWait(maxWait);

        LOG.info("***** Job executor wait time set to " + waitTime + " ms");
        LOG.info("***** Job executor max wait set to " + maxWait + " ms");

        return jobExecutor;
    }

    @Bean
    public PerformDeployment performDeployment() {
        return new PerformDeployment();
    }

    @Bean
    public LogDeployment logDeployment() {
        return new LogDeployment();
    }

    @Bean
    public NotifyUser notifyUser() {
        return new NotifyUser();
    }

    @Bean
    public AnalyzeDeployment analyzeDeployment() {
        return new AnalyzeDeployment();
    }

    @Bean
    public UITaskExecutionListener uiTaskExecutionListener() {
        return new UITaskExecutionListener();
    }
}
