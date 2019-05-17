public class GameManager {

    private String compGuessMovie;
    private String initialMovie;
    private int guessMovieLen;
    private int points;


    GameManager(String compGuessMovie, int guessMovieLen) {
        this.compGuessMovie = compGuessMovie;
        this.guessMovieLen = guessMovieLen;
        this.initialMovie="";
        this.points = 10;
        System.out.println(this.compGuessMovie);

        setInitialMovie();
    }

    private void setInitialMovie() {
        for (int i = 0; i <guessMovieLen; i++) {
            if(compGuessMovie.charAt(i)==' ') {
                this.initialMovie=this.initialMovie+' ';
            }
            else{
                this.initialMovie=this.initialMovie+'_';
            }
        }
    }

    public void displayInitialMovie() {
        for (int i = 0; i < initialMovie.length(); i++) {
            System.out.print(initialMovie.charAt(i)+" ");
        }
        System.out.print("\n");
    }

    private void decrementPoints() {
        this.points = this.points - 1;
    }

    public int getPoints() {
        return this.points;
    }


    public void matchCharWithMovie(char c)throws IndexOutOfBoundsException {
        if (compGuessMovie.indexOf(c) >= 0 && compGuessMovie.indexOf(c)<guessMovieLen) {

            for(int i=compGuessMovie.indexOf(c);i<guessMovieLen;i++){

                if(compGuessMovie.charAt(i)==c && i==0){
                    initialMovie=c+initialMovie.substring(1);
                }
                else if(compGuessMovie.charAt(i)==c && i==guessMovieLen-1){
                    initialMovie=initialMovie.substring(0,i)+c;
                }
                else if(compGuessMovie.charAt(i)==c){

                    initialMovie=initialMovie.substring(0,i)+c+initialMovie.substring(i+1);
                }
            }
        }
        else {
            decrementPoints();
        }
    }

    public boolean matchForSuccess()
    {
        if(compGuessMovie.equals(initialMovie)){
            return true;
        }
        else
            return false;
    }
}


