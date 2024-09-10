class Member {
    private String memberId;
    private String name;
    private String address;
    private String contact;

    public Member(String memberId, String name, String address, String contact) throws LibraryException {
        if (memberId == null || memberId.isEmpty()) {
            throw new LibraryException("Member ID cannot be null or empty.");
        }
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name;
    }
}
