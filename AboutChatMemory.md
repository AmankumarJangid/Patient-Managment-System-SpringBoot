## Introduction
LLMs are stateless, that means they do not remember the conversation. Each conversation is stateless. 
To make LLM remember the context or previous chats in Spring AI 
there is a concept named **`Chat Memory`**.

With ChatMemory LLM can remember our conversation and they can respond well to the next question.

Even ChatGPT also uses the similar concept.

Spring AI gives an abstraction named ChatMemory to store and manage messages. 
Messages are saved using *`ChatMemoryRepository`* 
similar way we store records in DB using *`Crud`* or *`JPAReposiory.`*

### ChatMemoryRepository interface has two implementation.

* InMemoryChatMemoryRepository
* JdbcChatMemoryRepository

ChatMemory interface is implemented by `MessageWindowChatMemory`.

