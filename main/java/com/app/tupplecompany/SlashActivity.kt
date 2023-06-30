package com.app.tupplecompany

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.tupplecompany.databinding.ActivitySlashBinding

class SlashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySlashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySlashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread({
            Thread.sleep(3000)
        }).start()
        startActivity(Intent(this,MainActivity::class.java))


    }
}