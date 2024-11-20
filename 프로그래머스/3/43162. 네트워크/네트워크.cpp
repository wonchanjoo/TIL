#include <string>
#include <vector>
#include <queue>
#define MAX 200

using namespace std;

vector<vector<int>> computers_;
bool visited[MAX];

void bfs(int i) {
    queue<int> q;
    q.push(i);
    visited[i] = true;
    
    while (!q.empty()) {
        int now = q.front();
        q.pop();
        
        for (int j = 0; j < computers_[now].size(); j++) {
            if (!visited[j] && computers_[now][j] == 1) {
                visited[j] = true;
                q.push(j);
            }
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    computers_ = computers;
    
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            bfs(i);
            answer++;
        }
    }
    
    return answer;
}