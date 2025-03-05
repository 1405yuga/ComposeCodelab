package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.ui.data.PlacesData
import com.example.mycity.ui.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun setCategory(category: Category) {
        _uiState.update { currentState ->
            currentState.copy(categorySelected = category)
        }
    }

    fun setPlaceDetailsByIndex(index: Int) {
        _uiState.update {
            it.copy(
                placeSelected = PlacesData.getPlaceDetails(
                    category = uiState.value.categorySelected,
                    index = index
                ) ?: PlacesData.getBlankPlaceDetail()
            )
        }
    }
}