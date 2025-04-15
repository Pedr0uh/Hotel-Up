package `Hotel Update`

import kotlin.system.exitProcess

data class Hospede (
    var nome: String,
    var idade: Int?
)

var listaHospedes = mutableListOf(
    Hospede("Carlos Villagran",81),
    Hospede("Maria Antonieta de las Nieves", 75),
    Hospede("Florinda Meza", 76),
    Hospede("Carlos Santana",18)
)

fun cadastrarHospedes() {

    while (true) {
        println("""Cadastro de Hóspedes
        Selecione uma opção:
        1) Cadastrar
        2) Pesquisar
        3) Voltar para o menu
        4) Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarNovoHospede(listaHospedes)
            2 -> pesquisarHospede(listaHospedes)
            3 -> voltarMenu()
            4 -> sairCadastroDeHospedes()
            else -> erroCadastroDeHospedes()
        }
    }
}

fun cadastrarNovoHospede(listaHospedes: MutableList<Hospede>) {

    var condicao = true

    println("\nCadastro de Hóspedes\n")

    println("Informe o valor padrão da diária: ")
    var contagem = 0
    var valorDiaria = readln().toInt()
    var meia = valorDiaria / 2
    var meiaI = 0
    var gratuidade = 0
    var soma = 0

    do {
        println("Por favor, informe o nome da Hóspede, ou digite PARE: ")
        val nomeHospede = readln()

        if(nomeHospede.uppercase() == "PARE"){
            condicao = false
            break
        }

        if(contagem != 15) {
            println("Informe a idade da hóspede: ")
            var idadeHospede = readln().toIntOrNull() ?: 0

            if (idadeHospede >= 60) {
                meiaI++
                println("$nomeHospede cadastrado(a) com sucesso. $nomeHospede paga meia")
                soma += meia
                contagem++
            } else if (idadeHospede < 6) {
                gratuidade++
                println("$nomeHospede cadastrado(a) com sucesso. $nomeHospede possui gratuidade")
                contagem++
            } else {
                println("$nomeHospede cadastrado(a) com sucesso.")
                soma += valorDiaria
                contagem++
            }

            var novoHospede = Hospede(nome = nomeHospede, idade = idadeHospede)

            listaHospedes.add(novoHospede)
        }
        else{
            println("Número de cadastros maximo atingido!")
            condicao = false
            break
        }

    } while (condicao)

    if(soma == 0 || meia == 0){
        println("\nNenhum cadastramento foi realizado\n")
    }
    else {
        println("\n$nome, o valor das hospedagens é:R$ $soma; $meiaI meia(s); $gratuidade gratuidades\n")
        println("\nLista de Hóspedes atuais \n")
        listaHospedes.forEach { Hospede -> println(message = "Nome: ${Hospede.nome}, Idade: ${Hospede.idade} ") }
        println("\n")
    }
    // Não é necessário chamar a função cadastrarHospedes(), pois o loop while já está chamando.
}

fun pesquisarHospede(listaHospedes: MutableList<Hospede>) {
    println("Pesquisa de Hóspedes.\nPor favor, informe o nome da Hóspede:")
    val nomeHospede = readln()

    val hospedeEncontrado = listaHospedes.filter { it.nome.contains(nomeHospede, ignoreCase = true) }
    
    // Se o nome do hóspede estiver na lista, exibir o nome do hóspede.
    if (hospedeEncontrado.isNotEmpty()) {

        println("\nEncontramos a(s) hóspede(s):\n")
        hospedeEncontrado.forEach { println("Nome: ${it.nome}, idade: ${it.idade}")}
        println("\n")
    }
    else {
        println("Hóspede $nomeHospede não foi encontrado.\n")
    }
}

fun sairCadastroDeHospedes() {
    println("Você deseja sair? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        // uppercase fará o que for digitado ser convertido para maiúsculo por exemplpo x -> X
        "S" -> {
            println("Hasta la vista, Baby.")
            exitProcess(0)
        }
        "N" -> {
            println("Ok, voltando ao início...")
            cadastrarHospedes()
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeHospedes()
        }
    }
}

fun voltarMenu(){
    println("Você deseja voltar para o menu? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        // uppercase fará o que for digitado ser convertido para maiúsculo por exemplpo x -> X
        "S" -> {
            println("voltando para o menu...")
            iniciar()
        }
        "N" -> {
            println("Ok, voltando ao início...")
            cadastrarHospedes()
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            voltarMenu()
        }
    }
}

fun erroCadastroDeHospedes() {
    println("Por favor, informe um número entre 1 e 4.")
}