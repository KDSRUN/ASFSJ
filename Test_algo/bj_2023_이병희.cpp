#include <string>
#include <iostream>
#include <cmath>

using namespace std;

bool isPrime(int n) {
	if (n == 1)
		return false;

	for (int i = 2; i <= sqrt(n); i++) {
		if (n % i == 0)
			return false;
	}

	return true;
}

void DFS(int num, int n, int time) {

	for (int i = 1; i <= 9; i++) {
		num *= 10;
		num += i;

		if (isPrime(num)) {
			if (time == n)
				printf("%d\n", num);
			else
				DFS(num, n, time + 1);
		}

		num /= 10;
	}

}

int main() {
	int N;
	scanf("%d", &N);

	DFS(0, N, 1);

	return 0;
}