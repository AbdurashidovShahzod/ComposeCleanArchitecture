package uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeDetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.unzosoft.composecleanarchitecture.domain.model.Active
import uz.unzosoft.composecleanarchitecture.domain.useCase.getActive.ActiveUseCase
import uz.unzosoft.composecleanarchitecture.domain.useCase.getActives.ActivesUseCase
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.constants.Constants
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.resource.Resource
import java.util.*
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 31/12/21 20:48.
 * company QQBank
 * shahzod9933@gmail.com
 */
@HiltViewModel
class ActiveDetailsVM @Inject constructor(
    private val useCase: ActivesUseCase,
    private val stateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(ActiveDetailsState())
    val state: State<ActiveDetailsState> get() = _state

    init {
        stateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getActive(it)
        }
    }

    private fun getActive(activeId:String) {
        useCase(activeId).onEach { result ->
            when (result) {
                is Resource.Loading -> {_state.value = ActiveDetailsState(isLoading = true) }
                is Resource.Success -> {_state.value = ActiveDetailsState(active = result.data)}
                is Resource.Error -> {_state.value = ActiveDetailsState(error = result.message?:"Aniqlanmagan xatolik")}
            }

        }.launchIn(viewModelScope)
    }

}
