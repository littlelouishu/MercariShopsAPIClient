package com.sample.api.mercari;

import java.time.ZoneId;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.graphql.dgs.client.GraphQLClientException;
import com.netflix.graphql.dgs.client.GraphQLResponse;
import com.netflix.graphql.dgs.client.WebClientGraphQLClient;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import com.sample.api.mercari.generated.client.CreateWebhookGraphQLQuery;
import com.sample.api.mercari.generated.client.CreateWebhookProjectionRoot;
import com.sample.api.mercari.generated.client.DeleteWebhookGraphQLQuery;
import com.sample.api.mercari.generated.client.DeleteWebhookProjectionRoot;
import com.sample.api.mercari.generated.client.ShopGraphQLQuery;
import com.sample.api.mercari.generated.client.ShopProjectionRoot;
import com.sample.api.mercari.generated.client.WebhookGraphQLQuery;
import com.sample.api.mercari.generated.client.WebhookProjectionRoot;
import com.sample.api.mercari.generated.types.CreateWebhookInput;
import com.sample.api.mercari.generated.types.CreateWebhookPayload;
import com.sample.api.mercari.generated.types.DeleteWebhookInput;
import com.sample.api.mercari.generated.types.DeleteWebhookPayload;
import com.sample.api.mercari.generated.types.Shop;
import com.sample.api.mercari.generated.types.Webhook;
import com.sample.api.mercari.generated.types.WebhookTopic;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class MercariAPISample {
    public static void main(String[] args) {
        Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.INFO);

        WebClientGraphQLClient client = new WebClientGraphQLClient(
            WebClient.builder()
                .baseUrl("https://api.mercari-shops-sandbox.com/v1/graphql")
                .defaultHeader("Authorization", "Bearer msp_your_api_key")
                .build());
        log.info("==============================query shop==============================");
        GraphQLQueryRequest queryShop = new GraphQLQueryRequest(
            ShopGraphQLQuery.newRequest().build(),
            new ShopProjectionRoot().id().name().businessKind().parent().createdAt().description());
        GraphQLResponse responseQueryShop = null;
        try {
            responseQueryShop = client.reactiveExecuteQuery(queryShop.serialize()).block();
        } catch (GraphQLClientException e) {
            log.error(e.getMessage());
        }

        if (responseQueryShop != null) {
            if (CollectionUtils.isNotEmpty(responseQueryShop.getErrors())) {
                responseQueryShop.getErrors().forEach(e -> log.error(e.getMessage()));
            } else {
                Shop shop = responseQueryShop.extractValueAsObject("data.shop", Shop.class);
                log.info("Shop info got: {}", shop.toString());
            }
        } else {
            log.error("Somehow the response for query {} got null.", queryShop.serialize());
        }

        log.info("==============================mutation creationWebhook==============================");
        GraphQLQueryRequest queryCreateWebhook = new GraphQLQueryRequest(
            CreateWebhookGraphQLQuery.newRequest()
                .input(
                    CreateWebhookInput.newBuilder()
                        .topic(WebhookTopic.ORDER_CREATED)
                        .endPoint("https://www.sample.com/api/mercari/order_created")
                        .build())
                .build(),
            new CreateWebhookProjectionRoot().webhook().id().apiVersion().topic().parent().createdAt().endPoint());

        GraphQLResponse responseCreateWebhook = null;
        try {
            responseCreateWebhook = client.reactiveExecuteQuery(queryCreateWebhook.serialize()).block();
        } catch (GraphQLClientException e) {
            log.error(e.getMessage());
        }

        CreateWebhookPayload createdWebhookPayload = null;

        if (responseCreateWebhook != null) {
            if (CollectionUtils.isNotEmpty(responseCreateWebhook.getErrors())) {
                responseCreateWebhook.getErrors().forEach(e -> log.error(e.toString()));
            } else {
                createdWebhookPayload = responseCreateWebhook.extractValueAsObject("data.createWebhook", CreateWebhookPayload.class);
                log.info("Webhook info created: {}", createdWebhookPayload.toString());
            }
        } else {
            log.error("Somehow the response for query {} got null.", queryCreateWebhook.serialize());
        }

        log.info("==============================query webhook==============================");
        GraphQLQueryRequest queryWebhookExists = new GraphQLQueryRequest(
            WebhookGraphQLQuery.newRequest().id(createdWebhookPayload.getWebhook().getId()).build(),
            new WebhookProjectionRoot().id().apiVersion().createdAt().endPoint().topic());

        GraphQLResponse responseQueryWebhookExsits = client.reactiveExecuteQuery(queryWebhookExists.serialize()).block();

        if (CollectionUtils.isNotEmpty(responseQueryWebhookExsits.getErrors())) {
            responseQueryWebhookExsits.getErrors().forEach(e -> log.error(e.toString()));
        } else {
            Webhook webhoodExists = responseQueryWebhookExsits.extractValueAsObject("data.webhook", Webhook.class);
            log.info("Webhook info got: {}", webhoodExists.toString());
            log.info(webhoodExists.getCreatedAt().toString());
            log.info(webhoodExists.getCreatedAt().atZoneSameInstant(ZoneId.systemDefault()).toString());
        }

        log.info("==============================delete webhook==============================");
        GraphQLQueryRequest queryDeleteWebhook = new GraphQLQueryRequest(
            DeleteWebhookGraphQLQuery.newRequest()
                .input(DeleteWebhookInput.newBuilder().id(createdWebhookPayload.getWebhook().getId()).build())
                .build(),
            new DeleteWebhookProjectionRoot().id());

        GraphQLResponse responseDeleteWebhook = client.reactiveExecuteQuery(queryDeleteWebhook.serialize()).block();

        if (CollectionUtils.isNotEmpty(responseDeleteWebhook.getErrors())) {
            responseDeleteWebhook.getErrors().forEach(e -> log.error(e.toString()));
        } else {
            DeleteWebhookPayload deleteWebhookPayload =
                responseDeleteWebhook.extractValueAsObject("data.deleteWebhook", DeleteWebhookPayload.class);
            log.info("DeleteWebhookPayload info got: {}", deleteWebhookPayload.toString());
        }

        log.info("==============================query webhook does not exist==============================");
        GraphQLQueryRequest queryWebhookNotExists = new GraphQLQueryRequest(
            WebhookGraphQLQuery.newRequest().id(createdWebhookPayload.getWebhook().getId()).build(),
            new WebhookProjectionRoot().id().apiVersion().createdAt().endPoint().topic());

        GraphQLResponse responseQueryWebhookNotExsits = client.reactiveExecuteQuery(queryWebhookNotExists.serialize()).block();

        if (CollectionUtils.isNotEmpty(responseQueryWebhookNotExsits.getErrors())) {
            responseQueryWebhookNotExsits.getErrors().forEach(e -> log.error(e.toString()));
        } else {
            Webhook queryWebhoodNotExists = responseQueryWebhookNotExsits.extractValueAsObject("data.webhook", Webhook.class);
            log.info("Webhook info should be cant get: {}", queryWebhoodNotExists.toString());
        }

    }
}
