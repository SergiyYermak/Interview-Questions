#include <iostream>

using namespace std;
/*
There are three types of edits that can be performed on string: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, pales -> true
pale, pal -> true
pale, bale ->true
pale, bake -> false
*/
bool oneAway(string data, string data2);
int main()
{
    string data1 = "pale";
    string data2 = "pales";
    string data3 = "pal";
    string data4 = "bale";
    string data5 = "bake";
    string data6 = "paleee";
    cout << "oneAway(pale, pales) ->" << oneAway(data1, data2) << endl; //true
    cout << "oneAway(pale, pal) ->" << oneAway(data1, data3) << endl; //true
    cout << "oneAway(pale, bale) ->" << oneAway(data1, data4) << endl; //true
    cout << "oneAway(pale, bake) ->" << oneAway(data1, data5) << endl; //false
    cout << "oneAway(pale, please) ->" << oneAway(data1, data6) << endl; //false
    return 0;
}
bool oneAway(string data, string data2)
{
    if(data2.length() > data.length()+1 || data2.length() < data.length()-1)
        return false;

    if(data.length() == data2.length()) //replace edit?
    {
        bool oneDiff = false; //if no difference then its not one away
        for(int i = 0; i < data.length(); i++)
        {
            if(data[i] != data2[i]) //found a difference?
                if(oneDiff) //second time found a difference?
                    return false; //multiple edits away
                else
                    oneDiff = true; //first difference
        }
        return oneDiff;
    }
    else //one up/down difference
    {
        if(data.length() > data2.length())//can we insert into data2 to make data?
        {
            for(int i = 0; i<data.length(); i++)
            {
                if(data[i] != data2[i])
                {
                    string temp = data2.insert(i,1,data[i]);
                    if(temp == data)
                        return true;
                }
            }
        }
        else // can we insert into data to make data2?
        {
            for(int i = 0; i<data2.length(); i++)
            {
                if(data2[i] != data[i])
                {
                    string temp = data.insert(i,1,data2[i]);
                    if(temp == data2)
                        return true;
                }
            }
        }
    }
}







