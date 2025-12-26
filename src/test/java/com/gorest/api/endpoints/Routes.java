package com.gorest.api.endpoints;

import com.gorest.api.utilities.ConfigReader;

public class Routes {

	public static String base_url =
            ConfigReader.get("base.url");

    public static String create_user = "/public/v2/users";
    public static String get_user    = "/public/v2/users/{id}";
    public static String update_user = "/public/v2/users/{id}";
    public static String delete_user = "/public/v2/users/{id}";
	    
	    
	    
	    //Post module
	    public static String create_post = base_url + "/posts";
	    public static String get_post = base_url + "/posts/{id}";
	    public static String update_post = base_url + "/posts/{id}";
	    public static String delete_post = base_url + "/posts/{id}";
	    
	    
	    //Comments module
	    public static String get_comments = base_url + "/comments";
	    public static String get_comment = base_url + "/comments/{id}";
	    
	    //todo's moodule
	    public static String get_todos = base_url + "/todos";
	    public static String get_todo = base_url + "/todos/{id}";

	

}
