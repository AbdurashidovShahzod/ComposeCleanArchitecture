package uz.unzosoft.composecleanarchitecture.domain.repository

import uz.unzosoft.composecleanarchitecture.data.dto.ActiveDetailsDto
import uz.unzosoft.composecleanarchitecture.data.dto.ActiveDto


/**
 * Created by Abdurashidov Shahzod on 18/12/21 03:17.
 * company QQBank
 * shahzod9933@gmail.com
 */
interface ActiveRepository {
    suspend fun getActive(): List<ActiveDto>
    suspend fun getActiveDetailById(activeId: String): ActiveDetailsDto
}