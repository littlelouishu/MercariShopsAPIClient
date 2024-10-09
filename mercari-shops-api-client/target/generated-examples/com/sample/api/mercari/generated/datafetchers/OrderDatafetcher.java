package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.Order;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class OrderDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "order"
  )
  public Order getOrder(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
