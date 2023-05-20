package com.example.plugins

import freemarker.cache.*
import freemarker.core.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureTemplating() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        outputFormat = HTMLOutputFormat.INSTANCE
    }
    routing {
        get("/html-freemarker/articles") {
            call.respond(FreeMarkerContent("index_article.ftl", mapOf("data" to IndexData(listOf(1, 2, 3))), ""))
        }
        get("/html-freemarker/subjects") {
            call.respond(FreeMarkerContent("index_subject.ftl", mapOf("data" to IndexData(listOf(1, 2, 3))), ""))
        }
    }
}

data class IndexData(val items: List<Int>)
