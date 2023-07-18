package com.booknara.githubrepo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booknara.githubrepo.network.GithubRepository
import com.booknara.githubrepo.data.Result3
import com.booknara.githubrepo.data.adapter.DataAdapter
import com.booknara.githubrepo.data.model.GithubResponseModel
import com.booknara.githubrepo.data.model.MyData
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GithubRepository) : ViewModel() {

    private val _githubResponseData = MutableLiveData<Result3<GithubResponseModel>>()
    val githubResponseData : LiveData<Result3<GithubResponseModel>> = _githubResponseData

    var dataAdapter: DataAdapter = DataAdapter()

    init {
        makeApiCall()
    }
    fun getAdapter(): DataAdapter {
        return dataAdapter
    }

    fun setAdapterData(data : ArrayList<MyData>){
        dataAdapter.setData(data)
        dataAdapter.notifyDataSetChanged()
    }

    fun makeApiCall(input: String?=null) {
        repository.getAllRepository("kotlin").enqueue(object : retrofit2.Callback<GithubResponseModel> {
            override fun onFailure(call: Call<GithubResponseModel>, t: Throwable) {
                //_githubResponseData.value = Result2.Error(t.message)
            }

            override fun onResponse(
                call: Call<GithubResponseModel>,
                response: Response<GithubResponseModel>
            ) {
               /* if (!response.isSuccessful()) _githubResponseData.value =
                    null else _githubResponseData.value = response.body()*/
                if (response.isSuccessful) {
                    /*_githubResponseData.postValue(Result2.Success(response.body()!!))*/
                    _githubResponseData.postValue(Result3.Success(response.body()!!))
                }

            }


        })

    }
}
