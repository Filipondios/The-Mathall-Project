/*This C++ file is the same file than MathallRun.exe && MathallRun, but the others are compiled for Windows
and Linux. Why showing this file? The reason is pretty simple, if you look the code, you can clearly see that
your computer is not in danger by any virus. Also, if you experiment some errors, you can also change this file
and compile it for Windows and linux. If you do so, for Windows use an application named DevC++ and for Linux,
in the same directory that this file, run in a terminal g++ Mathall.cpp -o Mathall. If that doesnt work, take
a look at this website: https://www.cyberciti.biz/faq/howto-compile-and-run-c-cplusplus-code-in-linux/*/

#include<iostream>

using namespace std;

int main(){
	try{
		system("java -jar Mathall/dist/Mathall.jar");
		cout<<"Press enter to finalize the program...";
		char nothing = getchar();
	}catch(...){
		cout<<"Error: Mathall couldn''t start due some error. Check the lines below this one."<<endl;
	}
	return 0;
}


