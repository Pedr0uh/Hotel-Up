package `Hotel Update`

data class Empresa(
        var numero: Int,
        var nome: String,
        var valor_total: Double
        )


fun manutencaoAr(){

    println(" --- Manutenção dos Ar Condicionado --- ")

    var condicao = true
    var i = 0

    var empresas: MutableList<Empresa> = mutableListOf()



    do {
        println(" - insira o nome da empresa: ")
        var nome_empresa = readln()

        println(" - valor cobrado por aparelho: ")
        var valor_por_aparelho = readln().toDouble()

        println(" - quantidade de aparelhos: ")
        var quantidade_aparelhos = readln().toInt()

        println(" - Qual porcentagem de desconto oferecem? ")
        var valor_desconto = readln().toInt()

        println(" - Insira a quantidade de aparelhos minimo para conseguir o desconto: ")
        var quantidade_para_desconto = readln().toInt()

        var desconto: Boolean
        var valor_total = valor_por_aparelho * quantidade_aparelhos

        if(quantidade_aparelhos >= quantidade_para_desconto){
            desconto = true
        }
        else{
            desconto = false
        }

        if(desconto){
            valor_total -= valor_total * (valor_desconto/100)
        }
        else{
            continue
        }

        println(" -- O serviço da empresa $nome_empresa custará $valor_total")

        val empresa = Empresa(numero = i, nome_empresa, valor_total)

        empresas.add(empresa)

        println("Deseja informar novos dados? (S/N)")
        var escolha = readln()

        when(escolha.uppercase()){
            "S" -> continue
            "N" ->{
                condicao = false
                break
            }
        }

        i++

    } while(condicao)

    var empresa_mais_barata = empresas.minByOrNull { it.valor_total }

    if(empresa_mais_barata != null){
        println("A empresa com menor orçamento para a manutenção dos Ar Condicionado é:"+
        "\n - Empresa: ${empresa_mais_barata.nome}"+
        "\n - Orçamento: ${empresa_mais_barata.valor_total}")
    }
    else{
        println("Nenhum dado registrado")
    }

    println("voltando para o incio... ")

    iniciar()

}