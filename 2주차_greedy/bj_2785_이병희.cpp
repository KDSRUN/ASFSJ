#include <iostream>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

vector<int> list;

int main() {
	int gori = 0;

	int N;
	cin >> N;

	priority_queue<int, vector<int>, greater<int>> pq;

	for (int i = 0; i < N; i++) {
		int temp;
		cin >> temp;
		pq.push(temp);
	}

	int top = pq.top();
	while (top + gori < pq.size() - 1) {
		gori += top;
		pq.pop();
		top = pq.top();
	}

	if (top + gori > pq.size() - 1)
		gori += pq.size() - 1 - gori;
	else
		gori += top;

	cout << gori;
}