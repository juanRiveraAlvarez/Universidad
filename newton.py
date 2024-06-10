from math import e

def f(x):
    return pow(e,x)+x+1

def f_derivada(x):
    return pow(e,x)+1

def newton(x,n):
    xn = x - (f(x)/f_derivada(x))
    if xn != x:
        print(f'x_{n} = {xn}')
        n = n + 1
        newton(xn,n) 
    else:
        return

x0 = 1
newton(x0,1)
