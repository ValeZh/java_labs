import java.util.Objects;

public class ClubMember {
    private String name;
    private int membershipId;

    public ClubMember(String name, int membershipId) {
        this.name = name;
        this.membershipId = membershipId;
    }

    public String getName() {
        return name;
    }

    public int getMembershipId() {
        return membershipId;
    }

    @Override
    public String toString() {
        return "Член клубу: " + name + ", ID: " + membershipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubMember that = (ClubMember) o;
        return membershipId == that.membershipId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, membershipId);
    }
}