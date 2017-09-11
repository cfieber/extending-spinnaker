//////////////////////////////////////////////////////////////////////////////////////////////////

package com.innitech.spinnaker.tpsreport;

import com.netflix.spectator.api.Registry;
import com.netflix.spinnaker.orca.ExecutionStatus;
import com.netflix.spinnaker.orca.RetryableTask;
import com.netflix.spinnaker.orca.TaskResult;
import com.netflix.spinnaker.orca.pipeline.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.time.Duration;
import java.util.Collections;

@Component
public class TpsreportTask implements RetryableTask {
  @Override
  public long getBackoffPeriod() { return Duration.ofMinutes(5).toMillis(); }

  @Override
  public long getTimeout() { return Duration.ofDays(2).toMillis(); }

  @Autowired protected Registry registry;

  @Nonnull
  @Override
  public TaskResult execute(@Nonnull Stage stage) {
    registry.counter("tpsreports").increment();
    if ("lumbergh@innitech.com".equals(stage.getContext().get("approver"))) {
      return new TaskResult(ExecutionStatus.RUNNING,
        Collections.singletonMap("message", "I'm gonna need you to go ahead come in tomorrow."));
    }
    return TaskResult.SUCCEEDED;
  }
}

