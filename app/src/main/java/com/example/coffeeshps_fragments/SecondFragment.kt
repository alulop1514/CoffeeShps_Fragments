package com.example.coffeeshps_fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshps_fragments.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titulo = requireArguments().getString("titulo")
        binding.tituloText.text = titulo.toString()
        val items = ArrayList<Tarjeta2>()
        items.add(Tarjeta2("Muy recomendable.\nVolvere seguro"))
        items.add(Tarjeta2("Acogedor. Muy buen ambiente"))
        items.add(Tarjeta2("Buenos precios"))
        items.add(Tarjeta2("Servicio algo flojo"))
        items.add(Tarjeta2("Para repetir...extensa carta de cafes"))

        val recView: RecyclerView = binding.recyclerView2
        val adaptador = CardsAdapter2(items)
        recView.hasFixedSize()
        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(this.context, 2)
        adaptador.onClick = {}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}