package br.unisanta.desafio.model

class DesafioDaoImpl: DesafioDao {
    companion object {
        private val desafios = mutableListOf<Desafio>()
    }
    override fun adicionarDesafio(desafio: Desafio){
        desafios.add(desafio)
    }

    override fun obterDesafios(): List<Desafio> {
        return desafios
    }
}