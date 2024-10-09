package com.sample.api.mercari.scalars;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsRuntimeWiring;

import graphql.scalars.ExtendedScalars;
import graphql.schema.idl.RuntimeWiring;

@DgsComponent
public class MercariRuntimeWiringConfig {
    @DgsRuntimeWiring
    public RuntimeWiring.Builder addScalar(final RuntimeWiring.Builder builder) {
        return builder
            .scalar(ExtendedScalars.DateTime)
            .scalar(ExtendedScalars.Date)
            .scalar(ExtendedScalars.GraphQLBigDecimal);
    }
}
