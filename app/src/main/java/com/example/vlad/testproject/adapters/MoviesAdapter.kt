package com.example.vlad.testproject.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.vlad.testproject.R
import com.example.vlad.testproject.models.Movie
import com.squareup.picasso.Picasso

class MoviesAdapter(val movieList:ArrayList<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(v)
    }

    fun clearItems(){
        movieList.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
        Picasso.get().load(BASE_IMAGE_URL + movieList[position].image).into(holder.movieImage)
        holder.title.text = movieList[position].title
        holder.description.text = movieList[position].description
        holder.releaseDate.text = movieList[position].releaseDate
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var movieImage: ImageView
        lateinit var title: TextView
        lateinit var description: TextView
        lateinit var releaseDate: TextView

        init {
            movieImage=itemView.findViewById(R.id.movie_image)
            title=itemView.findViewById(R.id.movie_title)
            description=itemView.findViewById(R.id.description)
            releaseDate=itemView.findViewById(R.id.release_date)
        }
    }
}