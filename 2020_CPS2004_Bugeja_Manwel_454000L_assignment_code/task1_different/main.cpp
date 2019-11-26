#include <iostream>
#include "immutable_list.hpp"

int main(void){
    std::cout << "Hello, World!" << std::endl;
    immutable_list* list1 = new immutable_list(2);

    std::cout << "PRINTING list1" << std::endl;
    list1->print();

    immutable_list* list2 = list1->copy();
    std::cout << "PRINTING list2" << std::endl;
    list2->print();


    return 0;
};
