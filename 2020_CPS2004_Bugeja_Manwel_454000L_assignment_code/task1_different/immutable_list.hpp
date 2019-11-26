#include <iostream>

class immutable_list{
    private:
        int count;
        int node_value;
        immutable_list* next_ptr;
        immutable_list* prev_ptr;

    public:
        int value(void);
        immutable_list(int);
        immutable_list push_back(int);
        void print(void);
        immutable_list* copy(void);
 };
   
immutable_list::immutable_list(int new_value){
    this->node_value = new_value;
    this->count = 1;
}

int immutable_list::value(void){
    return this->node_value;
}

void immutable_list::print(void){
    if(this->next_ptr != nullptr){
        std::cout << this->node_value << ", ";
        this->next_ptr->print();
    }

    else{
        std::cout << this->node_value << std::endl;
    }
}

immutable_list* immutable_list::copy(void){
    immutable_list* new_list = new immutable_list(this->node_value);
    
         
    
    return new_list;
}
