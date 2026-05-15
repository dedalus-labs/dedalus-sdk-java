// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.models.chat.completions

import com.dedalus_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompletionTokensDetailsTest {

    @Test
    fun create() {
        val completionTokensDetails =
            CompletionTokensDetails.builder()
                .acceptedPredictionTokens(0L)
                .audioTokens(0L)
                .reasoningTokens(0L)
                .rejectedPredictionTokens(0L)
                .build()

        assertThat(completionTokensDetails.acceptedPredictionTokens()).contains(0L)
        assertThat(completionTokensDetails.audioTokens()).contains(0L)
        assertThat(completionTokensDetails.reasoningTokens()).contains(0L)
        assertThat(completionTokensDetails.rejectedPredictionTokens()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val completionTokensDetails =
            CompletionTokensDetails.builder()
                .acceptedPredictionTokens(0L)
                .audioTokens(0L)
                .reasoningTokens(0L)
                .rejectedPredictionTokens(0L)
                .build()

        val roundtrippedCompletionTokensDetails =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(completionTokensDetails),
                jacksonTypeRef<CompletionTokensDetails>(),
            )

        assertThat(roundtrippedCompletionTokensDetails).isEqualTo(completionTokensDetails)
    }
}
