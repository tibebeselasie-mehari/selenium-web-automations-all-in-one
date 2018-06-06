package webtest.security;

public class CredentialManager {
    private static CredentialManager ourInstance = new CredentialManager();

    private Credential facebookCredential;
    private Credential aaitPortalCredential;
    private Credential gmailCredential;
    private Credential slackCredential;

    public static CredentialManager getOurInstance() {
        return ourInstance;
    }

    public Credential getFacebookCredential() {
        return facebookCredential;
    }

    public Credential getAaitPortalCredential() {
        return aaitPortalCredential;
    }

    public Credential getGmailCredential() {
        return gmailCredential;
    }

    public Credential getSlackCredential() {
        return slackCredential;
    }

    public static CredentialManager getInstance() {
        return ourInstance;
    }

    private CredentialManager() {
        facebookCredential = new Credential("z7unk@vmani.com","fakeprofile");
        gmailCredential = new Credential("tibebemekonnen123@gmail.com","LEOULMEKONNEN");
        aaitPortalCredential = new Credential("ATR/8905/08","leoul@23jumpstreet");
    }
}
