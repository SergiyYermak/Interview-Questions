#include <iostream>
using namespace std;

//Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
bool isUnique(string data);
int main()
{
    string data1 = "Hello";
    string data2 = "Helo";
    cout << "isUnique(Hello)? -> " << isUnique(data1) << endl;
    cout << "isUnique(Helo)? -> " << isUnique(data2) << endl;

    return 0;
}
bool isUnique(string data){
    bool returnBool = true;
    int strLgth = data.length();
    for(int i = 0; i<strLgth; i++){
        for(int j = i+1; j<strLgth; j++){
            if(data[i] == data[j])
                returnBool = false;
        }
    }
    return returnBool;
}
