package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.Shop;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class ShopDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "shop"
  )
  public Shop getShop(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
