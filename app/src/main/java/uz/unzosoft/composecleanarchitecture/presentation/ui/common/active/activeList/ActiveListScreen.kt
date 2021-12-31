package uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


/**
 * Created by Abdurashidov Shahzod on 31/12/21 21:50.
 * company QQBank
 * shahzod9933@gmail.com
 */
@Composable
fun ActiveListScreen(
    navController: NavController,
    vm: ActiveListVM = hiltViewModel()
) {
    val state = vm.state.value
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.active){active->

            }
        }
    }
}