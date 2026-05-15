// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.models

import com.dedalus_sdk.api.core.Enum
import com.dedalus_sdk.api.core.ExcludeMissing
import com.dedalus_sdk.api.core.JsonField
import com.dedalus_sdk.api.core.JsonMissing
import com.dedalus_sdk.api.core.JsonValue
import com.dedalus_sdk.api.errors.DedalusInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * **gpt-5 and o-series models only**
 *
 * Configuration options for [reasoning models](https://platform.openai.com/docs/guides/reasoning).
 */
class Reasoning
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val effort: JsonField<Effort>,
    private val generateSummary: JsonField<GenerateSummary>,
    private val summary: JsonField<Summary>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("effort") @ExcludeMissing effort: JsonField<Effort> = JsonMissing.of(),
        @JsonProperty("generate_summary")
        @ExcludeMissing
        generateSummary: JsonField<GenerateSummary> = JsonMissing.of(),
        @JsonProperty("summary") @ExcludeMissing summary: JsonField<Summary> = JsonMissing.of(),
    ) : this(effort, generateSummary, summary, mutableMapOf())

    /**
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun effort(): Optional<Effort> = effort.getOptional("effort")

    /**
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun generateSummary(): Optional<GenerateSummary> =
        generateSummary.getOptional("generate_summary")

    /**
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun summary(): Optional<Summary> = summary.getOptional("summary")

    /**
     * Returns the raw JSON value of [effort].
     *
     * Unlike [effort], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("effort") @ExcludeMissing fun _effort(): JsonField<Effort> = effort

    /**
     * Returns the raw JSON value of [generateSummary].
     *
     * Unlike [generateSummary], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("generate_summary")
    @ExcludeMissing
    fun _generateSummary(): JsonField<GenerateSummary> = generateSummary

    /**
     * Returns the raw JSON value of [summary].
     *
     * Unlike [summary], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<Summary> = summary

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [Reasoning]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Reasoning]. */
    class Builder internal constructor() {

        private var effort: JsonField<Effort> = JsonMissing.of()
        private var generateSummary: JsonField<GenerateSummary> = JsonMissing.of()
        private var summary: JsonField<Summary> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(reasoning: Reasoning) = apply {
            effort = reasoning.effort
            generateSummary = reasoning.generateSummary
            summary = reasoning.summary
            additionalProperties = reasoning.additionalProperties.toMutableMap()
        }

        fun effort(effort: Effort?) = effort(JsonField.ofNullable(effort))

        /** Alias for calling [Builder.effort] with `effort.orElse(null)`. */
        fun effort(effort: Optional<Effort>) = effort(effort.getOrNull())

        /**
         * Sets [Builder.effort] to an arbitrary JSON value.
         *
         * You should usually call [Builder.effort] with a well-typed [Effort] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun effort(effort: JsonField<Effort>) = apply { this.effort = effort }

        fun generateSummary(generateSummary: GenerateSummary?) =
            generateSummary(JsonField.ofNullable(generateSummary))

        /** Alias for calling [Builder.generateSummary] with `generateSummary.orElse(null)`. */
        fun generateSummary(generateSummary: Optional<GenerateSummary>) =
            generateSummary(generateSummary.getOrNull())

        /**
         * Sets [Builder.generateSummary] to an arbitrary JSON value.
         *
         * You should usually call [Builder.generateSummary] with a well-typed [GenerateSummary]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun generateSummary(generateSummary: JsonField<GenerateSummary>) = apply {
            this.generateSummary = generateSummary
        }

        fun summary(summary: Summary?) = summary(JsonField.ofNullable(summary))

        /** Alias for calling [Builder.summary] with `summary.orElse(null)`. */
        fun summary(summary: Optional<Summary>) = summary(summary.getOrNull())

        /**
         * Sets [Builder.summary] to an arbitrary JSON value.
         *
         * You should usually call [Builder.summary] with a well-typed [Summary] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun summary(summary: JsonField<Summary>) = apply { this.summary = summary }

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
         * Returns an immutable instance of [Reasoning].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Reasoning =
            Reasoning(effort, generateSummary, summary, additionalProperties.toMutableMap())
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
    fun validate(): Reasoning = apply {
        if (validated) {
            return@apply
        }

        effort().ifPresent { it.validate() }
        generateSummary().ifPresent { it.validate() }
        summary().ifPresent { it.validate() }
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
        (effort.asKnown().getOrNull()?.validity() ?: 0) +
            (generateSummary.asKnown().getOrNull()?.validity() ?: 0) +
            (summary.asKnown().getOrNull()?.validity() ?: 0)

    class Effort @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val NONE = of("none")

            @JvmField val MINIMAL = of("minimal")

            @JvmField val LOW = of("low")

            @JvmField val MEDIUM = of("medium")

            @JvmField val HIGH = of("high")

            @JvmField val XHIGH = of("xhigh")

            @JvmStatic fun of(value: String) = Effort(JsonField.of(value))
        }

        /** An enum containing [Effort]'s known values. */
        enum class Known {
            NONE,
            MINIMAL,
            LOW,
            MEDIUM,
            HIGH,
            XHIGH,
        }

        /**
         * An enum containing [Effort]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Effort] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            NONE,
            MINIMAL,
            LOW,
            MEDIUM,
            HIGH,
            XHIGH,
            /** An enum member indicating that [Effort] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                NONE -> Value.NONE
                MINIMAL -> Value.MINIMAL
                LOW -> Value.LOW
                MEDIUM -> Value.MEDIUM
                HIGH -> Value.HIGH
                XHIGH -> Value.XHIGH
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws DedalusInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                NONE -> Known.NONE
                MINIMAL -> Known.MINIMAL
                LOW -> Known.LOW
                MEDIUM -> Known.MEDIUM
                HIGH -> Known.HIGH
                XHIGH -> Known.XHIGH
                else -> throw DedalusInvalidDataException("Unknown Effort: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws DedalusInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { DedalusInvalidDataException("Value is not a String") }

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
        fun validate(): Effort = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Effort && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class GenerateSummary @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AUTO = of("auto")

            @JvmField val CONCISE = of("concise")

            @JvmField val DETAILED = of("detailed")

            @JvmStatic fun of(value: String) = GenerateSummary(JsonField.of(value))
        }

        /** An enum containing [GenerateSummary]'s known values. */
        enum class Known {
            AUTO,
            CONCISE,
            DETAILED,
        }

        /**
         * An enum containing [GenerateSummary]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [GenerateSummary] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AUTO,
            CONCISE,
            DETAILED,
            /**
             * An enum member indicating that [GenerateSummary] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                AUTO -> Value.AUTO
                CONCISE -> Value.CONCISE
                DETAILED -> Value.DETAILED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws DedalusInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                AUTO -> Known.AUTO
                CONCISE -> Known.CONCISE
                DETAILED -> Known.DETAILED
                else -> throw DedalusInvalidDataException("Unknown GenerateSummary: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws DedalusInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { DedalusInvalidDataException("Value is not a String") }

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
        fun validate(): GenerateSummary = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is GenerateSummary && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Summary @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AUTO = of("auto")

            @JvmField val CONCISE = of("concise")

            @JvmField val DETAILED = of("detailed")

            @JvmStatic fun of(value: String) = Summary(JsonField.of(value))
        }

        /** An enum containing [Summary]'s known values. */
        enum class Known {
            AUTO,
            CONCISE,
            DETAILED,
        }

        /**
         * An enum containing [Summary]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Summary] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AUTO,
            CONCISE,
            DETAILED,
            /** An enum member indicating that [Summary] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                AUTO -> Value.AUTO
                CONCISE -> Value.CONCISE
                DETAILED -> Value.DETAILED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws DedalusInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                AUTO -> Known.AUTO
                CONCISE -> Known.CONCISE
                DETAILED -> Known.DETAILED
                else -> throw DedalusInvalidDataException("Unknown Summary: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws DedalusInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { DedalusInvalidDataException("Value is not a String") }

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
        fun validate(): Summary = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Summary && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Reasoning &&
            effort == other.effort &&
            generateSummary == other.generateSummary &&
            summary == other.summary &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(effort, generateSummary, summary, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Reasoning{effort=$effort, generateSummary=$generateSummary, summary=$summary, additionalProperties=$additionalProperties}"
}
