package com.example.mytestapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytestapplication.R
import com.example.mytestapplication.model.DataRandom
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, MainAdapter.Listener {

    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        swipeId.setOnRefreshListener {
            init()
        }
    }

    fun init() {
        presenter = MainPresenter(this)
        presenter.getData()
    }

    override fun onSuccessFull(list: List<DataRandom>) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewId?.layoutManager = GridLayoutManager(this, 1)
        recyclerViewId?.layoutManager = layoutManager
        adapter = MainAdapter(list, this)
        recyclerViewId.adapter = adapter
    }

    override fun onFailure() {
        Toast.makeText(this, "Error server!", Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        swipeId?.setRefreshing(true)
    }

    override fun hideProgress() {
        swipeId?.setRefreshing(false)
    }

    override fun setOnItemClick(position: DataRandom) {
        Toast.makeText(this, position.id.toString(), Toast.LENGTH_SHORT).show()
    }

}