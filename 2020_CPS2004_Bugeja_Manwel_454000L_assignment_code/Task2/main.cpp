#include <iostream>
#include "ImmutableLinkedList.h"

int main() {
    std::cout << "Hello, World!" << std::endl;

    auto list1 = new ImmutableLinkedList<int>();
    auto list2 = list1->push(2);
    auto list3 = list2->push(3);
    std::cout << "printing list3" << std::endl;
    list3->print();
    std::cout << "printing list2" << std::endl;
    list2->print();

    auto list4 = list3->push(4)->push(5)->push(6);
    std::cout << "printing list4" << std::endl;
    list4->print();

    auto list5 = list4->pop();
    std::cout << "printing list5" << std::endl;
    list5->print();

    return 0;
}
