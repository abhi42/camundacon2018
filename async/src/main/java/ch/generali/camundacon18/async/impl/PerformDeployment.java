package ch.generali.camundacon18.async.impl;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

import static ch.generali.camundacon18.async.impl.AsyncConstants.IT_ARTIFACT;

public class PerformDeployment implements JavaDelegate {

    private static final Logger LOG = Logger.getLogger(PerformDeployment.class.getName());

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {
        final ItArtifact itArtifact = (ItArtifact) delegateExecution.getVariable(IT_ARTIFACT);
        LOG.info("Performing deployment of " + itArtifact);
    }
}
