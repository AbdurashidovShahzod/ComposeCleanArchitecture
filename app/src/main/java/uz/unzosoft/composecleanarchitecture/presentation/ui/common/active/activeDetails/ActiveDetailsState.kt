package uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeDetails

import uz.unzosoft.composecleanarchitecture.domain.model.Active
import uz.unzosoft.composecleanarchitecture.domain.model.ActiveDetails


/**
 * Created by Abdurashidov Shahzod on 31/12/21 21:12.
 * company QQBank
 * shahzod9933@gmail.com
 */
data class ActiveDetailsState(
    val isLoading: Boolean = false,
    val active: ActiveDetails? = null,
    val error: String = ""
)