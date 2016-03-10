
package domein;

/**
 *
 * @author Kenzo
 */
public class Verkeerstechniek 
{
    private String algemeen;
    private String commentaar;

    public Verkeerstechniek(String algemeen, String commentaar) {
        this.algemeen = algemeen;
        this.commentaar = commentaar;
    }

    public String getAlgemeen() {
        return algemeen;
    }

    public void setAlgemeen(String algemeen) {
        this.algemeen = algemeen;
    }

    public String getCommentaar() {
        return commentaar;
    }

    public void setCommentaar(String commentaar) {
        this.commentaar = commentaar;
    }
    
}
