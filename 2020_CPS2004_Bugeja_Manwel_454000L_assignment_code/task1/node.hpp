template<typename T>
class node{
    private:
        const bool is_empty;
        const T value;
        const node<T>* next_ptr;

    public:
        virtual node<T>* copy(void) const;
        virtual node<T>* push(T) const;
        virtual node<T>* pop(void) const;
        virtual node<T>* clear(void) const;
};
