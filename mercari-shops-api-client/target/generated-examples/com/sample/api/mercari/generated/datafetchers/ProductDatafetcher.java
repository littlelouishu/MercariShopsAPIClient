package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.Product;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class ProductDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "product"
  )
  public Product getProduct(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
