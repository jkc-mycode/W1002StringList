package kr.ac.kumoh.s20201414.w1002stringlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kr.ac.kumoh.s20201414.w1002stringlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var songs = arrayOf(
        "It's my Life", "소주 한잔", "너너너", "Ghost Town",
        "It's my Life", "소주 한잔", "너너너", "Ghost Town",
        "It's my Life", "소주 한잔", "너너너", "Ghost Town",
        "It's my Life", "소주 한잔", "너너너", "Ghost Town",
        "It's my Life", "소주 한잔", "너너너", "Ghost Town",
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.list.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, songs
        )

        binding.list.setOnItemClickListener{ _, _, i, _ ->
            val uri = Uri.parse("http://www.youtube.com/results?search_query=노래방 " + songs[i])
            val youtube = Intent(Intent.ACTION_VIEW, uri)
            startActivity(youtube)
        }
    }
}