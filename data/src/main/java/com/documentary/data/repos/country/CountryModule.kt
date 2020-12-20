/*
 * Copyright 2020 Google LLC
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

package com.documentary.data.repos.country


import com.documentary.base.data.entities.Success
import com.documentary.data.dao.CountryDao
import com.documentary.data.entities.CountryEntity
import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.SourceOfTruth
import com.dropbox.android.external.store4.Store
import com.dropbox.android.external.store4.StoreBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

typealias CountryStore = Store<Int, List<CountryEntity>>

@InstallIn(ApplicationComponent::class)
@Module
object CountryStoreModule {
    @Provides
    @Singleton
    fun provideCountryStore(
        countryDao: CountryDao,
        countryDataSource: CountryDataSource
    ): CountryStore = StoreBuilder.from<Int, List<CountryEntity>, List<CountryEntity>>(
        fetcher = Fetcher.of { id: Int ->
            countryDataSource.getAllCountries().also {
                if (it is Success<*>) {
                    it.get()?.let { it1 -> countryDao.insertCountry(it1) }
                }
            }.getOrThrow()
        },
        sourceOfTruth = SourceOfTruth.of(
            reader = { key -> countryDao.getAllCountries() },
            writer = { id, response ->
                countryDao.insertCountry(response)
            },
            delete = {
                countryDao.deleteCountry(it)
            },
            deleteAll = countryDao::deleteCountryAll

        )
    ).build()

}
