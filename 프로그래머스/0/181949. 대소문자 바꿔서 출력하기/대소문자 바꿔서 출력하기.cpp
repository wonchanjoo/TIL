#include <iostream>
#include <string>
#include <locale>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    
    string answer = "";
    for (int i = 0; i < str.length(); i++) {
        if (str[i] >= 'a' && str[i] <= 'z') {
            answer += toupper(str[i]);
        } else {
            answer += tolower(str[i]);
        }
    }
    
    cout << answer;
    
    return 0;
}