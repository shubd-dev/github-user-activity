import java.net.URI;
import java.net.http.*;
import java.util.Scanner;
import java.io.IOException;
import org.json.*;

import netscape.javascript.JSObject;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        System.out.println("user name of user is " + userName);
        sc.close();

        // Http request message builder
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/" + userName + "/events"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        System.out.println("https://api.github.com/users/" + userName + "/events");
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(response.body());
        String responseString = response.body();
        JSONArray jsonArray = new JSONArray(responseString);
        for(int i = 0 ; i < jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String type = jsonObject.getString("type");
            String repoName = jsonObject.getJSONObject("repo").getString("name");
            JSONObject payload = jsonObject.getJSONObject("payload");
            String output;
            if (type.equals("PushEvent")) {
                // Handle push events (when code is pushed to a repository)
                output = "Pushed a commit to "+repoName;
                System.out.println(output);
            } 
            else if(type.equals("CommitComment")){
                // Handle commit comment events
                String comment = payload.getString("comment");
                String action = payload.getString("action");
                output = "A commit comment is "+ action+ "+ at "+ repoName+" with comment: "+comment;
                System.out.println(output);
            }
            else if (type.equals("CreateEvent")) {
                // Handle creation of branch or tag
                output = "A git branch is created at "+repoName;
                System.out.println(output );
            }
            else if (type.equals("DeleteEvent")) {
                // Handle deletion of branch or tag
                output = "A git branch is deleted at "+repoName;
                System.out.println(output);
            }
            else if(type.equals("ForkEvent")){
                String repo_name = payload.getJSONObject("forkee").getString("repo.name");
                output = "A repository is forked at "+repoName+" with repo-name:" + repo_name ;
                System.out.println(output);
            }
            else if (type.equals("IssueCommentEvent")) {
                // Handle pull request events
                String action = payload.getString("action");
                output = "A pull request Activity is "+action+" at "+repoName;
                System.out.println(output);

            }
            else if (type.equals("PullRequestReviewEvent")) {
                // Handle pull request review events
                
            }
            else if (type.equals("IssuesEvent")) {
                // Handle issues events (opened, closed, etc.)
                String action = payload.getString("action");
                output = "An issue is "+action+" at "+repoName;
            }
            else if (type.equals("IssueCommentEvent")) {
                // Handle comments on issues
            }
            else if (type.equals("ForkEvent")) {
                // Handle repository fork events
            }
            else if (type.equals("WatchEvent")) {
                // Handle repository starring events
            }
            else if (type.equals("ReleaseEvent")) {
                // Handle release events
            }
            else if (type.equals("CommitCommentEvent")) {
                // Handle commit comment events
            }
            else if (type.equals("GollumEvent")) {
                // Handle wiki page events
                output = "A wiki page is created or updated";
                System.out.println(output);
            }
            else if (type.equals("MemberEvent")) {
                // Handle repository collaborator events
                output = "A collaborator is added or removed";
                System.out.println();
            }
            else if (type.equals("PublicEvent")) {
                // Handle when repository becomes public
            }
            else {
                // Handle any other events
                System.out.println("Unhandled event type: " + type);
            }
            
            //generate else if for every event typ
        }

    }
};
