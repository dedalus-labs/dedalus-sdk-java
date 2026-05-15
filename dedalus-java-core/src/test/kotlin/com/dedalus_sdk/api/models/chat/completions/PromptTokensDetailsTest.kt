// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.models.chat.completions

import com.dedalus_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PromptTokensDetailsTest {

    @Test
    fun create() {
        val promptTokensDetails =
            PromptTokensDetails.builder().audioTokens(0L).cachedTokens(0L).build()

        assertThat(promptTokensDetails.audioTokens()).contains(0L)
        assertThat(promptTokensDetails.cachedTokens()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val promptTokensDetails =
            PromptTokensDetails.builder().audioTokens(0L).cachedTokens(0L).build()

        val roundtrippedPromptTokensDetails =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(promptTokensDetails),
                jacksonTypeRef<PromptTokensDetails>(),
            )

        assertThat(roundtrippedPromptTokensDetails).isEqualTo(promptTokensDetails)
    }
}
