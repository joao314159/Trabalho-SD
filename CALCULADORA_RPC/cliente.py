import xmlrpc.client

comunica_com_servidor = xmlrpc.client.ServerProxy("http://localhost:8000/")

mensagem = input("digite a operação entre: (- , + , * , /) e digite sair para sair: ")

while mensagem != "sair":
    if mensagem == "-":
        print("chamando operação de subtração")

        print("\n digite o primeiro parâmetro: ")
        a = float(input())
        print("\n digite o segundo parâmetro: ")
        b = float(input())

        chamando_funcao1 = getattr(comunica_com_servidor,"subtrair")

        resultado = chamando_funcao1(a,b)
        print(resultado)

    elif mensagem == "+":
        print("chamando operação de soma")

        print("\n digite o primeiro parâmetro: ")
        a = float(input())
        print("\n digite o segundo parâmetro: ")
        b = float(input())

        chamando_funcao2 = getattr(comunica_com_servidor,"somar")

        resultado = chamando_funcao2(a,b)
        print(resultado)
        
    elif mensagem == "*":
        print("chamando operação de multiplicação")
        
        print("\n digite o primeiro parâmetro: ")
        a = float(input())
        print("\n digite o segundo parâmetro: ")
        b = float(input())

        chamando_funcao3 = getattr(comunica_com_servidor,"multiplicar")

        resultado = chamando_funcao3(a,b)
        print(resultado)

    elif mensagem == "/":
        print("chamando operação de divisão")

        print("\n digite o primeiro parâmetro: ")
        a = float(input())
        print("\n digite o segundo parâmetro: ")
        b = float(input())

        chamando_funcao4 = getattr(comunica_com_servidor,"dividir")

        resultado = chamando_funcao4(a,b)
        print(resultado)

    else: 
        print("Digite uma opção válida")



    mensagem = input("digite a operação entre: (- , + , * , /) e digite sair para sair: ")    