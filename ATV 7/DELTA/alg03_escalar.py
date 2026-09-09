# -----------------------------------------------------------
# Algoritmo 3 - Multiplicação de uma matriz por um escalar
# -----------------------------------------------------------

def multiplicar_por_escalar(k, A):
    # Cada elemento é multiplicado pelo mesmo número real k.
    # A ordem da matriz continua exatamente a mesma.
    B = []
    for i in range(len(A)):
        linha = []
        for j in range(len(A[i])):
            linha.append(k * A[i][j])
        B.append(linha)
    return B

def imprimir(M):
    for linha in M:
        texto = ""
        for valor in linha:
            texto = texto + "%8.2f" % valor
        print(texto)

# ------------------------ programa principal ----------------
k = float(input("Escalar k = "))
A = [[1, 4, 7], [3, 6, 9]]

print("B = k * A:")
imprimir(multiplicar_por_escalar(k, A))