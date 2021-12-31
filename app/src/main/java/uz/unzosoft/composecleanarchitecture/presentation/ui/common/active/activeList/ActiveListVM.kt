package uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.unzosoft.composecleanarchitecture.domain.model.Active
import uz.unzosoft.composecleanarchitecture.domain.useCase.getActive.ActiveUseCase
import uz.unzosoft.composecleanarchitecture.domain.useCase.getActives.ActivesUseCase
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.resource.Resource
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 31/12/21 20:48.
 * company QQBank
 * shahzod9933@gmail.com
 */
@HiltViewModel
class ActiveListVM @Inject constructor(
    private val useCase: ActiveUseCase
) : ViewModel() {
    private val _state = mutableStateOf(ActiveListState())
    val state: State<ActiveListState> get() = _state

    init {
        getActive()
    }

    private  fun getActive() {
        useCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {_state.value = ActiveListState(isLoading = true) }
                is Resource.Success -> {_state.value = ActiveListState(active = result.data ?: emptyList())}
                is Resource.Error -> {_state.value = ActiveListState(error = result.message?:"Aniqlanmagan xatolik")}
            }

        }.launchIn(viewModelScope)
    }

}
