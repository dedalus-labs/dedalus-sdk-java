// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.core

import com.dedalus_sdk.api.core.http.AsyncStreamResponse
import com.dedalus_sdk.api.core.http.Headers
import com.dedalus_sdk.api.core.http.HttpClient
import com.dedalus_sdk.api.core.http.LoggingHttpClient
import com.dedalus_sdk.api.core.http.PhantomReachableClosingHttpClient
import com.dedalus_sdk.api.core.http.QueryParams
import com.dedalus_sdk.api.core.http.RetryingHttpClient
import com.fasterxml.jackson.databind.json.JsonMapper
import java.time.Clock
import java.time.Duration
import java.util.Optional
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicLong
import kotlin.jvm.optionals.getOrNull

/** A class representing the SDK client configuration. */
class ClientOptions
private constructor(
    private val originalHttpClient: HttpClient,
    /**
     * The HTTP client to use in the SDK.
     *
     * Use the one published in `dedalus-java-client-okhttp` or implement your own.
     *
     * This class takes ownership of the client and closes it when closed.
     */
    @get:JvmName("httpClient") val httpClient: HttpClient,
    /**
     * Whether to throw an exception if any of the Jackson versions detected at runtime are
     * incompatible with the SDK's minimum supported Jackson version (2.13.4).
     *
     * Defaults to true. Use extreme caution when disabling this option. There is no guarantee that
     * the SDK will work correctly when using an incompatible Jackson version.
     */
    @get:JvmName("checkJacksonVersionCompatibility") val checkJacksonVersionCompatibility: Boolean,
    /**
     * The Jackson JSON mapper to use for serializing and deserializing JSON.
     *
     * Defaults to [com.dedalus_sdk.api.core.jsonMapper]. The default is usually sufficient and
     * rarely needs to be overridden.
     */
    @get:JvmName("jsonMapper") val jsonMapper: JsonMapper,
    /**
     * The executor to use for running [AsyncStreamResponse.Handler] callbacks.
     *
     * Defaults to a dedicated cached thread pool.
     *
     * This class takes ownership of the executor and shuts it down, if possible, when closed.
     */
    @get:JvmName("streamHandlerExecutor") val streamHandlerExecutor: Executor,
    /**
     * The interface to use for delaying execution, like during retries.
     *
     * This is primarily useful for using fake delays in tests.
     *
     * Defaults to real execution delays.
     *
     * This class takes ownership of the sleeper and closes it when closed.
     */
    @get:JvmName("sleeper") val sleeper: Sleeper,
    /**
     * The clock to use for operations that require timing, like retries.
     *
     * This is primarily useful for using a fake clock in tests.
     *
     * Defaults to [Clock.systemUTC].
     */
    @get:JvmName("clock") val clock: Clock,
    private val baseUrl: String?,
    /** Headers to send with the request. */
    @get:JvmName("headers") val headers: Headers,
    /** Query params to send with the request. */
    @get:JvmName("queryParams") val queryParams: QueryParams,
    /**
     * Whether to call `validate` on every response before returning it.
     *
     * Setting this to `true` is _not_ forwards compatible with new types from the API for existing
     * fields.
     *
     * Defaults to false, which means the shape of the response will not be validated upfront.
     * Instead, validation will only occur for the parts of the response that are accessed.
     */
    @get:JvmName("responseValidation") val responseValidation: Boolean,
    /**
     * Sets the maximum time allowed for various parts of an HTTP call's lifecycle, excluding
     * retries.
     *
     * Defaults to [Timeout.default].
     */
    @get:JvmName("timeout") val timeout: Timeout,
    /**
     * The maximum number of times to retry failed requests, with a short exponential backoff
     * between requests.
     *
     * Only the following error types are retried:
     * - Connection errors (for example, due to a network connectivity problem)
     * - 408 Request Timeout
     * - 409 Conflict
     * - 429 Rate Limit
     * - 5xx Internal
     *
     * The API may also explicitly instruct the SDK to retry or not retry a request.
     *
     * Defaults to 2.
     */
    @get:JvmName("maxRetries") val maxRetries: Int,
    /**
     * The level at which to log request and response information.
     *
     * [fromEnv] will set the level from environment variables. See [LogLevel.fromEnv].
     *
     * Defaults to [LogLevel.fromEnv].
     */
    @get:JvmName("logLevel") val logLevel: LogLevel,
    private val apiKey: String?,
    private val xApiKey: String?,
    private val asBaseUrl: String?,
    private val dedalusOrgId: String?,
    private val provider: String?,
    private val providerKey: String?,
    private val providerModel: String?,
) {

    init {
        if (checkJacksonVersionCompatibility) {
            checkJacksonVersionCompatibility()
        }
    }

    /**
     * The base URL to use for every request.
     *
     * Defaults to the production environment: `https://api.dedaluslabs.ai`.
     *
     * The following other environments, with dedicated builder methods, are available:
     * - development: `http://localhost:4010`
     */
    fun baseUrl(): String = baseUrl ?: PRODUCTION_URL

    /** API key for Bearer token authentication. */
    fun apiKey(): Optional<String> = Optional.ofNullable(apiKey)

    /** API key for X-API-Key header authentication. */
    fun xApiKey(): Optional<String> = Optional.ofNullable(xApiKey)

    /**
     * MCP Authorization Server URL
     *
     * Defaults to `"https://as.dedaluslabs.ai"`.
     */
    fun asBaseUrl(): Optional<String> = Optional.ofNullable(asBaseUrl)

    /** Organization ID for request scoping. */
    fun dedalusOrgId(): Optional<String> = Optional.ofNullable(dedalusOrgId)

    /** Provider name for BYOK mode (e.g., 'google', 'openai', 'anthropic'). */
    fun provider(): Optional<String> = Optional.ofNullable(provider)

    /** Provider API key for BYOK mode. */
    fun providerKey(): Optional<String> = Optional.ofNullable(providerKey)

    /** Model identifier for BYOK provider. */
    fun providerModel(): Optional<String> = Optional.ofNullable(providerModel)

    fun toBuilder() = Builder().from(this)

    companion object {

        const val PRODUCTION_URL = "https://api.dedaluslabs.ai"

        const val DEVELOPMENT_URL = "http://localhost:4010"

        /**
         * Returns a mutable builder for constructing an instance of [ClientOptions].
         *
         * The following fields are required:
         * ```java
         * .httpClient()
         * ```
         */
        @JvmStatic fun builder() = Builder()

        /**
         * Returns options configured using system properties and environment variables.
         *
         * @see Builder.fromEnv
         */
        @JvmStatic fun fromEnv(): ClientOptions = builder().fromEnv().build()
    }

    /** A builder for [ClientOptions]. */
    class Builder internal constructor() {

        private var httpClient: HttpClient? = null
        private var checkJacksonVersionCompatibility: Boolean = true
        private var jsonMapper: JsonMapper = jsonMapper()
        private var streamHandlerExecutor: Executor? = null
        private var sleeper: Sleeper? = null
        private var clock: Clock = Clock.systemUTC()
        private var baseUrl: String? = null
        private var headers: Headers.Builder = Headers.builder()
        private var queryParams: QueryParams.Builder = QueryParams.builder()
        private var responseValidation: Boolean = false
        private var timeout: Timeout = Timeout.default()
        private var maxRetries: Int = 2
        private var logLevel: LogLevel = LogLevel.fromEnv()
        private var apiKey: String? = null
        private var xApiKey: String? = null
        private var asBaseUrl: String? = "https://as.dedaluslabs.ai"
        private var dedalusOrgId: String? = null
        private var provider: String? = null
        private var providerKey: String? = null
        private var providerModel: String? = null

        @JvmSynthetic
        internal fun from(clientOptions: ClientOptions) = apply {
            httpClient = clientOptions.originalHttpClient
            checkJacksonVersionCompatibility = clientOptions.checkJacksonVersionCompatibility
            jsonMapper = clientOptions.jsonMapper
            streamHandlerExecutor = clientOptions.streamHandlerExecutor
            sleeper = clientOptions.sleeper
            clock = clientOptions.clock
            baseUrl = clientOptions.baseUrl
            headers = clientOptions.headers.toBuilder()
            queryParams = clientOptions.queryParams.toBuilder()
            responseValidation = clientOptions.responseValidation
            timeout = clientOptions.timeout
            maxRetries = clientOptions.maxRetries
            logLevel = clientOptions.logLevel
            apiKey = clientOptions.apiKey
            xApiKey = clientOptions.xApiKey
            asBaseUrl = clientOptions.asBaseUrl
            dedalusOrgId = clientOptions.dedalusOrgId
            provider = clientOptions.provider
            providerKey = clientOptions.providerKey
            providerModel = clientOptions.providerModel
        }

        /**
         * The HTTP client to use in the SDK.
         *
         * Use the one published in `dedalus-java-client-okhttp` or implement your own.
         *
         * This class takes ownership of the client and closes it when closed.
         */
        fun httpClient(httpClient: HttpClient) = apply {
            this.httpClient = PhantomReachableClosingHttpClient(httpClient)
        }

        /**
         * Whether to throw an exception if any of the Jackson versions detected at runtime are
         * incompatible with the SDK's minimum supported Jackson version (2.13.4).
         *
         * Defaults to true. Use extreme caution when disabling this option. There is no guarantee
         * that the SDK will work correctly when using an incompatible Jackson version.
         */
        fun checkJacksonVersionCompatibility(checkJacksonVersionCompatibility: Boolean) = apply {
            this.checkJacksonVersionCompatibility = checkJacksonVersionCompatibility
        }

        /**
         * The Jackson JSON mapper to use for serializing and deserializing JSON.
         *
         * Defaults to [com.dedalus_sdk.api.core.jsonMapper]. The default is usually sufficient and
         * rarely needs to be overridden.
         */
        fun jsonMapper(jsonMapper: JsonMapper) = apply { this.jsonMapper = jsonMapper }

        /**
         * The executor to use for running [AsyncStreamResponse.Handler] callbacks.
         *
         * Defaults to a dedicated cached thread pool.
         *
         * This class takes ownership of the executor and shuts it down, if possible, when closed.
         */
        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor =
                if (streamHandlerExecutor is ExecutorService)
                    PhantomReachableExecutorService(streamHandlerExecutor)
                else streamHandlerExecutor
        }

        /**
         * The interface to use for delaying execution, like during retries.
         *
         * This is primarily useful for using fake delays in tests.
         *
         * Defaults to real execution delays.
         *
         * This class takes ownership of the sleeper and closes it when closed.
         */
        fun sleeper(sleeper: Sleeper) = apply { this.sleeper = PhantomReachableSleeper(sleeper) }

        /**
         * The clock to use for operations that require timing, like retries.
         *
         * This is primarily useful for using a fake clock in tests.
         *
         * Defaults to [Clock.systemUTC].
         */
        fun clock(clock: Clock) = apply { this.clock = clock }

        /**
         * The base URL to use for every request.
         *
         * Defaults to the production environment: `https://api.dedaluslabs.ai`.
         *
         * The following other environments, with dedicated builder methods, are available:
         * - development: `http://localhost:4010`
         */
        fun baseUrl(baseUrl: String?) = apply { this.baseUrl = baseUrl }

        /** Alias for calling [Builder.baseUrl] with `baseUrl.orElse(null)`. */
        fun baseUrl(baseUrl: Optional<String>) = baseUrl(baseUrl.getOrNull())

        /** Sets [baseUrl] to `http://localhost:4010`. */
        fun development() = baseUrl(DEVELOPMENT_URL)

        /**
         * Whether to call `validate` on every response before returning it.
         *
         * Setting this to `true` is _not_ forwards compatible with new types from the API for
         * existing fields.
         *
         * Defaults to false, which means the shape of the response will not be validated upfront.
         * Instead, validation will only occur for the parts of the response that are accessed.
         */
        fun responseValidation(responseValidation: Boolean) = apply {
            this.responseValidation = responseValidation
        }

        /**
         * Sets the maximum time allowed for various parts of an HTTP call's lifecycle, excluding
         * retries.
         *
         * Defaults to [Timeout.default].
         */
        fun timeout(timeout: Timeout) = apply { this.timeout = timeout }

        /**
         * Sets the maximum time allowed for a complete HTTP call, not including retries.
         *
         * See [Timeout.request] for more details.
         *
         * For fine-grained control, pass a [Timeout] object.
         */
        fun timeout(timeout: Duration) = timeout(Timeout.builder().request(timeout).build())

        /**
         * The maximum number of times to retry failed requests, with a short exponential backoff
         * between requests.
         *
         * Only the following error types are retried:
         * - Connection errors (for example, due to a network connectivity problem)
         * - 408 Request Timeout
         * - 409 Conflict
         * - 429 Rate Limit
         * - 5xx Internal
         *
         * The API may also explicitly instruct the SDK to retry or not retry a request.
         *
         * Defaults to 2.
         */
        fun maxRetries(maxRetries: Int) = apply { this.maxRetries = maxRetries }

        /**
         * The level at which to log request and response information.
         *
         * [fromEnv] will set the level from environment variables. See [LogLevel.fromEnv].
         *
         * Defaults to [LogLevel.fromEnv].
         */
        fun logLevel(logLevel: LogLevel) = apply { this.logLevel = logLevel }

        /** API key for Bearer token authentication. */
        fun apiKey(apiKey: String?) = apply { this.apiKey = apiKey }

        /** Alias for calling [Builder.apiKey] with `apiKey.orElse(null)`. */
        fun apiKey(apiKey: Optional<String>) = apiKey(apiKey.getOrNull())

        /** API key for X-API-Key header authentication. */
        fun xApiKey(xApiKey: String?) = apply { this.xApiKey = xApiKey }

        /** Alias for calling [Builder.xApiKey] with `xApiKey.orElse(null)`. */
        fun xApiKey(xApiKey: Optional<String>) = xApiKey(xApiKey.getOrNull())

        /**
         * MCP Authorization Server URL
         *
         * Defaults to `"https://as.dedaluslabs.ai"`.
         */
        fun asBaseUrl(asBaseUrl: String?) = apply { this.asBaseUrl = asBaseUrl }

        /** Alias for calling [Builder.asBaseUrl] with `asBaseUrl.orElse(null)`. */
        fun asBaseUrl(asBaseUrl: Optional<String>) = asBaseUrl(asBaseUrl.getOrNull())

        /** Organization ID for request scoping. */
        fun dedalusOrgId(dedalusOrgId: String?) = apply { this.dedalusOrgId = dedalusOrgId }

        /** Alias for calling [Builder.dedalusOrgId] with `dedalusOrgId.orElse(null)`. */
        fun dedalusOrgId(dedalusOrgId: Optional<String>) = dedalusOrgId(dedalusOrgId.getOrNull())

        /** Provider name for BYOK mode (e.g., 'google', 'openai', 'anthropic'). */
        fun provider(provider: String?) = apply { this.provider = provider }

        /** Alias for calling [Builder.provider] with `provider.orElse(null)`. */
        fun provider(provider: Optional<String>) = provider(provider.getOrNull())

        /** Provider API key for BYOK mode. */
        fun providerKey(providerKey: String?) = apply { this.providerKey = providerKey }

        /** Alias for calling [Builder.providerKey] with `providerKey.orElse(null)`. */
        fun providerKey(providerKey: Optional<String>) = providerKey(providerKey.getOrNull())

        /** Model identifier for BYOK provider. */
        fun providerModel(providerModel: String?) = apply { this.providerModel = providerModel }

        /** Alias for calling [Builder.providerModel] with `providerModel.orElse(null)`. */
        fun providerModel(providerModel: Optional<String>) =
            providerModel(providerModel.getOrNull())

        fun headers(headers: Headers) = apply {
            this.headers.clear()
            putAllHeaders(headers)
        }

        fun headers(headers: Map<String, Iterable<String>>) = apply {
            this.headers.clear()
            putAllHeaders(headers)
        }

        fun putHeader(name: String, value: String) = apply { headers.put(name, value) }

        fun putHeaders(name: String, values: Iterable<String>) = apply { headers.put(name, values) }

        fun putAllHeaders(headers: Headers) = apply { this.headers.putAll(headers) }

        fun putAllHeaders(headers: Map<String, Iterable<String>>) = apply {
            this.headers.putAll(headers)
        }

        fun replaceHeaders(name: String, value: String) = apply { headers.replace(name, value) }

        fun replaceHeaders(name: String, values: Iterable<String>) = apply {
            headers.replace(name, values)
        }

        fun replaceAllHeaders(headers: Headers) = apply { this.headers.replaceAll(headers) }

        fun replaceAllHeaders(headers: Map<String, Iterable<String>>) = apply {
            this.headers.replaceAll(headers)
        }

        fun removeHeaders(name: String) = apply { headers.remove(name) }

        fun removeAllHeaders(names: Set<String>) = apply { headers.removeAll(names) }

        fun queryParams(queryParams: QueryParams) = apply {
            this.queryParams.clear()
            putAllQueryParams(queryParams)
        }

        fun queryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.clear()
            putAllQueryParams(queryParams)
        }

        fun putQueryParam(key: String, value: String) = apply { queryParams.put(key, value) }

        fun putQueryParams(key: String, values: Iterable<String>) = apply {
            queryParams.put(key, values)
        }

        fun putAllQueryParams(queryParams: QueryParams) = apply {
            this.queryParams.putAll(queryParams)
        }

        fun putAllQueryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.putAll(queryParams)
        }

        fun replaceQueryParams(key: String, value: String) = apply {
            queryParams.replace(key, value)
        }

        fun replaceQueryParams(key: String, values: Iterable<String>) = apply {
            queryParams.replace(key, values)
        }

        fun replaceAllQueryParams(queryParams: QueryParams) = apply {
            this.queryParams.replaceAll(queryParams)
        }

        fun replaceAllQueryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.replaceAll(queryParams)
        }

        fun removeQueryParams(key: String) = apply { queryParams.remove(key) }

        fun removeAllQueryParams(keys: Set<String>) = apply { queryParams.removeAll(keys) }

        fun timeout(): Timeout = timeout

        /**
         * Updates configuration using system properties and environment variables.
         *
         * See this table for the available options:
         *
         * |Setter         |System property        |Environment variable    |Required|Default value                 |
         * |---------------|-----------------------|------------------------|--------|------------------------------|
         * |`apiKey`       |`dedalus.apiKey`       |`DEDALUS_API_KEY`       |false   |-                             |
         * |`xApiKey`      |`dedalus.xApiKey`      |`DEDALUS_X_API_KEY`     |false   |-                             |
         * |`asBaseUrl`    |`dedalus.asUrl`        |`DEDALUS_AS_URL`        |false   |`"https://as.dedaluslabs.ai"` |
         * |`dedalusOrgId` |`dedalus.orgId`        |`DEDALUS_ORG_ID`        |false   |-                             |
         * |`provider`     |`dedalus.provider`     |`DEDALUS_PROVIDER`      |false   |-                             |
         * |`providerKey`  |`dedalus.providerKey`  |`DEDALUS_PROVIDER_KEY`  |false   |-                             |
         * |`providerModel`|`dedalus.providerModel`|`DEDALUS_PROVIDER_MODEL`|false   |-                             |
         * |`baseUrl`      |`dedalus.baseUrl`      |`DEDALUS_BASE_URL`      |true    |`"https://api.dedaluslabs.ai"`|
         *
         * System properties take precedence over environment variables.
         */
        fun fromEnv() = apply {
            logLevel(LogLevel.fromEnv())
            (System.getProperty("dedalus.baseUrl") ?: System.getenv("DEDALUS_BASE_URL"))?.let {
                baseUrl(it)
            }
            (System.getProperty("dedalus.apiKey") ?: System.getenv("DEDALUS_API_KEY"))?.let {
                apiKey(it)
            }
            (System.getProperty("dedalus.xApiKey") ?: System.getenv("DEDALUS_X_API_KEY"))?.let {
                xApiKey(it)
            }
            (System.getProperty("dedalus.asUrl") ?: System.getenv("DEDALUS_AS_URL"))?.let {
                asBaseUrl(it)
            }
            (System.getProperty("dedalus.orgId") ?: System.getenv("DEDALUS_ORG_ID"))?.let {
                dedalusOrgId(it)
            }
            (System.getProperty("dedalus.provider") ?: System.getenv("DEDALUS_PROVIDER"))?.let {
                provider(it)
            }
            (System.getProperty("dedalus.providerKey") ?: System.getenv("DEDALUS_PROVIDER_KEY"))
                ?.let { providerKey(it) }
            (System.getProperty("dedalus.providerModel") ?: System.getenv("DEDALUS_PROVIDER_MODEL"))
                ?.let { providerModel(it) }
            System.getenv("DEDALUS_CUSTOM_HEADERS")?.let { customHeadersEnv ->
                for (line in customHeadersEnv.split("\n")) {
                    val colon = line.indexOf(':')
                    if (colon >= 0) {
                        putHeader(line.substring(0, colon).trim(), line.substring(colon + 1).trim())
                    }
                }
            }
        }

        /**
         * Returns an immutable instance of [ClientOptions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .httpClient()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ClientOptions {
            val httpClient = checkRequired("httpClient", httpClient)
            val streamHandlerExecutor =
                streamHandlerExecutor
                    ?: PhantomReachableExecutorService(
                        Executors.newCachedThreadPool(
                            object : ThreadFactory {

                                private val threadFactory: ThreadFactory =
                                    Executors.defaultThreadFactory()
                                private val count = AtomicLong(0)

                                override fun newThread(runnable: Runnable): Thread =
                                    threadFactory.newThread(runnable).also {
                                        it.name =
                                            "dedalus-stream-handler-thread-${count.getAndIncrement()}"
                                    }
                            }
                        )
                    )
            val sleeper = sleeper ?: PhantomReachableSleeper(DefaultSleeper())

            val headers = Headers.builder()
            val queryParams = QueryParams.builder()
            headers.put("X-Stainless-Lang", "java")
            headers.put("X-Stainless-Arch", getOsArch())
            headers.put("X-Stainless-OS", getOsName())
            headers.put("X-Stainless-OS-Version", getOsVersion())
            headers.put("X-Stainless-Package-Version", getPackageVersion())
            headers.put("X-Stainless-Runtime", "JRE")
            headers.put("X-Stainless-Runtime-Version", getJavaVersion())
            headers.put("X-Stainless-Kotlin-Version", KotlinVersion.CURRENT.toString())
            headers.put("User-Agent", "Dedalus-SDK")
            headers.put("X-SDK-Version", "1.0.0")
            // We replace after all the default headers to allow end-users to overwrite them.
            headers.replaceAll(this.headers.build())
            queryParams.replaceAll(this.queryParams.build())
            provider?.let { headers.replace("X-Provider", it) }
            providerKey?.let { headers.replace("X-Provider-Key", it) }
            providerModel?.let { headers.replace("X-Provider-Model", it) }
            apiKey?.let {
                if (!it.isEmpty()) {
                    headers.replace("Authorization", "Bearer $it")
                }
            }
            xApiKey?.let {
                if (!it.isEmpty()) {
                    headers.replace("x-api-key", it)
                }
            }

            return ClientOptions(
                httpClient,
                RetryingHttpClient.builder()
                    .httpClient(
                        LoggingHttpClient.builder()
                            .httpClient(httpClient)
                            .clock(clock)
                            .level(logLevel)
                            .build()
                    )
                    .sleeper(sleeper)
                    .clock(clock)
                    .maxRetries(maxRetries)
                    .idempotencyHeader("Idempotency-Key")
                    .build(),
                checkJacksonVersionCompatibility,
                jsonMapper,
                streamHandlerExecutor,
                sleeper,
                clock,
                baseUrl,
                headers.build(),
                queryParams.build(),
                responseValidation,
                timeout,
                maxRetries,
                logLevel,
                apiKey,
                xApiKey,
                asBaseUrl,
                dedalusOrgId,
                provider,
                providerKey,
                providerModel,
            )
        }
    }

    /**
     * Closes these client options, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client options are
     * long-lived and usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default client automatically
     * releases threads and connections if they remain idle, but if you are writing an application
     * that needs to aggressively release unused resources, then you may call this method.
     */
    fun close() {
        httpClient.close()
        (streamHandlerExecutor as? ExecutorService)?.shutdown()
        sleeper.close()
    }
}
