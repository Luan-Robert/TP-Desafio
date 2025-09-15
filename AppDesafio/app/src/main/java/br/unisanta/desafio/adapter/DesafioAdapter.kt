package br.unisanta.desafio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.desafio.R
import br.unisanta.desafio.model.Desafio

class DesafioAdapter(private val desafios: List<Desafio>) :
    RecyclerView.Adapter<DesafioAdapter.DesafioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DesafioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_desafio, parent, false)
        return DesafioViewHolder(view)
    }


    override fun onBindViewHolder(holder: DesafioViewHolder, position: Int) {
//        val desafio = desafios[position]
//        holder.bind(desafio)
    }


    override fun getItemCount(): Int {
        return desafios.size
    }

    class DesafioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val textViewEmail: TextView = itemView.findViewById(R.id.txv_email_usuario)

//        fun bind(desafio: Desafio) {
//            textViewEmail.text = desafio.nome
//        }
    }
}