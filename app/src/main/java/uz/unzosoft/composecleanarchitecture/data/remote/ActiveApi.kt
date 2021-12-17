package uz.unzosoft.composecleanarchitecture.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import uz.unzosoft.composecleanarchitecture.data.dto.ActiveDto


/**
 * Created by Abdurashidov Shahzod on 17/12/21 16:45.
 * company QQBank
 * shahzod9933@gmail.com
 */
interface ActiveApi {
    @GET("/v1/coins")
    suspend fun getActive(): List<ActiveDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getActiveById(@Path("coinId") activeId:String)
}