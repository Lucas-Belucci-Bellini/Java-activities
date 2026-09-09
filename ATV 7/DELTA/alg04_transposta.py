# -----------------------------------------------------------
# Algoritmo 4 - Transposta de uma matriz
# -----------------------------------------------------------

def transposta(A):
    # O elemento da linha i, coluna j de A vai para a linha j,
    # coluna i da transposta. Uma matriz m x n vira n x m.
    m = len(A)                       # número de linhas
    n = len(A[0])                    # número de colunas
    T = []
    for j in range(n):                 # cada coluna de A...
        linha = []
        for i in range(m):
            linha.append(A[i][j])
        T.append(linha)                 # ...vira uma linha de T
    return T

def imprimir(M):
    for linha in M:
        print(linha)

# ------------------------ programa principal ----------------
# Matriz resultado da Questão 7 da Atividade 01.
A = [[-9, 7], [2, 0], [-8, 8]]

print("A (3 x 2):")
imprimir(A)
print("A transposta (2 x 3):")
imprimir(transposta(A))