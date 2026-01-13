package service;

import com.mycompany.mavenproject3.entity.Role;
import com.mycompany.mavenproject3.entity.User;
import config.JWT;
import java.lang.constant.DirectMethodHandleDesc;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class UserService {

    private User layer = new User();
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{};:,.?/";

    public JSONObject getUserById(Integer id) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        if (id > 0) {
            User user = new User(id);
            JSONObject result = new JSONObject();
            result.put("id", user.getId());
            result.put("firstName", user.getFirstName());
            result.put("lastName", user.getLastName());
            result.put("email", user.getEmail());
            result.put("phone", user.getPhone());
            toReturn.put("result", result);
        } else {
            status = "InvalidParamValue";
            statusCode = 417;
        }

        toReturn.put("satus", status);
        toReturn.put("statusCode", statusCode);

        return toReturn;
    }

    public JSONObject registerUser(User registeredUser) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        if (!isValidEmail(registeredUser.getEmail())) {
            status = "invalidEmail";
            statusCode = 417;
        } else if (!isValidPassword(registeredUser.getPassword())) {
            status = "invalidPassword";
            statusCode = 417;
        } else {
            Boolean modelResult = User.registerUser(registeredUser);
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

    public JSONObject updateUser(User updatedUser) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        if (updatedUser.getId().equals(null)) {
            status = "invalidUser";
            statusCode = 417;
        } else if (!isValidEmail(updatedUser.getEmail())) {
            status = "invalidEmail";
            statusCode = 417;
        } else {
            Boolean modelResult = User.updateUer(updatedUser);
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

    public JSONObject deleteUser(User deletedUser) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        if (deletedUser.getId().equals(null)) {
            status = "invalidUser";
            statusCode = 417;
        } else {
            Boolean modelResult = User.deleteUser(deletedUser);
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

    public JSONObject getAllUser() {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        ArrayList<User> modelResult = User.getAllUser();

        if (modelResult == null) {
            statusCode = 500;
            status = "ModelException";
        } else if (modelResult.isEmpty()) {
            status = "NoRecordFound";
        } else {
            JSONArray result = new JSONArray();

            for (User actualUser : modelResult) {
                JSONObject actualUserObject = new JSONObject();
                actualUserObject.put("id", actualUser.getId());
                actualUserObject.put("firstName", actualUser.getFirstName());
                actualUserObject.put("lastName", actualUser.getLastName());
                actualUserObject.put("img", actualUser.getImg());
                actualUserObject.put("email", actualUser.getEmail());
                actualUserObject.put("phone", actualUser.getPhone());
                actualUserObject.put("guid", actualUser.getGuid());
                actualUserObject.put("createdAt", actualUser.getCreatedAt().toString());
                actualUserObject.put("lastLogin", actualUser.getLastLogin() == null ? "" : actualUser.getLastLogin().toString());
                actualUserObject.put("registerFinished", actualUser.getRegisterFinishedAt().toString());

                result.put(actualUserObject);
            }

            toReturn.put("result", result);
        }

        toReturn.put("satus", status);
        toReturn.put("statusCode", statusCode);

        return toReturn;
    }

    public JSONObject login(User u2) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        User modelResult = User.login(u2);

        if (modelResult == null) {
            statusCode = 500;
            status = "ModelException";
        } else if (modelResult.getId() == null) {
            status = "NoRecordFound";
        } else {
            JSONObject result = new JSONObject();
            result.put("userId", modelResult.getId());
            result.put("firstName", modelResult.getFirstName());
            result.put("lastName", modelResult.getLastName());
            result.put("img", modelResult.getImg());
            result.put("phone", modelResult.getPhone());
            result.put("lastLogin", modelResult.getLastLogin() == null ? "" : modelResult.getLastLogin().toString());

            JSONArray roles = new JSONArray();
            for(Role r : modelResult.getRoles()){
                JSONObject role = new JSONObject();
                role.put("roleId", r.getId());
                role.put("roleName", r.getName());
                
                roles.put(role);
            }
            
            result.put("roles", roles);
            result.put("jwt", JWT.createJwtToken(u2));
            toReturn.put("result", result);
        }

        toReturn.put("satus", status);
        toReturn.put("statusCode", statusCode);

        return toReturn;
    }

    //Egyeb:
    public static boolean isValidEmail(String email) {
        if (email == null || email.length() > 320) {
            return false; // ésszerű hosszkorlát
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidPassword(String pwd) {
        if (pwd == null || pwd.length() != 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (SPECIAL.indexOf(c) >= 0) { // ugyanaz a SPECIAL, mint a generátorban
                hasSpecial = true;
            } else {
                // Nem engedélyezett karakter (pl. szóköz) -> érvénytelen
                return false;
            }
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
