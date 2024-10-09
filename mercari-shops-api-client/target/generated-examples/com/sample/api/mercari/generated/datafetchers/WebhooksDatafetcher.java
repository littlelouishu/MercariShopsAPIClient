package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.Webhook;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class WebhooksDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "webhooks"
  )
  public List<Webhook> getWebhooks(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
