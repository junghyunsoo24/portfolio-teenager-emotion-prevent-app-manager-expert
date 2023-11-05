package com.example.portfolioteenageremotionpreventappexpertandmanager

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.portfolioteenageremotionpreventappexpertandmanager.appViewModel.AppViewModel
import com.example.portfolioteenageremotionpreventappexpertandmanager.databinding.ActivityAllMainBinding

class AllMainActivity : AppCompatActivity() {
    private lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = AppViewModel.getInstance()

        val actionBar: ActionBar? = supportActionBar

        actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar?.setCustomView(R.layout.actionbar_all)

        val actionBarTitle = actionBar?.customView?.findViewById<TextView>(R.id.actionBarAll)
        actionBarTitle?.text = "하루친구(전문가,관리자)"

        actionBar?.setDisplayHomeAsUpEnabled(true)

        val binding = ActivityAllMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.expertBtn.setOnClickListener {
            viewModel.setUser("1")
            onStartButtonClicked()
        }

        binding.managerBtn.setOnClickListener {
            viewModel.setUser("2")
            onStartButtonClicked()
        }

    }

    private fun onStartButtonClicked() {
        val intent = Intent(this, AllLoginActivity::class.java)
        startActivity(intent)
    }

}