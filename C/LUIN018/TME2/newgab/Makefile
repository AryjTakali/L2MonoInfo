CFLAGS = -g -Wall -Wextra -pedantic
CC = gcc

PROGRAMS =   tests_ecosys

.PHONY:	all clean

.SUFFIX: 

all: $(PROGRAMS)

tests_ecosys: ecosys.o tests.o
	$(CC) -o $@ $(CFLAGS) $^

tests.o: tests.c
	gcc -c $(CFLAGS) tests.c


main.o: main.c 
	gcc -c $(CFLAGS) main.c

ecosys.o: ecosys.c 
	gcc -c $(CFLAGS) ecosys.c

#Ou plus simplement
#%.o:%.c %.h
#	$(CC)  $(GCC_FLAGS) -c  $<


clean:
	rm -f *.o 

fclean:	clean 
	rm tests_ecosys

re	: clean all
	
