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

package com.jpaya.englishisfun.abbreviations.mapper

import com.jpaya.englishisfun.abbreviations.data.db.AbbreviationRoomItem
import com.jpaya.englishisfun.abbreviations.data.network.model.AbbreviationNetworkItem
import com.jpaya.englishisfun.abbreviations.domain.Abbreviation
import com.jpaya.englishisfun.base.ui.model.SimpleListItem2

fun Abbreviation.toRoomItem() = AbbreviationRoomItem(
    id = id,
    abbr = abbr,
    desc = desc
)

fun AbbreviationRoomItem.toDomain() = Abbreviation(
    id = id,
    abbr = abbr,
    desc = desc
)

fun AbbreviationNetworkItem.toDomain() = Abbreviation(
    id = id,
    abbr = abbr,
    desc = desc
)

fun Abbreviation.toPresentation() = SimpleListItem2(
    id = id,
    text1 = abbr,
    text2 = desc
)
