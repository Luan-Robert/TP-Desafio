package br.unisanta.desafio.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.desafio.R
import br.unisanta.desafio.model.DesafioDaoImpl

class ListaDesafiosActivity : AppCompatActivity(R.layout.activity_lista_desafios) {
    private val dao = DesafioDaoImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvDesafios = findViewById<RecyclerView>(R.id.rv_desafios)
        val listaDeDesafios = dao.obterDesafios()

        rvDesafios.layoutManager = LinearLayoutManager(this)

//        val adapter = DesafioAdapter(listaDeDesafios)
//        rvDesafios.adapter = adapter
    }
}