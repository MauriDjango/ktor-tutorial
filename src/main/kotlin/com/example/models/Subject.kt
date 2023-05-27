package com.example.models

import org.jetbrains.exposed.sql.Table

data class Subject(
    val id: String,
    val value: String,
    val name: String,
    val description: String,
    val sectionId: Int,
    val order: Int,
    )

object Subjects: Table() {
    val id = varchar("id", 32)
    val value = varchar("value", 1024)
    val name = varchar("name", 128)
    val description = varchar("description", 256)
    val order = integer("order")
    val sectionId = reference("sectionId", Articles.id)

    override val primaryKey = PrimaryKey(id)
}