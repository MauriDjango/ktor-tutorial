package com.example.dao

import com.example.models.*
import java.util.UUID

interface DAOFacade<T> {
    suspend fun all(): List<T>
    suspend fun findById(t: T): T?
    suspend fun add(t: T): T?
    suspend fun edit(t: T): Boolean
    suspend fun delete(t: T): Boolean
}