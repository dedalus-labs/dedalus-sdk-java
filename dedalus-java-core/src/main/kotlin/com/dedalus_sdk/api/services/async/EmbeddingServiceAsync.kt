// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.async

import com.dedalus_sdk.api.core.ClientOptions
import com.dedalus_sdk.api.core.RequestOptions
import com.dedalus_sdk.api.core.http.HttpResponseFor
import com.dedalus_sdk.api.models.embeddings.CreateEmbeddingRequest
import com.dedalus_sdk.api.models.embeddings.CreateEmbeddingResponse
import com.dedalus_sdk.api.models.embeddings.EmbeddingCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface EmbeddingServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EmbeddingServiceAsync

    /** Create embeddings using the configured provider. */
    fun create(params: EmbeddingCreateParams): CompletableFuture<CreateEmbeddingResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: EmbeddingCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CreateEmbeddingResponse>

    /** @see create */
    fun create(
        createEmbeddingRequest: CreateEmbeddingRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CreateEmbeddingResponse> =
        create(
            EmbeddingCreateParams.builder().createEmbeddingRequest(createEmbeddingRequest).build(),
            requestOptions,
        )

    /** @see create */
    fun create(
        createEmbeddingRequest: CreateEmbeddingRequest
    ): CompletableFuture<CreateEmbeddingResponse> =
        create(createEmbeddingRequest, RequestOptions.none())

    /**
     * A view of [EmbeddingServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EmbeddingServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/embeddings`, but is otherwise the same as
         * [EmbeddingServiceAsync.create].
         */
        fun create(
            params: EmbeddingCreateParams
        ): CompletableFuture<HttpResponseFor<CreateEmbeddingResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: EmbeddingCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CreateEmbeddingResponse>>

        /** @see create */
        fun create(
            createEmbeddingRequest: CreateEmbeddingRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CreateEmbeddingResponse>> =
            create(
                EmbeddingCreateParams.builder()
                    .createEmbeddingRequest(createEmbeddingRequest)
                    .build(),
                requestOptions,
            )

        /** @see create */
        fun create(
            createEmbeddingRequest: CreateEmbeddingRequest
        ): CompletableFuture<HttpResponseFor<CreateEmbeddingResponse>> =
            create(createEmbeddingRequest, RequestOptions.none())
    }
}
