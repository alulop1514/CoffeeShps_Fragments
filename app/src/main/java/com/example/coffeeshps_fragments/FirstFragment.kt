package com.example.coffeeshps_fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshps_fragments.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta("Antico Caffe Greco", R.drawable.images, "St. Italy, Rome"))
        items.add(Tarjeta("Coffee Room", R.drawable.images1, "St. Germany, Berlin"))
        items.add(Tarjeta("Coffee Ibiza", R.drawable.images2, "St. Colon, Madrid"))
        items.add(Tarjeta("Pudding Coffee Shop", R.drawable.images3, "St. Diagonal, Barcelona"))
        items.add(Tarjeta("L' Express", R.drawable.images4, "St. Picadilly Circus, London"))
        items.add(Tarjeta("Coffe corner", R.drawable.images5, "St. Angel Guimera, Valencia"))
        items.add(Tarjeta("Sweet Cup", R.drawable.images6, "St. Kinkerstraat, Amsterdam"))

        val recView: RecyclerView = binding.recyclerView
        recView.hasFixedSize()
        val adaptador = CardsAdapter(items)
        adaptador.onClick = {
            val item = items[recView.getChildAdapterPosition(it)]
            val bundle = androidx.core.os.bundleOf("titulo" to item.titulo)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
         }
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this.context)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}