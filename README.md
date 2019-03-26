# Google_Search_Simulator
Simple google search simulator program using HeapSort and HeapPriorityQueue algorithms.

Design of code is such that user is prompted with successive questions as follows:
1.	 Please enter a word to search:
2.	Do you wish to increase the PageRank of a URL? [enter 1 for yes or 0 for exit]:
3.	Please enter the index of the URL you want to increase the PageRank of:
4.	Please enter the value you want to increase PageRank to:
5.	Do you wish to sort and display the top 20 URLs? [enter 1 for yes or 0 for exit]:
6.	Do you wish to add a URL? [enter 1 for yes or 0 for exit]:
7.	Please enter the URL you wish to add:
8.	Do you wish to view the first ranked web url link? [enter 1 for yes or 0 for exit]:
9.	Do you wish to start a new search? [enter 1 for yes or 0 to end program]:
If user enters 0 when prompted, the program will skip to the next question. For question 9 if 0 is entered the program will be terminated.

List of classes/subroutines/function calls:

1.0 	Spider.java
1.1.	[webcrawler crawls the web]
2.0 	HeapSort.java
2.1.	HeapSort(): constructor
2.2.	getPages(): getter
2.3.	build_max_heap(): method to build heap from array
2.4.	max_heapify(): method to maintain heap property
2.5.	heap_sort(): order array in ascending order
2.6.	heap_maximum(): method to output top url (not used)
2.7.	heap_extract_max(): method to remove and display top URL
2.8.	display(): custom method for displaying array
2.9.	heap_increase_key(): method takes in the following params: array of type WebPage, integer i representing index of URL and the key represents the integer value being increased
2.10.	heap_insert(): method to insert url
3.0 	WebPage.java
3.1.	WebPage(): constructor
3.2.	getSum(): sum up all integers in the integer array
3.3.	getURL(): getter for URL
3.4.	setURL(): setter for URL
3.5.	setScores(): setter for scores
4.0 	Driver.java
4.1.	ui(): user interface
