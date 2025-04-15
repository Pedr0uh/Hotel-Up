package `Hotel Update`

import kotlin.system.exitProcess

var nome: String = ""
val senha = 2678

fun main() {
    // Função principal que chama a função inicio().
    var tentativa = 0

    println("--------------------------------------------")
    println("           Bem vindo ao Hotel Up!           ")
    println("--------------------------------------------")

    println("Informe o nome do usuario:")
    nome = readln()

    println("Informe a senha:")
    var senhaUsuario = readln().toIntOrNull()

    while(senhaUsuario != senha){
        println("Senha incorreta! Tente novamente:")
        senhaUsuario = readln().toIntOrNull()
        tentativa++
        if(tentativa == 5){
            println("Número de tentativas excedido! Encerrando Programa...")
            exitProcess(0)
        }
    }
    iniciar()
}

fun iniciar() {

    print("\nBem vindo ao Hotel Up, $nome é um imenso prazer te ter por aqui!\n")
    println("O que deseja fazer? \n" +
            "\n1) Cadastrar Quartos" +
            "\n2) Cadastrar Hospedes" +
            "\n3) Abastecimento de Automoveis" +
            "\n4) Organização de Eventos" +
            "\n5) Manutenção de ar condicionados"+
            "\n6) Sair\n")

    // A varival escolha armazena a opção escolhida pelo usuário.
    // uma variavel local é utilizada apenas dentro da função inicio().
    val escolha = readln().toIntOrNull()
    print("\n")

    when (escolha) {
        1 -> cadastrarQuarto(Quartos)
        2 -> cadastrarHospedes()
        3 -> AbastecimentoDeAutomoveis()
        4 -> organizarEvento()
        5 -> manutencaoAr()
        6 -> sairDoHotel()
        else -> erro()
    }
}

fun sairDoHotel() {
    println("Você deseja sair? (S/N)")
    val confirma = readln()
    when(confirma.uppercase()){
        "S" -> exitProcess(0)
        "N" -> iniciar()
    }
}

fun erro(){
    println("\nOps ocorreu um erro. Por favor, Tente novamente\n")
    iniciar()
}