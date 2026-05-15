// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.async

import com.dedalus_sdk.api.client.okhttp.DedalusOkHttpClientAsync
import com.dedalus_sdk.api.models.embeddings.CreateEmbeddingRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EmbeddingServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = DedalusOkHttpClientAsync.builder().apiKey("My API Key").build()
        val embeddingServiceAsync = client.embeddings()

        val createEmbeddingResponseFuture =
            embeddingServiceAsync.create(
                CreateEmbeddingRequest.builder()
                    .input("string")
                    .model(CreateEmbeddingRequest.Model.TEXT_EMBEDDING_ADA_002)
                    .dimensions(1L)
                    .encodingFormat(CreateEmbeddingRequest.EncodingFormat.FLOAT)
                    .user("user")
                    .build()
            )

        val createEmbeddingResponse = createEmbeddingResponseFuture.get()
        createEmbeddingResponse.validate()
    }
}
