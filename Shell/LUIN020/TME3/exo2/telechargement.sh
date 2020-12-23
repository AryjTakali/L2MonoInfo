
if [ ! -d "./chunks" ]; then
	mkdir chunks
fi

if [ -f concatenation.jpeg ]; then
	rm concatenation.jpeg
fi

for i in 0{0..9} {10..99}; do 
	if [ ! -f ./chunks/data.$i ]; then
		wget http://julien.sopena.fr/chunks/data.$i -P ./chunks
	fi
	if [ ! $? -eq 0 ]; then
		echo "error while downloading"
		break
	fi
	cat ./chunks/data.$i >> concatenation.jpeg
done 
	file concatenation
	open concatenation.jpeg

