// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.async

import com.dedalus_sdk.api.core.ClientOptions
import com.dedalus_sdk.api.core.RequestOptions
import com.dedalus_sdk.api.core.http.HttpResponseFor
import com.dedalus_sdk.api.models.ocr.OcrProcessParams
import com.dedalus_sdk.api.models.ocr.OcrRequest
import com.dedalus_sdk.api.models.ocr.OcrResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface OcrServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OcrServiceAsync

    /**
     * Process a document through Mistral OCR.
     *
     * Extracts text from PDFs and images, returning markdown-formatted content.
     */
    fun process(params: OcrProcessParams): CompletableFuture<OcrResponse> =
        process(params, RequestOptions.none())

    /** @see process */
    fun process(
        params: OcrProcessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OcrResponse>

    /** @see process */
    fun process(
        ocrRequest: OcrRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OcrResponse> =
        process(OcrProcessParams.builder().ocrRequest(ocrRequest).build(), requestOptions)

    /** @see process */
    fun process(ocrRequest: OcrRequest): CompletableFuture<OcrResponse> =
        process(ocrRequest, RequestOptions.none())

    /** A view of [OcrServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): OcrServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/ocr`, but is otherwise the same as
         * [OcrServiceAsync.process].
         */
        fun process(params: OcrProcessParams): CompletableFuture<HttpResponseFor<OcrResponse>> =
            process(params, RequestOptions.none())

        /** @see process */
        fun process(
            params: OcrProcessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OcrResponse>>

        /** @see process */
        fun process(
            ocrRequest: OcrRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OcrResponse>> =
            process(OcrProcessParams.builder().ocrRequest(ocrRequest).build(), requestOptions)

        /** @see process */
        fun process(ocrRequest: OcrRequest): CompletableFuture<HttpResponseFor<OcrResponse>> =
            process(ocrRequest, RequestOptions.none())
    }
}
