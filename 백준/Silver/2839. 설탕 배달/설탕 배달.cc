#include <iostream>

using namespace std;

int N;

int main() {
    cin >> N;

    int answer = N / 5;
    N %= 5;

    while (N > 0) {
        if (N % 3 == 0) {
            answer += N / 3;
            break;
        }

        N += 5;
        answer--;
        
        if (answer < 0) {
            answer = -1;
            break;
        }
    }

    cout << answer;

    return 0;
}