#pragma once
template <class Type>
class nodeType
{
public:
	Type value;
	Type minValue;
	nodeType();
	nodeType(Type value);
	//friend ostream& operator<<(ostream& os, const nodeType& nt);
};
template <class Type>
nodeType<Type>::nodeType()
{
	value = 0;
	minValue = 0;
}
template <class Type>
nodeType<Type>::nodeType(Type newValue)
{
	value = newValue;
}
/*
template <class nodeType>
ostream& operator<<(ostream& os, const nodeType& nt)
{
	os << nt.value;
	return os;
}
*/

template <class nodeType>
class stackADT
{
public:
	virtual void initializeStack() = 0;
		//Method to initialize the stack to an empty state.
		//Postcondition: Stack is empty.

	virtual bool isEmptyStack() const = 0;
		//Function to determine whether the stack is empty.
		//Postcondition:	Returns true if the stack is empty,
		//			otherwise returns false.

	virtual bool isFullStack() const = 0;
		//Function to determine wheter the stack is full.
		//Postcondition:	Returns true if the stack is full,
		//			otherwise returns false.

	virtual void push(const nodeType& newItem) = 0;
		//Function to add newItem to the stack.
		//Precondition: The stack exists and is not full.
		//Postcondition:	The stack is changed and newItem
		//			is added to the top of the stack.

	virtual nodeType top() const = 0;
		//Function to return the top element of the stack.
		//Precondition: The stack exists and is not empty.
		//Postcondition:	If the stack is empty, the program
		//			terminates; otherwise, the top element
		//			of the stack is returned

	virtual void pop() = 0;
		//Function to removed the top element of the stack.
		//Precondition: The stack exists and is not empty.
		//Postcondition:	The stack is changed and the top
		//			element is removed from the stack.
};