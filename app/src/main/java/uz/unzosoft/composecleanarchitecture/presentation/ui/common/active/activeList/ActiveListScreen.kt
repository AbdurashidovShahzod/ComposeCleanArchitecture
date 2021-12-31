package uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeList.components.ActiveListItem
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.resource.Screen


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
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.active) { active ->
                ActiveListItem(active = active, onItemClick = {
                    navController.navigate(Screen.ActiveDetailsScreen.route + "/${active.id}")
                })
            }

        }
        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color =  MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)

            )
        }
    }
}