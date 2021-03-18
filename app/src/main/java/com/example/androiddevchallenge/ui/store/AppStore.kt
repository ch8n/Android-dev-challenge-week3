package com.example.androiddevchallenge.ui.store

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

object AppStore : CoroutineScope {
    private val _state = mutableStateOf(AppState.default())
    val state: State<AppState> = _state

    fun update(values: AppState.() -> AppState) {
        val currentState = _state.value.deepCopy()
        val updatedState = values.invoke(currentState)
        _state.value = updatedState
    }

    fun updateAsync(values: AppState.() -> AppState) = synchronized(this) {
        launch(Dispatchers.IO) {
            val currentState = _state.value.deepCopy()
            println("current:$currentState")
            val updatedState = values.invoke(currentState)
            println("updated:$currentState")
            _state.value = updatedState
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Job()

}

data class AppState(
    val email: String,
    val password: String
) {

    companion object {
        fun default() = AppState(
            email = "",
            password = "",
        )
    }
}

inline fun <reified T> T.deepCopy(): T {
    return Gson().fromJson(Gson().toJson(this), T::class.java)
}
