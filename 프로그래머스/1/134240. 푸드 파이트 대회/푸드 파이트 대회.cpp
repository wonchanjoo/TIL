#include <string>
#include <vector>

using namespace std;

string solution(vector<int> food) {
    string tmp = "";
    for (int i = 1; i < food.size(); i++) {
        tmp += string(food[i] / 2, char(i + '0'));
    }
    
    string answer = tmp + '0';
    for (int i = tmp.size() - 1; i >= 0; i--) {
        answer += tmp[i];
    }
    
    return answer;
}