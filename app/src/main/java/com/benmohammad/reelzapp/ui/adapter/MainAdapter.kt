package com.benmohammad.reelzapp.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.benmohammad.reelzapp.R
import com.benmohammad.reelzapp.data.model.Snippet
import com.benmohammad.reelzapp.ui.view.MainActivity
import kotlinx.android.synthetic.main.snippet_item.view.*

class MainAdapter(private val snippets: ArrayList<Snippet>): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {



    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(snippet: Snippet) {
            itemView.title.text = snippet.title
            itemView.setOnClickListener {
                if(adapterPosition != RecyclerView.NO_POSITION) {
                    val context = itemView.context
                    val intent = Intent(context, MainActivity::class.java)
                    intent.putExtra("snippet", snippet.code)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.snippet_item, parent, false))

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(snippets[position])
    }

    override fun getItemCount(): Int = snippets.size

    fun addData(list: List<Snippet>){
        snippets.addAll(list)
    }





}
