package be.matkensim.project.domein;

public class Rijtechniek {

    private String commentaar;

    public Rijtechniek(String commentaar) {

        this.commentaar = commentaar;
    }

    public String getCommentaar() {
        return commentaar;
    }

    public void setCommentaar(String commentaar) {
        this.commentaar = commentaar;
    }

    @Override
    public String toString() {
        return commentaar;
    }
    
    
}
