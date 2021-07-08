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

package com.jpaya.englishisfun.conditionals.ui.model

import com.jpaya.base.adapter.GenericAdapterComparator

data class ConditionalItem(
    val id: Long,
    val name: String,
    val condition: String,
    val result: String,
    val uses: String,
    val examples: String
) : GenericAdapterComparator<ConditionalItem> {
    override fun isSameItemAs(item: ConditionalItem) = id == item.id

    override fun hasSameContentsAs(item: ConditionalItem) = this == item
}
