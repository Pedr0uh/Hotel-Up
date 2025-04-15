package `Hotel Update`

fun AbastecimentoDeAutomoveis() {

    var wayneOil_alcool_litro = 0.0
    var wayneOil_gasolina_litro = 0.0
    var sparkPetrol_alcool_litro = 0.0
    var sparkPetrol_gasolina_litro = 0.0
    var tanque_carro = 42
    var nome_posto = ""

    println("\n ---- Abastecimento dos Automóveis ---- \n")

    println(" - Qual o valor do litro de álcool no posto Wayne Oil hoje?")
    wayneOil_alcool_litro = readln().toDouble()

    println(" - Qual o valor do litro de gasolinha no posto Wayne Oil hoje?")
    wayneOil_gasolina_litro = readln().toDouble()

    println(" - Qual o valor do litro de álcool no posto Spark Petrol hoje?")
    sparkPetrol_alcool_litro = readln().toDouble()

    println(" - Qual o valor do litro de gasolinha no posto Spark Petrol hoje?")
    sparkPetrol_gasolina_litro = readln().toDouble()

    //qual o alcool é mais barato

    var alcool_mais_barato = 0.0
    var gasolina_mais_barata = 0.0


    if(wayneOil_alcool_litro < sparkPetrol_alcool_litro){
        alcool_mais_barato = wayneOil_alcool_litro
        nome_posto = "Wayne Oil"
    }
    else{
        alcool_mais_barato = sparkPetrol_alcool_litro
        nome_posto = "Spark Petrol"
    }

    //qual gasolina é mais barata

    if(wayneOil_gasolina_litro < sparkPetrol_alcool_litro){
        gasolina_mais_barata = wayneOil_gasolina_litro
        nome_posto = "Wayne Oil"
    }
    else{
        gasolina_mais_barata = sparkPetrol_gasolina_litro
        nome_posto = "Spark Petrol"
    }

    //condicao de se o alcool for 30% mais barato que a gasolina ele será o escolhido

    var limite_alcool_preço = gasolina_mais_barata * 0.7
    var escolha = ""

    if( alcool_mais_barato <= limite_alcool_preço){
        escolha = "alcool"
    }
    else{
        escolha = "gasolina"
    }

    println("\n--- $nome, é mais barato abastecer com $escolha no posto $nome_posto. ---\n")

    println(" Voltando a o menu...")

    iniciar()


}