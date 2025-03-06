package com.example.marsphoto.data

import com.example.marsphoto.network.MarsApi
import com.example.marsphoto.network.MarsPhoto

interface MarsPhotoRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository():MarsPhotoRepository{
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return MarsApi.retrofitService.getPhotos()
    }

}