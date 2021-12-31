package uz.unzosoft.composecleanarchitecture.domain.useCase.getActive

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import uz.unzosoft.composecleanarchitecture.data.dto.toActive
import uz.unzosoft.composecleanarchitecture.domain.model.Active
import uz.unzosoft.composecleanarchitecture.domain.repository.ActiveRepository
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.resource.Resource
import java.io.IOException
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 18/12/21 03:27.
 * company QQBank
 * shahzod9933@gmail.com
 */
class ActiveUseCase @Inject constructor(
    private val repository: ActiveRepository
) {
    operator fun invoke(): Flow<Resource<List<Active>>> = flow {
        try {
            emit(Resource.Loading<List<Active>>())
            val active = repository.getActive().map { activeDto -> activeDto.toActive() }
            emit(Resource.Success<List<Active>>(active))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Active>>(e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error<List<Active>>("Check your internet!!!"))
        }
    }
}