// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.async.audio

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
import com.dedalus_sdk.api.core.http.multipartFormData
import com.dedalus_sdk.api.core.http.parseable
import com.dedalus_sdk.api.core.prepareAsync
import com.dedalus_sdk.api.models.audio.transcriptions.TranscriptionCreateParams
import com.dedalus_sdk.api.models.audio.transcriptions.TranscriptionCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class TranscriptionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TranscriptionServiceAsync {

    private val withRawResponse: TranscriptionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TranscriptionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranscriptionServiceAsync =
        TranscriptionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: TranscriptionCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TranscriptionCreateResponse> =
        // post /v1/audio/transcriptions
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TranscriptionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranscriptionServiceAsync.WithRawResponse =
            TranscriptionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<TranscriptionCreateResponse> =
            jsonHandler<TranscriptionCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: TranscriptionCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TranscriptionCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "audio", "transcriptions")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
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
