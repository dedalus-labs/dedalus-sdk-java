// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.models

import com.dedalus_sdk.api.core.JsonValue
import com.dedalus_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JsonValueInputTest {

    @Test
    fun ofString() {
        val string = "string"

        val jsonValueInput = JsonValueInput.ofString(string)

        assertThat(jsonValueInput.string()).contains(string)
        assertThat(jsonValueInput.number()).isEmpty
        assertThat(jsonValueInput.bool()).isEmpty
        assertThat(jsonValueInput.unionMember3()).isEmpty
        assertThat(jsonValueInput.inputs()).isEmpty
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val jsonValueInput = JsonValueInput.ofString("string")

        val roundtrippedJsonValueInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jsonValueInput),
                jacksonTypeRef<JsonValueInput>(),
            )

        assertThat(roundtrippedJsonValueInput).isEqualTo(jsonValueInput)
    }

    @Test
    fun ofNumber() {
        val number = 0.0

        val jsonValueInput = JsonValueInput.ofNumber(number)

        assertThat(jsonValueInput.string()).isEmpty
        assertThat(jsonValueInput.number()).contains(number)
        assertThat(jsonValueInput.bool()).isEmpty
        assertThat(jsonValueInput.unionMember3()).isEmpty
        assertThat(jsonValueInput.inputs()).isEmpty
    }

    @Test
    fun ofNumberRoundtrip() {
        val jsonMapper = jsonMapper()
        val jsonValueInput = JsonValueInput.ofNumber(0.0)

        val roundtrippedJsonValueInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jsonValueInput),
                jacksonTypeRef<JsonValueInput>(),
            )

        assertThat(roundtrippedJsonValueInput).isEqualTo(jsonValueInput)
    }

    @Test
    fun ofBool() {
        val bool = true

        val jsonValueInput = JsonValueInput.ofBool(bool)

        assertThat(jsonValueInput.string()).isEmpty
        assertThat(jsonValueInput.number()).isEmpty
        assertThat(jsonValueInput.bool()).contains(bool)
        assertThat(jsonValueInput.unionMember3()).isEmpty
        assertThat(jsonValueInput.inputs()).isEmpty
    }

    @Test
    fun ofBoolRoundtrip() {
        val jsonMapper = jsonMapper()
        val jsonValueInput = JsonValueInput.ofBool(true)

        val roundtrippedJsonValueInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jsonValueInput),
                jacksonTypeRef<JsonValueInput>(),
            )

        assertThat(roundtrippedJsonValueInput).isEqualTo(jsonValueInput)
    }

    @Test
    fun ofUnionMember3() {
        val unionMember3 =
            JsonValueInput.UnionMember3.builder()
                .putAdditionalProperty("foo", JsonValue.from("string"))
                .build()

        val jsonValueInput = JsonValueInput.ofUnionMember3(unionMember3)

        assertThat(jsonValueInput.string()).isEmpty
        assertThat(jsonValueInput.number()).isEmpty
        assertThat(jsonValueInput.bool()).isEmpty
        assertThat(jsonValueInput.unionMember3()).contains(unionMember3)
        assertThat(jsonValueInput.inputs()).isEmpty
    }

    @Test
    fun ofUnionMember3Roundtrip() {
        val jsonMapper = jsonMapper()
        val jsonValueInput =
            JsonValueInput.ofUnionMember3(
                JsonValueInput.UnionMember3.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )

        val roundtrippedJsonValueInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jsonValueInput),
                jacksonTypeRef<JsonValueInput>(),
            )

        assertThat(roundtrippedJsonValueInput).isEqualTo(jsonValueInput)
    }

    @Test
    fun ofInputs() {
        val inputs = listOf(JsonValueInput.ofString("string"))

        val jsonValueInput = JsonValueInput.ofInputs(inputs)

        assertThat(jsonValueInput.string()).isEmpty
        assertThat(jsonValueInput.number()).isEmpty
        assertThat(jsonValueInput.bool()).isEmpty
        assertThat(jsonValueInput.unionMember3()).isEmpty
        assertThat(jsonValueInput.inputs()).contains(inputs)
    }

    @Test
    fun ofInputsRoundtrip() {
        val jsonMapper = jsonMapper()
        val jsonValueInput = JsonValueInput.ofInputs(listOf(JsonValueInput.ofString("string")))

        val roundtrippedJsonValueInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jsonValueInput),
                jacksonTypeRef<JsonValueInput>(),
            )

        assertThat(roundtrippedJsonValueInput).isEqualTo(jsonValueInput)
    }
}
