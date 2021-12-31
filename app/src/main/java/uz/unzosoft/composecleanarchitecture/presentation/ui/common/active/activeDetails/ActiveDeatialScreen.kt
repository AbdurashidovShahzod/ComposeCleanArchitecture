package uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeDetails

import androidx.compose.foundation.layout.*
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
import com.google.accompanist.flowlayout.FlowRow
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeDetails.components.ActiveTag
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeList.components.ActiveListItem
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.resource.Screen


/**
 * Created by Abdurashidov Shahzod on 31/12/21 21:50.
 * company QQBank
 * shahzod9933@gmail.com
 */
@Composable
fun ActiveDetailsScreen(
    vm: ActiveDetailsVM = hiltViewModel()
) {
    val state = vm.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.active?.let { activeDetails ->
            LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)) {
                item() {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${activeDetails.rank}. ${activeDetails.name} ${activeDetails.symbol}",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if (activeDetails.isActive) "active" else "InActive",
                            color = if (activeDetails.isActive) Color.Green else Color.Red,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2f)
                        )
                        Text(
                            text = "${activeDetails.description}",
                            style = MaterialTheme.typography.h2,
                        )
                        Text(
                            text = "Tags",
                            style = MaterialTheme.typography.h3,
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        FlowRow(
                            mainAxisSpacing = 10.dp,
                            crossAxisSpacing = 10.dp,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            activeDetails.tags.forEach {
                                ActiveTag(tag = it)
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Team members",
                            style = MaterialTheme.typography.h3,
                        )
                        Spacer(modifier = Modifier.height(15.dp))

                    }

                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)

            )
        }
    }
}