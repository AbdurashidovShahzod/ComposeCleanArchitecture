package uz.unzosoft.composecleanarchitecture.domain.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Abdurashidov Shahzod on 17/12/21 17:24.
 * company QQBank
 * shahzod9933@gmail.com
 */
data class Active(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)