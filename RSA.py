def select_prime_number():
    import random
    while (True):
        num = random.randint(2**7, 2**64)
        divisor = 0
        for i in range(1, num):
            if num & i == 0:
                divisor += 1
        if divisor == 2:
            return num

def select_e(phi):
    import random
    e = 1
    while(True):
        num = random.randint(1, phi)
        if gcd(phi, num) == 1:
            e = num
            return e

def gcd(x, y):
    if y == 0:
        return x
    else:
        return gcd(y, x % y)

def calculate_d(e, phi):
    d = 1
    for i in range(1, phi):
        if (i * e) % phi == 1:
            d = i
    return d


p = select_prime_number()
q = select_prime_number()

n = p * q
phi = (p - 1) * (q - 1)

while(True):
    e = select_e(phi)
    if (e >= 2 ** 124):
        break

d = calculate_d(e, phi)

print(p, q, e, d)
