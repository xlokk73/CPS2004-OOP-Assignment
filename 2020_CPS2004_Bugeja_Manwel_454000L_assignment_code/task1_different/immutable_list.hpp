#include <iostream>

template<class T>
class immutable_list{
    private:
        T node_value;
        immutable_list<T>* next_ptr;

        void change_last_ptr(immutable_list<T>*);
        void clear_last_ptr(void);

    public:
        immutable_list<T>(T new_value);
        T value(void);
        void print(void);

        immutable_list<T>* copy(void);
        immutable_list<T>* add(T);
        immutable_list<T>* remove(void);
        immutable_list<T>* clear(void);
 };
   
template<class T>
immutable_list<T>::immutable_list(T new_value){
    this->node_value = new_value;
    this->next_ptr = nullptr;
}


template<class T>
T immutable_list<T>::value(void){
    return this->node_value;
}

template<class T>
void immutable_list<T>::print(void){
    if(this->next_ptr != nullptr){
        std::cout << this->node_value << ", ";
        this->next_ptr->print();
    }

    else{
        std::cout << this->node_value << std::endl;
    }
}

template<class T>
immutable_list<T>* immutable_list<T>::copy(void){
    immutable_list<T>* new_list = new immutable_list<T>(this->node_value);
    
    if(this->next_ptr == nullptr){
        new_list = new immutable_list<T>(this->node_value);
    }

    else{
        new_list = new immutable_list<T>(this->node_value);
        new_list->next_ptr = this->next_ptr->copy();
    }
    
    return new_list;
}

template<class T>
void immutable_list<T>::change_last_ptr(immutable_list<T>* new_ptr){
    if(this->next_ptr == nullptr){
        this->next_ptr = new_ptr;
    }

    else{
        this->next_ptr->change_last_ptr(new_ptr);
    }
}

template<class T>
immutable_list<T>* immutable_list<T>::add(T new_value){
    immutable_list<T>* new_list = this->copy();
    immutable_list<T>* last_node = new immutable_list<T>(new_value);
    new_list->change_last_ptr(last_node);
    return new_list;
}

template<class T>
void immutable_list<T>::clear_last_ptr(void){
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

template<class T>
immutable_list<T>* immutable_list<T>::remove(void){
    immutable_list<T>* new_list = this->copy();
    new_list->clear_last_ptr();
    return new_list;
}

template<class T>
immutable_list<T>* immutable_list<T>::clear(void){
    immutable_list<T>* new_list = this->copy();

    if(new_list->next_ptr == nullptr){
        return new_list;
    }

    else{
        return new_list->next_ptr->clear();
    }
}
