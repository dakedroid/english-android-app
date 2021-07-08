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

package com.jpaya.englishisfun.conditionals.mapper

import com.jpaya.englishisfun.conditionals.data.db.ConditionalRoomItem
import com.jpaya.englishisfun.conditionals.data.network.model.ConditionalNetworkItem
import com.jpaya.englishisfun.conditionals.domain.Conditional
import com.jpaya.englishisfun.conditionals.ui.model.ConditionalItem
import org.junit.Assert.assertEquals
import org.junit.Test

class ConditionalMapperTest {

    @Test
    fun `Check domain to room works properly`() {
        val domain = Conditional(
            id = 1,
            name = "Name",
            condition = "Condition",
            result = "Result",
            uses = mutableListOf("Use 1"),
            examples = mutableListOf("Example 1")
        )

        val expectedResult = ConditionalRoomItem(
            id = 1,
            name = "Name",
            condition = "Condition",
            result = "Result",
            uses = mutableListOf("Use 1"),
            examples = mutableListOf("Example 1")
        )

        assertEquals(expectedResult, domain.toRoomItem())
    }

    @Test
    fun `Check room to domain works properly`() {
        val room = ConditionalRoomItem(
            id = 1,
            name = "Name",
            condition = "Condition",
            result = "Result",
            uses = mutableListOf("Use 1"),
            examples = mutableListOf("Example 1")
        )

        val expectedResult = Conditional(
            id = 1,
            name = "Name",
            condition = "Condition",
            result = "Result",
            uses = mutableListOf("Use 1"),
            examples = mutableListOf("Example 1")
        )

        assertEquals(expectedResult, room.toDomain())
    }

    @Test
    fun `Check network to domain works properly`() {
        val network = ConditionalNetworkItem().apply {
            id = 1
            name = "Name"
            condition = "Condition"
            result = "Result"
            uses = mutableListOf("Use 1")
            examples = mutableListOf("Example 1")
        }

        val expectedResult = Conditional(
            id = 1,
            name = "Name",
            condition = "Condition",
            result = "Result",
            uses = mutableListOf("Use 1"),
            examples = mutableListOf("Example 1")
        )

        assertEquals(expectedResult, network.toDomain())
    }

    @Test
    fun `Check domain to presentation works properly`() {
        val domain = Conditional(
            id = 1,
            name = "Name",
            condition = "Condition",
            result = "Result",
            uses = mutableListOf("Use 1"),
            examples = mutableListOf("Example 1")
        )

        val expectedResult = ConditionalItem(
            id = 1,
            name = "Name",
            condition = "Condition",
            result = "Result",
            uses = "Use 1",
            examples = "Example 1"
        )

        assertEquals(expectedResult, domain.toPresentation())
    }
}
