#define MAX 1000001
#include <iostream>
#include <queue>

using namespace std;

int N;
int cnt[MAX];
queue<int> q;

int main() {
    cin >> N;

    q.push(N);
    while (!q.empty()) {
        int n = q.front();
        q.pop();

        if (n % 3 == 0 && cnt[n / 3] == 0) {
            cnt[n / 3] = cnt[n] + 1;
            q.push(n / 3);
        }
        if (n % 2 == 0 && cnt[n / 2] == 0) {
            cnt[n / 2] = cnt[n] + 1;
            q.push(n / 2);
        }
        if (n - 1 >= 0 && cnt[n - 1] == 0) {
            cnt[n - 1] = cnt[n] + 1;
            q.push(n - 1);
        }

        if (cnt[1] != 0) {
            break;
        }
    }

    cout << cnt[1];

    return 0;
}