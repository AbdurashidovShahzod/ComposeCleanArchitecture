package uz.unzosoft.composecleanarchitecture.data.dto

import com.google.gson.annotations.SerializedName
import uz.unzosoft.composecleanarchitecture.domain.model.Active

data class ActiveDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun ActiveDto.toActive(): Active {
    return Active(
        id = id, isActive = isActive, name = name, rank = rank, symbol = symbol
    )
}