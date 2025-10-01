package com.xyz.iptv

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.channelList)
        recycler.layoutManager = LinearLayoutManager(this)

        val channels = listOf(
            Channel("ANTV", "https://example.com/antv.m3u8"),
            Channel("TransTV", "https://example.com/transtv.m3u8")
        )
        recycler.adapter = ChannelAdapter(channels) { channel ->
            val intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra("STREAM_URL", channel.url)
            startActivity(intent)
        }
    }
}
