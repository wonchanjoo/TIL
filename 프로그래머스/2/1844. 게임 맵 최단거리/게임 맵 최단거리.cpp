#include<vector>
#include<queue>
#define MAX 101
using namespace std;

int n, m;
int dist[MAX][MAX];
bool visited[MAX][MAX];

int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};

bool rangeIn(int r, int c) {
    return (r > 0) && (c > 0) && (r <= n) && (c <= m);
}

int solution(vector<vector<int> > maps)
{
    n = maps.size();
    m = maps[0].size();
    
    queue<pair<int, int>> q;
    q.push(make_pair(1, 1));
    visited[1][1] = true;
    dist[1][1] = 1;
    
    while (!q.empty()) {
        int nowR = q.front().first;
        int nowC = q.front().second;
        q.pop();
        
        for (int i = 0; i < 4; i++) {
            int nextR = nowR + dr[i];
            int nextC = nowC + dc[i];
            if (rangeIn(nextR, nextC) && !visited[nextR][nextC] && maps[nextR - 1][nextC - 1] == 1) {
                q.push(make_pair(nextR, nextC));
                visited[nextR][nextC] = true;
                dist[nextR][nextC] = dist[nowR][nowC] + 1;
                
                if (nextR == n && nextC == m) {
                    break;
                }
            }
        }
    }
    
    if (visited[n][m]) {
        return dist[n][m];
    } else {
        return -1;
    }
}