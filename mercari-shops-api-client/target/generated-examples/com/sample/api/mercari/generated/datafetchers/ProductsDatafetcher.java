package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ProductConnection;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class ProductsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "products"
  )
  public ProductConnection getProducts(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
