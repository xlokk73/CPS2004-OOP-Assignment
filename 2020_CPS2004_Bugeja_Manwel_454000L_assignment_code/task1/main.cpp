#include <iostream>
#include "immutable_list.hpp"

int main(void){
    std::cout << "Hello, World!" << std::endl;

    immutable_list<int>* list1 = new immutable_list<int>(); 
    immutable_list<int>* list2 = list1->add(2);
    immutable_list<int>* list3 = list2->add(3);
    std::cout << "printing list3" << std::endl;
    list3->print();
    std::cout << "printing list2" << std::endl;
    list2->print();

    return 0;
}
