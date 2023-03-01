package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BlockEntity {


    @SerializedName("Id")
    @Expose
    private String blockId;

    @SerializedName("Name")
    @Expose
    private String blockName;

    public BlockEntity() {
    }

    public BlockEntity(String blockId, String blockName) {
        this.blockId = blockId;
        this.blockName = blockName;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }
}
