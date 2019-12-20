//
// Created by Manwel Bugeja on 20/12/2019.
//

#ifndef TASK2_IMMUTABLELINKEDLIST_H
#define TASK2_IMMUTABLELINKEDLIST_H

#include "ImmutableList.h"

template <typename T>
class ImmutableLinkedList : public ImmutableList<T> {
private:
    const bool isEmpty;
    const T value;
    const ImmutableLinkedList<T>* nextPtr;

    ImmutableLinkedList<T>(T, bool, ImmutableLinkedList*);

public:
    ImmutableLinkedList<T>();
    ImmutableLinkedList<T>* copy() const;
    ImmutableLinkedList<T>* push(T) const;
    ImmutableLinkedList<T>* pop() const;
    ImmutableLinkedList<T>* clear() const;
    void print() const;
};





#endif //TASK2_IMMUTABLELINKEDLIST_H
