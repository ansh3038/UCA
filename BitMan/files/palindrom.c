#include <stdio.h>

int main() {
    int b;
    scanf("%d", &b);

    int count = 0;
    int temp = b;

    while (temp != 0) {
        temp = temp >> 1;
        count++;
    }
    count = 32 - count; 
    int j = 0;
    while (j < count) { 
        int check1 = (b & (1 << j)) > 0;
        int check2 = (b & (1 << (31 - j))) > 0;
        if (check1 != check2) {
            printf("false\n");
            return 0;
        }
        j++;
    }
    printf("true\n");
    return 0;
}
