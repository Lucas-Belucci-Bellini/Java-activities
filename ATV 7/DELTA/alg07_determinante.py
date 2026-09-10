# -----------------------------------------------------------
# Algoritmo 7 - Determinante de matrizes de ordem 2 e 3
# -----------------------------------------------------------

def det2(A):
# Diagonal principal menos diagonal secundária.
return A[0][0] * A[1][1] - A[0][1] * A[1][0]

def det3(A):
# Laplace na 1a linha: cada elemento multiplica o
# determinante 2x2 que sobra ao apagar a linha e a coluna
# dele, com os sinais + - + alternando.
m11 = A[1][1] * A[2][2] - A[1][2] * A[2][1]
m12 = A[1][0] * A[2][2] - A[1][2] * A[2][0]
m13 = A[1][0] * A[2][1] - A[1][1] * A[2][0]
return A[0][0] * m11 - A[0][1] * m12 + A[0][2] * m13

def determinante(A):
# Escolhe a fórmula conforme a ordem da matriz.
n = len(A)
if n != len(A[0]):
    return None                # não é quadrada
if n == 2:
    return det2(A)
if n == 3:
    return det3(A)
return None                    # ordem não tratada

# ------------------------ programa principal ----------------
A = [[2, 1, 0], [1, 1, 1], [1, 0, 1]]   # Questão 4

print("det(A) =", determinante(A))