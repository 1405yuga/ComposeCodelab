package com.example.marsphoto.fake

import com.example.marsphoto.rules.TestDispatcherRule
import com.example.marsphoto.ui.screens.MarsUiState
import com.example.marsphoto.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() =
        runTest {
            val marsViewModel =
                MarsViewModel(marsPhotosRepository = FakeNetworkMarsPhotosRepository())
            assertEquals(
                MarsUiState.Success(FakeDataSource.photosList),
                marsViewModel.marsUiState
            )
        }
}