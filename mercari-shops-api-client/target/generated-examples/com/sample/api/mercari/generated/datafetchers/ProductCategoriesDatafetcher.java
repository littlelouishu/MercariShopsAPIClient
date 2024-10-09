package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ProductCategory;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class ProductCategoriesDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "productCategories"
  )
  public List<ProductCategory> getProductCategories(
      DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
