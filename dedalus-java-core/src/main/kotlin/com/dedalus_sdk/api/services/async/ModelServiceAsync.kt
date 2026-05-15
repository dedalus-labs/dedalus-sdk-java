// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.async

import com.dedalus_sdk.api.core.ClientOptions
import com.dedalus_sdk.api.core.RequestOptions
import com.dedalus_sdk.api.core.http.HttpResponseFor
import com.dedalus_sdk.api.models.models.ListModelsResponse
import com.dedalus_sdk.api.models.models.Model
import com.dedalus_sdk.api.models.models.ModelListParams
import com.dedalus_sdk.api.models.models.ModelRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ModelServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ModelServiceAsync

    /**
     * Retrieve a model.
     *
     * Retrieve detailed information about a specific model, including its capabilities, provider,
     * and supported features.
     *
     * Args: model_id: The ID of the model to retrieve (e.g., 'openai/gpt-4',
     * 'anthropic/claude-3-5-sonnet-20241022') user: Authenticated user obtained from API key
     * validation
     *
     * Returns: Model: Information about the requested model
     *
     * Raises: HTTPException:
     * - 401 if authentication fails
     * - 404 if model not found or not accessible with current API key
     * - 500 if internal error occurs
     *
     * Requires: Valid API key with 'read' scope permission
     *
     * Example:
     *
     *     ```python
     *     import dedalus_labs
     *
     *     client = dedalus_labs.Client(api_key="your-api-key")
     *     model = client.models.retrieve("openai/gpt-4")
     *
     *     print(f"Model: {model.id}")
     *     print(f"Owner: {model.owned_by}")
     *     ```
     *     Response:
     *     ```json
     *     {
     *         "id": "openai/gpt-4",
     *         "object": "model",
     *         "created": 1687882411,
     *         "owned_by": "openai"
     *     }
     *     ```
     */
    fun retrieve(modelId: String): CompletableFuture<Model> =
        retrieve(modelId, ModelRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        modelId: String,
        params: ModelRetrieveParams = ModelRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Model> =
        retrieve(params.toBuilder().modelId(modelId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        modelId: String,
        params: ModelRetrieveParams = ModelRetrieveParams.none(),
    ): CompletableFuture<Model> = retrieve(modelId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Model>

    /** @see retrieve */
    fun retrieve(params: ModelRetrieveParams): CompletableFuture<Model> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(modelId: String, requestOptions: RequestOptions): CompletableFuture<Model> =
        retrieve(modelId, ModelRetrieveParams.none(), requestOptions)

    /**
     * List available models.
     *
     * Retrieve the complete list of models available to your organization, including models from
     * OpenAI, Anthropic, Google, xAI, Mistral, Fireworks, and DeepSeek.
     *
     * Returns: ListModelsResponse: List of available models across all supported providers
     */
    fun list(): CompletableFuture<ListModelsResponse> = list(ModelListParams.none())

    /** @see list */
    fun list(
        params: ModelListParams = ModelListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ListModelsResponse>

    /** @see list */
    fun list(
        params: ModelListParams = ModelListParams.none()
    ): CompletableFuture<ListModelsResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ListModelsResponse> =
        list(ModelListParams.none(), requestOptions)

    /** A view of [ModelServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ModelServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/models/{model_id}`, but is otherwise the same as
         * [ModelServiceAsync.retrieve].
         */
        fun retrieve(modelId: String): CompletableFuture<HttpResponseFor<Model>> =
            retrieve(modelId, ModelRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            modelId: String,
            params: ModelRetrieveParams = ModelRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Model>> =
            retrieve(params.toBuilder().modelId(modelId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            modelId: String,
            params: ModelRetrieveParams = ModelRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Model>> =
            retrieve(modelId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ModelRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Model>>

        /** @see retrieve */
        fun retrieve(params: ModelRetrieveParams): CompletableFuture<HttpResponseFor<Model>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            modelId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Model>> =
            retrieve(modelId, ModelRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/models`, but is otherwise the same as
         * [ModelServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ListModelsResponse>> =
            list(ModelListParams.none())

        /** @see list */
        fun list(
            params: ModelListParams = ModelListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ListModelsResponse>>

        /** @see list */
        fun list(
            params: ModelListParams = ModelListParams.none()
        ): CompletableFuture<HttpResponseFor<ListModelsResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ListModelsResponse>> =
            list(ModelListParams.none(), requestOptions)
    }
}
