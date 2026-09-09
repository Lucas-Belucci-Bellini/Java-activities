# -----------------------------------------------------------
# Algoritmo 8 - Inversa de uma matriz 2 x 2 (com menu)
# -----------------------------------------------------------

def det2(A):
    return A[0][0] * A[1][1] - A[0][1] * A[1][0]

def inversa2(A):
    # Se o determinante for zero a matriz é singular e não tem
    # inversa. Se não for, troca-se a diagonal principal,
    # inverte-se o sinal da secundária e divide-se pelo det.
    d = det2(A)
    if d == 0:
        return None
    return [[A[1][1] / d, -A[0][1] / d],
            [-A[1][0] / d, A[0][0] / d]]

def ler_2x2():
    # Lê os 4 elementos da matriz um a um.
    M = []
    for i in range(2):
        linha = []
        for j in range(2):
            linha.append(float(input("a[%d][%d] = " % (i + 1, j + 1))))
        M.append(linha)
    return M

# ---- o menu se repete até o usuário digitar 0 para sair ----
opcao = ""

while opcao != "0":
    print("1 - Inversa de uma matriz 2x2   |   0 - Sair")
    opcao = input("Opcao: ")
    if opcao == "1":
        inv = inversa2(ler_2x2())
        if inv is None:
            print("det(A) = 0 -> a matriz nao tem inversa.")
        else:
            for linha in inv:
                print(linha)