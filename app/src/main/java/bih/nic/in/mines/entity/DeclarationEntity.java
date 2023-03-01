package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeclarationEntity {

    @SerializedName("Declaration")
    @Expose
    private String declaration;

    public DeclarationEntity() {
    }

    public DeclarationEntity(String declaration) {
        this.declaration = declaration;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }
}
