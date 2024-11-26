#include <iostream>
#include <vector>

using namespace std;

int N, K;
vector<int> coin;

int main() {
    cin >> N >> K;
    for (int i = 0; i < N; i++) {
        int A;
        cin >> A;
        coin.push_back(A);
    }

    int idx = N - 1;
    int answer = 0;
    while (K > 0) {
        answer += (K / coin[idx]);
        K %= coin[idx];
        idx--;
    }

    cout << answer;

    return 0;
}