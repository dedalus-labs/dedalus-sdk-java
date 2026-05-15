// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.models.models

import com.dedalus_sdk.api.core.Enum
import com.dedalus_sdk.api.core.ExcludeMissing
import com.dedalus_sdk.api.core.JsonField
import com.dedalus_sdk.api.core.JsonMissing
import com.dedalus_sdk.api.core.JsonValue
import com.dedalus_sdk.api.core.checkKnown
import com.dedalus_sdk.api.core.checkRequired
import com.dedalus_sdk.api.core.toImmutable
import com.dedalus_sdk.api.errors.DedalusInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Unified model metadata across all providers.
 *
 * Combines provider-specific schemas into a single, consistent format. Fields that aren't available
 * from a provider are set to None.
 */
class Model
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val provider: JsonField<Provider>,
    private val capabilities: JsonField<Capabilities>,
    private val defaults: JsonField<Defaults>,
    private val description: JsonField<String>,
    private val displayName: JsonField<String>,
    private val providerDeclaredGenerationMethods: JsonField<List<String>>,
    private val providerInfo: JsonField<ProviderInfo>,
    private val version: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("provider") @ExcludeMissing provider: JsonField<Provider> = JsonMissing.of(),
        @JsonProperty("capabilities")
        @ExcludeMissing
        capabilities: JsonField<Capabilities> = JsonMissing.of(),
        @JsonProperty("defaults") @ExcludeMissing defaults: JsonField<Defaults> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("display_name")
        @ExcludeMissing
        displayName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("provider_declared_generation_methods")
        @ExcludeMissing
        providerDeclaredGenerationMethods: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("provider_info")
        @ExcludeMissing
        providerInfo: JsonField<ProviderInfo> = JsonMissing.of(),
        @JsonProperty("version") @ExcludeMissing version: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        provider,
        capabilities,
        defaults,
        description,
        displayName,
        providerDeclaredGenerationMethods,
        providerInfo,
        version,
        mutableMapOf(),
    )

    /**
     * Unique model identifier with provider prefix (e.g., 'openai/gpt-4')
     *
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * When the model was released (RFC 3339)
     *
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

    /**
     * Provider that hosts this model
     *
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun provider(): Provider = provider.getRequired("provider")

    /**
     * Normalized model capabilities across all providers.
     *
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun capabilities(): Optional<Capabilities> = capabilities.getOptional("capabilities")

    /**
     * Provider-declared default parameters for model generation.
     *
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun defaults(): Optional<Defaults> = defaults.getOptional("defaults")

    /**
     * Model description
     *
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * Human-readable model name
     *
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun displayName(): Optional<String> = displayName.getOptional("display_name")

    /**
     * Provider-specific generation method names (None = not declared)
     *
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun providerDeclaredGenerationMethods(): Optional<List<String>> =
        providerDeclaredGenerationMethods.getOptional("provider_declared_generation_methods")

    /**
     * Raw provider-specific metadata
     *
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun providerInfo(): Optional<ProviderInfo> = providerInfo.getOptional("provider_info")

    /**
     * Model version identifier
     *
     * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun version(): Optional<String> = version.getOptional("version")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [provider].
     *
     * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("provider") @ExcludeMissing fun _provider(): JsonField<Provider> = provider

    /**
     * Returns the raw JSON value of [capabilities].
     *
     * Unlike [capabilities], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("capabilities")
    @ExcludeMissing
    fun _capabilities(): JsonField<Capabilities> = capabilities

    /**
     * Returns the raw JSON value of [defaults].
     *
     * Unlike [defaults], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("defaults") @ExcludeMissing fun _defaults(): JsonField<Defaults> = defaults

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [displayName].
     *
     * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("display_name")
    @ExcludeMissing
    fun _displayName(): JsonField<String> = displayName

    /**
     * Returns the raw JSON value of [providerDeclaredGenerationMethods].
     *
     * Unlike [providerDeclaredGenerationMethods], this method doesn't throw if the JSON field has
     * an unexpected type.
     */
    @JsonProperty("provider_declared_generation_methods")
    @ExcludeMissing
    fun _providerDeclaredGenerationMethods(): JsonField<List<String>> =
        providerDeclaredGenerationMethods

    /**
     * Returns the raw JSON value of [providerInfo].
     *
     * Unlike [providerInfo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("provider_info")
    @ExcludeMissing
    fun _providerInfo(): JsonField<ProviderInfo> = providerInfo

    /**
     * Returns the raw JSON value of [version].
     *
     * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

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

        /**
         * Returns a mutable builder for constructing an instance of [Model].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .provider()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Model]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var provider: JsonField<Provider>? = null
        private var capabilities: JsonField<Capabilities> = JsonMissing.of()
        private var defaults: JsonField<Defaults> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var displayName: JsonField<String> = JsonMissing.of()
        private var providerDeclaredGenerationMethods: JsonField<MutableList<String>>? = null
        private var providerInfo: JsonField<ProviderInfo> = JsonMissing.of()
        private var version: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(model: Model) = apply {
            id = model.id
            createdAt = model.createdAt
            provider = model.provider
            capabilities = model.capabilities
            defaults = model.defaults
            description = model.description
            displayName = model.displayName
            providerDeclaredGenerationMethods =
                model.providerDeclaredGenerationMethods.map { it.toMutableList() }
            providerInfo = model.providerInfo
            version = model.version
            additionalProperties = model.additionalProperties.toMutableMap()
        }

        /** Unique model identifier with provider prefix (e.g., 'openai/gpt-4') */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** When the model was released (RFC 3339) */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Provider that hosts this model */
        fun provider(provider: Provider) = provider(JsonField.of(provider))

        /**
         * Sets [Builder.provider] to an arbitrary JSON value.
         *
         * You should usually call [Builder.provider] with a well-typed [Provider] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun provider(provider: JsonField<Provider>) = apply { this.provider = provider }

        /** Normalized model capabilities across all providers. */
        fun capabilities(capabilities: Capabilities?) =
            capabilities(JsonField.ofNullable(capabilities))

        /** Alias for calling [Builder.capabilities] with `capabilities.orElse(null)`. */
        fun capabilities(capabilities: Optional<Capabilities>) =
            capabilities(capabilities.getOrNull())

        /**
         * Sets [Builder.capabilities] to an arbitrary JSON value.
         *
         * You should usually call [Builder.capabilities] with a well-typed [Capabilities] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun capabilities(capabilities: JsonField<Capabilities>) = apply {
            this.capabilities = capabilities
        }

        /** Provider-declared default parameters for model generation. */
        fun defaults(defaults: Defaults?) = defaults(JsonField.ofNullable(defaults))

        /** Alias for calling [Builder.defaults] with `defaults.orElse(null)`. */
        fun defaults(defaults: Optional<Defaults>) = defaults(defaults.getOrNull())

        /**
         * Sets [Builder.defaults] to an arbitrary JSON value.
         *
         * You should usually call [Builder.defaults] with a well-typed [Defaults] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun defaults(defaults: JsonField<Defaults>) = apply { this.defaults = defaults }

        /** Model description */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Human-readable model name */
        fun displayName(displayName: String?) = displayName(JsonField.ofNullable(displayName))

        /** Alias for calling [Builder.displayName] with `displayName.orElse(null)`. */
        fun displayName(displayName: Optional<String>) = displayName(displayName.getOrNull())

        /**
         * Sets [Builder.displayName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun displayName(displayName: JsonField<String>) = apply { this.displayName = displayName }

        /** Provider-specific generation method names (None = not declared) */
        fun providerDeclaredGenerationMethods(providerDeclaredGenerationMethods: List<String>?) =
            providerDeclaredGenerationMethods(
                JsonField.ofNullable(providerDeclaredGenerationMethods)
            )

        /**
         * Alias for calling [Builder.providerDeclaredGenerationMethods] with
         * `providerDeclaredGenerationMethods.orElse(null)`.
         */
        fun providerDeclaredGenerationMethods(
            providerDeclaredGenerationMethods: Optional<List<String>>
        ) = providerDeclaredGenerationMethods(providerDeclaredGenerationMethods.getOrNull())

        /**
         * Sets [Builder.providerDeclaredGenerationMethods] to an arbitrary JSON value.
         *
         * You should usually call [Builder.providerDeclaredGenerationMethods] with a well-typed
         * `List<String>` value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun providerDeclaredGenerationMethods(
            providerDeclaredGenerationMethods: JsonField<List<String>>
        ) = apply {
            this.providerDeclaredGenerationMethods =
                providerDeclaredGenerationMethods.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [providerDeclaredGenerationMethods].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addProviderDeclaredGenerationMethod(providerDeclaredGenerationMethod: String) = apply {
            providerDeclaredGenerationMethods =
                (providerDeclaredGenerationMethods ?: JsonField.of(mutableListOf())).also {
                    checkKnown("providerDeclaredGenerationMethods", it)
                        .add(providerDeclaredGenerationMethod)
                }
        }

        /** Raw provider-specific metadata */
        fun providerInfo(providerInfo: ProviderInfo?) =
            providerInfo(JsonField.ofNullable(providerInfo))

        /** Alias for calling [Builder.providerInfo] with `providerInfo.orElse(null)`. */
        fun providerInfo(providerInfo: Optional<ProviderInfo>) =
            providerInfo(providerInfo.getOrNull())

        /**
         * Sets [Builder.providerInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.providerInfo] with a well-typed [ProviderInfo] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun providerInfo(providerInfo: JsonField<ProviderInfo>) = apply {
            this.providerInfo = providerInfo
        }

        /** Model version identifier */
        fun version(version: String?) = version(JsonField.ofNullable(version))

        /** Alias for calling [Builder.version] with `version.orElse(null)`. */
        fun version(version: Optional<String>) = version(version.getOrNull())

        /**
         * Sets [Builder.version] to an arbitrary JSON value.
         *
         * You should usually call [Builder.version] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun version(version: JsonField<String>) = apply { this.version = version }

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
         * Returns an immutable instance of [Model].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .provider()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Model =
            Model(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("provider", provider),
                capabilities,
                defaults,
                description,
                displayName,
                (providerDeclaredGenerationMethods ?: JsonMissing.of()).map { it.toImmutable() },
                providerInfo,
                version,
                additionalProperties.toMutableMap(),
            )
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
    fun validate(): Model = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        provider().validate()
        capabilities().ifPresent { it.validate() }
        defaults().ifPresent { it.validate() }
        description()
        displayName()
        providerDeclaredGenerationMethods()
        providerInfo().ifPresent { it.validate() }
        version()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (provider.asKnown().getOrNull()?.validity() ?: 0) +
            (capabilities.asKnown().getOrNull()?.validity() ?: 0) +
            (defaults.asKnown().getOrNull()?.validity() ?: 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (displayName.asKnown().isPresent) 1 else 0) +
            (providerDeclaredGenerationMethods.asKnown().getOrNull()?.size ?: 0) +
            (providerInfo.asKnown().getOrNull()?.validity() ?: 0) +
            (if (version.asKnown().isPresent) 1 else 0)

    /** Provider that hosts this model */
    class Provider @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val OPENAI = of("openai")

            @JvmField val ANTHROPIC = of("anthropic")

            @JvmField val GOOGLE = of("google")

            @JvmField val XAI = of("xai")

            @JvmField val MISTRAL = of("mistral")

            @JvmField val GROQ = of("groq")

            @JvmField val FIREWORKS = of("fireworks")

            @JvmField val DEEPSEEK = of("deepseek")

            @JvmField val MOONSHOT = of("moonshot")

            @JvmField val CEREBRAS = of("cerebras")

            @JvmStatic fun of(value: String) = Provider(JsonField.of(value))
        }

        /** An enum containing [Provider]'s known values. */
        enum class Known {
            OPENAI,
            ANTHROPIC,
            GOOGLE,
            XAI,
            MISTRAL,
            GROQ,
            FIREWORKS,
            DEEPSEEK,
            MOONSHOT,
            CEREBRAS,
        }

        /**
         * An enum containing [Provider]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Provider] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            OPENAI,
            ANTHROPIC,
            GOOGLE,
            XAI,
            MISTRAL,
            GROQ,
            FIREWORKS,
            DEEPSEEK,
            MOONSHOT,
            CEREBRAS,
            /** An enum member indicating that [Provider] was instantiated with an unknown value. */
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
                OPENAI -> Value.OPENAI
                ANTHROPIC -> Value.ANTHROPIC
                GOOGLE -> Value.GOOGLE
                XAI -> Value.XAI
                MISTRAL -> Value.MISTRAL
                GROQ -> Value.GROQ
                FIREWORKS -> Value.FIREWORKS
                DEEPSEEK -> Value.DEEPSEEK
                MOONSHOT -> Value.MOONSHOT
                CEREBRAS -> Value.CEREBRAS
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
                OPENAI -> Known.OPENAI
                ANTHROPIC -> Known.ANTHROPIC
                GOOGLE -> Known.GOOGLE
                XAI -> Known.XAI
                MISTRAL -> Known.MISTRAL
                GROQ -> Known.GROQ
                FIREWORKS -> Known.FIREWORKS
                DEEPSEEK -> Known.DEEPSEEK
                MOONSHOT -> Known.MOONSHOT
                CEREBRAS -> Known.CEREBRAS
                else -> throw DedalusInvalidDataException("Unknown Provider: $value")
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
        fun validate(): Provider = apply {
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

            return other is Provider && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Normalized model capabilities across all providers. */
    class Capabilities
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val audio: JsonField<Boolean>,
        private val imageGeneration: JsonField<Boolean>,
        private val inputTokenLimit: JsonField<Long>,
        private val outputTokenLimit: JsonField<Long>,
        private val streaming: JsonField<Boolean>,
        private val structuredOutput: JsonField<Boolean>,
        private val text: JsonField<Boolean>,
        private val thinking: JsonField<Boolean>,
        private val tools: JsonField<Boolean>,
        private val vision: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("audio") @ExcludeMissing audio: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("image_generation")
            @ExcludeMissing
            imageGeneration: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("input_token_limit")
            @ExcludeMissing
            inputTokenLimit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("output_token_limit")
            @ExcludeMissing
            outputTokenLimit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("streaming")
            @ExcludeMissing
            streaming: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("structured_output")
            @ExcludeMissing
            structuredOutput: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("thinking")
            @ExcludeMissing
            thinking: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("tools") @ExcludeMissing tools: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("vision") @ExcludeMissing vision: JsonField<Boolean> = JsonMissing.of(),
        ) : this(
            audio,
            imageGeneration,
            inputTokenLimit,
            outputTokenLimit,
            streaming,
            structuredOutput,
            text,
            thinking,
            tools,
            vision,
            mutableMapOf(),
        )

        /**
         * Supports audio processing
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun audio(): Optional<Boolean> = audio.getOptional("audio")

        /**
         * Supports image generation
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun imageGeneration(): Optional<Boolean> = imageGeneration.getOptional("image_generation")

        /**
         * Maximum input tokens
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inputTokenLimit(): Optional<Long> = inputTokenLimit.getOptional("input_token_limit")

        /**
         * Maximum output tokens
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun outputTokenLimit(): Optional<Long> = outputTokenLimit.getOptional("output_token_limit")

        /**
         * Supports streaming responses
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streaming(): Optional<Boolean> = streaming.getOptional("streaming")

        /**
         * Supports structured JSON output
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun structuredOutput(): Optional<Boolean> =
            structuredOutput.getOptional("structured_output")

        /**
         * Supports text generation
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun text(): Optional<Boolean> = text.getOptional("text")

        /**
         * Supports extended thinking/reasoning
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun thinking(): Optional<Boolean> = thinking.getOptional("thinking")

        /**
         * Supports function/tool calling
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tools(): Optional<Boolean> = tools.getOptional("tools")

        /**
         * Supports image understanding
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun vision(): Optional<Boolean> = vision.getOptional("vision")

        /**
         * Returns the raw JSON value of [audio].
         *
         * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<Boolean> = audio

        /**
         * Returns the raw JSON value of [imageGeneration].
         *
         * Unlike [imageGeneration], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("image_generation")
        @ExcludeMissing
        fun _imageGeneration(): JsonField<Boolean> = imageGeneration

        /**
         * Returns the raw JSON value of [inputTokenLimit].
         *
         * Unlike [inputTokenLimit], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("input_token_limit")
        @ExcludeMissing
        fun _inputTokenLimit(): JsonField<Long> = inputTokenLimit

        /**
         * Returns the raw JSON value of [outputTokenLimit].
         *
         * Unlike [outputTokenLimit], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("output_token_limit")
        @ExcludeMissing
        fun _outputTokenLimit(): JsonField<Long> = outputTokenLimit

        /**
         * Returns the raw JSON value of [streaming].
         *
         * Unlike [streaming], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("streaming") @ExcludeMissing fun _streaming(): JsonField<Boolean> = streaming

        /**
         * Returns the raw JSON value of [structuredOutput].
         *
         * Unlike [structuredOutput], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("structured_output")
        @ExcludeMissing
        fun _structuredOutput(): JsonField<Boolean> = structuredOutput

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<Boolean> = text

        /**
         * Returns the raw JSON value of [thinking].
         *
         * Unlike [thinking], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("thinking") @ExcludeMissing fun _thinking(): JsonField<Boolean> = thinking

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<Boolean> = tools

        /**
         * Returns the raw JSON value of [vision].
         *
         * Unlike [vision], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("vision") @ExcludeMissing fun _vision(): JsonField<Boolean> = vision

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

            /** Returns a mutable builder for constructing an instance of [Capabilities]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Capabilities]. */
        class Builder internal constructor() {

            private var audio: JsonField<Boolean> = JsonMissing.of()
            private var imageGeneration: JsonField<Boolean> = JsonMissing.of()
            private var inputTokenLimit: JsonField<Long> = JsonMissing.of()
            private var outputTokenLimit: JsonField<Long> = JsonMissing.of()
            private var streaming: JsonField<Boolean> = JsonMissing.of()
            private var structuredOutput: JsonField<Boolean> = JsonMissing.of()
            private var text: JsonField<Boolean> = JsonMissing.of()
            private var thinking: JsonField<Boolean> = JsonMissing.of()
            private var tools: JsonField<Boolean> = JsonMissing.of()
            private var vision: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(capabilities: Capabilities) = apply {
                audio = capabilities.audio
                imageGeneration = capabilities.imageGeneration
                inputTokenLimit = capabilities.inputTokenLimit
                outputTokenLimit = capabilities.outputTokenLimit
                streaming = capabilities.streaming
                structuredOutput = capabilities.structuredOutput
                text = capabilities.text
                thinking = capabilities.thinking
                tools = capabilities.tools
                vision = capabilities.vision
                additionalProperties = capabilities.additionalProperties.toMutableMap()
            }

            /** Supports audio processing */
            fun audio(audio: Boolean?) = audio(JsonField.ofNullable(audio))

            /**
             * Alias for [Builder.audio].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun audio(audio: Boolean) = audio(audio as Boolean?)

            /** Alias for calling [Builder.audio] with `audio.orElse(null)`. */
            fun audio(audio: Optional<Boolean>) = audio(audio.getOrNull())

            /**
             * Sets [Builder.audio] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audio] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audio(audio: JsonField<Boolean>) = apply { this.audio = audio }

            /** Supports image generation */
            fun imageGeneration(imageGeneration: Boolean?) =
                imageGeneration(JsonField.ofNullable(imageGeneration))

            /**
             * Alias for [Builder.imageGeneration].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun imageGeneration(imageGeneration: Boolean) =
                imageGeneration(imageGeneration as Boolean?)

            /** Alias for calling [Builder.imageGeneration] with `imageGeneration.orElse(null)`. */
            fun imageGeneration(imageGeneration: Optional<Boolean>) =
                imageGeneration(imageGeneration.getOrNull())

            /**
             * Sets [Builder.imageGeneration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageGeneration] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun imageGeneration(imageGeneration: JsonField<Boolean>) = apply {
                this.imageGeneration = imageGeneration
            }

            /** Maximum input tokens */
            fun inputTokenLimit(inputTokenLimit: Long?) =
                inputTokenLimit(JsonField.ofNullable(inputTokenLimit))

            /**
             * Alias for [Builder.inputTokenLimit].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun inputTokenLimit(inputTokenLimit: Long) = inputTokenLimit(inputTokenLimit as Long?)

            /** Alias for calling [Builder.inputTokenLimit] with `inputTokenLimit.orElse(null)`. */
            fun inputTokenLimit(inputTokenLimit: Optional<Long>) =
                inputTokenLimit(inputTokenLimit.getOrNull())

            /**
             * Sets [Builder.inputTokenLimit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputTokenLimit] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inputTokenLimit(inputTokenLimit: JsonField<Long>) = apply {
                this.inputTokenLimit = inputTokenLimit
            }

            /** Maximum output tokens */
            fun outputTokenLimit(outputTokenLimit: Long?) =
                outputTokenLimit(JsonField.ofNullable(outputTokenLimit))

            /**
             * Alias for [Builder.outputTokenLimit].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun outputTokenLimit(outputTokenLimit: Long) =
                outputTokenLimit(outputTokenLimit as Long?)

            /**
             * Alias for calling [Builder.outputTokenLimit] with `outputTokenLimit.orElse(null)`.
             */
            fun outputTokenLimit(outputTokenLimit: Optional<Long>) =
                outputTokenLimit(outputTokenLimit.getOrNull())

            /**
             * Sets [Builder.outputTokenLimit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputTokenLimit] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputTokenLimit(outputTokenLimit: JsonField<Long>) = apply {
                this.outputTokenLimit = outputTokenLimit
            }

            /** Supports streaming responses */
            fun streaming(streaming: Boolean?) = streaming(JsonField.ofNullable(streaming))

            /**
             * Alias for [Builder.streaming].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun streaming(streaming: Boolean) = streaming(streaming as Boolean?)

            /** Alias for calling [Builder.streaming] with `streaming.orElse(null)`. */
            fun streaming(streaming: Optional<Boolean>) = streaming(streaming.getOrNull())

            /**
             * Sets [Builder.streaming] to an arbitrary JSON value.
             *
             * You should usually call [Builder.streaming] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun streaming(streaming: JsonField<Boolean>) = apply { this.streaming = streaming }

            /** Supports structured JSON output */
            fun structuredOutput(structuredOutput: Boolean?) =
                structuredOutput(JsonField.ofNullable(structuredOutput))

            /**
             * Alias for [Builder.structuredOutput].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun structuredOutput(structuredOutput: Boolean) =
                structuredOutput(structuredOutput as Boolean?)

            /**
             * Alias for calling [Builder.structuredOutput] with `structuredOutput.orElse(null)`.
             */
            fun structuredOutput(structuredOutput: Optional<Boolean>) =
                structuredOutput(structuredOutput.getOrNull())

            /**
             * Sets [Builder.structuredOutput] to an arbitrary JSON value.
             *
             * You should usually call [Builder.structuredOutput] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun structuredOutput(structuredOutput: JsonField<Boolean>) = apply {
                this.structuredOutput = structuredOutput
            }

            /** Supports text generation */
            fun text(text: Boolean?) = text(JsonField.ofNullable(text))

            /**
             * Alias for [Builder.text].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun text(text: Boolean) = text(text as Boolean?)

            /** Alias for calling [Builder.text] with `text.orElse(null)`. */
            fun text(text: Optional<Boolean>) = text(text.getOrNull())

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun text(text: JsonField<Boolean>) = apply { this.text = text }

            /** Supports extended thinking/reasoning */
            fun thinking(thinking: Boolean?) = thinking(JsonField.ofNullable(thinking))

            /**
             * Alias for [Builder.thinking].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun thinking(thinking: Boolean) = thinking(thinking as Boolean?)

            /** Alias for calling [Builder.thinking] with `thinking.orElse(null)`. */
            fun thinking(thinking: Optional<Boolean>) = thinking(thinking.getOrNull())

            /**
             * Sets [Builder.thinking] to an arbitrary JSON value.
             *
             * You should usually call [Builder.thinking] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun thinking(thinking: JsonField<Boolean>) = apply { this.thinking = thinking }

            /** Supports function/tool calling */
            fun tools(tools: Boolean?) = tools(JsonField.ofNullable(tools))

            /**
             * Alias for [Builder.tools].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun tools(tools: Boolean) = tools(tools as Boolean?)

            /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
            fun tools(tools: Optional<Boolean>) = tools(tools.getOrNull())

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tools(tools: JsonField<Boolean>) = apply { this.tools = tools }

            /** Supports image understanding */
            fun vision(vision: Boolean?) = vision(JsonField.ofNullable(vision))

            /**
             * Alias for [Builder.vision].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun vision(vision: Boolean) = vision(vision as Boolean?)

            /** Alias for calling [Builder.vision] with `vision.orElse(null)`. */
            fun vision(vision: Optional<Boolean>) = vision(vision.getOrNull())

            /**
             * Sets [Builder.vision] to an arbitrary JSON value.
             *
             * You should usually call [Builder.vision] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun vision(vision: JsonField<Boolean>) = apply { this.vision = vision }

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
             * Returns an immutable instance of [Capabilities].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Capabilities =
                Capabilities(
                    audio,
                    imageGeneration,
                    inputTokenLimit,
                    outputTokenLimit,
                    streaming,
                    structuredOutput,
                    text,
                    thinking,
                    tools,
                    vision,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Capabilities = apply {
            if (validated) {
                return@apply
            }

            audio()
            imageGeneration()
            inputTokenLimit()
            outputTokenLimit()
            streaming()
            structuredOutput()
            text()
            thinking()
            tools()
            vision()
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
            (if (audio.asKnown().isPresent) 1 else 0) +
                (if (imageGeneration.asKnown().isPresent) 1 else 0) +
                (if (inputTokenLimit.asKnown().isPresent) 1 else 0) +
                (if (outputTokenLimit.asKnown().isPresent) 1 else 0) +
                (if (streaming.asKnown().isPresent) 1 else 0) +
                (if (structuredOutput.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                (if (thinking.asKnown().isPresent) 1 else 0) +
                (if (tools.asKnown().isPresent) 1 else 0) +
                (if (vision.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Capabilities &&
                audio == other.audio &&
                imageGeneration == other.imageGeneration &&
                inputTokenLimit == other.inputTokenLimit &&
                outputTokenLimit == other.outputTokenLimit &&
                streaming == other.streaming &&
                structuredOutput == other.structuredOutput &&
                text == other.text &&
                thinking == other.thinking &&
                tools == other.tools &&
                vision == other.vision &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                audio,
                imageGeneration,
                inputTokenLimit,
                outputTokenLimit,
                streaming,
                structuredOutput,
                text,
                thinking,
                tools,
                vision,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Capabilities{audio=$audio, imageGeneration=$imageGeneration, inputTokenLimit=$inputTokenLimit, outputTokenLimit=$outputTokenLimit, streaming=$streaming, structuredOutput=$structuredOutput, text=$text, thinking=$thinking, tools=$tools, vision=$vision, additionalProperties=$additionalProperties}"
    }

    /** Provider-declared default parameters for model generation. */
    class Defaults
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val maxOutputTokens: JsonField<Long>,
        private val temperature: JsonField<Double>,
        private val topK: JsonField<Long>,
        private val topP: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("max_output_tokens")
            @ExcludeMissing
            maxOutputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("top_k") @ExcludeMissing topK: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
        ) : this(maxOutputTokens, temperature, topK, topP, mutableMapOf())

        /**
         * Default maximum output tokens
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxOutputTokens(): Optional<Long> = maxOutputTokens.getOptional("max_output_tokens")

        /**
         * Default temperature setting
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> = temperature.getOptional("temperature")

        /**
         * Default top_k setting
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topK(): Optional<Long> = topK.getOptional("top_k")

        /**
         * Default top_p setting
         *
         * @throws DedalusInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topP(): Optional<Double> = topP.getOptional("top_p")

        /**
         * Returns the raw JSON value of [maxOutputTokens].
         *
         * Unlike [maxOutputTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        fun _maxOutputTokens(): JsonField<Long> = maxOutputTokens

        /**
         * Returns the raw JSON value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Returns the raw JSON value of [topK].
         *
         * Unlike [topK], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_k") @ExcludeMissing fun _topK(): JsonField<Long> = topK

        /**
         * Returns the raw JSON value of [topP].
         *
         * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

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

            /** Returns a mutable builder for constructing an instance of [Defaults]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Defaults]. */
        class Builder internal constructor() {

            private var maxOutputTokens: JsonField<Long> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var topK: JsonField<Long> = JsonMissing.of()
            private var topP: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(defaults: Defaults) = apply {
                maxOutputTokens = defaults.maxOutputTokens
                temperature = defaults.temperature
                topK = defaults.topK
                topP = defaults.topP
                additionalProperties = defaults.additionalProperties.toMutableMap()
            }

            /** Default maximum output tokens */
            fun maxOutputTokens(maxOutputTokens: Long?) =
                maxOutputTokens(JsonField.ofNullable(maxOutputTokens))

            /**
             * Alias for [Builder.maxOutputTokens].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun maxOutputTokens(maxOutputTokens: Long) = maxOutputTokens(maxOutputTokens as Long?)

            /** Alias for calling [Builder.maxOutputTokens] with `maxOutputTokens.orElse(null)`. */
            fun maxOutputTokens(maxOutputTokens: Optional<Long>) =
                maxOutputTokens(maxOutputTokens.getOrNull())

            /**
             * Sets [Builder.maxOutputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxOutputTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxOutputTokens(maxOutputTokens: JsonField<Long>) = apply {
                this.maxOutputTokens = maxOutputTokens
            }

            /** Default temperature setting */
            fun temperature(temperature: Double?) = temperature(JsonField.ofNullable(temperature))

            /**
             * Alias for [Builder.temperature].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun temperature(temperature: Double) = temperature(temperature as Double?)

            /** Alias for calling [Builder.temperature] with `temperature.orElse(null)`. */
            fun temperature(temperature: Optional<Double>) = temperature(temperature.getOrNull())

            /**
             * Sets [Builder.temperature] to an arbitrary JSON value.
             *
             * You should usually call [Builder.temperature] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun temperature(temperature: JsonField<Double>) = apply {
                this.temperature = temperature
            }

            /** Default top_k setting */
            fun topK(topK: Long?) = topK(JsonField.ofNullable(topK))

            /**
             * Alias for [Builder.topK].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun topK(topK: Long) = topK(topK as Long?)

            /** Alias for calling [Builder.topK] with `topK.orElse(null)`. */
            fun topK(topK: Optional<Long>) = topK(topK.getOrNull())

            /**
             * Sets [Builder.topK] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topK] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun topK(topK: JsonField<Long>) = apply { this.topK = topK }

            /** Default top_p setting */
            fun topP(topP: Double?) = topP(JsonField.ofNullable(topP))

            /**
             * Alias for [Builder.topP].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun topP(topP: Double) = topP(topP as Double?)

            /** Alias for calling [Builder.topP] with `topP.orElse(null)`. */
            fun topP(topP: Optional<Double>) = topP(topP.getOrNull())

            /**
             * Sets [Builder.topP] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topP] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

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
             * Returns an immutable instance of [Defaults].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Defaults =
                Defaults(
                    maxOutputTokens,
                    temperature,
                    topK,
                    topP,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Defaults = apply {
            if (validated) {
                return@apply
            }

            maxOutputTokens()
            temperature()
            topK()
            topP()
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
            (if (maxOutputTokens.asKnown().isPresent) 1 else 0) +
                (if (temperature.asKnown().isPresent) 1 else 0) +
                (if (topK.asKnown().isPresent) 1 else 0) +
                (if (topP.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Defaults &&
                maxOutputTokens == other.maxOutputTokens &&
                temperature == other.temperature &&
                topK == other.topK &&
                topP == other.topP &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(maxOutputTokens, temperature, topK, topP, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Defaults{maxOutputTokens=$maxOutputTokens, temperature=$temperature, topK=$topK, topP=$topP, additionalProperties=$additionalProperties}"
    }

    /** Raw provider-specific metadata */
    class ProviderInfo
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

            /** Returns a mutable builder for constructing an instance of [ProviderInfo]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ProviderInfo]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(providerInfo: ProviderInfo) = apply {
                additionalProperties = providerInfo.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [ProviderInfo].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ProviderInfo = ProviderInfo(additionalProperties.toImmutable())
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
        fun validate(): ProviderInfo = apply {
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

            return other is ProviderInfo && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "ProviderInfo{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Model &&
            id == other.id &&
            createdAt == other.createdAt &&
            provider == other.provider &&
            capabilities == other.capabilities &&
            defaults == other.defaults &&
            description == other.description &&
            displayName == other.displayName &&
            providerDeclaredGenerationMethods == other.providerDeclaredGenerationMethods &&
            providerInfo == other.providerInfo &&
            version == other.version &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            provider,
            capabilities,
            defaults,
            description,
            displayName,
            providerDeclaredGenerationMethods,
            providerInfo,
            version,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Model{id=$id, createdAt=$createdAt, provider=$provider, capabilities=$capabilities, defaults=$defaults, description=$description, displayName=$displayName, providerDeclaredGenerationMethods=$providerDeclaredGenerationMethods, providerInfo=$providerInfo, version=$version, additionalProperties=$additionalProperties}"
}
