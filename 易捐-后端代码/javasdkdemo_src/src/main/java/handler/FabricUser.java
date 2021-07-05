package handler;

import java.security.PrivateKey;
import java.util.Set;

import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.User;

public class FabricUser implements User {

    public void setName(String name) {
        this.name = name;
    }

    protected String name;
    protected String enrollSecret;
    protected String mspid;
    private Set<String> roles;
    private String account;
    private String affiliation;
    private Enrollment enrollment;

    public void setEnrollSecret(String enrollSecret) {
        this.enrollSecret = enrollSecret;
    }

    public String getMspid() {
        return mspid;
    }

    public void setMspid(String mspid) {
        this.mspid = mspid;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public FabricUser(String accessKey){
    	this.name = accessKey;
    	this.mspid = accessKey+"MSP";
    }
    

    public String getEnrollSecret() {
        return enrollSecret;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<String> getRoles() {
        return roles;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public String getAffiliation() {
        return affiliation;
    }

    @Override
    public Enrollment getEnrollment() {
        return enrollment;
    }

    public String getMspId() {
        return mspid;
    }

}