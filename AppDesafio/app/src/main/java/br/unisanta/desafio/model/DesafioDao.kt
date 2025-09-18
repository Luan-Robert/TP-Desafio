package br.unisanta.desafio.model

interface DesafioDao {
    fun adicionarDesafio(desafio: Desafio)
    fun obterDesafios():List<Desafio>
    fun excluir(desafio: Desafio)
}