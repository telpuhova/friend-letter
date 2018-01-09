import static spark.Spark.*;

//adding stuff to work with handlebars
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView; //Spark tool that allows us to pass dynamic information, like variables, from our App.java file to our template files.
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public"); //This will let Spark know it should always look in the /public directory for any additional resources we link, and load images assuming /public as a starting point.

        get("/", (request, response) -> { //request for route happens at this location
            Map<String, Object> model = new HashMap<String, Object>(); // new model is made to store information
            return new ModelAndView(model, "hello.hbs"); // assemble individual pieces and render
        }, new HandlebarsTemplateEngine()); //

        get("/favorite_photos", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "favorite_photos.hbs");
        }, new HandlebarsTemplateEngine());

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/greeting_card", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String recipient = request.queryParams("recipient");
            String sender = request.queryParams("sender");
            model.put("recipient", recipient);
            model.put("sender", sender);
            return new ModelAndView(model, "greeting_card.hbs");
        }, new HandlebarsTemplateEngine());

    }
}