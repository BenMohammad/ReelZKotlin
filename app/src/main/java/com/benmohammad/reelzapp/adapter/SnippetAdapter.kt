package com.benmohammad.reelzapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.benmohammad.reelzapp.R
import com.benmohammad.reelzapp.data.model.Snippet


class SnippetAdapter(private val snippets: List<Snippet>, val context: Context, val comm: Comm) :
    BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        if (view == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.snippet_item, null)
        }
        val content = view!!.findViewById<TextView>(R.id.title)
        content.text = snippets.get(p0).title
        content.setOnClickListener { comm.sendCodeToEditor(snippets.get(p0).title) }

        return view
    }

    override fun getItem(p0: Int): Snippet = snippets.get(p0)

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getCount(): Int = snippets.size
}