#include<iostream>
#include<cstdlib>
#include<time.h>
using namespace std;
class game
{
	char s1[6],s2[6],s3[6],s4[6];
	int r,i,k,f;
	public:
		game()
		{
			srand(time(0));
			for(i=0;i<5;i++)
			{
				k=rand()%5;
				r=rand()%5+k;
				r=r%5;
				r++;
//				cout<<r;
				switch(r)
				{
					case 1: s1[i]='a';s4[i]='a';break;
					case 2: s1[i]='e';s4[i]='e';break;
					case 3: s1[i]='i';s4[i]='i';break;
					case 4: s1[i]='o';s4[i]='o';break;
					case 5: s1[i]='u';s4[i]='u';break;
				}
			}
			cout<<"******THE SEQUENCE HAS BEEN GENERATED******";
			s1[5]='\0';
			cout<<s1;
		}
		void get_input()
		{
			cin>>s2;
			//cout<<"\n***"<<s2;
			//cout<<"\n***"<<s1;
		}
		int test()
		{
			for(i=0;i<=5;i++)
				s4[i]=s1[i];
			int j;
			f=0;
			for(i=0,j=0;i<5;i++)
			{
				if(s4[i]==s2[i])
				{
					s3[j++]='1';
					//cout<<""<<s2[i]<<"";					
					s4[i]='o';
					s2[i]='o';
					//cout<<"*****"<<j;	
				}
				if(j==5)
					f=1;
			}
			for(i=0;i<5;i++)
			{
				for(k=0;k<5;k++)
				{
					if(s4[i]==s2[k] && s4[i]!='o' && i!=k)
					{
						s3[j++]='0';
					}
				}
			}
			for(;j<5;j++)
			{
				s3[j]='_';
				s3[5]='\0';
			}
			return f;
		}
		void print_clue()
		{
			for(i=0;i<5;i++)
				cout<<s3[i];
		}
};
int main()
{
	game s;
	int i,c=10,k;
	srand(time(0));
	for(i=0;i<10;i++)
	{
		cout<<"\n"<<i+1<<"th Chance\n";
		cout<<"Enter guess : ";
		s.get_input();
		k=s.test();
		{
			if(k!=1)
			{
				cout<<"\nWrong Guess!";
				cout<<"\nClue is : ";
				s.print_clue();
			}
			else
			{
				cout<<"\nCongrats! You've guessed the correct sequence";
				cout<<"\nYour score is"<<c;
				return 1;
			}
			c--;
		}
	}
	return 0;
}
			
			
		
			
																													
