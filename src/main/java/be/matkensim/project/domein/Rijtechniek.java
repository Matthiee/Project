/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.matkensim.project.domein;

/**
 *
 * @author Kenzo
 */
public class Rijtechniek {

    private String algemeen;
    private String commentaar;

    public Rijtechniek(String algemeen, String commentaar) {
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
