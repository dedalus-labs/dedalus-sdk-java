// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.async

import com.dedalus_sdk.api.core.ClientOptions
import com.dedalus_sdk.api.core.RequestOptions
import com.dedalus_sdk.api.core.http.HttpResponseFor
import com.dedalus_sdk.api.models.responses.Response
import com.dedalus_sdk.api.models.responses.ResponseCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ResponseServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ResponseServiceAsync

    /**
     * Create a response using the OpenAI Responses API.
     *
     * This endpoint routes directly to OpenAI's Responses API. Only OpenAI models are supported.
     */
    fun create(params: ResponseCreateParams): CompletableFuture<Response> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ResponseCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Response>

    /** @see create */
    fun create(
        responseCreateParams: ResponseCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Response> =
        create(
            ResponseCreateParams.builder().responseCreateParams(responseCreateParams).build(),
            requestOptions,
        )

    /** @see create */
    fun create(responseCreateParams: ResponseCreateParams): CompletableFuture<Response> =
        create(responseCreateParams, RequestOptions.none())

    /**
     * A view of [ResponseServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ResponseServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/responses`, but is otherwise the same as
         * [ResponseServiceAsync.create].
         */
        fun create(params: ResponseCreateParams): CompletableFuture<HttpResponseFor<Response>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ResponseCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Response>>

        /** @see create */
        fun create(
            responseCreateParams: ResponseCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Response>> =
            create(
                ResponseCreateParams.builder().responseCreateParams(responseCreateParams).build(),
                requestOptions,
            )

        /** @see create */
        fun create(
            responseCreateParams: ResponseCreateParams
        ): CompletableFuture<HttpResponseFor<Response>> =
            create(responseCreateParams, RequestOptions.none())
    }
}
