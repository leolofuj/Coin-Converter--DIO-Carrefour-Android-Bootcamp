package com.leonardo.myappcoinconverter.domain

import com.leonardo.myappcoinconverter.core.UseCase
import com.leonardo.myappcoinconverter.data.model.ExchangeResponseValue
import com.leonardo.myappcoinconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetExchangeValueUseCase(
    private val repository: CoinRepository
) : UseCase<String, ExchangeResponseValue>() {

    override suspend fun execute(param: String): Flow<ExchangeResponseValue> {
        return repository.getExchangeValue(param)
    }

}