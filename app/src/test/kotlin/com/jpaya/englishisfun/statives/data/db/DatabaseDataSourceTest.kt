/*
 * Copyright 2020 Jose Maria Payá Castillo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jpaya.englishisfun.statives.data.db

import androidx.room.Room
import com.jpaya.englishisfun.data.database.EnglishIsFunDatabase
import com.jpaya.englishisfun.statives.domain.Stative
import com.jpaya.libraries.testutils.robolectric.TestRobolectric
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DatabaseDataSourceTest : TestRobolectric() {

    private lateinit var dataSource: DatabaseDataSource

    private val item1 = Stative(
        id = 1,
        category = "Category 1",
        verbs = mutableListOf("Verb 1")
    )

    private val item2 = Stative(
        id = 2,
        category = "Category 2",
        verbs = mutableListOf("Verb 2")
    )

    private val item3 = Stative(
        id = 3,
        category = "Category 3",
        verbs = mutableListOf("Verb 3")
    )

    @Before
    fun setUp() {
        val database = Room.inMemoryDatabaseBuilder(context, EnglishIsFunDatabase::class.java).build()
        dataSource = DatabaseDataSource(database.stative())
    }

    @Test
    fun `Check statives works properly`() = runBlocking {
        assertEquals(0, dataSource.count())

        dataSource.save(item1)
        assertEquals(1, dataSource.count())

        dataSource.saveAll(listOf(item2, item3))
        assertEquals(3, dataSource.count())

        // Save duplicated item
        dataSource.save(item2)
        assertEquals(3, dataSource.count())

        val list = dataSource.all()
        assertEquals(3, list.size)
        assertEquals(listOf(item1, item2, item3), list)

        // Delete unexisting element
        dataSource.delete(4)
        assertEquals(3, dataSource.count())

        dataSource.delete(3)
        assertEquals(2, dataSource.count())

        dataSource.deleteAll()
        assertEquals(0, dataSource.count())
    }
}
