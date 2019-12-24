#include <iostream>
#include <thread>
#include <string>
#include "ImmutableLinkedList.h"

void func(ImmutableLinkedList<int>* list, int n) {
    std::cout << "adding " << n << " from within new thread" << std::endl;
    auto newList = list->push(n);
    std::cout << "printing edited list" << std::endl;
    newList->print();
    std::cout << std::endl;
}

int main() {
    std::cout << "Hello, World!" << std::endl;

    auto list1 = new ImmutableLinkedList<int>();
    auto list2 = list1->push(2);
    auto list3 = list2->push(3);
    std::cout << "printing list3" << std::endl;
    list3->print();
    std::cout << std::endl;

    std::cout << "printing list2" << std::endl;
    list2->print();
    std::cout << std::endl;

    auto list4 = list3->push(4)->push(5)->push(6);
    std::cout << "printing list4" << std::endl;
    list4->print();
    std::cout << std::endl;

    auto list5 = list4->pop();
    std::cout << "printing list5" << std::endl;
    list5->print();
    std::cout << std::endl;

    auto list6 = new ImmutableLinkedList<int>();
    auto list7 = list6->push(10)->push(9)->push(8)->push(7);
    std::cout << "printing list6" << std::endl;
    list7->print();
    std::cout << std::endl;

    std::cout << "new thread with list7 passed" << std::endl;
    std::thread th1(&func, list7, 6);
    std::cout << "new thread with list7 passed" << std::endl;
    std::thread th2(&func, list7, 5);
    th1.join();
    th2.join();

    std::cout << "Outside thread" << std::endl;
    std::cout << "printing list7"<< std::endl;
    list7->print();

    return 0;
}
