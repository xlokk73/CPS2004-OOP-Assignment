#include <iostream>
#include "immutable_list.hpp"

int main(void){
    std::cout << "Hello, World!" << std::endl;

    immutable_list<int>* list1 = new immutable_list(2);
    std::cout << "PRINTING list1" << std::endl;
    list1->print();


    immutable_list<int>* list2 = list1->add(3);
    std::cout << "PRINTING list2" << std::endl;
    list2->print();

    immutable_list<int>* list3 = list2->add(4);
    std::cout << "PRINTING list3" << std::endl;
    list3->print();

    immutable_list<int>* list4 = new immutable_list(9);
    immutable_list<int>* list5 = list4->add(8)->add(7)->add(6);
    std::cout << "PRINTING list4" << std::endl;
    list4->print();
    std::cout << "PRINTING list5" << std::endl;
    list5->print();

    immutable_list<int>* list6 = list5->remove();
    std::cout << "PRINTING list5" << std::endl;
    list5->print();
    std::cout << "PRINTING list6" << std::endl;
    list6->print();

    list6 = list6->clear();
    std::cout << "PRINTING list6" << std::endl;
    list6->print();
    
    std::cout << "PRINTING list7" << std::endl;
    immutable_list<int> list7(2);
    list7.print();
    return 0;
};
