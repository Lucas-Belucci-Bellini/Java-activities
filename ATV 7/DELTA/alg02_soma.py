# -----------------------------------------------------------
# Algoritmo 2 - Soma de duas matrizes de mesma ordem
# -----------------------------------------------------------

def mesma_ordem(A, B):
    # A soma só é possível se as duas tiverem o mesmo número
    # de linhas e o mesmo número de colunas em cada linha.
    if len(A) != len(B):
        return False
    for i in range(len(A)):
        if len(A[i]) != len(B[i]):
            return False
    return True

def somar(A, B):
    # C[i][j] = A[i][j] + B[i][j] - soma posição por posição.
    C = []
    for i in range(len(A)):
        linha = []
        for j in range(len(A[i])):
            linha.append(A[i][j] + B[i][j])
        C.append(linha)
    return C

def imprimir(M):
    for linha in M:
        print(linha)

# ------------------------ programa principal ----------------
# Matrizes B e C da Questão 1 da Atividade 01.
A = [[2, 2, 2], [2, 1, -3], [-1, 0, 4]]
B = [[3, 3, 3], [3, 0, 5], [6, 9, -1]]

if mesma_ordem(A, B):
    imprimir(somar(A, B))
else:
    print("Soma impossivel: as ordens sao diferentes.")