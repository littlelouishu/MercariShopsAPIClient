package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ShippingMethodOption;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class AvailableShippingMethodOptionsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "availableShippingMethodOptions"
  )
  public List<ShippingMethodOption> getAvailableShippingMethodOptions(
      DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
