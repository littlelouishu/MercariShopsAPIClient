package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.CancelReason;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class CancelReasonTypesDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "cancelReasonTypes"
  )
  public List<CancelReason> getCancelReasonTypes(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
