package be.matkensim.project.domein;

public class Verkeerstechniek {

    private String commentaar;

    public Verkeerstechniek(String commentaar) {
        this.commentaar = commentaar;
    }

    public String getCommentaar() {
        return commentaar;
    }

    public void setCommentaar(String commentaar) {
        this.commentaar = commentaar;
    }
}
