package br.unisanta.desafio.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.desafio.R
import br.unisanta.desafio.model.DesafioDaoImpl

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val dao = DesafioDaoImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val edtTitulo = findViewById<EditText>(R.id.edt_titulo)
//        val ckbAcao = findViewById<CheckBox>(R.id.ckb_acao)
//        val ckbTerror = findViewById<CheckBox>(R.id.ckb_terror)
//        val ckbCifi = findViewById<CheckBox>(R.id.ckb_cifi)
//        val ckbAnimacao = findViewById<CheckBox>(R.id.ckb_animacao)
//        val ckbMisterio = findViewById<CheckBox>(R.id.ckb_misterio)
//        val ckbRomance = findViewById<CheckBox>(R.id.ckb_romance)
//        val skbAvaliar = findViewById<SeekBar>(R.id.skb_avaliar)
//        val btnAdicionar = findViewById<Button>(R.id.btn_adicionar)
//        val btnLista = findViewById<Button>(R.id.btn_lista)





//        btnAdicionar.setOnClickListener{
//            val titulo = edtTitulo.text.toString()
//            val generos = mutableListOf<String>()
//            if (ckbAcao.isChecked) generos.add("Ação")
//            if (ckbTerror.isChecked) generos.add("Terror")
//            if (ckbCifi.isChecked) generos.add("Ficção Científica")
//            if (ckbAnimacao.isChecked) generos.add("Animação")
//            if (ckbMisterio.isChecked) generos.add("Mistério")
//            if (ckbRomance.isChecked) generos.add("Romance")
//            val genero = generos.joinToString(", ")
//            val avaliacao = skbAvaliar.progress
//            val filme = Filme(titulo, genero, avaliacao)
//            dao.adicionarFilme(filme)
//            val builder = AlertDialog.Builder(this)
//            builder.setTitle("Sucesso")
//            builder.setMessage("Cadastro OK!")
//            val alert = builder.create()
//            alert.show()
//            edtTitulo.text.clear()
//            ckbAcao.isChecked = false
//            ckbTerror.isChecked = false
//            ckbCifi.isChecked = false
//            ckbAnimacao.isChecked = false
//            ckbMisterio.isChecked = false
//            ckbRomance.isChecked = false
//            skbAvaliar.progress = 0
//        }
//
//        btnLista.setOnClickListener{
//            val intent = Intent (this, ListaDesafiosActivity::class.java)
//            startActivity(intent)
//        }
    }
}