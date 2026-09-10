# -----------------------------------------------------------
# Algoritmo 6 - Matriz identidade de ordem n
# -----------------------------------------------------------

def identidade(n):
    # Vale 1 quando i == j (diagonal principal) e 0 nos demais
    # casos. É o elemento neutro: I * A = A * I = A.
    I = []
    for i in range(n):
        linha = []
        for j in range(n):
            if i == j:
                linha.append(1)     # diagonal principal
            else:
                linha.append(0)     # fora da diagonal
        I.append(linha)
    return I

# ------------------------ programa principal ----------------
n = int(input("Ordem n da identidade: "))

for linha in identidade(n):
    print(linha)