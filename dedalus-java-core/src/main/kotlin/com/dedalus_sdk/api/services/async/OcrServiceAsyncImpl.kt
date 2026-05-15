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
import com.dedalus_sdk.api.models.ocr.OcrProcessParams
import com.dedalus_sdk.api.models.ocr.OcrResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class OcrServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    OcrServiceAsync {

    private val withRawResponse: OcrServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OcrServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OcrServiceAsync =
        OcrServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun process(
        params: OcrProcessParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OcrResponse> =
        // post /v1/ocr
        withRawResponse().process(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OcrServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OcrServiceAsync.WithRawResponse =
            OcrServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val processHandler: Handler<OcrResponse> =
            jsonHandler<OcrResponse>(clientOptions.jsonMapper)

        override fun process(
            params: OcrProcessParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OcrResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "ocr")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { processHandler.handle(it) }
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
