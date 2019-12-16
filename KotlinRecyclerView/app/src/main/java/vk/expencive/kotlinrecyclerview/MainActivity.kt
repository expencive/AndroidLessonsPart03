package vk.expencive.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter: BlogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        blogAdapter.submintList(data)

    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpasingDecoration = TopSpasingItemDecoration(30)
            addItemDecoration(topSpasingDecoration)
            blogAdapter = BlogRecyclerAdapter()
            adapter = blogAdapter


        }

//        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
//        blogAdapter = BlogRecyclerAdapter()
//        recycler_view.adapter = blogAdapter
    }
}
