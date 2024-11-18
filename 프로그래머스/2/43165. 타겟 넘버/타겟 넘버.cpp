#include <string>
#include <vector>

using namespace std;

vector<int> nums;
int tgt;
int answer = 0;

void dfs(int idx, int sum) {
    if (idx == nums.size()) {
        answer = (sum == tgt) ? answer + 1 : answer;
        return;
    }
    
    dfs(idx + 1, sum + nums[idx]);
    dfs(idx + 1, sum - nums[idx]);
}

int solution(vector<int> numbers, int target) {
    tgt = target;
    nums = numbers;
    
    dfs(0, 0);
    
    return answer;
}