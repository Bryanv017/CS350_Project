public class IssuedBook{
    private String isbn;
    private String issue_ID;
    private String issuedBy;
    private String issueDate;

    public IssuedBook(String issue_ID, String isbn , String issuedBy, String date ){
        this.isbn = isbn;
        this.issue_ID = issue_ID;
        this.issuedBy = issuedBy;
        this.issueDate = date;
    }

    public String getIssue_ID() {
        return issue_ID;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public String getIsbn() {
        return isbn;
    }


    public void setIssue_ID(String issue_ID) {
        this.issue_ID = issue_ID;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

