package ch.generali.camundacon18.async.impl;

import org.camunda.bpm.engine.delegate.*;

import java.util.logging.Logger;

/**
 * This is an easy adapter implementation 
 * illustrating how a Java Delegate can be used 
 * from within a BPMN 2.0 Service Task.
 */
public class UITaskExecutionListener implements JavaDelegate, TaskListener {
 
  private final Logger LOGGER = Logger.getLogger(UITaskExecutionListener.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
    LOGGER.info("\n\n  ... ExecutionListener UITaskExecutionListener invoked by "
            + "processDefinitionId=" + execution.getProcessDefinitionId()
            + ", activtyId=" + execution.getCurrentActivityId()
            + ", activtyName='" + execution.getCurrentActivityName() + "'"
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + " \n\n");
    
  }

  @Override
  public void notify(final DelegateTask delegateTask) {
    LOGGER.info("\n\n  ... TaskListener UITaskExecutionListener invoked by "
            + "processDefinitionId=" + delegateTask.getProcessDefinitionId()
            + ", processInstanceId=" + delegateTask.getProcessInstanceId()
            + ", executionId=" + delegateTask.getExecutionId()
            + ", taskId= " + delegateTask.getTaskDefinitionKey()
            + " \n\n");
  }

}
