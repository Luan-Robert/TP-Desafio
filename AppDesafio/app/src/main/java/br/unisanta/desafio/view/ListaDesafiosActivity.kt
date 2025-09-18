package br.unisanta.desafio.view

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.desafio.R
import br.unisanta.desafio.adapter.DesafioAdapter
import br.unisanta.desafio.model.DesafioDao
import br.unisanta.desafio.model.DesafioDaoImpl

class ListaDesafiosActivity : AppCompatActivity(R.layout.activity_lista_desafios) {

    private lateinit var adapter:DesafioAdapter
    private lateinit var dao: DesafioDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dao = DesafioDaoImpl()
        val listaDesafios = dao.obterDesafios()

        val rvDesafios = findViewById<RecyclerView>(R.id.rv_desafios)
        val listaDeDesafios = dao.obterDesafios().toMutableList()

        adapter = DesafioAdapter(listaDeDesafios) { desafio ->
            dao.excluir(desafio)
            adapter.remover(desafio)
        }

        rvDesafios.layoutManager = LinearLayoutManager(this)
        rvDesafios.adapter = adapter
    }
}