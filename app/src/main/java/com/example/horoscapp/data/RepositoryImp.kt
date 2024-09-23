package com.example.horoscapp.data

import android.util.Log
import com.example.horoscapp.data.network.HoroscopeApiService
import com.example.horoscapp.domain.PredictionModel
import com.example.horoscapp.domain.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val apiService:HoroscopeApiService) :Repository {


    override suspend fun getPrediction(sign: String):PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("wea", "Ha ocurrido un error ${it.message}") }

        return null
    }

}