//#include <cassert>
//#include <iostream>
//#include <vector>
//
//template<typename T, typename Cont= std::vector<T> >
//class Expr{
//    Cont cont;
//
//public:
//
//    // Expr initialize with value
//    Expr(const double initialValue) : cont(1, initialValue){}
//
//    // Constructor for underlying container
//    Expr(const Cont& other) : cont(other){}
//
//    // returns the underlying data
//    const Cont& data() const{
//        return cont;
//    }
//
//    double eval() {
//        return cont[0];
//    }
//};
//
//// elementwise Expr + Expr
//template<typename T, typename Op1 , typename Op2>
//class Plus{
//    const Op1& op1;
//    const Op2& op2;
//
//public:
//    Plus(const Op1& a, const Op2& b): op1(a), op2(b){}
//
//    T operator[](const std::size_t i) const{
//        return op1[i] + op2[i];
//    }
//};
//
//// elementwise Expr * Expr
//template< typename T, typename Op1 , typename Op2 >
//class Multiply {
//    const Op1& op1;
//    const Op2& op2;
//
//public:
//    Multiply(const Op1& a, const Op2& b ): op1(a), op2(b){}
//
//    T operator[](const std::size_t i) const{
//        return op1[i] * op2[i];
//    }
//};
//
//// elementwise Expr - Expr
//template< typename T, typename Op1, typename Op2 >
//class Subtract {
//    const Op1& op1;
//    const Op2& op2;
//
//public:
//    Subtract(const Op1& a, const Op2& b ): op1(a), op2(b){}
//
//    T operator[](const std::size_t i) const{
//        return op1[i] - op2[i];
//    }
//};
//
//template<typename T, typename Op1 , typename Op2>
//class Divide{
//    const Op1& op1;
//    const Op2& op2;
//
//public:
//    Divide(const Op1& a, const Op2& b): op1(a), op2(b){}
//
//    T operator[](const std::size_t i) const{
//        return op1[i] / op2[i];
//    }
//};
//
//// function template for the + operator
//template<typename T, typename R1, typename R2>
//Expr<T, Plus<T, R1, R2> >
//operator+ (const Expr<T, R1>& a, const Expr<T, R2>& b){
//    return Expr<T, Plus<T, R1, R2> >(Plus<T, R1, R2 >(a.data(), b.data()));
//}
//
//// function template for the * operator
//template<typename T, typename R1, typename R2>
//Expr<T, Multiply< T, R1, R2> >
//operator* (const Expr<T, R1>& a, const Expr<T, R2>& b){
//    return Expr<T, Multiply<T, R1, R2> >(Multiply<T, R1, R2 >(a.data(), b.data()));
//}
//
//// function template for the - operator
//template<typename T, typename R1, typename R2>
//Expr<T, Subtract< T, R1, R2> >
//operator- (const Expr<T, R1>& a, const Expr<T, R2>& b){
//    return Expr<T, Subtract<T, R1, R2> >(Subtract<T, R1, R2 >(a.data(), b.data()));
//}
//
//// function template for the / operator
//template<typename T, typename R1, typename R2>
//Expr<T, Divide< T, R1, R2> >
//operator/ (const Expr<T, R1>& a, const Expr<T, R2>& b){
//    return Expr<T, Divide<T, R1, R2> >(Divide<T, R1, R2 >(a.data(), b.data()));
//}
//
//int main(){
//
//    Expr<double> x(4);
//    Expr<double> c(14);
//
//
//    double res = (x * x + c).eval();
//
//    std::cout << res << std::endl;
//
//    std::cout << (x - x).eval() << std::endl;
//
//    std::cout << (x/c).eval() << std::endl;
//}

#include <iostream>

template <typename L, typename BinOp, typename R>
class Expr {
    L l_;
    R r_;

public:
    Expr(const L& l, const R& r) : l_(l), r_(r) {};
    double eval(double n) {
        return BinOp::apply(l_.eval(n), r_.eval(n));
    }
};

class X {
public:
    double static eval(double x) {
        return x;
    }
};

class C {
    double c;
public:
    explicit C(double d) : c(d) {}

    double eval(double) {
        return c;
    }
};

class Plus {
public:
    template <typename L, typename R>
    inline static double apply(L a, R b) {
        return (a + b);
    }
};

template <typename L, typename R>
Expr<L, Plus, R> operator+(const L& l, const R& r) {
    return Expr<L, Plus, R>(l, r);
};


int main() {
    std::cout << "Hello, World!" << std::endl;

    double res = ((X() + X()) + C(2)).eval(23);
    std::cout << res << std::endl;

    return 0;
}


