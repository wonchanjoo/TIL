#define MAX 1000001
#include <iostream>
#include <queue>

using namespace std;

int N;
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        int size;
        cin >> size;
        pq.push(size);
    }

    int answer = 0;
    while (pq.size() >= 2) {
        int A = pq.top();
        pq.pop();
        int B = pq.top();
        pq.pop();

        answer += (A + B);
        pq.push(A + B);
    }

    cout << answer;

    return 0;
}