package com.example.coffeeshps_fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class CardsAdapter2 (var items: ArrayList<Tarjeta2>) : RecyclerView.Adapter<CardsAdapter2.TarjViewHolder>(){
    lateinit var onClick: (View)->Unit

    init{
        this.items=items
    }

    class TarjViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){

        var titulo : TextView

        init{
            titulo = itemView.findViewById(R.id.titulo2)
        }

        fun bindTarjeta(t: Tarjeta2, onClick:(View)->Unit)=with(itemView) {
            titulo.text = t.titulo
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup:ViewGroup,viewType:Int):TarjViewHolder{
        val itemView=
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_fragment2,viewGroup,false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder:TarjViewHolder,pos:Int) {
        val itemcard = items.get(pos)
        viewHolder.bindTarjeta(itemcard, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}