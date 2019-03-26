/*
    A WebPage object has a URL assoicated with it and has an integer array representing the four page rank values
*/

public class WebPage {

    //String to store URL
    private String URL;
    //integer array to store the 4 differnt page ranks
    public int[] Scores= new int[4];



    //constructor
    public WebPage(String url){

        this.URL=url;

        //populate the integer array, each array has 4 page ranks elements
        for (int i=0; i<Scores.length; i++)
            Scores[i]= (int)(Math.random()*100);

    }

    //sum up all the integers in the integer array
    public int getSum(){

        int sum = 0;
        for (int i = 0; i < Scores.length; i++) {
            sum = sum + Scores[i];
        }
        return sum;
    }

    //getter for url
    public String getURL() {
        return URL;
    }

    //setter for url
    public void setURL(String URL) {
        this.URL = URL;
    }

    //setter for scores
    public void setScores(int[] scores) {
        Scores = scores;
    }
}