#include <iostream>

using namespace std;

/*
Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word of a phrase that is the same forward and backwards.
*/
bool palindromePermutation(string data);
int main()
{
    string data1 = "Tact Coa";
    string data2 = "Tact Co";

    cout << "palindromePermutation(Tact Coa)? -> " << palindromePermutation(data1) << endl;
    cout << "palindromePermutation(Tact Co)? -> " << palindromePermutation(data2) << endl;
    return 0;
}
bool palindromePermutation(string data){
    int table[(int)'z' - (int)'a'] = {0};
    bool oneOdd = false;
    for(int i = 0; i < data.length(); i++){
        if(data[i] <= 'Z' && data[i] >= 'A')//its uppercased https://stackoverflow.com/questions/313970/how-to-convert-an-instance-of-stdstring-to-lower-case
        {
            table[ (int)data[i] - (int)'a' - ('Z' - 'z')]++;
        }
        else
            table[(int)data[i] - (int)'a']++;
    }

    for(int i = 0; i < 25; i++){
        if(table[i]%2 == 1){
            if(oneOdd)
                return false; //already found an odd
            else
                oneOdd = true; //found one odd
        }
    }
    return true;
}
