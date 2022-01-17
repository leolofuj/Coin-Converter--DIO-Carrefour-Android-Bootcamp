package com.leonardo.myappcoinconverter.domain

import com.leonardo.myappcoinconverter.core.UseCase
import com.leonardo.myappcoinconverter.data.model.ExchangeResponseValue
import com.leonardo.myappcoinconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class ListExchangeUseCase(
    private val repository: CoinRepository
) : UseCase.NoParam<List<ExchangeResponseValue>>() {

    override suspend fun execute(): Flow<List<ExchangeResponseValue>> {
        return repository.list()
    }
}