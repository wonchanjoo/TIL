#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    for (int i = 0; i < myString.size(); i++) {
        myString[i] = (myString[i] == 'A') ? 'B' : 'A';
    }
    
    if (myString.find(pat) == string::npos) {
        return 0;
    } else {
        return 1;
    }
}