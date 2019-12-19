#include <iostream>

template<typename T>
class Immutable_list{
    private:
        int test;
    public:
        virtual Immutable_list<T>* copy(void) const = 0;
        virtual Immutable_list<T>* push(T) const = 0;
        virtual Immutable_list<T>* pop(void) const = 0;
        virtual Immutable_list<T>* clear(void) const = 0;
};

template<typename T>
class Immutable_linked_list : public Immutable_list<T>{
    private:
        const bool is_empty;
        const T value;
        const Immutable_linked_list<T>* next_ptr;

        Immutable_linked_list<T>(T, bool, Immutable_linked_list*);

    public:
        Immutable_linked_list<T>(void);
        // Immutable_linked_list<T>* copy(void) const;
        // Immutable_linked_list<T>* push(T) const;
        // Immutable_linked_list<T>* pop(void) const;
        // Immutable_linked_list<T>* clear(void) const;

        void print(void) const;
};

// template<typename T>
// Immutable_linked_list<T>::Immutable_linked_list(void) : is_empty(true), value(0), next_ptr(nullptr){
// }
// 
// template<typename T>
// Immutable_linked_list<T>::Immutable_linked_list(T new_value, bool is_empty, Immutable_linked_list* next_ptr) : is_empty(is_empty), value(new_value), next_ptr(next_ptr){
// }
// 
// template<typename T>
// void Immutable_linked_list<T>::print(void) const{
//     if(this->is_empty){
//         std::cout << std::endl;
//         return;
//     }
// 
//     std::cout << this->value << " ";
//     this->next_ptr->print();
// }
// 
// template<typename T>
// Immutable_linked_list<T>* Immutable_linked_list<T>::copy(void) const{
//     Immutable_linked_list<T>* new_list = new Immutable_linked_list<T>();
//     
//     if(this->is_empty){
//         return new_list;
//     }
// 
//     else{
//         new_list = new Immutable_linked_list<T>(this->value, false, this->next_ptr->copy());
//     }
//     
//     return new_list;
// }
// 
// template<typename T>
// Immutable_linked_list<T>* Immutable_linked_list<T>::push(T new_value) const{
//     Immutable_linked_list<T>* new_list = this->copy();
//     Immutable_linked_list<T>* new_node = new Immutable_linked_list(new_value, false, new_list);
//     return new_node;
// }
// 
// template<typename T>
// Immutable_linked_list<T>* Immutable_linked_list<T>::pop(void) const{
//     Immutable_linked_list<T>* new_list = this->next_ptr->copy();
//     return new_list;
// }
//     
// template<typename T>
// Immutable_linked_list<T>* Immutable_linked_list<T>::clear(void) const{
//     Immutable_linked_list<T>* new_list = new Immutable_linked_list();
//     return new_list;
// }
