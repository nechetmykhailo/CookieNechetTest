package ua.com.cookienechettest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import ua.com.cookienechettest.R
import ua.com.cookienechettest.model.Sea

class RecyclerAllImageAdapter(context: Context, val callback: Callback) : RecyclerView.Adapter<RecyclerAllImageAdapter.AllImageHolder>(){
    var list : List<Sea> = listOf()

    interface Callback {
        fun onItemClicked(item: Sea)
    }

    fun setMovieListItems(movieList: List<Sea>){
        this.list = movieList;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)
        return AllImageHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: AllImageHolder, position: Int) {
        Picasso.get().load(list[position].image).into(holder.ivSea)
        holder.tvAuthor.text = list[position].tittle

        holder.itemView.setOnClickListener { callback.onItemClicked(list[position]) }
    }

    class AllImageHolder(v: View) : RecyclerView.ViewHolder(v){
        val ivSea: AppCompatImageView = v.findViewById(R.id.ivSea)
        val tvAuthor: MaterialTextView = v.findViewById(R.id.tvAuthor)
    }
}