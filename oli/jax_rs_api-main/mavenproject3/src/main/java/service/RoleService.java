package service;

import com.mycompany.mavenproject3.entity.Role;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class RoleService {

    private Role layer = new Role();

    public static JSONObject getRoleById(Integer id) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        if (id > 0) {
            Role role = new Role(id);
            JSONObject result = new JSONObject();
            result.put("id", role.getId());
            result.put("name", role.getName());
            result.put("createdAt", role.getCreatedAt());
            result.put("deletedAt", role.getDeletedAt());
            result.put("isDeleted", role.getIsDeleted());

            toReturn.put("result", result);
        } else {
            status = "InvalidParamValue";
            statusCode = 417;
        }

        toReturn.put("satus", status);
        toReturn.put("statusCode", statusCode);

        return toReturn;
    }

    public static JSONObject getAllRole() {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        ArrayList<Role> modelResult = Role.getAllRole();

        if (modelResult == null) {
            statusCode = 500;
            status = "ModelException";
        } else if (modelResult.isEmpty()) {
            status = "NoRecordFound";
        } else {
            JSONArray result = new JSONArray();

            for (Role actualRole : modelResult) {
                JSONObject actualRoleObject = new JSONObject();
                actualRoleObject.put("id", actualRole.getId());
                actualRoleObject.put("name", actualRole.getName());
                actualRoleObject.put("createdAt", actualRole.getCreatedAt().toString());
                actualRoleObject.put("deletedAt", actualRole.getDeletedAt() == null ? "" : actualRole.getDeletedAt().toString());
                actualRoleObject.put("isDeleted", actualRole.getIsDeleted());

                result.put(actualRoleObject);
            }

            toReturn.put("result", result);
        }

        toReturn.put("satus", status);
        toReturn.put("statusCode", statusCode);

        return toReturn;
    }

    public static JSONObject addRole(Role addedRole) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        Boolean modelResult = Role.addRole(addedRole);
        if (!modelResult) {
            status = "serverError";
            statusCode = 500;
        }

        toReturn.put("result", modelResult);
        toReturn.put("satus", status);
        toReturn.put("statusCode", statusCode);

        return toReturn;
    }

    public static JSONObject deleteRole(Role deletedRole) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        if (deletedRole.getId() == null) {
            status = "invalidUser";
            statusCode = 417;
        } else {
            Boolean modelResult = Role.deleteRole(deletedRole);
            if (!modelResult) {
                status = "serverError";
                statusCode = 500;
            }

            toReturn.put("result", modelResult);
        }

        toReturn.put("satus", status);
        toReturn.put("statusCode", statusCode);

        return toReturn;
    }

    public JSONObject updateRole(Role updatedRole) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        if (updatedRole.getId() < 1) {
            status = "roleNotFound";
            statusCode = 404;
        } else {
            Boolean modelResult = Role.updateRole(updatedRole);
            if (!modelResult) {
                status = "serverError";
                statusCode = 500;
            }

            toReturn.put("result", modelResult);
        }

        toReturn.put("satus", status);
        toReturn.put("statusCode", statusCode);

        return toReturn;
    }
}
