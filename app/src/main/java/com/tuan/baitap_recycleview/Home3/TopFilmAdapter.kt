package com.tuan.baitap_recycleview.Home3


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tuan.baitap_recycleview.databinding.ItemFilmBinding


class TopFilmAdapter : RecyclerView.Adapter<TopFilmAdapter.TopFilmViewHolder>(),Filterable {

    private val listDataFilm     = ArrayList<Top_Film>()
    private var listDataFilmFiltered = ArrayList<Top_Film>()
    var onClickItem : ((Top_Film) -> Unit)? = null

    inner class TopFilmViewHolder(val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(TopFilm: Top_Film) {
            binding.imgFilm.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.imgFilm.context,
                    TopFilm.image
                )
            )
            binding.tvFilmName.text = TopFilm.filmName

            binding.root.setOnClickListener {
                onClickItem?.invoke(TopFilm)
            }

        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopFilmViewHolder {
        return TopFilmViewHolder(
            ItemFilmBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return listDataFilmFiltered.size
    }

    override fun onBindViewHolder(holder: TopFilmViewHolder, position: Int) {
        holder.bind(listDataFilmFiltered[position])
    }

    override fun getFilter(): Filter {
            return object : Filter(){
                override fun performFiltering(constraint: CharSequence?): FilterResults {
                    val charString = constraint.toString()
                    listDataFilmFiltered = if (charString.isEmpty()){
                        listDataFilm
                    }else{
                        val filterList = ArrayList<Top_Film>()
                        for(film in listDataFilm){
                            if((film.filmName).lowercase().contains((charString.lowercase()))){
                                filterList.add(film)
                            }
                        }
                        filterList
                    }
                    val filterResult = FilterResults()
                    filterResult.values = listDataFilmFiltered
                    return filterResult
                }

                override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                    listDataFilmFiltered = results?.values as ArrayList<Top_Film>
                    notifyDataSetChanged()
                }
            }
    }

    fun setupData(newData : List<Top_Film>){
        listDataFilm.clear().also {
            listDataFilm.addAll(newData)
            filter.filter("")
        }
    }


}
