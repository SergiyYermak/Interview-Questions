#include <iostream>
using namespace std;

//Given two strings, write a method to decide if one is a permutation or the other.
bool isPermutation(string data1, string data2);
int main()
{
    string data1 = "Hello";
    string data2 = "eolHl";
    string data3 = "eolH";
    cout << "isPermutation(Hello, eolHl)? -> " << isPermutation(data1, data2) << endl;
    cout << "isPermutation(Hello, eolH)? -> " << isPermutation(data1, data3) << endl;

    return 0;
}
bool isPermutation(string data1, string data2){
    if(data1.length() == data2.length())
    {
        for(int i=0; i<data1.length(); i++){
            for(int j=0; j<data2.length(); j++){
                if(data1[i] == data2[j])
                    data2.erase(data2.begin()+j);
            }
        }
    }

    if(data2.length() > 0)
        return false;
    else
        return true;
}
