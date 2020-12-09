package ModelClasses;

enum Role
{
    TEAM_MEMBER("Team member"), SCRUM_MASTER("Scrum master"), PRODUCT_OWNER("Product owner");
    private String role;

    Role(String role)
    {
        this.role = role;
    }

    private boolean isRole(String role)
    {
        return role.equalsIgnoreCase(TEAM_MEMBER.role) || role.equalsIgnoreCase(SCRUM_MASTER.role) || role.equalsIgnoreCase(PRODUCT_OWNER.role);
    }
}
