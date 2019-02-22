#include<stdio.h>
#include<stdlib.h>
#define MAX 10
void push1(int a[],int);
void pop1(int a[]);
void display1(int a[]);
void r_display1(int a[]);
void push2(int a[],int);
void pop2(int a[]);
void display2(int a[]);
void r_display2(int a[]);
void duplicate1(int a[]);
void duplicate2(int a[]);
int check();
int s[MAX];
int top1=-1,top2=MAX;
int c1=0,c2=0,d1=0,d2=0,l;
int main()
{
	int n,m;
	while(1)
	{
		printf("\n 1. PUSH IN STACK 1 \n 2. POP FROM STACK 1 \n 3. DISPLAY THE STACK 1 \n 4. DISPLAY THE STACK 1 IN REVERSE \n 5. PUSH IN STACK 2 ");
		printf("\n 6. POP FROM STACK 2 \n 7. DISPLAY THE STACK 2 \n 8. DISPLAY THE STACK @ IN REVERSE \n 9. DUPLICATE TOP ELEMENT IN STACK 1 \n 10. DUPLICATE TOP ELEMENT IN STACK 2 \n 11. CHECK EQUALITY OF TWO STACKS \n 12. EXIT ");
		scanf("%d",&n);
		switch(n)
		{
			case 1: printf("\nENTER THE NUMBER PUSH TO THE STACK : ");
			        scanf("%d",&m);
			        push1(s,m);
                                c1=0,c2=0;
			        break;
			case 2: pop1(s);
                                c1=0,c2=0;
			        break;
			case 3: display1(s);
			        break;
			case 4: r_display1(s);
			        break;	
			case 5: printf("\nENTER THE NUMBER PUSH TO THE STACK : ");
			        scanf("%d",&m);
			        push2(s,m);
                                d1=0,d2=0;
			        break;
			case 6: pop2(s);
                                d1=0,d2=0;
			        break;
			case 7: display2(s);
			        break;
			case 8: r_display2(s);
			        break;
			case 9: duplicate1(s);
                                c1=0,c2=0;
                                printf("\nTOP ELEMENT DUPLICATED\n");
                                break;
                        case 10: duplicate2(s);
                                 d1=0,d2=0;
                                 printf("\nTOP ELEMENT DUPLICATED\n");
                                 break;
                        case 11: l=check();
                                 if(l==1)
                                 printf("\nTWO STACKS ARE EQUAL\n");
                                 else printf("\nTWO STACKS ARE NOT EQUAL\n");
                                 break;
 			                    												        
		}
	}
	return 0;
}
void push1(int a[],int n)
{
	if(top1==MAX-1)
	{
		printf("\nSTACK IS OVERFLOW ");
		return;
	}
	else
	{
		top1++;
		a[top1]=n;
	}
}
void pop1(int a[])
{
	if(top1==-1)
	{
		printf("\nSTACK IS UNDERFLOW \n");
		return;
	}
	else
	{
		printf("\nTHE ELEMENT DELETED FROM THE STACK IS %d\n",a[top1]);
		top1--;
	}
}
void display1(int a[])
{
	int i;
	if(top1==-1)
	{
		printf("\n NO ELEMENT EXISTS IN THE STACK ");
		return;
	}
        else if(c1==1)
         printf("\nSTACK IS UNCHANGED\n");
	else
	{
                c1=1;
		printf("\nELEMENTS IN STACK \n");
		for(i=top1;i>=0;i--)
		printf("\n %d\n",a[i]);
	}
}
void r_display1(int a[])
{
	int i;
	if(top1==-1)
	{
		printf("\nSTACK IS UNDERFLOW ");
		return;
	}
        else if(c2==1)
        printf("\nSTACK IS UNCHANGED\n");
	else
	{
                c2=1;
		printf("\nELEMENT IN THE STACK IN REVESE \n");
		for(i=0;i<=top1;i++)
		printf("\n %d\n",a[i]);
	}
}
void push2(int a[],int n)
{
	if(top2==top1+1)
	{
		printf("\nSTACK IS OVERFLOW ");
		return;
	}
	else
	{
		top2--;
		a[top2]=n;
	}
}
void pop2(int a[])
{
	if(top2==MAX)
	{
		printf("\nSTACK IS UNDERFLOW \n");
		return;
	}
	else
	{
		printf("\nTHE ELEMENT DELETED FROM THE STACK IS %d\n",a[top2]);
		top2++;
	}
}
void display2(int a[])
{
	int i;
	if(top2==MAX)
	{
		printf("\n NO ELEMENT EXISTS IN THE STACK ");
		return;
	}
        else if(d1==1)
        printf("\nSTACK IS UNCHANGED\n");
	else
	{ 
                d1=1;
		printf("\nELEMENT IN STACK \n");
		for(i=top2;i<MAX;i++)
		printf("\n %d\n",a[i]);
	}
}
void r_display2(int a[])
{
	int i;
	if(top2==MAX)
	{
		printf("\nSTACK IS UNDERFLOW ");
		return;
	}
        else if(d2==1)
        printf("\nSTACK IS UNCHANGED\n");
	else
	{
                d2=1;
		printf("\nELEMENT IN THE STACK IN REVESE \n");
		for(i=MAX-1;i>=top2;i--)
		printf("\n %d\n",a[i]);
	}
}
void duplicate1(int a[])
{
       int k;
       k=s[top1];
       push1(s,k);
}
void duplicate2(int a[])
{
       int k;
       k=s[top2];
       push2(s,k);
}
int check()
{
       int c=0,i;
       if(top1+1==MAX-1-top2)
       return c;
       else
          {
               for(i=0;i<=top1;i++)
                {
                   if(s[i]!=s[MAX-1-i])
                   {
                      c=0;
                      break;
                   }
                    else c=1;
                }
                return c;
           }
}
                




