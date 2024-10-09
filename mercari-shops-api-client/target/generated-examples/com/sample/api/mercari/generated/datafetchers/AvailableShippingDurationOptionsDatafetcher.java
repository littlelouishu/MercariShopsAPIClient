package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ShippingDurationOption;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class AvailableShippingDurationOptionsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "availableShippingDurationOptions"
  )
  public List<ShippingDurationOption> getAvailableShippingDurationOptions(
      DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
