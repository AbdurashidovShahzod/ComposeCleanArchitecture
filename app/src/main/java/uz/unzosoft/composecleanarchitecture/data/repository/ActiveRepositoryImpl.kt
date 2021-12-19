package uz.unzosoft.composecleanarchitecture.data.repository

import uz.unzosoft.composecleanarchitecture.data.dto.ActiveDetailsDto
import uz.unzosoft.composecleanarchitecture.data.dto.ActiveDto
import uz.unzosoft.composecleanarchitecture.data.remote.ActiveApi
import uz.unzosoft.composecleanarchitecture.domain.repository.ActiveRepository
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 18/12/21 03:21.
 * company QQBank
 * shahzod9933@gmail.com
 */
class ActiveRepositoryImpl @Inject constructor(
    private val api: ActiveApi
) : ActiveRepository {
    override suspend fun getActive(): List<ActiveDto> {
        return api.getActive()
    }

    override suspend fun getActiveDetailById(activeId: String): ActiveDetailsDto {
        return api.getActiveById(activeId)
    }
}