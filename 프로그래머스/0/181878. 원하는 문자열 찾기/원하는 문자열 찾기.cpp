#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    for (char &c : myString) {
        c = toupper(c);
    }
    
    for (char &c : pat) {
        c = toupper(c);
    }
    
    if (myString.find(pat) == string::npos) {
        return 0;
    } else {
        return 1;
    }
}