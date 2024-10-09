package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ProductConditionOption;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class AvailableProductConditionOptionsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "availableProductConditionOptions"
  )
  public List<ProductConditionOption> getAvailableProductConditionOptions(
      DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
