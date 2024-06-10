d_matriz1=input()
d_matriz2=input()

d_matriz1=d_matriz1.split("x")
d_matriz2=d_matriz2.split("x")

def multiplicar(lista1,lista2):
    lista_final = []
    for i in range(len(lista1)):
        lista_final.append(lista1[i]*lista2[i])
    return sum(lista_final)

if d_matriz1[1] == d_matriz2[0]:
    lista=[[int(input()) for i in range(int(d_matriz1[1]))] for j in range(int(d_matriz1[0]))]
    lista2=[[int(input()) for i in range(int(d_matriz2[1]))] for j in range(int(d_matriz2[0]))]

    for i in range(len(lista)):
        for j in range(int(d_matriz2[1])):
            aux = []
            for f in range(len(lista2)):
                aux.append(lista2[f][j])
            print(multiplicar(lista[i],aux),end=" ")
        print(" ")
else:
    print("Las columnas de la primera tabla deben ser iguales a las filas de la segunda tabla")



