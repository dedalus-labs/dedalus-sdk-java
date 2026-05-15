// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.models

import com.dedalus_sdk.api.core.BaseDeserializer
import com.dedalus_sdk.api.core.BaseSerializer
import com.dedalus_sdk.api.core.ExcludeMissing
import com.dedalus_sdk.api.core.JsonValue
import com.dedalus_sdk.api.core.allMaxBy
import com.dedalus_sdk.api.core.getOrThrow
import com.dedalus_sdk.api.core.toImmutable
import com.dedalus_sdk.api.errors.DedalusInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Objects
import java.util.Optional

@JsonDeserialize(using = JsonValueInput.Deserializer::class)
@JsonSerialize(using = JsonValueInput.Serializer::class)
class JsonValueInput
private constructor(
    private val string: String? = null,
    private val number: Double? = null,
    private val bool: Boolean? = null,
    private val unionMember3: UnionMember3? = null,
    private val inputs: List<JsonValueInput?>? = null,
    private val _json: JsonValue? = null,
) {

    fun string(): Optional<String> = Optional.ofNullable(string)

    fun number(): Optional<Double> = Optional.ofNullable(number)

    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

    fun unionMember3(): Optional<UnionMember3> = Optional.ofNullable(unionMember3)

    fun inputs(): Optional<List<JsonValueInput?>> = Optional.ofNullable(inputs)

    fun isString(): Boolean = string != null

    fun isNumber(): Boolean = number != null

    fun isBool(): Boolean = bool != null

    fun isUnionMember3(): Boolean = unionMember3 != null

    fun isInputs(): Boolean = inputs != null

    fun asString(): String = string.getOrThrow("string")

    fun asNumber(): Double = number.getOrThrow("number")

    fun asBool(): Boolean = bool.getOrThrow("bool")

    fun asUnionMember3(): UnionMember3 = unionMember3.getOrThrow("unionMember3")

    fun asInputs(): List<JsonValueInput?> = inputs.getOrThrow("inputs")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.dedalus_sdk.api.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = jsonValueInput.accept(new JsonValueInput.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitString(String string) {
     *         return Optional.of(string.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws DedalusInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            string != null -> visitor.visitString(string)
            number != null -> visitor.visitNumber(number)
            bool != null -> visitor.visitBool(bool)
            unionMember3 != null -> visitor.visitUnionMember3(unionMember3)
            inputs != null -> visitor.visitInputs(inputs)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws DedalusInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): JsonValueInput = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitNumber(number: Double) {}

                override fun visitBool(bool: Boolean) {}

                override fun visitUnionMember3(unionMember3: UnionMember3) {
                    unionMember3.validate()
                }

                override fun visitInputs(inputs: List<JsonValueInput?>) {
                    inputs.forEach { it?.validate() }
                }
            }
        )
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: DedalusInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitString(string: String) = 1

                override fun visitNumber(number: Double) = 1

                override fun visitBool(bool: Boolean) = 1

                override fun visitUnionMember3(unionMember3: UnionMember3) = unionMember3.validity()

                override fun visitInputs(inputs: List<JsonValueInput?>) =
                    inputs.sumOf { (it?.validity() ?: 0).toInt() }

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is JsonValueInput &&
            string == other.string &&
            number == other.number &&
            bool == other.bool &&
            unionMember3 == other.unionMember3 &&
            inputs == other.inputs
    }

    override fun hashCode(): Int = Objects.hash(string, number, bool, unionMember3, inputs)

    override fun toString(): String =
        when {
            string != null -> "JsonValueInput{string=$string}"
            number != null -> "JsonValueInput{number=$number}"
            bool != null -> "JsonValueInput{bool=$bool}"
            unionMember3 != null -> "JsonValueInput{unionMember3=$unionMember3}"
            inputs != null -> "JsonValueInput{inputs=$inputs}"
            _json != null -> "JsonValueInput{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid JsonValueInput")
        }

    companion object {

        @JvmStatic fun ofString(string: String) = JsonValueInput(string = string)

        @JvmStatic fun ofNumber(number: Double) = JsonValueInput(number = number)

        @JvmStatic fun ofBool(bool: Boolean) = JsonValueInput(bool = bool)

        @JvmStatic
        fun ofUnionMember3(unionMember3: UnionMember3) = JsonValueInput(unionMember3 = unionMember3)

        @JvmStatic
        fun ofInputs(inputs: List<JsonValueInput?>) = JsonValueInput(inputs = inputs.toImmutable())
    }

    /**
     * An interface that defines how to map each variant of [JsonValueInput] to a value of type [T].
     */
    interface Visitor<out T> {

        fun visitString(string: String): T

        fun visitNumber(number: Double): T

        fun visitBool(bool: Boolean): T

        fun visitUnionMember3(unionMember3: UnionMember3): T

        fun visitInputs(inputs: List<JsonValueInput?>): T

        /**
         * Maps an unknown variant of [JsonValueInput] to a value of type [T].
         *
         * An instance of [JsonValueInput] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws DedalusInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw DedalusInvalidDataException("Unknown JsonValueInput: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<JsonValueInput>(JsonValueInput::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): JsonValueInput {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<UnionMember3>())?.let {
                            JsonValueInput(unionMember3 = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            JsonValueInput(string = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                            JsonValueInput(number = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                            JsonValueInput(bool = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<JsonValueInput?>>())?.let {
                            JsonValueInput(inputs = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants.
                0 -> JsonValueInput(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<JsonValueInput>(JsonValueInput::class) {

        override fun serialize(
            value: JsonValueInput,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.number != null -> generator.writeObject(value.number)
                value.bool != null -> generator.writeObject(value.bool)
                value.unionMember3 != null -> generator.writeObject(value.unionMember3)
                value.inputs != null -> generator.writeObject(value.inputs)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid JsonValueInput")
            }
        }
    }

    class UnionMember3
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [UnionMember3]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UnionMember3]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(unionMember3: UnionMember3) = apply {
                additionalProperties = unionMember3.additionalProperties.toMutableMap()
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [UnionMember3].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): UnionMember3 = UnionMember3(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws DedalusInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): UnionMember3 = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: DedalusInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UnionMember3 && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "UnionMember3{additionalProperties=$additionalProperties}"
    }
}
