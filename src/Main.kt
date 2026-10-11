// ==========================================
// Prática 1: Variáveis e Tipos
// ==========================================

fun pratica1() {
    val nomeProduto = "Café"
    val precoProduto = 12.50
    val qtdEstoque = 30
    println("Produto: $nomeProduto | Preço: R$$precoProduto | Estoque: $qtdEstoque")

    var temperatura = 25.0
    println("Temperatura de manhã: $temperatura°C")
    temperatura = 30.5
    println("Temperatura à tarde: $temperatura°C")
    temperatura = 22.0
    println("Temperatura à noite: $temperatura°C")

    // val numero = 10
    // numero = 15 // ERRO: Val cannot be reassigned
}


// ==========================================
// Prática 2: Null Safety
// ==========================================

fun saudar(nome: String?): String {
    return "Olá, ${nome ?: "visitante"}!"
}

fun pratica2() {
    println(saudar("Wellington"))
    println(saudar(null))

    var email: String? = null
    if (email != null) {
        println(email.substringAfter("@"))
    } else {
        println("E-mail não informado")
    }

    email = "teste@gmail.com"
    if (email != null) {
        println(email.substringAfter("@"))
    } else {
        println("E-mail não informado")
    }

    val dado: String? = null
    println(dado ?: "Dado vazio")
}


// ==========================================
// Prática 3: Funções
// ==========================================

fun calcularMedia(notas: List<Double>): Double {
    return notas.sum() / notas.size
}

fun estaAprovado(media: Double, minima: Double = 6.0): Boolean {
    return media >= minima
}

fun pratica3() {
    val notas = listOf(7.0, 8.5, 9.0)
    val media = calcularMedia(notas)
    val aprovado = estaAprovado(media)
    println("Média: $media | Aprovado: $aprovado")
}


// ==========================================
// Prática 4: Classes e Data Classes
// ==========================================

data class Produto(val id: Int, val nome: String, val preco: Double) {
    fun descricao(): String {
        return "[$id] $nome - R$$preco"
    }
}

data class Aluno(val nome: String, val matricula: String, val nota: Double)

class Calculadora {
    fun somar(a: Double, b: Double) = a + b
    fun subtrair(a: Double, b: Double) = a - b
    fun multiplicar(a: Double, b: Double) = a * b
    fun dividir(a: Double, b: Double): Double? {
        if (b == 0.0) return null
        return a / b
    }
}

fun pratica4() {
    val alunos = listOf(
        Aluno("João", "123", 7.5),
        Aluno("Maria", "456", 9.0),
        Aluno("Pedro", "789", 8.0)
    )
    val melhorAluno = alunos.maxByOrNull { it.nota }
    println("Melhor aluno: $melhorAluno")

    val produto = Produto(1, "Caderno", 12.50)
    println(produto.descricao())

    val calc = Calculadora()
    println("Soma: ${calc.somar(10.0, 5.0)}")
    println("Divisão: ${calc.dividir(10.0, 0.0)}")
}


// ==========================================
// Prática 5: Coleções e Lambdas
// ==========================================

fun pratica5() {
    val notas = listOf(4.5, 7.0, 9.5, 6.0, 3.0, 8.5)
    val notasAprovadas = notas.filter { it >= 6.0 }
    val mediaAprovados = notasAprovadas.sum() / notasAprovadas.size
    val reprovados = notas.size - notasAprovadas.size
    println("Notas aprovadas: $notasAprovadas")
    println("Média dos aprovados: $mediaAprovados")
    println("Aprovados: ${notasAprovadas.size} | Reprovados: $reprovados")

    val inventario = mutableMapOf("Pão" to 10, "Leite" to 5)
    inventario["Queijo"] = 8
    inventario.remove("Leite")
    println("Inventário ordenado: ${inventario.toSortedMap()}")

    val palavras = listOf("banana", "maçã", "uva", "banana", "abacaxi", "uva")
    val resultado = palavras.distinct().filter { it.length > 4 }.sorted()
    println("Palavras filtradas e ordenadas: $resultado")
}


// ==========================================
// Função Principal
// ==========================================

fun main() {
    println("--- Executando Prática 1 ---")
    pratica1()
    
    println("\n--- Executando Prática 2 ---")
    pratica2()
    
    println("\n--- Executando Prática 3 ---")
    pratica3()
    
    println("\n--- Executando Prática 4 ---")
    pratica4()
    
    println("\n--- Executando Prática 5 ---")
    pratica5()
}