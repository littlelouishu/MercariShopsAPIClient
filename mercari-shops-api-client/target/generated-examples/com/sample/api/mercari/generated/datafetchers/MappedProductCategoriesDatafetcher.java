package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ProductCategory;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class MappedProductCategoriesDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "mappedProductCategories"
  )
  public List<List<ProductCategory>> getMappedProductCategories(
      DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
