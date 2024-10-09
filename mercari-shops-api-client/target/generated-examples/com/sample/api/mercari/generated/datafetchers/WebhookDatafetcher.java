package com.sample.api.mercari.generated.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.sample.api.mercari.generated.types.Webhook;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class WebhookDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "webhook"
  )
  public Webhook getWebhook(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
