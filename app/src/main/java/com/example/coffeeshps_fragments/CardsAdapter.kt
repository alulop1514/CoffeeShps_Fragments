package com.example.coffeeshps_fragments

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class CardsAdapter (var items: ArrayList<Tarjeta>) : RecyclerView.Adapter<CardsAdapter.TarjViewHolder>(){
    lateinit var onClick: (View)->Unit

    init{
        this.items=items
    }

    class TarjViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){

        var foto:ImageView
        var boton : Button
        var ratingBar : RatingBar
        var titulo : TextView
        var localizacion : TextView
        var notaRating : TextView

        init{
            foto=itemView.findViewById(R.id.image)
            boton = itemView.findViewById(R.id.button)
            ratingBar = itemView.findViewById(R.id.ratingBar)
            titulo = itemView.findViewById(R.id.titulo)
            localizacion = itemView.findViewById(R.id.localizacion)
            notaRating = itemView.findViewById(R.id.notaRating)
        }

        fun bindTarjeta(t:Tarjeta,onClick:(View)->Unit)=with(itemView) {
            foto.setImageResource(t.imagen)
            titulo.text = t.titulo
            localizacion.text = t.localizacion
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup:ViewGroup,viewType:Int):TarjViewHolder{
        val itemView=
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item,viewGroup,false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder:TarjViewHolder,pos:Int) {
        val itemcard = items.get(pos)
        viewHolder.bindTarjeta(itemcard, onClick)
        viewHolder.ratingBar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener() {
                _, fl, b -> viewHolder.notaRating.text = fl.toString()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}