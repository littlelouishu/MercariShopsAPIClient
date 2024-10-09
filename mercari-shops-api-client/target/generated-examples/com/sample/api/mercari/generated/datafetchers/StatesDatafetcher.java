package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.State;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class StatesDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "states"
  )
  public List<State> getStates(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
