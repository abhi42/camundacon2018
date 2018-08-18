package ch.generali.camundacon18.async.impl;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import static ch.generali.camundacon18.async.impl.AsyncConstants.*;

import java.util.logging.Logger;

public class AnalyzeDeployment implements JavaDelegate {

    private static final Logger LOG = Logger.getLogger(AnalyzeDeployment.class.getName());

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {
        final ItArtifact itArtifact = (ItArtifact) delegateExecution.getVariable(IT_ARTIFACT);
        LOG.info("...Analyzing deployed artifact: " + itArtifact.toString());
    }
}
