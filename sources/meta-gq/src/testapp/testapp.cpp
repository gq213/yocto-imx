#include <stdio.h>
#include <testlib.h>

int main(int argc, char *argv[])
{
	printf("+ build time: " __DATE__ " " __TIME__ "\n");
	
	testlib_init();
	testlib_deinit();
	
	return 0;
}
