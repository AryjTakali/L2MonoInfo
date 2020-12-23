#include <stdio.h>


int main(){
	FILE *f = fopen("test.txt","wb");
	char *tab = "yiiiiiiiiooooo";
	fwrite(tab,sizeof(char),10,f);
	fclose(f);

}
