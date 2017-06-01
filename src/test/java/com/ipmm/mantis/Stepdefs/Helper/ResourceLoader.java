package com.ipmm.mantis.Stepdefs.Helper;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.ipmm.mantis.BugForm;
import com.ipmm.mantis.User;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * Created by elijah on 02.05.17.
 */
public class ResourceLoader {
    public static Map<String, User> users;
    public static Map<String, BugForm> bugForms;
    private static final String DATA_USERS_JSON = "data/users.json";
    private static final String DATA_BUGFORM_JSON = "data/bugForm.json";

    static {
        loadUsers();
        loadIssues();
    }

    @SneakyThrows
    private static void loadIssues() {
        String rawData = getRawData(DATA_BUGFORM_JSON);
        bugForms = new Gson().fromJson(rawData, new TypeToken<Map<String, BugForm>>(){}.getType());
    }

    @SneakyThrows
    private static void loadUsers() {
        String rawData = getRawData(DATA_USERS_JSON);
        users = new Gson().fromJson(rawData, new TypeToken<Map<String, User>>(){}.getType());
    }

    private static String getRawData(String dataUserJson) throws IOException {
        URL resource = ResourceLoader.class.getClassLoader().getResource(dataUserJson);
        return IOUtils.toString(resource, "utf-8");
    }
}
