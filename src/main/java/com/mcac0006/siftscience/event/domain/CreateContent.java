package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Use $create_content to record when a user creates content on your site (for example, a job posting, sale
 * listing, or blog post).
 *
 * @author <a href="mailto:gonzalob@gonz0.com.ar">Gonzalo Bermúdez</a>
 */
public class CreateContent extends Event {

    public CreateContent() {
        super("$create_content");
    }

    /**
     * The user's account ID according to your systems. Use the same ID that you would use to look up users
     * on your website's databases. This field is required on all events performed by the user while logged in.
     * Users without an assigned {@link #userId} will not show up in the console. Note: User IDs are
     * <strong>case sensitive</strong>. You may need to normalize the capitalization of your user IDs.
     */
    @JsonProperty("$user_id")
    private String userId;

    /**
     * The user's current session ID, used to tie a user's action before and after log in or account creation.
     */
    @JsonProperty("$session_id")
    private String sessionId;

    /**
     * The contact email provided with the posting.
     * <p/>
     * Email addresses, sent as a String. Sift performs a number of fraud detection algorithms on emails,
     * including matching against throw-away email domains, and looking for similarity to known fraudsters
     * in the past.
     */
    @JsonProperty("$contact_email")
    private String contactEmail;

    /**
     * The contact phone number provided with the posting.
     * <p/>
     * Phone numbers, sent as a String. Sift can perform lookups to identify country and region of phone
     * numbers if the data is well formed. For example: "1-415-555-6041".
     */
    @JsonProperty("$contact_phone")
    private String contactPhone;

    /**
     * The subject of the content.
     */
    @JsonProperty("$subject")
    private String subject;

    /**
     * The text body of the content.
     */
    @JsonProperty("$content")
    private String content;

    public String getUserId() {
        return userId;
    }

    public CreateContent setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public CreateContent setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public CreateContent setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
        return this;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public CreateContent setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public CreateContent setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CreateContent setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CreateContent that = (CreateContent) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (contactEmail != null ? !contactEmail.equals(that.contactEmail) : that.contactEmail != null) return false;
        if (contactPhone != null ? !contactPhone.equals(that.contactPhone) : that.contactPhone != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        return content != null ? content.equals(that.content) : that.content == null;

    }

    @Override
    // auto-generated with intellij idea 15
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        result = 31 * result + (contactPhone != null ? contactPhone.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
