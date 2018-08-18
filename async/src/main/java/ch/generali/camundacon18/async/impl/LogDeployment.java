package ch.generali.camundacon18.async.impl;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;

import java.util.logging.Logger;

import static ch.generali.camundacon18.async.impl.AsyncConstants.IT_ARTIFACT;

public class LogDeployment implements JavaDelegate, TaskListener {

    private static final Logger LOG = Logger.getLogger(LogDeployment.class.getName());

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {
        final ItArtifact itArtifact = (ItArtifact) delegateExecution.getVariable(IT_ARTIFACT);
        LOG.info("Deployment completed: " + itArtifact);
    }

    @Override
    public void notify(final DelegateTask delegateTask) {
        final ItArtifact itArtifact = (ItArtifact) delegateTask.getVariable(IT_ARTIFACT);
        final String taskDefinitionKey = delegateTask.getTaskDefinitionKey();
        LOG.info(String.format("Deployment of %s completed, task definition key: %s ", itArtifact, taskDefinitionKey));
    }
}
