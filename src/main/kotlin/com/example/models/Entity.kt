package com.example.models

import com.example.models.Articles.autoIncrement
import org.jetbrains.exposed.sql.Table

data class Subject(
    val id: String,
    val value: String,
    val name: String,
    val description: String,
    val sectionId: String,
    val order: Int
    )

object Subjects: Table() {
    val id = varchar("id", 32)
    val value = varchar("value", 1024)
    val name = varchar("name", 128)
    val description = varchar("ddescription", 256)
    val sectionId = varchar("sectionId", 32)
    val order = integer("order")

    override val primaryKey = PrimaryKey(id)
}