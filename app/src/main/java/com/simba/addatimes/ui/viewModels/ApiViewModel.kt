package com.simba.addatimes.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simba.addatimes.data.models.OriginalResponse
import com.simba.addatimes.domain.GetOriginalsUseCase
import com.simba.addatimes.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApiViewModel @Inject constructor(
    private val getOriginalsUseCase: GetOriginalsUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(AddaTimesUiState())
    val uiState: StateFlow<AddaTimesUiState> = _uiState

    fun onTriggerEvent(event: UIEvent) {
        when (event) {
            is UIEvent.GetOriginalsData -> getOriginals()
        }
    }

    private fun getOriginals() {
        _uiState.update { it.copy(isDataLoading = true) }
        viewModelScope.launch {
            when (val result = getOriginalsUseCase(Unit)) {
                is Result.Error -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            message = "Something went wrong! Please try again."
                        )
                    }
                }
                Result.Loading -> {
                    _uiState.update { it.copy(isDataLoading = true) }
                }
                is Result.Success -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            data = result.data,
                        )
                    }
                }
            }
        }
    }

}

data class AddaTimesUiState(
    val isDataLoading: Boolean = false,
    val data: OriginalResponse? = null,
    val message: String? = null
)

sealed class UIEvent {
    object GetOriginalsData : UIEvent()
}