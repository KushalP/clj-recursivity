SRC_MD5=`find src/ -type f | xargs cat | md5`
TEST_MD5=`find test/ -type f | xargs cat | md5`

while true; do
	SRC2_MD5=`find src/ -type f | xargs cat | md5`
	TEST2_MD5=`find test/ -type f | xargs cat | md5`
	if [ "$SRC_MD5" != "$SRC2_MD5" -o "$TEST_MD5" != "$TEST2_MD5" ]
		then
		echo "------------- RUNNING TESTS ON CHANGED FILES... ------------------"	
		SRC_MD5=$SRC2_MD5
		TEST_MD5=$TEST2_MD5
		lein test
		echo "-----------------------------------------------------"	
	fi

	sleep 2
done