#include <iostream>
#include <vector>

using namespace std;

vector<int> A;
vector<bool> visited(8, false);
int N;
int maxValue = 0;

void DFS(vector<int> seq, int time) {
	if (time == N)
	{
		int sum = 0;

		for (int i = 0; i < A.size() - 1; i++) {
			sum += abs(A[seq[i]] - A[seq[i + 1]]);
		}

		if (maxValue < sum)
			maxValue = sum;

		return;
	}

	for (int i = 0; i < A.size(); i++) {
		if (!visited[i]) {
			visited[i] = true;
			seq.push_back(i);
			DFS(seq, time + 1);
			seq.pop_back();
			visited[i] = false;
		}
	}

	return;
}

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		int temp;
		cin >> temp;

		A.push_back(temp);
	}

	DFS(vector<int>(), 0);

	cout << maxValue;
}