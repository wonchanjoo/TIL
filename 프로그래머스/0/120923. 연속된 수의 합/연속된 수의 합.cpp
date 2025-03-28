#include <string>
#include <vector>
#include <numeric>

using namespace std;

vector<int> solution(int num, int total) {
    vector<int> answer(num);
    int start = (2 * total / num - num + 1) / 2;
    iota(answer.begin(), answer.end(), start);
    return answer;
}