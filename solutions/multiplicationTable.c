// problem statement: https://codeforces.com/gym/359475/problem/A

#include <stdio.h>
int main()
{
    int n,x;
    scanf("%d",&n);
    scanf("%d",&x);
    int i,cpt=0;
    for (i=1;i<=n;i++)
    {
        if (x%i==0 && x/i<=n)
        {
            cpt++;
        }
    }
    printf("%d",cpt);
    return 0;
}