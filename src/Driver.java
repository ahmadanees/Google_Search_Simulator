import java.util.Scanner;

public class Driver {

    public static void main(String[] args)
    {
        Driver y = new Driver();
        y.ui();
    }

    //recursive user interface
    public void ui() {

        //Prompt user to enter search word then crawl
        System.out.println("\nPlease enter a word to search:");
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();

        String[] URLs = new String[31];    //This contains The 30 successful URLs.
        WebPage[] pages = new WebPage[31]; //This contains the 30 successful webpage objects.

        //webcrawler
        Spider spider = new Spider();
        spider.search("https://en.wikipedia.org/wiki/", word);

        //populating url array
        System.out.println("\n");
        URLs = spider.getURLs();

        //populating webpage array
        for (int i = 1; i < URLs.length; i++) {
            WebPage obj = new WebPage(URLs[i]);
            pages[i] = obj;
        }

        //Creating a heap sort object
        HeapSort sort = new HeapSort(pages);
        sort.build_max_heap(pages);
        sort.heap_sort(pages);
        sort.display(pages);


        //Increasing PageRank of a URL.
        System.out.println("\nDo you wish to increase the PageRank of a URL? [enter 1 for yes or 0 for exit]:");
        int s = in.nextInt();

        if (s == 1) {
            System.out.println("\nPlease enter the index of the URL you want to increase the PageRank of:");
            int index = in.nextInt();

            System.out.println("\nPlease enter the value you want to increase PageRank to:");
            int val = in.nextInt();

            System.out.println("\nChanged PageRank of selected URL:");

            sort.heap_increase_key(pages, index, val);
            sort.build_max_heap(pages);
            sort.heap_sort(pages);
            sort.display(pages);
        }

        if (s != 1) {
            System.out.println("Exit!");
        }


        System.out.println();    //spacer


        /*
            Following calls only for top 20 URLs
        */


        //Displaying the top 20 URLs using priority queue.
        System.out.println("\nDo you wish to sort and display the top 20 URLs? [enter 1 for yes or 0 for exit]:");
        int w = in.nextInt();

        WebPage[] pages20 = new WebPage[21];   //this contains the top  20 URLs
        HeapSort sort20 = new HeapSort(pages);
        sort20.build_max_heap(pages);

        for (int i = 1; i < pages20.length; i++) {
            pages20[i] = sort20.heap_extract_max(pages);
        }


        if (w == 1) {
            System.out.println("\nTop 20 URLs:");
            sort20.display(pages20);
        }
        if (w != 1) {
            System.out.println("Exit!");
        }

        //new scanner for following inputs
        Scanner e = new Scanner(System.in);

        //Prompt user to add a URL, add to heap, then sort it
        System.out.println("\nDo you wish to add a URL? [enter 1 for yes or 0 for exit]:");
        int o = e.nextInt();

        if (o == 1) {
            System.out.println("\nPlease enter the URL you wish to add:");
            String url = e.next();

            System.out.println("\nSorting...");

            WebPage[] AA = sort.heap_insert(pages20, url); //inserting url

            //sorting with inserted url
            sort.build_max_heap(AA);
            sort.heap_sort(AA);
            System.out.println("\n\nTop 21 URLs:");
            sort.display(AA);
        }

        if (o != 1) {
            System.out.println("Exit!");
        }


        //User wants to extract the top URL
        System.out.println("\nDo you wish to view the first ranked web url link? [enter 1 for yes or 0 for exit]:");
        int q = e.nextInt();

        if (q == 1) {
            WebPage top = sort.heap_extract_max(pages20);
            System.out.println("PageRank: " + top.getSum() + " URL: " + top.getURL() );
        }

        if (q != 1) {
            System.out.println("Exit!");
        }

        //Ask user for another search
        System.out.println("\n\nDo you wish to start a new search? [enter 1 for yes or 0 to end program]:");
        int r = e.nextInt();

        if (r == 1) {
            ui(); // Recursive call
        }

        if (r != 1) {
            System.out.println("Program ended!");
        }
    }
}
