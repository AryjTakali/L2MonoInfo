CFLAGS = -Wall -Wextra -Werror
CC = gcc

PROGRAMS =   tests_ecosys

.PHONY:	all clean

.SUFFIX: 

all: $(PROGRAMS)

tests_ecosys: ecosys.o main_tests.o
	$(CC) -o $@ $(CFLAGS) $^

main_tests.o: main_tests.c
	gcc -c $(CFLAGS) main_tests.c

main_ecosys.o: main_ecosys.c 
	gcc -c $(CFLAGS) main_ecosys.c


clean:
	rm -f *.o 

fclean:	clean
	rm $(PROGRAMS)