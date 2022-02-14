#include <iostream>
using namespace std;
/*
Write a method to replace all spaces in a string with "%20". YOu may assume that the string has sufficient
space at the end to hold the additional characters, and that you are given the "true" length of the string.
*/
string URLify(string data, int trueLength);
int main()
{
    string data1 = "Mr John Smith";
    cout << "URLify(Mr John Smith)? -> " << URLify(data1, data1.length()) << endl;
    return 0;
}
string URLify(string data, int trueLength){
    string URL = "%20";
    for(int i = 0; i < trueLength; i++){
        if(data[i] == ' '){
            data.replace(i,1, URL);//(position to start?, how many chars replace?, with what?)
        }
    }
    return data;
}
