#include<stdio.h>
int bitAnd(int x, int y){
    return ~(~x | ~y);
}

int bitXor(int x, int y){
    return ((x&(~y)) | (y&(~x)));
}

int getByte(int x, int n){
    return (x>>(n<<3))&255;
}
int sign(int x){
        return (x>>31 & ~0 ) | (!!x);
}
int logicalShift( int x, int n){
    return (x>>n)&(~(~0 << (32+(~n +1))));
}
int invert(int a, int p, int n){
    int mask = ~((~0)<<n) << p;
    // printf("%x",a^mask);
    return a ^ mask;
}

int conditional( int x, int y, int z){
    int mask = !!x;
    mask = ~mask + 1;
    return (y & mask) | (z & ~mask);
}

int bang(int x) {
    return ((x | (~x + 1)) >> 31) + 1;
}
