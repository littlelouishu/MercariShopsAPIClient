package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ShippingPayerOption;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class AvailableShippingPayerOptionsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "availableShippingPayerOptions"
  )
  public List<ShippingPayerOption> getAvailableShippingPayerOptions(
      DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
