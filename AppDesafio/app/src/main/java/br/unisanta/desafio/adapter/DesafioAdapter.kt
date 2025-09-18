package br.unisanta.desafio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.desafio.R
import br.unisanta.desafio.model.Desafio
import com.bumptech.glide.Glide

class DesafioAdapter(private val desafios: MutableList<Desafio>, private val onExcluirClick: (Desafio) -> Unit) :
    RecyclerView.Adapter<DesafioAdapter.DesafioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DesafioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_desafio, parent, false)
        return DesafioViewHolder(view)
    }


    override fun onBindViewHolder(holder: DesafioViewHolder, position: Int) {
        val desafio = desafios[position]
        holder.bind(desafio)
    }


    override fun getItemCount(): Int {
        return desafios.size
    }

    fun remover(desafio: Desafio) {
        val index = desafios.indexOf(desafio)
        if (index != -1) {
            desafios.removeAt(index)
            notifyItemRemoved(index)
        }
    }
    inner class DesafioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewNome: TextView = itemView.findViewById(R.id.txv_nome)
        private val textViewValor: TextView = itemView.findViewById(R.id.txv_valor)
        private val imageViewURL: ImageView = itemView.findViewById(R.id.img_url)
        private val btnExcluir: Button = itemView.findViewById(R.id.btn_excluir)

        fun bind(desafio: Desafio) {
            btnExcluir.setOnClickListener {
                onExcluirClick(desafio)
            }
            textViewNome.text = desafio.nome
            textViewValor.text = desafio.valor
            val url = desafio.url
            if(!url.isNullOrBlank())
            {
                Glide.with(itemView.context)
                    .load(url)
                    .into(imageViewURL)
            }
            else
            {
                imageViewURL.setImageResource(R.drawable.bottom_shape)
            }

        }
    }
}
