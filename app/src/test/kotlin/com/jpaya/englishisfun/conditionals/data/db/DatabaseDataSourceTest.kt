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

package com.jpaya.englishisfun.conditionals.data.db

import androidx.room.Room
import com.jpaya.englishisfun.conditionals.domain.Conditional
import com.jpaya.englishisfun.data.database.EnglishIsFunDatabase
import com.jpaya.libraries.testutils.robolectric.TestRobolectric
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DatabaseDataSourceTest : TestRobolectric() {

    private lateinit var dataSource: DatabaseDataSource

    private val item1 = Conditional(
        id = 1,
        name = "Name 1",
        condition = "Condition 1",
        result = "Result 1",
        uses = mutableListOf("Use 1"),
        examples = mutableListOf("Example 1")
    )

    private val item2 = Conditional(
        id = 2,
        name = "Name 2",
        condition = "Condition 2",
        result = "Result 2",
        uses = mutableListOf("Use 1"),
        examples = mutableListOf("Example 1")
    )

    private val item3 = Conditional(
        id = 3,
        name = "Name 3",
        condition = "Condition 3",
        result = "Result 3",
        uses = mutableListOf("Use 1"),
        examples = mutableListOf("Example 1")
    )

    @Before
    fun setUp() {
        val database = Room.inMemoryDatabaseBuilder(context, EnglishIsFunDatabase::class.java).build()
        dataSource = DatabaseDataSource(database.conditionals())
    }

    @Test
    fun `Check conditionals works properly`() = runBlocking {
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
