// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.models.images

import com.dedalus_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateImageRequestTest {

    @Test
    fun create() {
        val createImageRequest =
            CreateImageRequest.builder()
                .prompt("A white siamese cat")
                .background(CreateImageRequest.Background.TRANSPARENT)
                .model("openai/dall-e-3")
                .moderation(CreateImageRequest.Moderation.AUTO)
                .n(1L)
                .outputCompression(85L)
                .outputFormat(CreateImageRequest.OutputFormat.PNG)
                .partialImages(0L)
                .quality(CreateImageRequest.Quality.STANDARD)
                .responseFormat(CreateImageRequest.ResponseFormat.URL)
                .size(CreateImageRequest.Size._1024X1024)
                .stream(true)
                .style(CreateImageRequest.Style.VIVID)
                .user("user")
                .build()

        assertThat(createImageRequest.prompt()).isEqualTo("A white siamese cat")
        assertThat(createImageRequest.background())
            .contains(CreateImageRequest.Background.TRANSPARENT)
        assertThat(createImageRequest.model()).contains("openai/dall-e-3")
        assertThat(createImageRequest.moderation()).contains(CreateImageRequest.Moderation.AUTO)
        assertThat(createImageRequest.n()).contains(1L)
        assertThat(createImageRequest.outputCompression()).contains(85L)
        assertThat(createImageRequest.outputFormat()).contains(CreateImageRequest.OutputFormat.PNG)
        assertThat(createImageRequest.partialImages()).contains(0L)
        assertThat(createImageRequest.quality()).contains(CreateImageRequest.Quality.STANDARD)
        assertThat(createImageRequest.responseFormat())
            .contains(CreateImageRequest.ResponseFormat.URL)
        assertThat(createImageRequest.size()).contains(CreateImageRequest.Size._1024X1024)
        assertThat(createImageRequest.stream()).contains(true)
        assertThat(createImageRequest.style()).contains(CreateImageRequest.Style.VIVID)
        assertThat(createImageRequest.user()).contains("user")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val createImageRequest =
            CreateImageRequest.builder()
                .prompt("A white siamese cat")
                .background(CreateImageRequest.Background.TRANSPARENT)
                .model("openai/dall-e-3")
                .moderation(CreateImageRequest.Moderation.AUTO)
                .n(1L)
                .outputCompression(85L)
                .outputFormat(CreateImageRequest.OutputFormat.PNG)
                .partialImages(0L)
                .quality(CreateImageRequest.Quality.STANDARD)
                .responseFormat(CreateImageRequest.ResponseFormat.URL)
                .size(CreateImageRequest.Size._1024X1024)
                .stream(true)
                .style(CreateImageRequest.Style.VIVID)
                .user("user")
                .build()

        val roundtrippedCreateImageRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(createImageRequest),
                jacksonTypeRef<CreateImageRequest>(),
            )

        assertThat(roundtrippedCreateImageRequest).isEqualTo(createImageRequest)
    }
}
