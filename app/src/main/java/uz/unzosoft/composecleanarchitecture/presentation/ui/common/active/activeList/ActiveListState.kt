package uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeList

import uz.unzosoft.composecleanarchitecture.domain.model.Active


/**
 * Created by Abdurashidov Shahzod on 31/12/21 21:12.
 * company QQBank
 * shahzod9933@gmail.com
 */
data class ActiveListState(
    val isLoading: Boolean = false,
    val active: List<Active> = emptyList(),
    val error: String = ""
)