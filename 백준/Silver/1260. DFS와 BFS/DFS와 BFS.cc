#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;

int N, M, V;
vector<int> adjList[1001];
bool visited[1001];

void DFS(int v) {
    cout << v << " ";
    visited[v] = true;

    for (int next : adjList[v]) {
        if (!visited[next]) {
            DFS(next);
        }
    }
}

void BFS(int v) {
    queue<int> queue;
    queue.push(v);
    fill(begin(visited), end(visited), false);
    visited[v] = true;

    while (!queue.empty()) {
        int now = queue.front();
        queue.pop();
        cout << now << " ";

        for (int next : adjList[now]) {
            if (!visited[next]) {
                visited[next] = true;
                queue.push(next);
            }
        }
    }
}

int main() {
    cin >> N >> M >> V;
    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        adjList[a].push_back(b);
        adjList[b].push_back(a);
    }

    // 방문할 수 있는 정점 오름차순 정렬
    for (int i = 0; i < 1001; i++) {
        sort(adjList[i].begin(), adjList[i].end());
    }

    DFS(V);
    cout << endl;
    BFS(V);
    cout << endl;

    return 0;
}