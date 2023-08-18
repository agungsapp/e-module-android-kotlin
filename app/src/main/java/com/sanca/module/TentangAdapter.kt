package com.sanca.module

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TentangAdapter(
    private val imageList: List<Int>,
    private val namaList: List<String>
) : RecyclerView.Adapter<TentangAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

return ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.tentang_adapter, parent, false)
)


    }

    override fun getItemCount(): Int {
        return namaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name  = namaList[position]
        holder.image.setImageResource(imageList[position])
        holder.nama.text = namaList[position]

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.imageDosen)
        val nama = itemView.findViewById<TextView>(R.id.namaDosen)
    }

}