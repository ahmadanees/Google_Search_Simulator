import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    This class contains all heapsort algorithm methods
*/
public class HeapSort {

    //fields
    private WebPage pages []; //array to hold webpage objects
    private int heapsize;    //hold heapsize value

    //constructor
    HeapSort(WebPage [] pages_Arg){

        this.pages =new WebPage[31];

        for(int i=1; i < pages.length; i++){
            this.pages[i]=pages_Arg[i];
        }

        this.heapsize=pages_Arg.length-1;
    //    this.in=new WebPage[pages.length+1];
    }

    //getter for webpage array
    public WebPage[] getPages() {
        return pages;
    }

    public int parent(int i){
        return (int) Math.floor(i/2);
    }

    public int left(int i){
        return(2*i);
    }

    public int right(int i){
        return(2*i+1);
    }

    //method to build heap from array
    public void build_max_heap(WebPage [] A){

        int n = heapsize;

        for(int i = (int) Math.floor(n/2); i >= 1; i--){
            max_heapify(A,i);
        }

    }

    //method to maintain heap property
    public void max_heapify(WebPage [] A, int i){

        int left = left(i);
        int right = right(i);
        int largest=i;

        if(left<=heapsize && A[left].getSum() > A[i].getSum()){
            largest=left;
        }
        if(right<=heapsize && A[right].getSum()>A[largest].getSum()){
            largest=right;
        }
        if(largest!=i){
            //swap A[i] with A[largest]
            WebPage temp = A[i];
            A[i]=A[largest];
            A[largest]=temp;
            //call max heapify
            max_heapify(A,largest);
        }

    }

    //order array in accending order
    public void heap_sort(WebPage [] A){
        int n= heapsize;

        for(int i=n; i>=2; i--){

            WebPage temp = A[1];
            A[1]=A[i];
            A[i]=temp;
            heapsize-=1;
            max_heapify(A,1);
        }
    }

    //method to output top url
    public WebPage heap_maximum(WebPage [] A){
        return A[1];
    }


    //method to remove and display top url
    public WebPage heap_extract_max(WebPage [] A){

        WebPage max = A[1];
        WebPage temp;
        temp = A[1];
        A[1] = A[heapsize];
        A[heapsize]=temp;

        heapsize-=1;
        max_heapify(A,1);
        return max;
    }

    //custom method for displaying the array
    public void display(WebPage [] A){

        for(int i =A.length-1; i > 0; i--){
            System.out.println((i) + " = PageRank: " + A[i].getSum() + " URL: " + A[i].getURL());
        }
        System.out.println();
    }

    /*
    this method takes in the following params: array of type WebPage, integer i representing
    index of URL and the key represents the integer value being increased
     */
    public void heap_increase_key(WebPage [] A, int i, int key){

        //check if key value is less than the selected page rank value
        if(key<A[i].getSum()){
            System.out.println("Error: the new key is smaller than current key");
            return;
        }

        int temp[] = new int[4];
        temp[0]=0; temp[1]=0;temp[2]=0; temp[3]=key;
        A[i].setScores(temp);

        while(i>1 && A[parent(i)].getSum() < A[i].getSum()){
            WebPage obj = A[i];
            A[i]=A[parent(i)];
            A[parent(i)]=obj;
            i=parent(i);
        }

    }


    //method to insert url
    public WebPage [] heap_insert(WebPage [] A, String url){

        List<WebPage> temp = new ArrayList<>();
        temp.addAll(Arrays.asList(A));

        WebPage obj =new WebPage(url);
        temp.add(obj);

        WebPage [] myArr = new WebPage[temp.size()];
        myArr = temp.toArray(myArr);

        for(int i =1; i < myArr.length; i++){
            System.out.println(myArr[i].getURL() + " " + myArr[i].getSum());
        }

        return myArr;
    }
}


