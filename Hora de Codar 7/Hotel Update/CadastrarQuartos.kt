package `Hotel Update`

data class Quarto(
    var numero: Int?,
    var ocupado: Boolean = false,
    var hospede: String?
)

val Quartos = mutableListOf<Quarto>()

fun cadastrarQuarto(Quartos: MutableList<Quarto>) {

    if(Quartos.isEmpty()) {
        var i = 1
        while (i != 21) {
            var quarto = Quarto(i, false, null)
            Quartos.add(quarto)
            i++
        }
    }

    println("Insira o valor da diária: ")
    var valorDiaria = readln().toFloat()

    while(valorDiaria <= 0){
        println("Valor Invalido, $nome, tente novamente ou digite 0 para voltar para o menu.")
        valorDiaria = readln().toFloat()
        if(valorDiaria == 0.0f){
            iniciar()
            break
        }
    }

    println("Insira Quantas diárias serão necessárias: ")
    var valorDia = readln().toInt()

    while(valorDia <= 0 || valorDia > 30){
        println("Valor Invalido, $nome, tente novamente ou digite 0 para voltar para o menu.")
        valorDia = readln().toInt()
        if(valorDia == 0){
            iniciar()
        }
    }

    var total = valorDiaria * valorDia

    println("O valor de $valorDia diárias é R$ $total")
    println("confirmar? (S/N)")
    var confirmacao = readln()

    when(confirmacao.uppercase()){

        "S" -> print("")
        "N" -> iniciar()
        else -> erro()
    }

    println("Informe o nome do hospede: ")
    var nomeHospede = readln()

    println("Informe o quarto para reserva (1 a 20): ")
    var numeroQuarto = readln().toInt()

    while(numeroQuarto <= 0 || numeroQuarto > 20){
        println("Numero invalido, use número de 1 a 20, ou digite 0 para voltar para o menu.")
        numeroQuarto = readln().toInt()
    }

    var numFind = Quartos.find{ it.numero == numeroQuarto }

    while(numFind == null || numFind.ocupado){
        if(numFind != null && numFind.ocupado){
            println("\nO quarto está ocupado!\n")
        }
        else{
            println("Quarto não encontrado! Insira o valor valido")
        }
        Quartos.forEach { Quarto ->
            println(message = "- Quarto 0${Quarto.numero} - Estado atual: ${if (Quarto.ocupado) "ocupado" else "vazio"} - Hospede: ${Quarto.hospede ?: "vazio"} ")
        }
        println("Informe o quarto para reserva (1 a 20) ou digite 0 para voltar a o menu: ")
        numeroQuarto = readln().toInt()

        if (numeroQuarto == 0){
            println("\nVoltando para o menu...\n")
            iniciar()
            return
        }
        numFind = Quartos.find{it.numero == numeroQuarto}
    }


    println("\nQuarto encontrado: 0${numFind.numero} Ocupado: ${numFind.ocupado}\n")

    println("${nome} você confirma a hospedagem para ${nomeHospede} por ${valorDia} dias para o quarto 0${numFind.numero} por R$ ${total}? (S/N)")
    var confirmarReserva = readln()

    when(confirmarReserva.uppercase()){
        "S" -> {
            numFind.ocupado = true
            numFind.hospede = nomeHospede
            println("\n${nome}, reserva confirmada com sucesso!\n")
        }
        "N" -> {
            println("operação cancelada, voltando a o menu...")
            iniciar()
        }
        else -> erro()
    }

    Quartos.forEach { Quarto ->
        println(message = "- Quarto 0${Quarto.numero} - Estado atual: ${if (Quarto.ocupado) "ocupado" else "vazio"} - Hospede: ${Quarto.hospede ?: "vazio"} ")
    }

    iniciar()

}


