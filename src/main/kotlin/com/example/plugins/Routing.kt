package com.example.plugins

import com.example.dao.daoArticle
import com.example.dao.daoSubject
import com.example.models.Article
import com.example.models.Subject
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.util.*

fun Application.configureRouting() {

    routing {
        static("/static") {
            resources("files")
        }
        get("/") {
            call.respond(FreeMarkerContent("home.ftl", model = null))
        }
        route("/articles") {
                // Show a list of articles
            get {
                call.respond(FreeMarkerContent("/articles/index_article.ftl", mapOf("articles" to daoArticle.all())))
            }
            get("new") {
                // Show a page with fields for creating a new article
                call.respond(FreeMarkerContent("/articles/new_article.ftl", model = null))
            }
            post {
                val formParameters = call.receiveParameters()
                val id = 0
                val title = formParameters.getOrFail("title")
                val body = formParameters.getOrFail("body")
                val formArt = Article(id, title, body)
                val article = daoArticle.add(formArt)
                call.respondRedirect("/articles/${article?.id}")
                // Save an article
            }
            get("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val tempArt = Article(id, "Null", "Null")
                call.respond(FreeMarkerContent("/articles/show_article.ftl", mapOf("articles" to mapOf(daoArticle.findById(tempArt) to mapOf("subject" to daoSubject.getByArticle(id)))
                //TODO variable being passed need to be all passed in same argument, current attempt is map inside of a map
            }
            get("{id}/edit") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val tempArt = Article(id, "Null", "Null")
                call.respond(FreeMarkerContent("/articles/edit_article.ftl", mapOf("article" to daoArticle.findById(tempArt))))
            }
            post("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val formParameters = call.receiveParameters()
                when (formParameters.getOrFail("_action")) {
                    "update" -> {
                        val title = formParameters.getOrFail("title")
                        val body = formParameters.getOrFail("body")
                        val formArt = Article(id, title, body)
                        daoArticle.edit(formArt)
                        call.respondRedirect("/articles/$id")
                    }
                    "delete" -> {
                        val tempArt = Article(id, "Null", "Null")
                        daoArticle.delete(tempArt)
                        call.respondRedirect("/articles")
                    }
                }
            }
        }
        route("/subjects") {
            // Show a list of articles
            get {
                call.respond(FreeMarkerContent("/subjects/index_subject.ftl", mapOf("subjects" to daoSubject.all())))
            }
            get("new") {
                // Show a page with fields for creating a new article
                call.respond(FreeMarkerContent("/subjects/new_subject.ftl", model = null))
            }
            post {
                val formParameters = call.receiveParameters()
                val id = formParameters.getOrFail("id")
                val value = formParameters.getOrFail("value")
                val name = formParameters.getOrFail("name")
                val description = formParameters.getOrFail("description")
                val sectionId = formParameters.getOrFail("sectionId")
                val order = formParameters.getOrFail("order")
                val subject = Subject(id, value, name, description, sectionId, order.toInt())
                val newSub = daoSubject.add(subject)
                call.respondRedirect("/subjects/${newSub?.id}")
                // Save an article
            }
            get("{id}") {
                val id = call.parameters.getOrFail<String>("id")
                val tempSub = Subject(id, "null", "null", "null", "null", 0)
                call.respond(FreeMarkerContent("/subjects/show_subject.ftl", mapOf("subject" to daoSubject.findById(tempSub))))
            }
            get("{id}/edit") {
                val id = call.parameters.getOrFail<String>("id")
                val tempSub = Subject(id, "null", "null", "null", "null", 0)
                call.respond(FreeMarkerContent("/subjects/edit_subject.ftl", mapOf("subject" to daoSubject.findById(tempSub))))
            }
            post("{id}") {
                val id = call.parameters.getOrFail<String>("id")
                val formParameters = call.receiveParameters()
                when (formParameters.getOrFail("_action")) {
                    "update" -> {
                        val value = formParameters.getOrFail("value")
                        val name = formParameters.getOrFail("name")
                        val description = formParameters.getOrFail("description")
                        val sectionId = formParameters.getOrFail("sectionId")
                        val order = formParameters.getOrFail("order")
                        val subject = Subject(id, value, name, description, sectionId, order.toInt())
                        daoSubject.edit(subject)
                        call.respondRedirect("/subjects/$id")
                    }

                    "delete" -> {
                        val tempSub = Subject(id, "null", "null", "null", "null", 0)
                        daoSubject.delete(tempSub)
                        call.respondRedirect("/subjects")
                    }
                }
            }
        }
    }
}
