package com.codeforfood.mapfood.Integration;

import com.codeforfood.mapfood.authentication.Token;
import com.codeforfood.mapfood.domain.Route;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Maplink {

    private List<Double> fastestTrajectory;
    private String calculationMode;
    private String callback;
    private String profileName;
    private boolean useRealSpeeds;
    private String requestTrajectoryURL;
    private Route route;

    private boolean waitingForProblemSolution;


    public Maplink(Route route) {
        this.calculationMode = "THE_FASTEST";
        this.callback = "http://localhost:8080/deliveries/callback";
        this.profileName = "BRAZIL";
        this.useRealSpeeds = false;
        this.requestTrajectoryURL = "https://lbslocal-prod.apigee.net/trip/v1/problems";
        this.route = route;
        this.waitingForProblemSolution = false;
    }

    public ResponseEntity<?> requestTrajectory() throws JSONException {
        Token token = new Token();

        System.out.println("TOKEN GERADO: " + token.getAccessToken());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON.toString());
        headers.add("Authorization", "Bearer " + token.getAccessToken());


        JSONObject bodyObj = new JSONObject();

        bodyObj.put("calculationMode", this.calculationMode);

        JSONObject urlObj = new JSONObject();
        urlObj.put("url", this.callback);
        bodyObj.put("callback", urlObj);

        JSONObject initial = new JSONObject();
        initial.put("latitude", route.getInitialPosition().getLatitude());
        initial.put("longitude", route.getInitialPosition().getLongitude());
        initial.put("siteId", "endereco1");
        JSONObject middle = new JSONObject();
        middle.put("latitude", route.getMiddlePosition().getLatitude());
        middle.put("longitude", route.getMiddlePosition().getLongitude());
        middle.put("siteId", "endereco2");
        JSONObject target = new JSONObject();
        target.put("latitude", route.getTargetPosition().getLatitude());
        target.put("longitude", route.getTargetPosition().getLongitude());
        target.put("siteId", "endereco3");
        List<JSONObject> pointsList = new ArrayList<>();
        pointsList.add(initial);
        pointsList.add(middle);
        pointsList.add(target);
        bodyObj.put("points", pointsList);

        bodyObj.put("profileName", this.profileName);
        bodyObj.put("useRealSpeeds", this.useRealSpeeds);
        bodyObj.put("startDate", 0);

        JSONObject vehicleSpecificationObj = new JSONObject();
        List<String> loadTypes = new ArrayList<>();
        loadTypes.add("GOODS");
        vehicleSpecificationObj.put("loadTypes", loadTypes);
        vehicleSpecificationObj.put("maxHeight", 0);
        vehicleSpecificationObj.put("maxLength", 0);
        vehicleSpecificationObj.put("maxLengthBetweenAxles", 0);
        vehicleSpecificationObj.put("maxWeight", 0);
        vehicleSpecificationObj.put("maxWeightForDangerousMaterials", 0);
        vehicleSpecificationObj.put("maxWeightForExplodingMaterials", 0);
        vehicleSpecificationObj.put("maxWeightForPollutingMaterials", 0);
        vehicleSpecificationObj.put("maxWeightPerAxle", 0);
        vehicleSpecificationObj.put("maxWidth", 0);
        bodyObj.put("vehicleSpecification", vehicleSpecificationObj);

        HttpEntity<?> request = new HttpEntity<>(bodyObj.toString(), headers);
        ResponseEntity<?> response = new RestTemplate().postForEntity(this.requestTrajectoryURL, request, String.class);

        if(response.getStatusCode() == HttpStatus.CREATED) {
            this.waitingForProblemSolution = true;
        }

        return response;
    }

    /* Getters and Setters */
    public List<Double> getFastestTrajectory() {
        return fastestTrajectory;
    }

    public void setFastestTrajectory(List<Double> fastestTrajectory) {
        this.fastestTrajectory = fastestTrajectory;
    }

    public boolean isWaitingForProblemSolution() {
        return waitingForProblemSolution;
    }
}
