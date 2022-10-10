public class Programming {

    private boolean learned = false;
    private String language;

    public Programming(String language) {
        this.language = language;
    }

    public void learningStatus() {
        if(learned) {
            System.out.println("Mastered " + language);
        } else {
            System.out.println("Learning " + language);
        }
    }

    public void completeLearning() {
        learned = true;
    }

}
