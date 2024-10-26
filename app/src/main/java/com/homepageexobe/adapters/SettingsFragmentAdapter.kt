package com.homepageexobe.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.R
import com.homepageexobe.dataclass.SettingsFragmentModel
import com.homepageexobe.fragments.SettingsFragment

class SettingsFragmentAdapter(context: SettingsFragment, val settingsFragmentList: ArrayList<SettingsFragmentModel>):
    RecyclerView.Adapter<SettingsFragmentAdapter.SettingsFragmentViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SettingsFragmentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_for_fragment_settings, parent, false)
        return SettingsFragmentViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: SettingsFragmentViewHolder,
        position: Int
    ) {
        val item = settingsFragmentList[position]
        holder.icon.setImageResource(item.icon)
        holder.name.text = item.name
    }

    override fun getItemCount(): Int {
        return settingsFragmentList.size
    }
    inner class SettingsFragmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val icon: ImageView = itemView.findViewById(R.id.settings_image)
        val name: TextView = itemView.findViewById(R.id.settings_name)
    }

}