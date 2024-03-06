CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

cp student-submission/*.java grading-area
cp *.java grading-area
cp -r lib grading-area

cd grading-area

if ! [ -f ListExamples.java ]
then
	echo "Missing ListExamples.java in student submission"
	echo "Score: 0/2"
	exit
fi

javac -cp $CPATH *.java &> compile.txt
if [ $? -ne 0 ]
then 
	echo "Compilation error"
	echo "Score: 0/2"
	exit
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples &> results.txt

# Score based on methods passed
if [ $(grep -c "OK" results.txt) -eq 1 ]
then
	echo "Score: 2/2"
	exit
elif [[ $(grep -c "Merge" results.txt) && $(grep -c "Filter" results.txt) -ge 1 ]] # If both Merge and Filter fail, score is 0
then
	echo "Score: 0/2"
	exit
else
	echo "Score: 1/2"
	exit
fi