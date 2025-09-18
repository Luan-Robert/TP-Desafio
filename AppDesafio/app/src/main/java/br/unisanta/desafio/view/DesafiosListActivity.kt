package br.unisanta.desafio.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.desafio.R
import br.unisanta.desafio.adapter.DesafioAdapter
import br.unisanta.desafio.model.DesafioDaoImpl

class DesafiosListActivity : AppCompatActivity(R.layout.activity_desafios_list) {

    private lateinit var adapter: DesafioAdapter
    private val desafioDao = DesafioDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvDesafios = findViewById<RecyclerView>(R.id.rv_desafios)
        val listaDeDesafios = desafioDao.obterDesafios().toMutableList()

        adapter = DesafioAdapter(listaDeDesafios) { desafio, position ->

            desafioDao.excluir(desafio)
            adapter.removerItem(position)
        }

        rvDesafios.layoutManager = LinearLayoutManager(this)
        rvDesafios.adapter = adapter
    }
}