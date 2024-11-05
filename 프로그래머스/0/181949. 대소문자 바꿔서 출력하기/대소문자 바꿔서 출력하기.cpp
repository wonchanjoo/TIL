#include <iostream>
#include <string>
#include <locale>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    
    for (char c : str) {
        if (islower(c)) {
            cout << char(toupper(c));
        } else {
            cout <<  char(tolower(c));
        }
    }
    
    return 0;
}