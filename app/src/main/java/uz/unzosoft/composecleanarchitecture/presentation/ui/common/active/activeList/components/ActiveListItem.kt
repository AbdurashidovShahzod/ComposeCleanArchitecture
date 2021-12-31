package uz.unzosoft.composecleanarchitecture.presentation.ui.common.active.activeList.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uz.unzosoft.composecleanarchitecture.domain.model.Active


/**
 * Created by Abdurashidov Shahzod on 31/12/21 21:38.
 * company QQBank
 * shahzod9933@gmail.com
 */
@Composable
fun ActiveListItem(
    active: Active,
    onItemClick: (Active) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(active) }
        .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween) {

        Text(
            text = "${active.rank}. ${active.name} (${active.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if (active.isActive) "active" else "InActive",
            color = if (active.isActive) Color.Green else Color.Red,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}