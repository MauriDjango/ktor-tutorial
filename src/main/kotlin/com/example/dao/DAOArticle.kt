package com.example.dao

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.*
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOArticle : DAOFacade<Article> {
    private fun resultRowToArticle(row: ResultRow) = Article(
        id = row[Articles.id],
        title = row[Articles.title],
        body = row[Articles.body],
    )

    override suspend fun all(): List<Article> = dbQuery {
        Articles.selectAll().map(::resultRowToArticle)
    }


    override suspend fun findById(t: Article): Article? = dbQuery {
        Articles
            .select {Articles.id eq t.id}
            .map(::resultRowToArticle)
            .singleOrNull()
    }

    override suspend fun add(t: Article): Article? = dbQuery {
        val insertStatement = Articles.insert {
            it[title] = t.title
            it[body] = t.body
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToArticle)
    }

    override suspend fun edit(t: Article): Boolean = dbQuery {
        Articles.update({ Articles.id eq t.id }) {
            it[title] = t.title
            it[body] = t.body
        } > 0
    }

    override suspend fun delete(t: Article): Boolean = dbQuery {
        Articles.deleteWhere { id eq t.id } > 0
    }
}


val daoArticle: DAOArticle = DAOArticle().apply {
    runBlocking {
        if(all().isEmpty()) {
            add(
                Article(
                    id = 1,
                    title = "The drive to develop!",
                    body = "...it's what keeps me going."
                )
            )
        }
    }
}
