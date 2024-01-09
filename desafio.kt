enum class Nivel { JUNIOR, PLENO, SENIOR }

class Usuario(val name: String, val matricula: String) {
}

data class ConteudoEducacional(val nome: String, val duracao: Int)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Aluno: ${usuario.name} - Formacao: ${nome}")
        } else {
            println("Aluno já matriculado nesta formação")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Eduarda", "123456")
    val usuario2 = Usuario("Tofu", "987654")

    val conteudo1 = ConteudoEducacional("Orientação a Objetos", 84)
    val conteudo2 = ConteudoEducacional("Java para Iniciantes", 146)

    val formacao = Formacao("Do Zero ao Junior", listOf(conteudo1, conteudo2))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println("\n${formacao.nome}:\n")
    println(formacao.inscritos.joinToString("\n") { it.name })
}
