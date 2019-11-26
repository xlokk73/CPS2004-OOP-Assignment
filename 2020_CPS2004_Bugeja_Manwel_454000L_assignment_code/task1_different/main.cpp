#include <iostream>
#include "immutable_list.hpp"

int main(void){
    std::cout << "Hello, World!" << std::endl;

    immutable_list* list1 = new immutable_list(2);
    std::cout << "PRINTING list1" << std::endl;
    list1->print();


    immutable_list* list2 = list1->push_back(3);
    std::cout << "PRINTING list2" << std::endl;
    list2->print();

    immutable_list* list3 = list2->push_back(4);
    std::cout << "PRINTING list3" << std::endl;
    list3->print();

    immutable_list* list4 = new immutable_list(9);
    immutable_list* list5 = list4->push_back(8)->push_back(7);
    std::cout << "PRINTING list4" << std::endl;
    list4->print();
    std::cout << "PRINTING list5" << std::endl;
    list5->print();

    return 0;
};
