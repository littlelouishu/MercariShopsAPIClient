package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.ProductBrand;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class ProductBrandsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "productBrands"
  )
  public List<ProductBrand> getProductBrands(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
