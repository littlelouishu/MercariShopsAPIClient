package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ProductVariant;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class ProductVariantDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "productVariant"
  )
  public ProductVariant getProductVariant(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
