# -----------------------------------------------------------
# Algoritmo 5 - Multiplicação de matrizes  C = A * B
# -----------------------------------------------------------

def pode_multiplicar(A, B):
    # O produto só existe quando o número de colunas de A
    # é igual ao número de linhas de B.
    return len(A[0]) == len(B)

def multiplicar(A, B):
    # C[i][j] é a soma dos produtos da linha i de A pela
    # coluna j de B (o produto interno linha-coluna).
    m = len(A)                       # linhas de A
    p = len(A[0])                    # colunas de A = linhas de B
    n = len(B[0])                    # colunas de B
    C = []
    for i in range(m):
        linha = []
        for j in range(n):
            soma = 0
            for k in range(p):        # percorre linha x coluna
                soma = soma + A[i][k] * B[k][j]
            linha.append(soma)
        C.append(linha)
    return C

# ------------------------ programa principal ----------------
# Matrizes A e B da Questão 2 da Atividade 01.
A = [[1, 4, 7], [3, 6, 9]]
B = [[3, 0, -1], [3, 6, 1], [5, 4, 9]]

if pode_multiplicar(A, B):
    for linha in multiplicar(A, B):
        print(linha)
else:
    print("Impossivel: colunas de A diferentes de linhas de B")