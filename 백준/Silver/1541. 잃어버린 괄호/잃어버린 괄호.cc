#include <iostream>
#include <string>

using namespace std;

string str, num;
int tmp = 1;
int answer = 0;

int main() {
    cin >> str;

    for (int i = 0; i < str.size(); i++) {
        if (str[i] == '+' || str[i] == '-') {
            answer += (stoi(num) * tmp);
            tmp = (str[i] == '-') ? -1 : tmp;
            num = "";
        } else {
            num += str[i];
        }
    }
    answer += (stoi(num) * tmp);

    cout << answer;

    return 0;
}