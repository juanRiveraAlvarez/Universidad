G = 6.67384*10**(-11)
M = 1
c = 299792458
rs = (2*G*(8.2*pow(10,36)))/pow(c,2)
print(rs)

def c(r):
    return 1/(1-(rs/(r)))

