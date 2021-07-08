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

package com.jpaya.englishisfun.conditionals.ui

import com.jpaya.englishisfun.conditionals.domain.Conditional
import com.jpaya.englishisfun.conditionals.domain.ConditionalsInteractor
import com.jpaya.englishisfun.conditionals.ui.model.ConditionalItem
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ConditionalsListPresenterTest {

    companion object {
        private val MOCK_CONDITIONALS_LIST = listOf(
            Conditional(
                id = 1,
                name = "Name 1",
                condition = "Condition 1",
                result = "Result 1",
                uses = mutableListOf("Use 1"),
                examples = mutableListOf("Example 1")
            ),
            Conditional(
                id = 2,
                name = "Name 2",
                condition = "Condition 2",
                result = "Result 2",
                uses = mutableListOf("Use 1"),
                examples = mutableListOf("Example 1")
            )
        )
    }

    private lateinit var interactor: ConditionalsInteractor
    private lateinit var presenter: ConditionalsListPresenter

    @Before
    fun setUp() {
        interactor = mock()
        presenter = ConditionalsListPresenter(interactor)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getConditionalsItems works properly`() = runBlocking {
        whenever(interactor.getConditionalsItems()).doReturn(MOCK_CONDITIONALS_LIST)

        val expectedResult = listOf(
            ConditionalItem(
                id = 1,
                name = "Name 1",
                condition = "Condition 1",
                result = "Result 1",
                uses = "Use 1",
                examples = "Example 1"
            ),
            ConditionalItem(
                id = 2,
                name = "Name 2",
                condition = "Condition 2",
                result = "Result 2",
                uses = "Use 1",
                examples = "Example 1"
            )
        )

        assertEquals(expectedResult, presenter.getConditionalsItems())
    }
}
