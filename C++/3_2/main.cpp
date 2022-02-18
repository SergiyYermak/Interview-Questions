#include <iostream>
#include "myStack.h"
using namespace std;
/*
3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop, and min should all operate in O(1) time.

Initial thoughts: At first I thought min() would work like pop(). Where I had to keep a min item off
to the side and pop it from stack when called. However, I realized that I just had to print the
number. The solution I came up with was to have the items be nodes with a value and stackMinValue.
So when you push an item, it asks the previous item what the minimum is. If the new item value is
less, set newItem.minValue to newItem.value. Otherwise newItem.minValue is previousItem.minValue.
So the top always knows what the min is and even if you pop it off, the previous item knows what
the min value is below it.

Problem. I had a stackADT.h and myStack.h copied from "C++ Programming From Problem Analysis to Program Design 8th Edition".
It's nice because you can use any comparable type (int, double, char). However, the items were not nodes, they only held one value.
So I had to add another template of <Type> that held two <Type> variables (value, minValue)
Then stackADT would be <nodeType> type and so myStack would have a list of nodeType. This was harder to implement than to
imagine.
*/
int main()
{
	stackType< nodeType<int> > stack(50);
	stack.initializeStack();

	nodeType<int> newNode0(6);
	nodeType<int> newNode1(3);
	nodeType<int> newNode2(4);
	nodeType<int> newNode3(5);
	nodeType<int> newNode4(2);
	nodeType<int> newNode5(7);

	stack.push(newNode0);
	stack.push(newNode1);
	stack.push(newNode2);
	stack.push(newNode3);
	stack.push(newNode4);
	stack.push(newNode5);
	cout << "pushed onto the stack: 6,3,4,5,2,7" << endl;
	stack.minValue();

	stack.pop();
	stack.pop();
	cout << "popped off the stack: 7,2" << endl;
	stack.minValue();

	return 0;
}
