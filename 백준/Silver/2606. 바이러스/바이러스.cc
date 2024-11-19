#include <iostream>
#include <queue>
#define MAX 101

using namespace std;

int N, M;
int answer = 0;
bool graph[MAX][MAX];
bool visited[MAX];
queue<int> q;

int main() {
    cin >> N;
    cin >> M;

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        graph[a][b] = true;
        graph[b][a] = true;
    }

    q.push(1);
    visited[1] = true;
    while (!q.empty()) {
        int now = q.front();
        q.pop();

        for (int i = 1; i <= N; i++) {
            if (graph[now][i] && !visited[i]) {
                visited[i] = true;
                q.push(i);
                answer++;
            }
        }
    }

    cout << answer;

    return 0;
}