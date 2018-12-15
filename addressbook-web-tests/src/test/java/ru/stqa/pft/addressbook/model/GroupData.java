package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
    private int grid = Integer.MAX_VALUE;
    private String grname;
    private String grheader;
    private String grfooter;

    public int getGrid() {
        return grid;
    }

    public String getGrname() {
        return grname;
    }

    public String getGrheader() {
        return grheader;
    }

    public String getGrfooter() {
        return grfooter;
    }

    public GroupData withId(int grid) {
        this.grid = grid;
        return this;
    }

    public GroupData withName(String grname) {
        this.grname = grname;
        return this;
    }

    public GroupData withHeader(String grheader) {
        this.grheader = grheader;
        return this;
    }

    public GroupData withFooter(String grfooter) {
        this.grfooter = grfooter;
        return this;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "grid=" + grid +
                ", grname='" + grname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return grid == groupData.grid &&
                Objects.equals(grname, groupData.grname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(grid, grname);
    }
}
