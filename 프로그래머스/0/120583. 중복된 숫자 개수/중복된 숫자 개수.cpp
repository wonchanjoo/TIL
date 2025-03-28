#include <string>
#include <vector>

using namespace std;

int solution(vector<int> array, int n) {
    int answer = 0;
    for (int i : array) {
        answer = (i == n) ? (answer + 1) : answer;
    }
    return answer;
}