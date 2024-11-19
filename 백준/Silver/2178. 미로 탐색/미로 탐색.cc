#include <iostream>
#include <queue>

using namespace std;

int N, M;
int map[101][101];
int dist[101][101];
bool visited[101][101];

int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};

bool rangeIn(int r, int c) {
    return (r > 0) && (c > 0) && (r <= N) && (c <= M);
}

void move() {
    queue<pair<int, int>> q;
    q.push(make_pair(1, 1));
    dist[1][1] = 1;
    visited[1][1] = true;

    while (!q.empty()) {
        pair now = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nextR = now.first + dr[i];
            int nextC = now.second + dc[i];

            if (rangeIn(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == 1) {
                visited[nextR][nextC] = true;
                dist[nextR][nextC] = dist[now.first][now.second] + 1;
                q.push(make_pair(nextR, nextC));

                if (nextR == N && nextC == M) {
                    break;
                }
            }
        }
    }
}

int main() {
    cin >> N >> M;
    for (int r = 1; r <= N; r++) {
        string s;
        cin >> s;
        for (int c = 1;c <= M; c++) {
            map[r][c] = s[c - 1] - '0';
        }
    }

    move();

    cout << dist[N][M] << endl;

    return 0;
}