// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.models.chat.completions

import com.dedalus_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChoiceDeltaTest {

    @Test
    fun create() {
        val choiceDelta =
            ChoiceDelta.builder()
                .content("content")
                .functionCall(
                    ChoiceDelta.FunctionCall.builder().arguments("arguments").name("name").build()
                )
                .refusal("refusal")
                .role(ChoiceDelta.Role.DEVELOPER)
                .addToolCall(
                    ChoiceDeltaToolCall.builder()
                        .index(0L)
                        .id("id")
                        .function(
                            ChoiceDeltaToolCall.Function.builder()
                                .arguments("arguments")
                                .name("name")
                                .build()
                        )
                        .type(ChoiceDeltaToolCall.Type.FUNCTION)
                        .build()
                )
                .build()

        assertThat(choiceDelta.content()).contains("content")
        assertThat(choiceDelta.functionCall())
            .contains(
                ChoiceDelta.FunctionCall.builder().arguments("arguments").name("name").build()
            )
        assertThat(choiceDelta.refusal()).contains("refusal")
        assertThat(choiceDelta.role()).contains(ChoiceDelta.Role.DEVELOPER)
        assertThat(choiceDelta.toolCalls().getOrNull())
            .containsExactly(
                ChoiceDeltaToolCall.builder()
                    .index(0L)
                    .id("id")
                    .function(
                        ChoiceDeltaToolCall.Function.builder()
                            .arguments("arguments")
                            .name("name")
                            .build()
                    )
                    .type(ChoiceDeltaToolCall.Type.FUNCTION)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val choiceDelta =
            ChoiceDelta.builder()
                .content("content")
                .functionCall(
                    ChoiceDelta.FunctionCall.builder().arguments("arguments").name("name").build()
                )
                .refusal("refusal")
                .role(ChoiceDelta.Role.DEVELOPER)
                .addToolCall(
                    ChoiceDeltaToolCall.builder()
                        .index(0L)
                        .id("id")
                        .function(
                            ChoiceDeltaToolCall.Function.builder()
                                .arguments("arguments")
                                .name("name")
                                .build()
                        )
                        .type(ChoiceDeltaToolCall.Type.FUNCTION)
                        .build()
                )
                .build()

        val roundtrippedChoiceDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(choiceDelta),
                jacksonTypeRef<ChoiceDelta>(),
            )

        assertThat(roundtrippedChoiceDelta).isEqualTo(choiceDelta)
    }
}
