answer = []
primes = [2, 3, 5, 7]

def isprime(num):
    if num == 1:
        return False
    if num == 2:
        return True
    if not num%2:
        return False
    
    for i in range(3, int(num**0.5)+1, 2):
        if not num%i:
            return False
    
    return True

def dfs(num, depth, N):

    if depth == N:
        if isprime(num):
            answer.append(num)
        return
    
    if not(isprime(num)):
        return
    
    for i in range(1, 10, 2):
        dfs(10*num+i, depth+1, N)

N = int(input())
for num in primes:
    dfs(num, 1, N)

for num in answer:
    print(num)