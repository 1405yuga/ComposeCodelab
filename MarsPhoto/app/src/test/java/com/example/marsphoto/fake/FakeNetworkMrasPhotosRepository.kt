package com.example.marsphoto.fake

import com.example.marsphoto.data.MarsPhotoRepository
import com.example.marsphoto.network.MarsPhoto

class FakeNetworkMarsPhotosRepository : MarsPhotoRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }

}