DP = [0] * 2501
DP[0] = 1

for i in range(1, 2501):
    for j in range(i):
        DP[i] += (DP[j]*DP[i-1-j]) % 1000000007
        DP[i] = DP[i] % 1000000007

for _ in range(int(input())):
    N = int(input())
    if N%2:
        print(0)
    else:
        print(DP[N//2])