package com.example.portfolioteenageremotionpreventappexpertandmanager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.portfolioteenageremotionpreventappexpertandmanager.R
import com.example.portfolioteenageremotionpreventappexpertandmanager.teenagerList.Teenager

class TeenagerListAdapter(var managerTeenagerList: List<Teenager>, private val onItemClick: (Teenager) -> Unit) : RecyclerView.Adapter<TeenagerListAdapter.ManagerTeenagerViewHolder>() {

    class ManagerTeenagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val managerTeenagerInfoTextView: TextView = itemView.findViewById(R.id.managerTeenagerInfoTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManagerTeenagerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_manager_teenagerlist, parent, false)
        return ManagerTeenagerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ManagerTeenagerViewHolder, position: Int) {
        val teenager = managerTeenagerList[position]
        var gender = "0"
        if(teenager.gender == "0") {
            gender = "남"
        }
        else if(teenager.gender == "1"){
            gender = "여"
        }

        val teenagerInfo = String.format(
            " 아이디: %s\n 이름: %s\n 나이: %s\n 주소: %s\n 성별: %s\n 핸드폰번호: %s\n 위험 비율: %s",
            teenager.id, teenager.name, teenager.age, teenager.address, gender, teenager.phone_num, teenager.percentage)

        holder.managerTeenagerInfoTextView.text = teenagerInfo
        holder.itemView.setOnClickListener {
            onItemClick(teenager)
        }
    }

    override fun getItemCount() = managerTeenagerList.size
}