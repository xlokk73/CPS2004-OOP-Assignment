#include <iostream>

class immutable_list{
    private:
        int count;
        int node_value;
        immutable_list* next_ptr;

        void change_last_ptr(immutable_list*);
        void clear_last_ptr(void);

    public:
        immutable_list(int);

        int value(void);
        void print(void);

        immutable_list* copy(void);
        immutable_list* push_back(int);
        immutable_list* remove(void);
 };
   
immutable_list::immutable_list(int new_value){
    this->node_value = new_value;
    this->count = 1;
    this->next_ptr = nullptr;
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
    
    if(this->next_ptr == nullptr){
        new_list = new immutable_list(this->node_value);
    }

    else{
        new_list = new immutable_list(this->node_value);
        new_list->next_ptr = this->next_ptr->copy();
    }
    
    return new_list;
}

void immutable_list::change_last_ptr(immutable_list* new_ptr){
    if(this->next_ptr == nullptr){
        this->next_ptr = new_ptr;
    }

    else{
        this->next_ptr->change_last_ptr(new_ptr);
    }
}

immutable_list* immutable_list::push_back(int new_value){
    immutable_list* new_list = this->copy();
    immutable_list* last_node = new immutable_list(new_value);
    new_list->change_last_ptr(last_node);
    return new_list;
}

void immutable_list::clear_last_ptr(void){
    if(this->next_ptr == nullptr){
        std::cout << "error: cannot have an empty list" << std::endl;
        return;
    }

    else if(this->next_ptr->next_ptr == NULL){
        delete this->next_ptr;
        this->next_ptr = nullptr;
    }

    else{
        this->next_ptr->clear_last_ptr();
    }
}

immutable_list* immutable_list::remove(void){
    immutable_list* new_list = this->copy();
    new_list->clear_last_ptr();
    return new_list;
}
