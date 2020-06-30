package com.thiqah.newssample.presentation.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.thiqah.hiltsample.R
import com.thiqah.newssample.base.model.ResourceState
import com.thiqah.newssample.presentation.view.adapter.NewsAdapter
import com.thiqah.newssample.presentation.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    @Inject
    lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        initRecyclerView()
        loadNews()
    }

    private fun initRecyclerView() {
        rcNews.adapter = newsAdapter
        rcNews.layoutManager = LinearLayoutManager(this)
    }

    private fun loadNews() {
        newsViewModel.getNews()
        newsViewModel.newsLiveData.observe(this, Observer {

            if (it.state == ResourceState.LOADING) {
                pbNews.visibility = View.VISIBLE
            } else {
                pbNews.visibility = View.GONE

                if (it.state == ResourceState.SUCCESS) {
                    newsAdapter.apply {
                        this.news = it.data
                        notifyDataSetChanged()
                    }
                }
            }
        })
    }
}