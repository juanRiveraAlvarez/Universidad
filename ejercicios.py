#Actividad 5 Sean f , g, h, j 
#las funciones reales definidas a continuación en términos
#de la funcion piso de x

from math import pow, floor

print("Limite de f(x) cuando x tiende a 2 por la derecha")
numeros = [2010,2009,2008,2007,2006,2005,2004,2003,2002,2001]
for i in numeros:
    if i != 0:
        x = i/1000
        print(f'{x} -- {pow(x,floor(x+1))}')
    else:
        print(0)


print("Limite de f(x) cuando x tiende a 2 por la izquierda")
numeros = [1990,1991,1992,1993,1994,1995,1996,1997,1998,1999]
for i in numeros:
    if i != 0:
        x = i/1000
        print(f'{x} -- {pow(x,floor(x+1))}')
    else:
        print(0)


print("Limite de g(x) cuando x tiende a 2 por la derecha")
numeros = [2010,2009,2008,2007,2006,2005,2004,2003,2002,2001]
for i in numeros:
    if i != 0:
        x = i/1000
        print(f'{x} -- {(floor(x)-2)/(x-2)}')
    else:
        print(0)


print("Limite de g(x) cuando x tiende a 2 por la izquierda")
numeros = [1990,1991,1992,1993,1994,1995,1996,1997,1998,1999]
for i in numeros:
    if i != 0:
        x = i/1000
        print(f'{x} -- {(floor(x)-2)/(x-2)}')
    else:
        print(0)


print("Limite de h(x) cuando x tiende a 1 por la izquierda")
numeros = [9991,9992,9993,9994,9995,9996,9997.9998,9999]
for i in numeros:
    if i != 0:
        x = i/10000
        print(f'{x} -- {x*(floor(1/x))}')
    else:
        print(0)


print("Limite de h(x) cuando x tiende a 0")
numeros = [-1,-2,-3,-4,-5,1,2,3,4,5]
for i in numeros:
    if i != 0:
        x = i/10000
        print(f'{x} -- {x*(floor(1/x))}')
    else:
        print(0)


print("Limite de j(x) cuando x tiende a 0 por la derecha")
numeros = [9,8,7,6,5,4,3,2,1]
for i in numeros:
    if i != 0:
        x = i/10000
        print(f'{x} -- {pow(-1,floor(1/x))}')
    else:
        print(0)

print("Limite de j(x) cuando x tiende a 1 por la derecha")
numeros = [5,4,3,2,1]
for i in numeros:
    if i != 0:
        x = i/10000
        print(f'{x} -- {pow(-1,floor(1/x))}')
    else:
        print(0)
