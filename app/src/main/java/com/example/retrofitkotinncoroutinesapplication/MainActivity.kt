package com.example.retrofitkotinncoroutinesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitkotinncoroutinesapplication.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val retrofitInstance = RetrofitInstance().getRetrofitInstance()
            .create(RetrofitInterface::class.java)
        val responseLiveDat:LiveData<Response<Albums>> = liveData {
            val response = retrofitInstance.getAlbums()
            emit(response)
        }
        responseLiveDat.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if(albumList!=null){
                while (albumList.hasNext()){
                    val albumListItem = albumList.next()
                    Log.d("Album data", albumListItem.toString())
                    val result = ""+"Album Title ${albumListItem.title}" +"\n"+
                                 "" + "Album id ${albumListItem.id}"+"\n"+
                                 "" + "Album User Id ${albumListItem.userId}"+"\n"
                    activityMainBinding.text.append(result)

                }
            }
        })
    }
}