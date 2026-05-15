// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.async

import com.dedalus_sdk.api.core.ClientOptions
import com.dedalus_sdk.api.core.RequestOptions
import com.dedalus_sdk.api.core.checkRequired
import com.dedalus_sdk.api.core.handlers.errorBodyHandler
import com.dedalus_sdk.api.core.handlers.errorHandler
import com.dedalus_sdk.api.core.handlers.jsonHandler
import com.dedalus_sdk.api.core.http.HttpMethod
import com.dedalus_sdk.api.core.http.HttpRequest
import com.dedalus_sdk.api.core.http.HttpResponse
import com.dedalus_sdk.api.core.http.HttpResponse.Handler
import com.dedalus_sdk.api.core.http.HttpResponseFor
import com.dedalus_sdk.api.core.http.parseable
import com.dedalus_sdk.api.core.prepareAsync
import com.dedalus_sdk.api.models.models.ListModelsResponse
import com.dedalus_sdk.api.models.models.Model
import com.dedalus_sdk.api.models.models.ModelListParams
import com.dedalus_sdk.api.models.models.ModelRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ModelServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ModelServiceAsync {

    private val withRawResponse: ModelServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ModelServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ModelServiceAsync =
        ModelServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Model> =
        // get /v1/models/{model_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: ModelListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ListModelsResponse> =
        // get /v1/models
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ModelServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ModelServiceAsync.WithRawResponse =
            ModelServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<Model> = jsonHandler<Model>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ModelRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Model>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("modelId", params.modelId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "models", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<ListModelsResponse> =
            jsonHandler<ListModelsResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ModelListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ListModelsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "models")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
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
