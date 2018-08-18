package ch.generali.camundacon18.async.impl;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

import static ch.generali.camundacon18.async.impl.AsyncConstants.INITIATOR;
import static ch.generali.camundacon18.async.impl.AsyncConstants.IT_ARTIFACT;

public class NotifyUser implements JavaDelegate {

    private static final Logger LOG = Logger.getLogger(NotifyUser.class.getName());

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {
        final String initiator = (String) delegateExecution.getVariable(INITIATOR);
        final ItArtifact itArtifact = (ItArtifact) delegateExecution.getVariable(IT_ARTIFACT);
        LOG.info(String.format("...Emailing %s: Deployment of %s has been successfully completed",  initiator, itArtifact.toString()));
    }
}
