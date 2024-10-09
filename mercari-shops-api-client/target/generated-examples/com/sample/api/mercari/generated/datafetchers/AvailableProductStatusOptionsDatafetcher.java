package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ProductStatusOption;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class AvailableProductStatusOptionsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "availableProductStatusOptions"
  )
  public List<ProductStatusOption> getAvailableProductStatusOptions(
      DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
