//
// Created by Manwel Bugeja on 20/12/2019.
//

#ifndef TASK2_IMMUTABLELIST_H
#define TASK2_IMMUTABLELIST_H

template<typename T>
class ImmutableList {
public:
    virtual ImmutableList<T>* copy() const = 0;
    virtual ImmutableList<T>* push(T) const = 0;
    virtual ImmutableList<T>* pop() const = 0;
    virtual ImmutableList<T>* clear() const = 0;
    virtual void print() const = 0;
};


#endif //TASK2_IMMUTABLELIST_H
