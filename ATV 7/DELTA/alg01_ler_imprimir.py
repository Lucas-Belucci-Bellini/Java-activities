# -----------------------------------------------------------
# Algoritmo 1 - Leitura e impressão de uma matriz A(m x n)
# Autor: Lucas Belucci Bellini
# -----------------------------------------------------------

def ler_matriz(m, n):
    # Lê m*n valores do teclado e devolve a matriz como uma
    # lista de listas, onde cada lista interna é uma linha.
    matriz = []
    for i in range(m):                 # anda pelas linhas
        linha = []
        for j in range(n):             # anda pelas colunas
            valor = float(input("a[%d][%d] = " % (i + 1, j + 1)))
            linha.append(valor)         # guarda o elemento
        matriz.append(linha)            # guarda a linha
    return matriz

def imprimir_matriz(matriz):
    # Monta cada linha como texto usando largura fixa de 8
    # caracteres e 2 decimais, o que alinha as colunas.
    for linha in matriz:
        texto = ""
        for valor in linha:
            texto = texto + "%8.2f" % valor
        print(texto)

# ------------------------ programa principal ----------------
m = int(input("Numero de linhas (m): "))
n = int(input("Numero de colunas (n): "))
A = ler_matriz(m, n)
print("Matriz A lida:")
imprimir_matriz(A)S