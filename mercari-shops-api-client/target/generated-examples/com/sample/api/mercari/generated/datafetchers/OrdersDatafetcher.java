package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.OrderConnection;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class OrdersDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "orders"
  )
  public OrderConnection getOrders(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
