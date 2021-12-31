package uz.unzosoft.composecleanarchitecture.presentation.ui.common.resource


/**
 * Created by Abdurashidov Shahzod on 31/12/21 21:57.
 * company QQBank
 * shahzod9933@gmail.com
 */
sealed class Screen(val route: String) {
    object ActiveListScreen : Screen("active_list_screen")
    object ActiveDetailsScreen : Screen("active_details_screen")
}
