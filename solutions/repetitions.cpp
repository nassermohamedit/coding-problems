#include<iostream>

// problem: https://cses.fi/problemset/task/1069


using namespace std;

int main() {

    string dna;
    cin >>dna;
    char prev;
    int max_rep = 0;
    int curr = 0;
    for (char c: dna) {
        if (c == prev) ++curr;
        else {
            max_rep = max(max_rep, curr);
            curr = 1;
        }
        prev = c;
    } 
    cout <<max(max_rep, curr);

    return 0;
}
