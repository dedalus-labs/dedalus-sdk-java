// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.async.chat

import com.dedalus_sdk.api.core.ClientOptions
import com.dedalus_sdk.api.core.JsonValue
import com.dedalus_sdk.api.core.RequestOptions
import com.dedalus_sdk.api.core.handlers.errorBodyHandler
import com.dedalus_sdk.api.core.handlers.errorHandler
import com.dedalus_sdk.api.core.handlers.jsonHandler
import com.dedalus_sdk.api.core.handlers.mapJson
import com.dedalus_sdk.api.core.handlers.sseHandler
import com.dedalus_sdk.api.core.http.AsyncStreamResponse
import com.dedalus_sdk.api.core.http.HttpMethod
import com.dedalus_sdk.api.core.http.HttpRequest
import com.dedalus_sdk.api.core.http.HttpResponse
import com.dedalus_sdk.api.core.http.HttpResponse.Handler
import com.dedalus_sdk.api.core.http.HttpResponseFor
import com.dedalus_sdk.api.core.http.StreamResponse
import com.dedalus_sdk.api.core.http.json
import com.dedalus_sdk.api.core.http.map
import com.dedalus_sdk.api.core.http.parseable
import com.dedalus_sdk.api.core.http.toAsync
import com.dedalus_sdk.api.core.prepareAsync
import com.dedalus_sdk.api.models.chat.completions.ChatCompletion
import com.dedalus_sdk.api.models.chat.completions.ChatCompletionChunk
import com.dedalus_sdk.api.models.chat.completions.CompletionCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class CompletionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CompletionServiceAsync {

    private val withRawResponse: CompletionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CompletionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CompletionServiceAsync =
        CompletionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: CompletionCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChatCompletion> =
        // post /v1/chat/completions
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun createStreaming(
        params: CompletionCreateParams,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<ChatCompletionChunk> =
        // post /v1/chat/completions
        withRawResponse()
            .createStreaming(params, requestOptions)
            .thenApply { it.parse() }
            .toAsync(clientOptions.streamHandlerExecutor)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CompletionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CompletionServiceAsync.WithRawResponse =
            CompletionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ChatCompletion> =
            jsonHandler<ChatCompletion>(clientOptions.jsonMapper)

        override fun create(
            params: CompletionCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "chat", "completions")
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

        private val createStreamingHandler: Handler<StreamResponse<ChatCompletionChunk>> =
            sseHandler(clientOptions.jsonMapper).mapJson<ChatCompletionChunk>()

        override fun createStreaming(
            params: CompletionCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<ChatCompletionChunk>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "chat", "completions")
                    .putHeader("Accept", "text/event-stream")
                    .body(
                        json(
                            clientOptions.jsonMapper,
                            params
                                ._body()
                                .toBuilder()
                                .putAdditionalProperty("stream", JsonValue.from(true))
                                .build(),
                        )
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .let { createStreamingHandler.handle(it) }
                            .let { streamResponse ->
                                if (requestOptions.responseValidation!!) {
                                    streamResponse.map { it.validate() }
                                } else {
                                    streamResponse
                                }
                            }
                    }
                }
        }
    }
}
