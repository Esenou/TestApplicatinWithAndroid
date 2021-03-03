package com.example.mytestapplication.ui

import app.superesenou.ru.example_neobis_translate.main.utils.IProgressBar
import com.example.mytestapplication.model.DataRandom

interface MainContract {
    interface View : IProgressBar {
        fun onSuccessFull(list: List<DataRandom>)
        fun onFailure()
    }

    interface Presenter {
        fun getData()
    }

}