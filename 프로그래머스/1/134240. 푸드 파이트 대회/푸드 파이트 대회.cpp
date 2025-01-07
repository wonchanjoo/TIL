#include <string>
#include <vector>

using namespace std;

string solution(vector<int> food) {
    string answer = "0";
    
    for (int i = food.size() - 1; i > 0; i--) {
        string tmp = string(food[i] / 2, char(i + '0'));
        answer = tmp + answer + tmp;
    }
    
    return answer;
}