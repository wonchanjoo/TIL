#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    int tmp = -1;
    for (int i : arr) {
        if (tmp != i) {
            answer.push_back(i);
            tmp = i;
        }
    }
    
    return answer;
}