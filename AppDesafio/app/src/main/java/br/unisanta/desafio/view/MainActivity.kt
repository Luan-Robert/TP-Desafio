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
import br.unisanta.desafio.model.Desafio
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

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtValor = findViewById<EditText>(R.id.edt_valor)
        val edtURL = findViewById<EditText>(R.id.edt_link)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val btnLista = findViewById<Button>(R.id.btn_lista)

        btnCadastrar.setOnClickListener{
            val nome = edtNome.text.toString()
            val valor = edtValor.text.toString()
            val url = edtURL.text.toString()
            val desafio = Desafio(nome, valor, url)
            dao.adicionarDesafio(desafio)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Cadastro OK!")
            val alert = builder.create()
            alert.show()
            edtNome.text.clear()
            edtValor.text.clear()
            edtURL.text.clear()
        }

        btnLista.setOnClickListener{
            val intent = Intent(this, DesafiosListActivity::class.java)
            startActivity(intent)
        }
    }
}