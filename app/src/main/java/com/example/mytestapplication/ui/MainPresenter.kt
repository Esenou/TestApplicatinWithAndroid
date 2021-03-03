package com.example.mytestapplication.ui

import com.example.mytestapplication.StartApplication
import com.example.mytestapplication.model.DataRandom
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {

    override fun getData() {
        if (isViewAttached()) {
            view.showProgress()
            StartApplication.service.getDataRandom().enqueue(
                object : Callback<List<DataRandom>> {
                    override fun onResponse(
                        call: Call<List<DataRandom>>,
                        response: Response<List<DataRandom>>
                    ) {
                        if (isViewAttached()) {
                            if (response!!.isSuccessful && response != null) {
                                view.onSuccessFull(response.body()!!)
                            } else
                                view.onFailure()
                            view.hideProgress()
                        }
                    }

                    override fun onFailure(call: Call<List<DataRandom>>, t: Throwable) {
                        if (isViewAttached()) {
                            view.hideProgress()
                        }
                        t?.printStackTrace()
                    }

                }
            )

        }
    }

    fun isViewAttached(): Boolean = view != null
}
