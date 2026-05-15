// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.async.audio

import com.dedalus_sdk.api.core.ClientOptions
import com.dedalus_sdk.api.core.RequestOptions
import com.dedalus_sdk.api.core.http.HttpResponseFor
import com.dedalus_sdk.api.models.audio.transcriptions.TranscriptionCreateParams
import com.dedalus_sdk.api.models.audio.transcriptions.TranscriptionCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TranscriptionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranscriptionServiceAsync

    /**
     * Transcribe audio into text.
     *
     * Transcribes audio files using OpenAI's Whisper model. Supports multiple audio formats
     * including mp3, mp4, mpeg, mpga, m4a, wav, and webm. Maximum file size is 25 MB.
     *
     * Args: file: Audio file to transcribe (required) model: Model ID to use (e.g.,
     * "openai/whisper-1") language: ISO-639-1 language code (e.g., "en", "es") - improves accuracy
     * prompt: Optional text to guide the model's style response_format: Format of the output (json,
     * text, srt, verbose_json, vtt) temperature: Sampling temperature between 0 and 1
     *
     * Returns: Transcription object with the transcribed text
     */
    fun create(params: TranscriptionCreateParams): CompletableFuture<TranscriptionCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TranscriptionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TranscriptionCreateResponse>

    /**
     * A view of [TranscriptionServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranscriptionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/audio/transcriptions`, but is otherwise the
         * same as [TranscriptionServiceAsync.create].
         */
        fun create(
            params: TranscriptionCreateParams
        ): CompletableFuture<HttpResponseFor<TranscriptionCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: TranscriptionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TranscriptionCreateResponse>>
    }
}
