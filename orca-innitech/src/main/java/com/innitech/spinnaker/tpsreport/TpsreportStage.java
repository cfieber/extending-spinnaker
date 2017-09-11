//////////////////////////////////////////////////////////////////////////////////////////////////

package com.innitech.spinnaker.tpsreport;

import com.netflix.spinnaker.orca.pipeline.StageDefinitionBuilder;
import com.netflix.spinnaker.orca.pipeline.TaskNode;
import com.netflix.spinnaker.orca.pipeline.model.Execution;
import com.netflix.spinnaker.orca.pipeline.model.Stage;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

@Component
public class TpsreportStage implements StageDefinitionBuilder {
  @Override
  public <T extends Execution<T>> void taskGraph(@Nonnull Stage<T> stage,
                                                 @Nonnull TaskNode.Builder builder) {
    builder.withTask("tpsreport", TpsreportTask.class);
  }
}


