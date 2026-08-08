package json_java;

import org.json.JSONObject;

public class Json_java {

    static class Person {
        String name;
        int age;
        String email;

        Person(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }
    }

    public static void main(String[] args) {

        Person person = new Person("Rohan", 27, "rohanbhowmick@gmail.com");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", person.name);
        jsonObject.put("age", person.age);
        jsonObject.put("email", person.email);

        System.out.println("Encoded JSON:");
        System.out.println(jsonObject.toString(2));

        String jsonString = jsonObject.toString();

        JSONObject parsed = new JSONObject(jsonString);

        Person decodedPerson = new Person(
                parsed.getString("name"),
                parsed.getInt("age"),
                parsed.getString("email"));

        System.out.println("\nDecoded Person:");
        System.out.println("Name : " + decodedPerson.name);
        System.out.println("Age  : " + decodedPerson.age);
        System.out.println("Email: " + decodedPerson.email);
    }
}