#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

unordered_map<int, int> map;

int solution(vector<int> array) {
    for (auto i : array) {
        map[i]++;
    }
    
    int maxFrequency = 0;
    int answer = -1;
    bool hasDuplicate = false;
    
    for (auto& pair : map) {
        if (maxFrequency < pair.second) {
            maxFrequency = pair.second;
            answer = pair.first;
            hasDuplicate = false;
        } else if (pair.second == maxFrequency) {
            hasDuplicate = true;
        }
    }
    
    if (hasDuplicate) {
        answer = -1;
    }
    
    return answer;
}