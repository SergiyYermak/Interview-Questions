#include <iostream>
#include "myStack.h"
using namespace std;

int main()
{
	stackType< nodeType<char> > stack(50);
	nodeType<char> newNode('a');
	stack.initializeStack();
	stack.push(newNode);

	cout << "stack: ";
	while (!stack.isEmptyStack())
	{
		cout << stack.top().value << " ";
		stack.pop();
	}
	cout << endl;

	return 0;
}
