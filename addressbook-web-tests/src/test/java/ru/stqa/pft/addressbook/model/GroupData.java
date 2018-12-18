package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

public class GroupData {
    @XStreamOmitField
    private int grid = Integer.MAX_VALUE;
    private String groupname;
    private String groupheader;
    private String groupfooter;

    public int getGrid() {
        return grid;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getGroupheader() {
        return groupheader;
    }

    public String getGroupfooter() {
        return groupfooter;
    }

    public GroupData withId(int grid) {
        this.grid = grid;
        return this;
    }

    public GroupData withName(String groupname) {
        this.groupname = groupname;
        return this;
    }

    public GroupData withHeader(String groupheader) {
        this.groupheader = groupheader;
        return this;
    }

    public GroupData withFooter(String groupfooter) {
        this.groupfooter = groupfooter;
        return this;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "grid=" + grid +
                ", grname='" + groupname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return grid == groupData.grid &&
                Objects.equals(groupname, groupData.groupname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(grid, groupname);
    }
}
