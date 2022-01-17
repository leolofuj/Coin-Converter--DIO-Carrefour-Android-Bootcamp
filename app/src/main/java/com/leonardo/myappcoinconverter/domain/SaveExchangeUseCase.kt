package br.com.dio.coinconverter.domain

import com.leonardo.myappcoinconverter.core.UseCase
import com.leonardo.myappcoinconverter.data.model.ExchangeResponseValue
import com.leonardo.myappcoinconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveExchangeUseCase(
    private val repository: CoinRepository
) : UseCase.NoSource<ExchangeResponseValue>() {

    override suspend fun execute(param: ExchangeResponseValue): Flow<Unit> {
        return flow {
            repository.save(param)
            emit(Unit)
        }
    }
}