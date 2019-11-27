#include <iostream>

template<typename T>
class immutable_list{
    private:
        bool is_empty;
        T value;
        immutable_list<T>* next_ptr;

        immutable_list<T>(T, bool);

    public:
        immutable_list<T>(void);
        immutable_list<T>* copy(void);
        immutable_list<T>* add(T);
        immutable_list<T>* remove(void);
        immutable_list<T>* clear(void);

        void print(void);
};

template<typename T>
immutable_list<T>::immutable_list(void){
    this->is_empty = true;
    this->value = 0;
    this->next_ptr = nullptr;
}

template<typename T>
immutable_list<T>::immutable_list(T new_value, bool is_empty){
    this->is_empty = is_empty;
    this->value = new_value;
    this->next_ptr = nullptr;
}

template<typename T>
void immutable_list<T>::print(void){
    if(this->is_empty){
        std::cout << std::endl;
        return;
    }

    std::cout << this->value << " ";
    this->next_ptr->print();
}

template<class T>
immutable_list<T>* immutable_list<T>::copy(void){
    immutable_list<T>* new_list = new immutable_list<T>();
    
    if(this->is_empty){
        return new_list;
    }

    else{
        new_list = new immutable_list<T>(this->value, false);
        new_list->next_ptr = this->next_ptr->copy();
    }
    
    return new_list;
}

template<typename T>
immutable_list<T>* immutable_list<T>::add(T new_value){
    immutable_list<T>* new_list = this->copy();
    immutable_list<T>* new_node = new immutable_list(new_value, false);
    new_node->next_ptr = new_list;
    return new_node;
}
