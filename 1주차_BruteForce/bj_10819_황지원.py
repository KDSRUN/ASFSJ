N = int(input())
numbers = list(map(int, input().split()))

answer = 0

def calculate(arr):
    global answer
    arr_ = []
    for idx in arr:
        arr_.append(numbers[idx])
    tmp = 0

    for i in range(N-1):
        tmp += abs(arr_[i] - arr_[i+1])

    if tmp > answer:
        answer = tmp

def recursive(element, depth, visited):

    if depth == N:
        calculate(element)
        return

    for i in range(N):
        if visited[i] == 0:
            element.append(i)
            visited[i] = 1
            recursive(element, depth + 1, visited)
            visited[element.pop()] = 0

visited = [0] * N
recursive([], 0, visited)

print(answer)