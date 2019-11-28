#include <iostream>

template<typename T>
class immutable_linked_list{
    private:
        const bool is_empty;
        const T value;
        const immutable_linked_list<T>* next_ptr;

        immutable_linked_list<T>(T, bool, immutable_linked_list*);

    public:
        immutable_linked_list<T>(void);
        immutable_linked_list<T>* copy(void) const;
        immutable_linked_list<T>* push(T) const;
        immutable_linked_list<T>* pop(void) const;
        immutable_linked_list<T>* clear(void) const;

        void print(void) const;
};

template<typename T>
immutable_linked_list<T>::immutable_linked_list(void) : is_empty(true), value(0), next_ptr(nullptr){
}

template<typename T>
immutable_linked_list<T>::immutable_linked_list(T new_value, bool is_empty, immutable_linked_list* next_ptr) : is_empty(is_empty), value(new_value), next_ptr(next_ptr){
}

template<typename T>
void immutable_linked_list<T>::print(void) const{
    if(this->is_empty){
        std::cout << std::endl;
        return;
    }

    std::cout << this->value << " ";
    this->next_ptr->print();
}

template<typename T>
immutable_linked_list<T>* immutable_linked_list<T>::copy(void) const{
    immutable_linked_list<T>* new_list = new immutable_linked_list<T>();
    
    if(this->is_empty){
        return new_list;
    }

    else{
        new_list = new immutable_linked_list<T>(this->value, false, this->next_ptr->copy());
    }
    
    return new_list;
}

template<typename T>
immutable_linked_list<T>* immutable_linked_list<T>::push(T new_value) const{
    immutable_linked_list<T>* new_list = this->copy();
    immutable_linked_list<T>* new_node = new immutable_linked_list(new_value, false, new_list);
    return new_node;
}

template<typename T>
immutable_linked_list<T>* immutable_linked_list<T>::pop(void) const{
    immutable_linked_list<T>* new_list = this->next_ptr->copy();
    return new_list;
}
    
template<typename T>
immutable_linked_list<T>* immutable_linked_list<T>::clear(void) const{
    immutable_linked_list<T>* new_list = new immutable_linked_list();
    return new_list;
}
