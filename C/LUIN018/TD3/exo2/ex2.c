#include <stdio.h>

//var globales a,b,c
int a, b, c;

//param formel f : x
int f(int x)
{
    return a * x;
}

//var locale g : c
int g()
{
    int c;
    c = a;
    a = b;
    b = c;
    return c;
}

int main()
{
    int x, y;
    a = 2;
    b = 3;
    c = 4;
    x = f(a);
    y = g();
    printf("%d %d %d %d %d\n", x, y, a, b, c);
    return 0;
}
