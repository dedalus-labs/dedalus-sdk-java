// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.blocking

import com.dedalus_sdk.api.core.ClientOptions
import com.dedalus_sdk.api.core.RequestOptions
import com.dedalus_sdk.api.core.http.HttpResponseFor
import com.dedalus_sdk.api.models.embeddings.CreateEmbeddingRequest
import com.dedalus_sdk.api.models.embeddings.CreateEmbeddingResponse
import com.dedalus_sdk.api.models.embeddings.EmbeddingCreateParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface EmbeddingService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EmbeddingService

    /** Create embeddings using the configured provider. */
    fun create(params: EmbeddingCreateParams): CreateEmbeddingResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: EmbeddingCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CreateEmbeddingResponse

    /** @see create */
    fun create(
        createEmbeddingRequest: CreateEmbeddingRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CreateEmbeddingResponse =
        create(
            EmbeddingCreateParams.builder().createEmbeddingRequest(createEmbeddingRequest).build(),
            requestOptions,
        )

    /** @see create */
    fun create(createEmbeddingRequest: CreateEmbeddingRequest): CreateEmbeddingResponse =
        create(createEmbeddingRequest, RequestOptions.none())

    /** A view of [EmbeddingService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EmbeddingService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/embeddings`, but is otherwise the same as
         * [EmbeddingService.create].
         */
        @MustBeClosed
        fun create(params: EmbeddingCreateParams): HttpResponseFor<CreateEmbeddingResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: EmbeddingCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CreateEmbeddingResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            createEmbeddingRequest: CreateEmbeddingRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CreateEmbeddingResponse> =
            create(
                EmbeddingCreateParams.builder()
                    .createEmbeddingRequest(createEmbeddingRequest)
                    .build(),
                requestOptions,
            )

        /** @see create */
        @MustBeClosed
        fun create(
            createEmbeddingRequest: CreateEmbeddingRequest
        ): HttpResponseFor<CreateEmbeddingResponse> =
            create(createEmbeddingRequest, RequestOptions.none())
    }
}
