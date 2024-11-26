#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
vector<int> arr;

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        int P;
        cin >> P;
        arr.push_back(P);
    }

    sort(arr.begin(), arr.end());

    int answer = 0;
    int pre = 0;
    for (auto i : arr) {
        pre += i;
        answer += pre;
    }

    cout << answer;

    return 0;
}