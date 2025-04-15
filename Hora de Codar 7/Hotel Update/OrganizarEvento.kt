package `Hotel Update`

fun organizarEvento () {

    println("\n--- Organização de Eventos ---\n")

    println("-- Qual a quantidade de convidados? ")
    var num_Convidados = readln().toInt()

    while (num_Convidados > 350) {
        println("Quantidade de convidados superior à capacidade maxima. tente novamente ou digite 0 para voltar a o menu.")
        num_Convidados = readln().toInt()
        if (num_Convidados == 0) {
            println("Voltando a o menu...\n")
            iniciar()
        }
    }

    var condicao_auditorio = ""

    if (num_Convidados > 220) {
        println("\n --- Use o Auditorio Colorado ---")
        condicao_auditorio = "Auditorio Colorado"
    } else {
        println("\n --- Use o Auditorio Laranja ---")
        condicao_auditorio = "Auditorio Laranja"
        if (num_Convidados > 150) {
            print(" (Inclua ${num_Convidados - 150} cadeira)\n")
        }
    }

    println("\n --- Agora vamos ver a agenda do evento ---\n")

    println("-- Qual o dia do evento? (digite um dia da semana)"+
    "\n1) Segunda"+
    "\n2) Terça"+
    "\n3) Quarta"+
    "\n4) Quinta"+
    "\n5) Sexta"+
    "\n6) Sábado"+
    "\n7) Domingo")
    var escolha_dia = readln().toInt()

    var condicao = 0

    var dia_Evento = ""



    when(escolha_dia){
        1 -> {
            condicao = 1
            dia_Evento = "Segunda"
        }
        2 -> {
            condicao = 1
            dia_Evento = "Terça"
        }
        3 -> {
            condicao = 1
            dia_Evento = "Quarta"
        }
        4 -> {
            condicao = 1
            dia_Evento = "Quinta"
        }
        5 -> {
            condicao = 1
            dia_Evento = "Sexta"
        }
        6 -> {
            condicao = 2
            dia_Evento = "Sabado"
        }
        7 -> {
            condicao = 2
            dia_Evento = "Domingo"
        }
        else -> println("Ops digite um dia da semana valido!")
    }

    var hora_Evento = 0

    if (condicao == 2) {
        println("\n-- Qual a hora do evento? (7h a 15h)")
        hora_Evento = readln().toInt()
        while (hora_Evento < 7 || hora_Evento > 15) {
            println("Auditorio Indisponível esse horario, tente novamente ou digite 0 para voltar ao menu")
            hora_Evento = readln().toInt()
            if (hora_Evento == 0) {
                println("voltando ao menu...")
                iniciar()
            }
        }
    }

    if (condicao == 1) {
        println("\n-- Qual a hora do evento? (7h a 23h)")
        hora_Evento = readln().toInt()
        while (hora_Evento < 7 || hora_Evento > 23) {
            println("Auditorio Indisponível esse horario, tente novamente ou digite 0 para voltar ao menu")
            hora_Evento = readln().toInt()
            if (hora_Evento == 0) {
                println("voltando ao menu...")
                iniciar()
            }
        }
    }

    println("\n-- Qual o nome da empresa que ira realizar o evento? ")
    var nome_Franquia = readln()

    println("\nAuditorio reservado para $nome_Franquia, $dia_Evento as $hora_Evento hs\n")

    var hora_do_garcon = 10.50
    var numero_garcons = 0
    var custo_garcons = 0.0
    var i = 0
    var contador = 0

    println("-- Qual sera a duração do evento em horas?")
    var duracao_evento = readln().toInt()

    //conta de quanto garçoes serão precisos

    while(contador != num_Convidados+1){
        if(i == 12){
            numero_garcons++
            i = 0
        }
        i++
        contador++
    }

    i = 0

    contador = 0

    while(contador != duracao_evento+1){
        if(i == 2){
            numero_garcons++
            i = 0
        }
        i++
        contador++
    }

    i = 0

    contador = 0

    //conta do custo dos garçons por hora

    //por garçon
    var custo_por_garcon = duracao_evento * hora_do_garcon

    var custo_total_garcon = custo_por_garcon * numero_garcons

    println("\nO evento ira precisar de:")
    println(" - Numero de garçons: $numero_garcons")
    println(" - Custo por garçon: $custo_por_garcon")
    println(" - Custo total: $custo_total_garcon")

    println("\n --- Agora vamos calcular o custo do buffet do hotel para o evento --- ")

    var quantidade_cafe_por_pessoa = 0.2
    var quantidade_agua_por_pessoa = 0.5
    var quantidade_salgados_por_pessoa = 7

    var custo_cafe_por_litro = 0.80
    var custo_agua_por_litro = 0.40
    var custo_salgados_por_cento = 34

    var total_cafe_em_litro = num_Convidados * quantidade_cafe_por_pessoa
    var total_agua_em_litro = num_Convidados * quantidade_agua_por_pessoa
    var total_salgados = num_Convidados * quantidade_salgados_por_pessoa

    var custo_cafe = total_cafe_em_litro * custo_cafe_por_litro
    var custo_agua = total_agua_em_litro * custo_agua_por_litro
    var custo_salgado = (total_salgados/100) * custo_salgados_por_cento

    var custo_total_buffet = custo_salgado + custo_agua + custo_cafe

    println("\nO evento precisará de: \n- %.1f litros de café\n- %.1f litro de água\n- %d salgados".format(total_cafe_em_litro, total_agua_em_litro, total_salgados))

    var custo_total_geral = custo_total_garcon + custo_total_buffet

    println("\n----------------------------------------------------------------------------------------------------\n")

    println("- Evento no $condicao_auditorio"+
    "\n- Nome da Empresa: $nome_Franquia"+
    "\n- Data: $dia_Evento, ${hora_Evento}H às ${hora_Evento+duracao_evento}H"+
    "\n- Duração do evento: ${duracao_evento}H"+
    "\n- Quantidade de Convidados: $num_Convidados"+
    "\n\n- Custo dos garçons: R$$custo_total_garcon"+
    "\n- Custo do Buffet: R$$custo_total_buffet"+
    "\n\n- Valor Total do evento: R$$custo_total_geral")

    println("\nDeseja efetuar a reserva? (S/N)")
    var escolha_final = readln()

    when(escolha_final.uppercase()){
        "S" -> {
            println("\n$nome, reserva efetuada com sucesso! Voltando a o menu...")
            iniciar()
        }
        "N" -> {
            println("\nReserva não efetuada, voltando a o menu...")
            iniciar()
        }
    }

    iniciar()

}