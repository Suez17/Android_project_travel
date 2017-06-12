package Element;

/**
 * Created by mikouyou on 07/06/2017.
 */

public class GroupTravel {
    private String groupName;
    private String groupDestination;
    private String startDate;
    private String endDate;
    private String groupMaxMembers;

    public GroupTravel(String groupName, String groupDestination, String startDate, String endDate, String groupMaxMembers) {
        this.groupName = groupName;
        this.groupDestination = groupDestination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupMaxMembers = groupMaxMembers;
    }

    @Override
    public String toString() {
        String group = "";
        group += "Groupe : " + groupName + "\n";
        group += "Destination : " + groupDestination + "\n";
        group += "Date de départ : " + startDate + "\n";
        group += "Date de retour : " + endDate + "\n";
        group += "Nombre de membre max : " + groupMaxMembers;
        return group;
    }
}
