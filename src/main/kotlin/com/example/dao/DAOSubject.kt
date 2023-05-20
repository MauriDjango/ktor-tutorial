package com.example.dao

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.*
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOSubject : DAOFacade<Subject> {
    private fun resultRowToSubject(row: ResultRow) = Subject(
        id = row[Subjects.id],
        value = row[Subjects.value],
        name = row[Subjects.name],
        description = row[Subjects.description],
        sectionId = row[Subjects.sectionId],
        order = row[Subjects.order],
    )

    override suspend fun all(): List<Subject> = dbQuery {
        Subjects.selectAll().map(::resultRowToSubject)
    }

    override suspend fun findById(t: Subject): Subject? = dbQuery {
        Subjects
            .select { Subjects.id eq t.id }
            .map(::resultRowToSubject)
            .singleOrNull()
    }

    override suspend fun add(t: Subject): Subject? = dbQuery {
        val insertStatement = Subjects.insert {
            it[id] = t.id
            it[value] = t.value
            it[name] = t.name
            it[description] = t.description
            it[sectionId] = t.sectionId
            it[order] = t.order
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToSubject)
    }

    override suspend fun edit(t: Subject): Boolean = dbQuery {
        Subjects.update({ Subjects.id eq t.id }) {
            it[value] = t.value
            it[name] = t.name
            it[description] = t.description
            it[sectionId] = t.sectionId
            it[order] = t.order
        } > 0
    }

    override suspend fun delete(t: Subject): Boolean = dbQuery {
        Subjects.deleteWhere { id eq t.id } > 0
    }

    suspend fun getByArticle(id: Int) = dbQuery {
        Subjects.select {
            Subjects.sectionId eq id
        }
    }
}

val daoSubject: DAOFacade<Subject> = DAOSubject().apply {
    runBlocking {
        if(all().isEmpty()) {
            add(
                Subject(
                "Default",
                "None",
                "Generic",
                "No subjects have been found",
                0,
                0,
                )
            )
        }
    }
}
