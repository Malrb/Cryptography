#include <iostream>
#include <fstream>
using namespace std;
/* Function Initialization */
char* encode(char*);
char* decode(char*);
/* Main Functions */
int main(int argc, const char * argv[]) {
    char str[100];
    int index;
    while(1){
        cout << "輸入字串: ";
        scanf("%s",str);
        cout << "(1)加密 (2)解密 (3)離開" << endl;
        cin >> index;
        if(index == 1){
            cout << "After encode : ";
            cout << encode(str) << endl;
        }else if(index == 2){
            cout << "After decode : ";
            cout << decode(str) << endl;
        }else if(index == 3){
            cout << "Program Exit" << endl;
            break;
        }else{
            cout << "Unknown input";
        }
    }
    
    //System block
    return 0;
}
/* Use “Displacement” to transform plaintext */
char* encode(char* str)
{
    char* ptr = str;
    while(*str){
        *str = *str + 1;
        str++;
    }
    return ptr;
}
char* decode(char* str)
{
    char* ptr = str;
    while(*str){
        *str = *str - 1;
        str++;
    }
    return ptr;
}
