//
// Created by Manwel Bugeja on 20/12/2019.
//

#include <iostream>
#include "ImmutableLinkedList.h"

template <typename T>
ImmutableLinkedList<T>::ImmutableLinkedList() : isEmpty(true), value(0), nextPtr(nullptr) {
}

template <typename T>
ImmutableLinkedList<T>::ImmutableLinkedList(T newValue, bool isEmpty, ImmutableLinkedList* nextPtr) : isEmpty(isEmpty), value(newValue), nextPtr(nextPtr) {
}

template <typename T>
void ImmutableLinkedList<T>::print() const {
    if(this->isEmpty) {
        std::cout << std::endl;
        return;
    }

    std::cout << this->value << " ";
    this->nextPtr->print();
}

template <typename T>
ImmutableLinkedList<T>* ImmutableLinkedList<T>::copy() const {
    auto newList = new ImmutableLinkedList<T>();

    if(this->isEmpty) {
        return newList;
    } else {
        newList = new ImmutableLinkedList<T>(this->value, false, this->nextPtr->copy());
    }

    return newList;
}

template <typename T>
ImmutableLinkedList<T>* ImmutableLinkedList<T>::push(T newValue) const {
    ImmutableLinkedList* newList = this->copy;
    auto newNode = new ImmutableLinkedList(newValue, false, newList);
}

template <typename T>
ImmutableLinkedList<T>* ImmutableLinkedList<T>::pop() const {
    ImmutableLinkedList<T>* newList = this->nextPtr->copy();
    return newList;
}

template <typename T>
ImmutableLinkedList<T>* ImmutableLinkedList<T>::clear() const {
    auto newList = new ImmutableLinkedList<T>();
    return newList;
}
