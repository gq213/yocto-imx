#include <stdio.h>
#include "testlib.h"

int testlib_init(void)
{
	printf("%s\n", __func__);
	
	return 0;
}

void testlib_deinit(void)
{
	printf("%s\n", __func__);
}
