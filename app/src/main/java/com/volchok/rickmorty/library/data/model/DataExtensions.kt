package com.volchok.space_x.library.data.model

import com.volchok.rickmorty.library.data.model.Data

/**
 * Invoke the given block of code in try-catch block and return a [Data] object with the result.
 * @param block the block of code to execute
 * @return [Data] object with the result of the block
 */
suspend fun <O> safeCall(block: suspend () -> O): Data<O> {
    return try {
        val result = block()
        Data.Success(result)
    } catch (e: Exception) {
        Data.Error(e)
    }
}