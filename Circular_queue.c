#include<stdio.h>
#include<stdlib.h>
#define MAX 5
void push(int a[],int);
void pop(int a[]);
void display(int a[]);
int c[MAX],top=-1,front=-1;
int main()
{
     int n,m;
     while(1)
     {
        printf("\nENTER YOUR CHOICE \n");
        printf("\n 1. PUSH INTO THE QUEUE \n 2. POP FROM THE QUEUE \n 3. DISPLAY THE QUEUE \n 4. EXIT ");
        scanf("%d",&n);
        switch(n)
        {
		case 1: printf("\nENTER THE ELEMENT : ");
                        scanf("%d",&m);
			push(c,m);
			break;
		case 2: pop(c);
			break;
		case 3: display(c);	
			break;
		case 4: exit(0);
			break;
	}
     }
     return 0;
}
void push(int a[],int n)
{
	if(((top==MAX-1)&&front==0)||(front==top+1))
	{	
		printf("\nQUEUE IS FULL \n");
		return;
	}
	else if(front==-1&&top==-1)
	{
		front=0;
		top=0;
		c[top]=n;
	
	}
	else if((top==MAX-1)&&front!=0)
        {
		top=0;
		c[top]=n;
	}
	else
	{
		top++;
		c[top]=n;
	}
}
void pop(int a[])
{
	if(front==-1&&top==-1)
	{
		printf("\nQUEUE IS EMPTY\n");
		return;
	}
	else if(front==MAX-1)
	{
		printf("\nTHE REMOVED ELEMENT IS %d \n",a[front]);
		front=0;
	}
	else if(front==top)
	{
		printf("\nTHE REMOVED ELEMENT IS %d \n",a[front]);
		front=-1,top=-1;
	}
	else
	{
		printf("\nTHE REMOVED ELEMENT IS %d \n",a[front]);
		front++;
	}
}	
void display(int a[])
{
	int i;
	printf("\nELEMENTS IN THE QUEUE \n");
        if(top<front)
	{
		for(i=front;i<=MAX-1;i++)
		printf(" %d",a[i]);
		for(i=0;i<=top;i++)
		printf(" %d",a[i]);
	}
	else
	{
		for(i=front;i<=top;i++)
		printf(" %d",a[i]);
	}
}

