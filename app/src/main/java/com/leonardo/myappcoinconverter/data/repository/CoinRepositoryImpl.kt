package com.leonardo.myappcoinconverter.data.repository

import com.leonardo.myappcoinconverter.core.exceptions.RemoteException
import com.google.gson.Gson
import com.leonardo.myappcoinconverter.data.database.AppDatabase
import com.leonardo.myappcoinconverter.data.model.ErrorResponse
import com.leonardo.myappcoinconverter.data.model.ExchangeResponseValue
import com.leonardo.myappcoinconverter.data.services.AwesomeService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CoinRepositoryImpl(
    appDatabase: AppDatabase,
    private val service: AwesomeService
) : CoinRepository {

    private val dao = appDatabase.exchangeDao()

    override suspend fun getExchangeValue(coins: String) = flow {
        try {
            val exchangeValue = service.exchangeValue(coins)
            val exchange = exchangeValue.values.first()
            emit(exchange)
        } catch (e: HttpException) {
            // {"status":404,"code":"CoinNotExists","message":"moeda nao encontrada USD-USD"}
            val json = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(json, ErrorResponse::class.java)
            throw RemoteException(errorResponse.message)
        }
    }

    override suspend fun save(exchange: ExchangeResponseValue) {
        dao.save(exchange)
    }

    override fun list(): Flow<List<ExchangeResponseValue>> {
        return dao.findAll()
    }
}