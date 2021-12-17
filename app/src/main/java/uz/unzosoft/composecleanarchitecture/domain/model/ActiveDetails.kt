package uz.unzosoft.composecleanarchitecture.domain.model

import com.google.gson.annotations.SerializedName
import uz.unzosoft.composecleanarchitecture.data.dto.*
import uz.unzosoft.composecleanarchitecture.data.dto.ActiveDetailsDto


/**
 * Created by Abdurashidov Shahzod on 17/12/21 17:59.
 * company QQBank
 * shahzod9933@gmail.com
 */
data class ActiveDetails(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)