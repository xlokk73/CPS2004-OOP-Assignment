// Expressions
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



// Addition operator
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

// Multiplication operator
class Multiply {
public:
    template <typename L, typename R>
    inline static double apply(L a, R b) {
        return (a * b);
    }
};

template <typename L, typename R>
Expr<L, Multiply, R> operator*(const L& l, const R& r) {
    return Expr<L, Multiply, R>(l, r);
};

// Division operator
class Divide {
public:
    template <typename L, typename R>
    inline static double apply(L a, R b) {
        return (a / b);
    }
};

template <typename L, typename R>
Expr<L, Divide, R> operator/(const L& l, const R& r) {
    return Expr<L, Divide, R>(l, r);
};


// Subtraction operator
class Subtract {
public:
    template <typename L, typename R>
    inline static double apply(L a, R b) {
        return (a - b);
    }
};

template <typename L, typename R>
Expr<L, Subtract, R> operator-(const L& l, const R& r) {
    return Expr<L, Subtract, R>(l, r);
};