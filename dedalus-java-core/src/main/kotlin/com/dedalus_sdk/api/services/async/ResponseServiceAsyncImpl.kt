// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.async

import com.dedalus_sdk.api.core.ClientOptions
import com.dedalus_sdk.api.core.RequestOptions
import com.dedalus_sdk.api.core.handlers.errorBodyHandler
import com.dedalus_sdk.api.core.handlers.errorHandler
import com.dedalus_sdk.api.core.handlers.jsonHandler
import com.dedalus_sdk.api.core.http.HttpMethod
import com.dedalus_sdk.api.core.http.HttpRequest
import com.dedalus_sdk.api.core.http.HttpResponse
import com.dedalus_sdk.api.core.http.HttpResponse.Handler
import com.dedalus_sdk.api.core.http.HttpResponseFor
import com.dedalus_sdk.api.core.http.json
import com.dedalus_sdk.api.core.http.parseable
import com.dedalus_sdk.api.core.prepareAsync
import com.dedalus_sdk.api.models.responses.Response
import com.dedalus_sdk.api.models.responses.ResponseCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ResponseServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ResponseServiceAsync {

    private val withRawResponse: ResponseServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ResponseServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ResponseServiceAsync =
        ResponseServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ResponseCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Response> =
        // post /v1/responses
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ResponseServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ResponseServiceAsync.WithRawResponse =
            ResponseServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Response> =
            jsonHandler<Response>(clientOptions.jsonMapper)

        override fun create(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Response>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "responses")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
