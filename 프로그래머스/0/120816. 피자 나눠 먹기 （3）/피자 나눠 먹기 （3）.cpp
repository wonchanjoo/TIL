#include <string>
#include <vector>

using namespace std;

int solution(int slice, int n) {
    int answer = (n % slice == 0) ? (n / slice) : (n / slice + 1);
    return answer;
}