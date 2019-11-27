#include <iostream>
#include "immutable_list.hpp"

int main(void){
    std::cout << "Hello, World!" << std::endl;

    immutable_list<int>* list1 = new immutable_list<int>(); 
    immutable_list<int>* list2 = list1->push(2);
    immutable_list<int>* list3 = list2->push(3);
    std::cout << "printing list3" << std::endl;
    list3->print();
    std::cout << "printing list2" << std::endl;
    list2->print();
    immutable_list<int>* list4 = list3->push(4)->push(5)->push(6);
    std::cout << "printing list4" << std::endl;
    list4->print();

    immutable_list<int>* list5 = list4->pop();
    std::cout << "printing list5" << std::endl;
    list5->print();

    return 0;
}
