package com.example.asus.mynetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomnavigation.BottomNavigationView

class Feed : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var feed = dataInit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        Glide.with(this).load(R.drawable.my_net_work_logo).apply(RequestOptions.centerCropTransform())
            .into(findViewById(R.id.backdrop))


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.all ->{
                    updateActivity(feed)
                }

                R.id.notification ->{
                    val data: List<New> =
                        feed.filter { i -> i.type.findAnyOf(listOf("Notification")) != null }
                    updateActivity(data)
                }

                R.id.news ->{
                    val data: List<New> =
                        feed.filter { i -> i.type.findAnyOf(listOf("News")) != null }
                    updateActivity(data)
                }
            }
            true
        }

        updateActivity(feed)


    }

    //update cardViews to data array
    private fun updateActivity(data: List<New>) {
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(data)

        recyclerView = findViewById<RecyclerView>(R.id.list).apply {

            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter

        }
    }

    private fun dataInit(): List<New> =
        listOf(
            New(
                "Уведомление",
                "Здесь находится текст",
                R.drawable.dollar,
                "Notification"
            ),
            New(
                "Новость",
                "Здесь находится текст",
                R.drawable.dollar,
                "News"
            ),
            New(
                "Новость",
                "Здесь находится текст",
                R.drawable.dollar,
                "News"
            ),
            New(
                "Новость",
                "Здесь находится текст",
                R.drawable.dollar,
                "News"
            ),
            New(
                "Уведомление",
                "Здесь находится текст",
                R.drawable.dollar,
                "Notification"
            ),
            New(
                "Уведомление",
                "Здесь находится текст",
                R.drawable.dollar,
                "Notification"
            )

        )


}


/*   */
