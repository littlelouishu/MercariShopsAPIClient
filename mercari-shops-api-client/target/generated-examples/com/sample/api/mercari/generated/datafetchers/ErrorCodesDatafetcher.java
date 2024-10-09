package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ErrorCode;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class ErrorCodesDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "errorCodes"
  )
  public List<ErrorCode> getErrorCodes(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
