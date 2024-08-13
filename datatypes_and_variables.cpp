// There are many datatypes and variables in cpp
#include <iostream>
using namespace std;
int main(){
    // example: 
    int a=5; 
    cout << a << endl;
    // Here in memory block a 5 is stored
    // variable is a and type is integer, so compiler will store 4 byte i.e 32 bits for it and allocate them to a and store 5 in it.
    // therefore through this we get to know what type and how much memory it needs to be allocated.
    // integer does not always takes 4 byte, depending on compiler value is decided(eg 2 bytes)

    char ch='a';
    cout << ch << endl;
    // character type and variable ch
    // 1 byte allocated

    bool b= true;
    cout << b << endl;
    // boolean values 0 and 1 i.e false and true respt
    // 1 bit stored

    float f=1.2;
    cout << f << endl;
    // floating point 8 byte

    double d=1.23;
    cout << d << endl;
    // 8 byte
    // in variables, name should not start with numbers i.e 1abc is not allowed but abc1 , _1abc is allowed.

    int size=sizeof(a);
    cout<<"Size of integer a is: "<<size<<endl;


}
