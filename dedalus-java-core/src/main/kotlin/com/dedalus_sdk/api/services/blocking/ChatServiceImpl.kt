// File generated from our OpenAPI spec by Stainless.

package com.dedalus_sdk.api.services.blocking

import com.dedalus_sdk.api.core.ClientOptions
import com.dedalus_sdk.api.services.blocking.chat.CompletionService
import com.dedalus_sdk.api.services.blocking.chat.CompletionServiceImpl
import java.util.function.Consumer

class ChatServiceImpl internal constructor(private val clientOptions: ClientOptions) : ChatService {

    private val withRawResponse: ChatService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val completions: CompletionService by lazy { CompletionServiceImpl(clientOptions) }

    override fun withRawResponse(): ChatService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatService =
        ChatServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun completions(): CompletionService = completions

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChatService.WithRawResponse {

        private val completions: CompletionService.WithRawResponse by lazy {
            CompletionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChatService.WithRawResponse =
            ChatServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun completions(): CompletionService.WithRawResponse = completions
    }
}
