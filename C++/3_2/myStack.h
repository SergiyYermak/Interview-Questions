#ifndef MYSTACK_H_INCLUDED
#define MYSTACK_H_INCLUDED
#include <iostream>
#include <cassert>
#include "stackADT.h"
using namespace std;

template <class nodeType>
class stackType : public stackADT<nodeType>
{
public:

    void minValue() const;

	const stackType<nodeType>& operator=(const stackType<nodeType>&);
	void initializeStack();
	bool isEmptyStack() const;
	bool isFullStack() const;
	void push(const nodeType& newItem);
	nodeType top() const;
	void pop();
	stackType(int stackSize = 100);
	stackType(const stackType<nodeType>& otherStack);
	~stackType();
private:

	int maxStackSize; //variable to store the maximum stack size
	int stackTop; //variable to point to the top of the stack
	nodeType *list; //pointer to the array that holds the
	//stack elements
	void copyStack(const stackType<nodeType>& otherStack);
};

    template <class nodeType>
    void stackType<nodeType>::minValue() const
    {
        if(stackTop == 0)
        {
            cout << "No minimum, the stack is empty" << endl;
        }
        else
            cout << "Minimum value in stack: " << list[stackTop - 1].minValue << endl;
    }

	template <class nodeType>
	void stackType<nodeType>::initializeStack()
	{
		stackTop = 0;
	}//end initializeStack

	template <class  nodeType>
	bool stackType< nodeType>::isEmptyStack() const
	{
		return (stackTop == 0);
	}//end isEmptyStack

	template <class nodeType>
	bool stackType<nodeType>::isFullStack() const
	{
		return (stackTop == maxStackSize);
	} //end isFullStack

	template <class nodeType>
	void stackType<nodeType>::push(const nodeType& newItem)
	{
		nodeType newElement = newItem;
		if (stackTop == 0)
		{
			newElement.minValue = newElement.value;
		}
		else if (newElement.value < list[stackTop - 1].minValue)
		{
			newElement.minValue = newElement.value;
		}
		else
		{
			newElement.minValue = list[stackTop - 1].minValue;
		}
		if (!isFullStack())
		{
			list[stackTop] = newElement; //add newItem to the
			//top of the stack
			stackTop++; //increment stackTop
		}
		else
			cout << "Cannot add to a full stack." << endl;
	}//end push

	template <class nodeType>
	nodeType stackType<nodeType>::top() const
	{
		assert(stackTop != 0); //if stack is empty,
		//terminate the program
		return list[stackTop - 1]; //return the element of the
		//stack indicated by
	   //stackTop - 1
	}//end top

	template <class nodeType>
	void stackType<nodeType>::pop()
	{
		if (!isEmptyStack())
			stackTop--; //decrement stackTop
		else
			cout << "Cannot remove from an empty stack." << endl;
	}//end pop

	template <class nodeType>
	stackType<nodeType>::stackType(int stackSize)
	{
		if (stackSize <= 0)
		{
			cout << "Size of the array to hold the stack must "
				<< "be positive." << endl;
			cout << "Creating an array of size 100." << endl;
			maxStackSize = 100;
		}
		else
			maxStackSize = stackSize; //set the stack size to
			//the value specified by
		   //the parameter stackSize
		stackTop = 0; //set stackTop to 0
		list = new nodeType[maxStackSize]; //create the array to
		//hold the stack elements
	}//end constructor

	template <class nodeType>
	stackType<nodeType>::~stackType() //destructor
	{
		delete[] list; //deallocate the memory occupied
		//by the array
	}//end destructor

	template <class nodeType>
	void stackType<nodeType>::copyStack(const stackType<nodeType>& otherStack)
	{
		delete[] list;
		maxStackSize = otherStack.maxStackSize;
		stackTop = otherStack.stackTop;
		list = new nodeType[maxStackSize];
		//copy otherStack into this stack
		for (int j = 0; j < stackTop; j++)
			list[j] = otherStack.list[j];
	} //end copyStack

	template <class nodeType>
	stackType<nodeType>::stackType(const stackType<nodeType>& otherStack)
	{
		list = nullptr;
		copyStack(otherStack);
	}//end copy constructor

	template <class nodeType>
	const stackType<nodeType>& stackType<nodeType>::operator=
		(const stackType<nodeType>& otherStack)
	{
		if (this != &otherStack) //avoid self-copy
			copyStack(otherStack);
		return *this;
	} //end operator=
#endif // MYSTACK_H_INCLUDED
