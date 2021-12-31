package uz.unzosoft.composecleanarchitecture.domain.useCase.getActives

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import uz.unzosoft.composecleanarchitecture.data.dto.toActive
import uz.unzosoft.composecleanarchitecture.data.dto.toActiveDetail
import uz.unzosoft.composecleanarchitecture.domain.model.Active
import uz.unzosoft.composecleanarchitecture.domain.model.ActiveDetails
import uz.unzosoft.composecleanarchitecture.domain.repository.ActiveRepository
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.resource.Resource
import java.io.IOException
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 18/12/21 03:27.
 * company QQBank
 * shahzod9933@gmail.com
 */
class ActivesUseCase @Inject constructor(
    private val repository: ActiveRepository
) {
    operator fun invoke(activeId: String): Flow<Resource<ActiveDetails>> = flow {
        try {
            emit(Resource.Loading<ActiveDetails>())
            val active = repository.getActiveDetailById(activeId).toActiveDetail()
            emit(Resource.Success<ActiveDetails>(active))
        } catch (e: HttpException) {
            emit(Resource.Error<ActiveDetails>(e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error<ActiveDetails>("Check your internet!!!"))
        }
    }
}