#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N;
vector<pair<int, int>> meeting;

bool compare(pair<int, int> a, pair<int, int> b) {
    if (a.second == b.second) {
        return a.first < b.first;
    }

    return a.second < b.second;
}

int main() {
    cin >> N;
    for (auto i = 0; i < N; i++) {
        int s, e;
        cin >> s >> e;
        meeting.push_back(make_pair(s, e));
    }

    sort(meeting.begin(), meeting.end(), compare);

    int answer = 1;
    int end = meeting[0].second;
    for (auto i = 1; i < N; i++) {
        if (end <= meeting[i].first) {
            end = meeting[i].second;
            answer++;
        }
    }

    cout << answer;

    return 0;
}